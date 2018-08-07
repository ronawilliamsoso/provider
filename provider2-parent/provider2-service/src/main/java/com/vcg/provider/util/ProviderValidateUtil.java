package com.vcg.provider.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.SimplifiedObjectMeta;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.vcg.metadata.MetadataUtil;
import com.vcg.oss.global.OSSClientFactory;
import com.vcg.oss.global.contant.AliContants;
import com.vcg.oss.util.ProviderOSSClientUtil;
import com.vcg.provider.constant.ColorTypeEnum;
import com.vcg.provider.constant.GraphicalStyleEnum;
import com.vcg.provider.constant.LicenseTypeEnum;
import com.vcg.provider.constant.MediaTypeEnum;
import com.vcg.provider.constant.ReleaseEnum;
import com.vcg.provider.entity.ExifEntity;
import com.vcg.provider.entity.ResourceInfo;
import com.vcg.provider.model.Collection;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.ResourceUploadBatch;
import com.vcg.provider.service.ResourceUploadBatchService;
import com.vcg.oss.global.contant.AliContants;


@Component
public class ProviderValidateUtil {

 
	
	
	@Value("${oss.isInternal}")
	private Integer isInternal;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private ResourceUploadBatchService resourceUploadBatchService;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	private SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static final int MIN_PI = 1200*1000;
	
	/**
	 * 获取批次号
	 * @param batchName
	 * @param providerId
	 * @return
	 */
	public Integer getNewUploadBatchId(String batchName,Integer providerId){
		ResourceUploadBatch batch = new ResourceUploadBatch();
		batch.setBatchName(batchName);
		batch.setBatchStatus(1);
		batch.setCreatedTime(new Date());
		batch.setProviderId(providerId);
		resourceUploadBatchService.insert(batch);
		
		return batch.getId();
	}
	
	public List<List<String>> getDataListByInput(String fileFormat,InputStream input) throws Exception{
		ReaderUtil util = null;
		if("xls".equals(fileFormat)||"xlsx".equals(fileFormat)){
			util = new ExcelUtil();
		}else if("cvs".equals(fileFormat)){
			util = new CsvUtil();
		}else{
			return null;
		}
		
		List<List<String>> dataList = util.readData(input);
		
		return dataList;
	}
	
	/**
	 * 判断字段是否为空
	 * @param ossurl
	 * @throws Exception 
	 */
	/*public List<String> validate(String  metakey) throws Exception{
		List<String> errList = new ArrayList<String>();
		
//		OSSClient ossClient = OssClient.getOssClient(storageUtil.getIsInternal());
		
//		InputStream input =EditOssClientUtil.getBeijingBucketObject(ossClient, metakey);
		InputStream input = new URL(metakey).openStream();
		
		String strArr[] = metakey.split("\\/");
		String name = strArr[strArr.length-1];
		String fileFormat = name.split("\\.")[1];
		ReaderUtil util = null;
		List<List<String>> dataList = null;
		
		if("xls".equals(fileFormat)||"xlsx".equals(fileFormat) || "cvs".equals(fileFormat)){
			dataList = getDataListByInput(fileFormat,input);
		}else{
			errList.add("meta文件");
			return errList;
		}
		
		if(dataList != null && dataList.size()>0){
			int rowIndex = 0;
			for(List<String> list:dataList){
				if(list != null && list.size()>0){
					if(rowIndex==0){
						//校验列名
						validateColumnName(list);
					}else{
						//校验meta文件
						ResourceInfo resource = new ResourceInfo();
						List<String> rowErrList = validateRowData(list,resource);
						if(rowErrList != null && rowErrList.size()>0){
							StringBuilder sb = new StringBuilder("第"+rowIndex+"行有错: ");
							for(String str:rowErrList){
								sb.append(str+",");
							}
							String rowErrMsg  = sb.toString();
							rowErrMsg = rowErrMsg.substring(0,rowErrMsg.length()-1);
							errList.add(rowErrMsg);
						}else{
							//校验图片
							String imgId = list.get(0);
							String imgKeyPrefix = metakey.substring(0,metakey.lastIndexOf("."));
							String imgKey = imgKeyPrefix+".jpg";
							this.validateImage(imgId, imgKey);
						}
					}
					
					
					rowIndex++;
				}
			}
		}else{
			throw new RuntimeException("没有读取到数据！");
		}
		
		return errList;
	}*/
	
	public static boolean  validateColumnName(List<String> dataList){
		if(dataList != null && dataList.size()>0){
			if("Image_ID".equals(dataList.get(0)) && "Collection".equals(dataList.get(1))
					&& "Caption".equals(dataList.get(2)) && "License Type".equals(dataList.get(3))
					&& "Keywords".equals(dataList.get(4)) && "Model Release".equals(dataList.get(5))
					&& "Model Release_Name".equals(dataList.get(6)) && "Property Release".equals(dataList.get(7))
					&& "Property Release_Name".equals(dataList.get(8)) &&  "Credit Line".equals(dataList.get(9)) 
					&& "Rest".equals(dataList.get(10)) && "Create Date".equals(dataList.get(11))
					&& "Media Type".equals(dataList.get(12)) && "Color Type".equals(dataList.get(13)));
			return true;
		}
		return false;
	}
	
	public List<String> validateRowData(Integer providerId,List<String> rowList,ResourceInfo resource){
		List<String> errList = new ArrayList<String>();
		
		if(rowList != null && rowList.size()>0 ){
			String imgId = rowList.get(0);
			if(imgId == null  || imgId.trim().length()==0){
				errList.add("img_id为空");
			}else{
				resource.setProvider_res_id(imgId);
			}
			
			String collection = rowList.get(1);
			if(collection == null || collection.trim().length()==0){
				errList.add("Collection为空");
			}else{
				//TODO
				Integer brandId = getBrandId(providerId,collection);
				if(brandId == null){
					errList.add("匹配不到brandId");
				}
				resource.setCollection(collection);
			}
			
			String caption = rowList.get(2);
			if(caption == null || caption.trim().length()==0){
				errList.add("Caption为空");
			}else{
				resource.setCaption(caption);
			}
			
			String licenseType = rowList.get(3);
			if(licenseType == null || licenseType.trim().length()==0){
				errList.add("License Type为空");
			}else{
				if(LicenseTypeEnum.getValueByName(licenseType) == null){
					errList.add("License Type只能为RF/RM之一");
				}
				resource.setLicenseType(LicenseTypeEnum.getValueByName(licenseType));
			}
			
			String keywords = rowList.get(4);
			if(keywords == null || keywords.trim().length()==0){
				errList.add("Keywords为空");
			}else{
				String strArr[] = keywords.split(",");
				if(strArr.length<5){
					strArr = keywords.split("，");
					if(strArr.length<5){
						errList.add("keywords少于5个");
					}
				}
				
				resource.setKeywords(keywords);
			}
			
			String modelResease = rowList.get(5);
			if(modelResease == null || modelResease.trim().length()==0){
				errList.add("Model Resease为空");
			}else{
				if(ReleaseEnum.getReleaseEnumByName(modelResease) == null){
					errList.add("ModelResease只能为Y/N之一");
				}else{
					resource.setModel_release(ReleaseEnum.getReleaseEnumByName(modelResease));
				}
			}
			
			String modelReseaseName = rowList.get(6);
			if(modelReseaseName == null || modelReseaseName.trim().length()==0){
//				errList.add("第"+rowIndex+"行Model Resease_Name为空");
			}else{
				
				String mrFileNameArr[] = modelReseaseName.split(",");
				for(String mrFilename:mrFileNameArr){
					if(mrFilename.trim().indexOf(" ")!=-1){
						errList.add(mrFilename+"文件名有空格");
					}
				}
				resource.setModel_release_id(mrFileNameArr);
			}
			
			
			
			String propertyResease = rowList.get(7);
			if(propertyResease == null || propertyResease.trim().length()==0){
				errList.add("Property Resease为空");
			}else{
				if(ReleaseEnum.getReleaseEnumByName(propertyResease) == null){
					errList.add("Property Resease只能为Y/N之一");
				}else{
					resource.setProperty_release(ReleaseEnum.getReleaseEnumByName(propertyResease));
				}
			}
			
			String propertyReseaseName = rowList.get(8);
			if(propertyReseaseName == null || propertyReseaseName.trim().length()==0){
//				errList.add("第"+rowIndex+"行Property Resease_Name为空");
			}else{
				String prFileNameArr[] = propertyReseaseName.split(",");
				for(String prFileName:prFileNameArr){
					if(prFileName.trim().indexOf(" ")!=-1){
						errList.add(prFileName+"文件名有空格");
					}
				}
				
				resource.setProperty_release_id(prFileNameArr);
			}
			
			
			String creditLine = rowList.get(9);
			if(creditLine == null || creditLine.trim().length()==0){
				errList.add("Credit Line为空");
			}else{
				resource.setCredit_line(creditLine);
			}
			
			//REST  rowList.get(10);
			
			String createDate = rowList.get(11);
			if(createDate == null || createDate.trim().length()==0){
				errList.add("Create Date为空");
			}else{
				try {
					Date date = sdf.parse(createDate);
					
					if(isGreateThanCurrenDate(date)){
						errList.add("Create Date不能大于当前日期");
					}
					
					resource.setDate_camera_shot(date.getTime());
				} catch (ParseException e) {
					errList.add("Create Date格式不对");
				}
			}
			
			String mediaType = rowList.get(12);
			if(mediaType == null || mediaType.trim().length()==0){
				errList.add("Media Type为空");
			}else{
				if(MediaTypeEnum.getValueByName(mediaType) == null){
					errList.add("ColorType不是Photography、Illustration和Vector之一");
				}else{
					resource.setGraphical_style(MediaTypeEnum.getValueByName(mediaType));
				}
			}
			
			String colorType = rowList.get(13);
			if(colorType == null || colorType.trim().length()==0){
				errList.add("ColorType为空");
			}else{
				if(ColorTypeEnum.getColorTypeEnumByName(colorType) == null){
					errList.add("ColorType不是Color Image或Black&White");
				}
			}
			
		}
		
		return errList;
	}
	
	/**
	 *  校验图片文件
	 * @param file
	 * @param graphical_style 1摄影图片2 插画 3漫画 4图表 5矢量图
	 * @param asset_family  1:编辑类 2:创意类
	 * @return
	 */
	public Map<String,Object>  checkPhoto (MultipartFile file,Integer graphical_style,Integer asset_family){
		Map<String,Object> map = new HashMap<String,Object>();
		if(file != null && graphical_style != null && asset_family != null){
			if(asset_family == 2){
				if(graphical_style == GraphicalStyleEnum.Photography.getValue() || graphical_style == GraphicalStyleEnum.illustration.getValue()){
					//摄影图片  插画
					StringBuilder sb = new StringBuilder("");
					
					long size = file.getSize();
					if(size>0L){
						if(size<3*1024*1024){
							sb.append("图片小于3M;");
						}else if( size>200*1024*1024){
							sb.append("图片大于200M;");
						}
					}
					
					try{
						InputStream input = file.getInputStream();
						ExifEntity exif = getExifInfo(input);
						
						if(exif != null){
							//1200万像素
							String heightSizestr = exif.getHeightSize();
							String widthSizestr = exif.getWidthSize();
							String heightSize="";
							String widthSize="";
							if(StringUtils.isNotBlank(heightSizestr)||StringUtils.isNotBlank(widthSizestr)){
								heightSize = heightSizestr.split(" ")[0];
								widthSize = widthSizestr.split(" ")[0];
							}
							if(heightSize != null && heightSize.trim().length()>0 && widthSize != null && widthSize.trim().length()>0){
								int heightPi = Integer.parseInt(heightSize);
								int widthPi = Integer.parseInt(widthSize);
								if(heightPi*widthPi <MIN_PI){
									sb.append("图片小于1200万像素;");
								}
							}
								
							//240dpi或300dpi
							String xResolution = exif.getxResolution();
							if(xResolution != null && xResolution.trim().length()>0){
								int xDpi = Integer.parseInt(xResolution.substring(0, 4).trim());
								if((xDpi == 300) == false){
									sb.append("图片水平分辨率不为300dpi;");
								}
							}
							String yResolution = exif.getyResolution();
							if(yResolution != null && yResolution.trim().length()>0){
								int yDpi = Integer.parseInt(yResolution.substring(0, 4).trim());
								if((yDpi == 300) == false){
									sb.append("图片垂直分辨率不为300dpi;");
								}
							}
							
							String colorSpace = exif.getColorSpace();
							if(colorSpace != null && colorSpace.trim().length()>0){
								if(colorSpace.trim().equalsIgnoreCase("sRGB") == false){
									sb.append("色彩模式不为sRGB");
								}
							}
						}
						
						if(sb.toString().trim().length()==0){
							//校验通过
							map.put("status", 200);
						}else{
							////校验不通过,有错误
							map.put("status", 201);
							map.put("msg", sb.toString());
						}
						
					}catch(Exception e){
						e.printStackTrace();
						map.put("status", 201);
						map.put("msg", "校验图片时出错！");
					}
					
				}else if(graphical_style == GraphicalStyleEnum.Vetorgram.getValue()){
					//矢量图
					map.put("status", 201);
					map.put("msg", "暂不支持矢量图");
				}else{
					map.put("status", 201);
					map.put("msg",  "暂只支持摄影图片、插画 和矢量图");
				}
				
			}else{
				map.put("status", 201);
				map.put("msg",  "暂不支持编辑类图片");
			}
		}else{
			map.put("status", 201);
			map.put("msg",  "部分参数为空");
		}
		return map;
	}
	
	/**
	 * 校验meta文件
	 * @param file
	 * @return
	 */
	public Map<String,Object>  checkMeta (MultipartFile file,Integer providerId,Integer asset_family){
		Map<String,Object> map = new HashMap<String,Object>();
		if(file != null &&  asset_family != null){
			if(asset_family == 2){
				List<String> errList = new ArrayList<String>();
				
				String name = file.getOriginalFilename();
				String fileFormat = name.substring(name.lastIndexOf(".")+1);
				ReaderUtil util = null;
				if("xls".equals(fileFormat)||"xlsx".equals(fileFormat)){
					util = new ExcelUtil();
				}else if("cvs".equals(fileFormat)){
					util = new CsvUtil();
				}else{
					errList.add("meta文件目前只支持xls、xlsx和csv;");
					map.put("status", 201);
					map.put("msg", errList);
				}
				
				InputStream input;
				try {
					input = file.getInputStream();
					List<List<String>> dataList = util.readData(input);
					if(dataList != null && dataList.size()>0){
						int rowIndex = 0;
						for(List<String> list:dataList){
							if(list != null && list.size()>0){
								if(rowIndex==0){
									//校验列名
									validateColumnName(list);
								}else{
									//校验meta文件
									ResourceInfo resource = new ResourceInfo();
									List<String> rowErrList = validateRowData(providerId,list,resource);
									if(rowErrList != null && rowErrList.size()>0){
										StringBuilder sb = new StringBuilder("第"+rowIndex+"行有错: ");
										for(String str:rowErrList){
											sb.append(str+",");
										}
										String rowErrMsg  = sb.toString();
										rowErrMsg = rowErrMsg.substring(0,rowErrMsg.length()-1);
										errList.add(rowErrMsg);
									}
								}
								rowIndex++;
							}
						}
						
						if(errList != null &&errList.size()>0){
							map.put("status", 201);
							map.put("msg",  errList);
						}else{
							map.put("status", 200);
							map.put("msg",  null);
						}
					}else{
						map.put("status", 201);
						map.put("msg", "没有读取到数据！");
					}
				} catch (Exception e) {
					e.printStackTrace();
					map.put("status", 201);
					map.put("msg", "校验meta文件时出错！");
				}
			}else{
				map.put("status", 201);
				map.put("msg", "暂不支持编辑类图片");
			}
		}
		return map;
	}
	
	public String getImageKey(String imgKeyPrefix,String imgId){
		String imgKey = imgKeyPrefix+"/"+imgId+".jpg";
		OSSClient ossclient = OSSClientFactory.getOssClient(isInternal);
//		boolean objectExist = OssClientUtil.objectExist(ossclient, AliContants.beijingvcgBucket, imgKey);
//		if(objectExist){
//			return imgKey;
//		}
		
		imgKey = imgKeyPrefix+"/"+imgId+".JPG";
//		objectExist = OssClientUtil.objectExist(ossclient, AliContants.beijingvcgBucket, imgKey);
//		if(objectExist){
//			return imgKey;
//		}
		
		imgKey = imgKeyPrefix+"/"+imgId+".jpeg";
//		objectExist = OssClientUtil.objectExist(ossclient, AliContants.beijingvcgBucket, imgKey);
//		if(objectExist){
//			return imgKey;
//		}
//		
		
		imgKey = imgKeyPrefix+"/"+imgId+".JPEG";
//		objectExist = OssClientUtil.objectExist(ossclient, AliContants.beijingvcgBucket, imgKey);
//		if(objectExist){
//			return imgKey;
//		}
		
		OSSClientFactory.closeClient(ossclient);
		
		return null;
	}
	
	public String getEpsImageKey(String imgKeyPrefix,String imgId){
		String imgKey = imgKeyPrefix+"/"+imgId+".eps";
		OSSClient ossclient = OSSClientFactory.getOssClient(isInternal);
//		boolean objectExist = OssClientUtil.objectExist(ossclient, AliContants.beijingvcgBucket, imgKey);
//		if(objectExist){
//			return imgKey;
//		}
		OSSClientFactory.closeClient(ossclient);
		
		return null;
	}
	
	public List<String> validateImage(String imgId,String key) throws IOException{
		List<String> errList = new ArrayList<String>();
		
		OSSClient ossclient = OSSClientFactory.getOssClient(isInternal);
		/*boolean objectExist = OssClientUtil.objectExist(ossclient, OssClient.beijingvcgBucket, key);
		if(!objectExist){
			errList.add("图片id:"+imgId +" 图片不存在");
		}*/
		
		ExifEntity exif = getExifInfoByImgId(key);
		/*String assetFormat = key.substring(key.lastIndexOf("."));
		if(("jpg".equalsIgnoreCase(assetFormat) || "jpeg" .equalsIgnoreCase(assetFormat)) == false){
			errList.add("图片id:"+imgId +" 图片格式不是JPG（JPEG）");
		}*/
		
		//从ObjectMeta获取文件大小
		SimplifiedObjectMeta objectMeta = ossclient.getSimplifiedObjectMeta(AliContants.beijingvcgBucket, key);
		Long size = objectMeta.getSize();
		if(size>0L){
			if(size<3*1024*1024){
				errList.add("图片id:"+imgId +" 小于3M");
			}else if( size>200*1024*1024){
				errList.add("图片id:"+imgId +" 大于200M");
			}
		}
		
		if(exif != null){
			//1200万像素
			String heightSize = exif.getHeightSize();
			String widthSize = exif.getWidthSize();
			if(heightSize != null && heightSize.trim().length()>0 && widthSize != null && widthSize.trim().length()>0){
				//3413 pixels
				int heightPi = Integer.parseInt(heightSize.split(" ")[0]);
				int widthPi = Integer.parseInt(widthSize.split(" ")[0]);
				if(heightPi*widthPi <MIN_PI){
					errList.add("图片id:"+imgId +" 小于1200万像素");
				}
			}
				
			//240dpi或300dpi
			String xResolution = exif.getxResolution();
			if(xResolution != null && xResolution.trim().length()>0){
				int xDpi = Integer.parseInt(xResolution.substring(0, 4).trim());
				if((xDpi == 300) == false){
					errList.add("图片id:"+imgId +" 水平分辨率不为300dpi");
				}
			}
			String yResolution = exif.getyResolution();
			if(yResolution != null && yResolution.trim().length()>0){
				int yDpi = Integer.parseInt(yResolution.substring(0, 4).trim());
				if((yDpi == 300) == false){
					errList.add("图片id:"+imgId +" 垂直分辨率不为300dpi");
				}
			}
			
			String colorSpace = exif.getColorSpace();
			if(colorSpace != null && colorSpace.trim().length()>0 && "Undefined".equals(colorSpace)==false){
				if(colorSpace.trim().equalsIgnoreCase("sRGB") == false){
					errList.add("图片id:"+imgId +" 色彩模式为RGB(sRGB1996)");
				}
			}
		}
		
		return errList;
	}
	
	
	private static ExifEntity getExifInfo(InputStream  inputStream) throws IOException{
		ExifEntity exif = null;
		if(inputStream != null){
			exif = new ExifEntity();
			int filesizek =  inputStream.available();
			String   filesize   =  String.valueOf(filesizek);
			Metadata imageInfo = MetadataUtil.getImageInfo(inputStream);
			String directoryName ="";
			String tagName ="";
			String desc ="";
			exif.setFileSize(filesize);
			for (Directory directory : imageInfo.getDirectories()) {
				for (Tag tag : directory.getTags()) {
					directoryName = tag.getDirectoryName();
					if("Exif IFD0".equals(directoryName)){
						tagName = tag.getTagName();
						desc = tag.getDescription();
						if("X Resolution".equalsIgnoreCase(tagName)){exif.setxResolution(desc);}
						if("Y Resolution".equalsIgnoreCase(tagName)){exif.setyResolution(desc);}
						if("Software".equalsIgnoreCase(tagName)){exif.setModifiedSoftware(desc);}
						if("Date/Time".equalsIgnoreCase(tagName)){exif.setDateModified(desc);}
						if("Make".equalsIgnoreCase(tagName)){exif.setMake(desc);}
						if("Model".equalsIgnoreCase(tagName)){exif.setModel(desc);}
						if("Image Width".equalsIgnoreCase(tagName)){exif.setWidthSize(desc);}
						if("Image Height".equalsIgnoreCase(tagName)){exif.setHeightSize(desc);}

					}else if("Exif SubIFD".equals(directoryName)){
						tagName = tag.getTagName();
						desc = tag.getDescription();
						if("Date/Time Original".equals(tagName) ){exif.setDateTimeOriginal(desc);}
						if( "Color Space".equals(tagName)){exif.setColorSpace(desc);}
						if( "Exposure Mode".equals(tagName)){exif.setExposureMode(desc);}
						if("Exposure Time".equals(tagName)){exif.setExposureTime(desc);}
						if("Exposure Bias Value".equals(tagName)){exif.setExposureBias(desc);}
						if("Focal Length".equals(tagName)){exif.setFocalLength(desc);}
						if("Flash".equals(tagName)){exif.setFlash(desc);}
						if("Metering Mode".equals(tagName)){exif.setMeteringMode(desc);}
						if("White Balance Mode".equals(tagName)){exif.setWhiteBalance(desc);}
						if("ISO Speed Ratings".equals(tagName) ){exif.setIso(desc);}
						if("F-Number".equals(tagName) ){exif.setfNumber(desc);}
						if("Lens Model".equals(tagName)){exif.setLens(desc);}
					}
				}
			}
		}
		
		return exif;
	
	}
	
	private ExifEntity getExifInfoByImgId(String key) throws IOException{
		OSSClient ossclient= OSSClientFactory.getOssClient(isInternal);
//		boolean objectExist = OssClientUtil.objectExist(ossclient, AliContants.beijingvcgBucket, key);
//		if(!objectExist){
//			return null;
//		}
		OSSObject object = ossclient.getObject(AliContants.beijingvcgBucket, key);
		InputStream inputStream = object.getObjectContent();
		ExifEntity exif = getExifInfo(inputStream);

		return exif;
	}
	
	private static boolean isGreateThanCurrenDate(Date date){
		Calendar cal =Calendar.getInstance();
		cal.setTime(date);
		//将2016/12/07 转换为数字20161207
		int d = cal.get(Calendar.YEAR)*1000+cal.get(Calendar.MONTH)*100+cal.get(Calendar.DATE);
		
		Date now = new Date();
		cal.setTime(now);
		
		//将2016/12/07 转换为数字20161207
		int n = cal.get(Calendar.YEAR)*1000+cal.get(Calendar.MONTH)*100+cal.get(Calendar.DATE);

		if(d>n){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 匹配brandId
	 * @param providerId
	 * @param collection
	 * @return
	 */
	private  Integer getBrandId(Integer providerId,String collection){
		if(providerId != null && collection !=null && collection.trim().length()>0){
			//处理供应商
			Provider ps = redisUtil.getProvider(providerId);
			if(ps!=null){
				
				if(!ps.getColls().isEmpty()){
					for(Collection c:ps.getColls()){
						if(collection.equals(c.getOriginalName())){
							return c.getBrandId();
						}
					}
				}
			}
		}
		
		return null;
	}

	public static void main(String[] args) throws Exception{
		String url = "http://bj-feiyuantu.oss-cn-beijing.aliyuncs.com/provider/419519/creativePic/268/meta/GIC Partner Metadata Template wangwei.xlsx";
		
		InputStream in = new URL(url).openStream();
		
		System.out.println(in.toString());
	}
}
