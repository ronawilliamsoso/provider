package com.vcg.provider.web;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vcg.common.Code;
import com.vcg.common.DateUtils;
import com.vcg.common.RestfulResult;
import com.vcg.common.RestfulResultFactory;
import com.vcg.common.ResultMap;
import com.vcg.common.Status;
import com.vcg.provider.entity.GroupInfo;
import com.vcg.provider.entity.ResourceInfo;
import com.vcg.provider.entity.SearchCreativeUpload;
import com.vcg.provider.entity.SearchUploadFail;
import com.vcg.provider.model.Collection;
import com.vcg.provider.model.ResourceUpload;
import com.vcg.provider.model.ResourceUploadBatch;
import com.vcg.provider.model.ResourceUploadMeta;
import com.vcg.provider.model.ResourceUploadMetaContent;
import com.vcg.provider.model.ResourceUploadRelease;
import com.vcg.provider.model.query.CollectionExample;
import com.vcg.provider.model.query.ResourceUploadExample;
import com.vcg.provider.model.query.ResourceUploadMetaContentExample;
import com.vcg.provider.model.query.ResourceUploadMetaExample;
import com.vcg.provider.model.query.ResourceUploadReleaseExample;
import com.vcg.provider.model.query.ResourceUploadReleaseExample.Criteria;
import com.vcg.provider.service.CollectionService;
import com.vcg.provider.service.ResourceUploadBatchService;
import com.vcg.provider.service.ResourceUploadMetaContentService;
import com.vcg.provider.service.ResourceUploadMetaService;
import com.vcg.provider.service.ResourceUploadReleaseService;
import com.vcg.provider.service.ResourceUploadService;
import com.vcg.provider.util.ExcelUtil;
import com.vcg.provider.util.PdfUtil;
import com.vcg.provider.util.RedisUtil;
import com.vcg.provider.util.ProviderValidateUtil;
import com.vcg.provider.util.UUIDUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
 
import com.vcg.oss.util.ProviderOSSClientUtil;
import com.vcg.instock2.base.feignClient.Instock2Client;
import com.vcg.instock2.base.form.RemoteMsgForm;
import com.vcg.oss.global.OSSClientFactory;
import com.vcg.oss.global.contant.CutImageSizeEnum;
import com.vcg.oss.util.InstockOSSClientUtil;

@RestController
@RequestMapping("/resourceUpload")
public class ResourceUploadController {
	
	
	@Autowired
	private PdfUtil pdfutil;
	
	@Value("${oss.isInternal}")
	private Integer isInternal;
	
	@Value("${custom.cutpictures}")
	private String cutpictures;
 
	@Autowired
	private ExcelUtil excelUtil;
	
	@Autowired
	private ProviderValidateUtil providerValidateUtil;
	@Autowired
	private RedisUtil providerUtil;

	@Autowired
	private ResourceUploadMetaContentService resourceUploadMetaContentService;

	@Autowired
	private ResourceUploadReleaseService resourceUploadReleaseService;
	
	@Autowired
	private ResourceUploadMetaService resourceUploadMetaService;
 
	@Autowired
	private ResourceUploadService resourceUploadService;
	
	@Autowired
	private ResourceUploadBatchService resourceUploadBatchService;
	
	@Autowired
	private CollectionService collectionService;
	
	@Autowired
	private Instock2Client instock2Client;
	
	@Autowired
	private InstockOSSClientUtil instockOSSClientUtil;
	
	String failPic= "http://bj-feiyuantu.oss-cn-beijing.aliyuncs.com/provider/template/fail.jpg";
	
	
	
	
	
	@ApiOperation(value = "供应商portal-上传管理-根据图的类型查询,查询所有授权文件,查询所有meta文件", notes = "查图所有都必填,查meta表不需要pagesize和pagenum, 查授权文件不需要pagesize和pagenum")
	@RequestMapping(value="/searchFileList",method=RequestMethod.POST)
	public Object searchFileList(@RequestBody SearchCreativeUpload requestParam){
		 
		//资源类型：1摄影图片 2 插画 5矢量图 6: meta表 7:授权文件-肖像权 8:授权文件-物权
		if(requestParam.getFileType()==1 || requestParam.getFileType()==5 || requestParam.getFileType()==2){
			ResourceUploadExample example=new ResourceUploadExample();
             //找出这个供应商的这个批次的所有 "已上传,已匹配" 的图
			
			
			example=new ResourceUploadExample();
            //找出这个供应商的这个批次的总数
			example.createCriteria().andBatchIdEqualTo(requestParam.getBatchId()).andProviderIdEqualTo(requestParam.getProviderId());
			int total =  this.resourceUploadService.countByExample(example);
			if(total>200){
				return RestfulResultFactory.getInstance(Status.ERROR, null, "每个批次图的数量不能超过200");
			}

			example=new ResourceUploadExample();
			example.createCriteria().andBatchIdEqualTo(requestParam.getBatchId()).andProviderIdEqualTo(requestParam.getProviderId()).andGraphicalStyleEqualTo(requestParam.getFileType()).andResourceStatusIn(Arrays.asList(1,2,3,5));
			PageHelper.startPage(0, 200);
			List<ResourceUpload> lst = this.resourceUploadService.selectByExample(example);
			
			for(ResourceUpload resourceUpload:lst){
				
				if( StringUtils.isNotBlank(resourceUpload.getUrl())){//缩略图给全路径
					//resourceUpload.setUrl(pdfutil.getFullFilePath(resourceUpload.getUrl()));
					//String tt = ProviderOSSClientUtil.getProviderObject(isInternal, resourceUpload.getUrl());
					String tt = ProviderOSSClientUtil.getProviderFeiyuantu(resourceUpload.getUrl());
					 
					resourceUpload.setUrl(tt);
				}
				
				Map<String,Object> check =checkResourceSubmitable(resourceUpload);
				
				 if(resourceUpload.getResourceStatus()==1||resourceUpload.getResourceStatus()==2){
					 if(check.get("submitable").toString().equals("1")){//信息完备
							resourceUpload.setCanSubmit(1);
						}if(check.get("submitable").toString().equals("2")){//信息完备,但是可能还缺东西
							resourceUpload.setCanSubmit(2);
						}else if(check.get("submitable").toString().equals("0")){//不能提交
							resourceUpload.setCanSubmit(0);
						}
						resourceUpload.setReason(check.get("reason").toString());
				 }else if(resourceUpload.getResourceStatus()==5||resourceUpload.getResourceStatus()==3){
					 resourceUpload.setCanSubmit(3);
				
				
			}
				 }
  
			return RestfulResultFactory.getInstance(200, lst, "ok");
			
		}else if(requestParam.getFileType()==6){//6: meta表
			//找出这个供应商的这个批次的所有的meta
			ResourceUploadMetaExample example=new ResourceUploadMetaExample();
			example.createCriteria().andProviderIdEqualTo(requestParam.getProviderId()).andBatchIdEqualTo(requestParam.getBatchId());
			List<ResourceUploadMeta> lst = this.resourceUploadMetaService.selectByExample(example);
			for(ResourceUploadMeta up:lst){
				up.setOssPath(pdfutil.getFullFilePath(up.getOssPath()));
			}
			 return RestfulResultFactory.getInstance(200, lst, "ok");
			
		}else if(requestParam.getFileType()==7){//7:授权文件
			//找出这个供应商的这个批次的所有的肖像权授权文件
			ResourceUploadReleaseExample example=new ResourceUploadReleaseExample();
			example.createCriteria().andProviderIdEqualTo(requestParam.getProviderId()).andReleaseTypeEqualTo(Code.release_model).andBatchIdEqualTo(requestParam.getBatchId());//1肖像权2物权
			List<ResourceUploadRelease> lst = this.resourceUploadReleaseService.selectByExample(example);
//			for(ResourceUploadRelease up:lst){
//				up.setOssPath(pdfutil.getFullFilePath(up.getOssPath()));
//			}
			 return RestfulResultFactory.getInstance(200, lst, "ok");
			
		}else if(requestParam.getFileType()==8){// 8:授权文件-物权
			//找出这个供应商的这个批次的所有的物权授权文件
			ResourceUploadReleaseExample example=new ResourceUploadReleaseExample();
			example.createCriteria().andProviderIdEqualTo(requestParam.getProviderId()).andBatchIdEqualTo(requestParam.getBatchId()).andReleaseTypeEqualTo(Code.release_property);//1肖像权2物权
			List<ResourceUploadRelease> lst = this.resourceUploadReleaseService.selectByExample(example);
//			for(ResourceUploadRelease up:lst){
//				up.setOssPath(pdfutil.getFullFilePath(up.getOssPath()));
//			}
			 return RestfulResultFactory.getInstance(200, lst, "ok");
		}
		return RestfulResultFactory.getInstance(Status.ERROR, null, "ok");
		 
	}
	
 

	/**
	 * 
	 * 文件上传
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "供应商portal的<上传文件>,必须带供应商id", notes = "只是给供应商用的上传")
	@RequestMapping(value = "/uploadOneFile", method = RequestMethod.POST)
	public Object uploadOneFile(@RequestParam MultipartFile file,
			                           @ApiParam(required = true,value = "12:meta表 13:授权文件-肖像权 14:创意图  15:矢量图 16:授权文件-物权 18:绘画插画")@RequestParam Integer fileType,
			                           @ApiParam(required = true,value = "assetFamily  1:编辑类 2:创意类")@RequestParam Integer assetFamily,
			                           @ApiParam(required = true,value = "本批次的id")@RequestParam Integer batchId,
			                           @ApiParam(required = true,value = "如:419519")@RequestParam Integer providerId) throws Exception {
		if (file == null) {
            throw new Exception("上传失败：文件为空");    
        }
        //得到文件名
        String originalFilename=file.getOriginalFilename();
        originalFilename = originalFilename.replaceAll(" ", "");  
        String imgObjectId =  pdfutil.createOssFilePath(originalFilename, fileType,providerId);
        int  i  =0;
		try {
			InputStream inputStream = file.getInputStream();
	        if(fileType==14||fileType==15|| fileType==18){//14:创意图 15:矢量图 18:绘画
	        	
	        	    Map<String, Object> retdata =  new HashMap<String,Object>();
	        	
	        	    String filename = originalFilename.substring(0,originalFilename.indexOf('.'));//不带后缀
		        	imgObjectId = "provider/"+providerId+"/creativePic/"+batchId +"/"+filename+".jpg";//所有文件重命名为.jpg
		        	
		        	//查看本批次文件是否重复
		        	ResourceUploadExample example = new ResourceUploadExample();
		        	example.setColunms(Arrays.asList("id","file_name","resource_status"));
		        	example.createCriteria().andFileNameEqualTo(filename).andBatchIdEqualTo(batchId);
		        	List<ResourceUpload> list = resourceUploadService.selectByExample(example);
		        	if(list.size()>0){//可能是重复 可能是重传失败的
		        		if(list.get(0).getResourceStatus()==5){//重传失败的 删除这个失败的
		        			resourceUploadService.deleteByPrimaryKey(list.get(0).getId());
		        		}else{
		        			return new RestfulResult<PageInfo<ResultMap>>(201, null, "已经存在!");
		        		}
		        		
		        	}
		        	
		        	
		        	//检查文件的格式问题  如果是上传失败，则记录下来
		        	Integer graphicalStyle=0;
		        	if(fileType==14){graphicalStyle=1;}else if(fileType==15){graphicalStyle=5;}else if(fileType==18){graphicalStyle=2;}
		        	Map<String, Object> map = providerValidateUtil.checkPhoto(file, graphicalStyle, assetFamily);
		        	if(map.get("status")!=null&& !map.get("status").toString().equals("200")){//检验失败
		   
		        		ResourceUpload resourceUpload = new ResourceUpload();
			        	resourceUpload.setFileName(filename);
			        	resourceUpload.setAssetFamily(2);
			        	resourceUpload.setProviderId(providerId);
			        	resourceUpload.setResourceStatus(5);//1:已上传 2:已匹配 3:入库失败 4: 已入库 5:上传失败
			        	resourceUpload.setUrl("provider/template/fail.jpg");//默认头像  http://bj-feiyuantu.oss-cn-beijing.aliyuncs.com/provider/template/fail.jpg
			        	resourceUpload.setCreatedTime(DateUtils.getNowDate());
			        	resourceUpload.setGraphicalStyle(graphicalStyle);
			        	resourceUpload.setBatchId(batchId);
			        	resourceUpload.setReason(map.get("msg").toString());
			        	resourceUploadService.insertSelective(resourceUpload);
			            i  = resourceUpload.getId();
			            retdata.put("imgId", i);
			            //String tt = ProviderOSSClientUtil.getProviderObject(isInternal, resourceUpload.getUrl());
			            retdata.put("imgUrl", failPic);
			            return RestfulResultFactory.getInstance(Status.ERROR, retdata,  map.get("msg").toString());
		        		 
		        	}
		        	
		        	//存入oss
		        	
		        	//http://bj-feiyuantu.oss-cn-beijing.aliyuncs.com/provider/510060/creativePic/411/img1.jpg
		        	ProviderOSSClientUtil.putProviderFeiyuantu(isInternal, imgObjectId, inputStream);
		        	
		        	//  切图
//		        	CutImageSizeEnum sizeEnum  = CutImageSizeEnum.SIZE_176;
//		        	OSSClient client=OSSClientFactory.getOssClient(isInternal);
		        	//String img176 = instockOSSClientUtil.putFeiyuantuByEdit(imgObjectId, sizeEnum, "jpg", client, assetFamily);
		        	
		        	//写入本地磁盘,为了形成缩略图
//		        	String fullpath = cutpictures+originalFilename;
//		        	File tempphoto = new File(fullpath);
//	    			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(tempphoto));
//	    			out.write(file.getBytes());
//	    			out.flush();
//	    			out.close();
//	    			
//	    			
//	    			//形成176缩略图,并且保存到oss
		            String img176ObjectId =  pdfutil.create176OssFilePath(originalFilename, fileType,providerId);
//		        	String img176FullPath =  cutpictures  + originalFilename;
//		        	Thumbnails.of(fullpath).size(176, 176).toFile(img176FullPath);
		        	//InputStream inputstream = new URL(img176).openStream();
		        	//ProviderOSSClientUtil.putProviderObject(isInternal, img176ObjectId, inputstream);
		        	
//		        	//删除临时图文件
//		        	tempphoto.delete();

		        	//保存这个图的信息到数据库
		            
		            instockOSSClientUtil.cutImageOnFeiyuantu(isInternal, imgObjectId, img176ObjectId);
		            
		        	ResourceUpload resourceUpload = new ResourceUpload();
		        	resourceUpload.setFileName(filename);
		        	resourceUpload.setAssetFamily(2);
		        	resourceUpload.setOssPath(imgObjectId);
		        	resourceUpload.setProviderId(providerId);
		        	resourceUpload.setResourceStatus(1);//1:已上传 2:已匹配 3:已提交到入库程序 4: 已入库 5:已上线 6:已下线  
		        	resourceUpload.setUrl(img176ObjectId);
		        	resourceUpload.setCreatedTime(DateUtils.getNowDate());
		        	resourceUpload.setGraphicalStyle(graphicalStyle);
		        	resourceUpload.setBatchId(batchId);
		        	
		        	//获取redis缓存
		        	ResourceUploadMetaContent  item =   providerUtil.getMetaItem(batchId, filename);
                    //并自动匹配
		        	if(item!=null){
		        		resourceUpload.setResourceStatus(2);
		        		resourceUpload.setColorType(item.getColorType());
		        		resourceUpload.setGraphicalStyle(item.getMediaType());
		        		resourceUpload.setShootDate(item.getCreateDate());
		        		resourceUpload.setCreditLine(item.getCreditLine());
		        		resourceUpload.setHaveModelRelease(item.getModelRelease());
		        		resourceUpload.setHavePropertyRelease(item.getPropertyRelease());
		        		resourceUpload.setKeywords(item.getKeywords());
		        		resourceUpload.setLicenseType(item.getLicenseType());
		        		resourceUpload.setCollection(item.getCollection());
		        		resourceUpload.setCaption(item.getCaption());
					    if(item.getModelRelease()==1 && StringUtils.isNotBlank(item.getModelReleaseName())){//可能存在肖像权文件,此时的肖像权文件是 123.jpg,456.jpg这种类型的
					    	List<String> m_release =  Arrays.asList(item.getModelReleaseName());
					    	ResourceUploadReleaseExample rexample = new ResourceUploadReleaseExample();
					    	rexample.setColunms(Arrays.asList("file_name","oss_path"));
				        	Criteria criteria = rexample.createCriteria();
				        	criteria.andFileNameIn(m_release).andBatchIdEqualTo(batchId);//本批次的
				            criteria.andReleaseTypeEqualTo(1);//肖像权
				        	List<ResourceUploadRelease> rlist = resourceUploadReleaseService.selectByExample(rexample);
				        	 List<String> m_releases  = rlist.stream().map(e->e.getFileName()).filter(f->!f.isEmpty()).distinct().collect(Collectors.toList());
				        	if(m_releases.size()>0){
				        		resourceUpload.setModelRelease(listToString(m_releases));
				        	}
				        }
					    if(item.getPropertyRelease()==1 && StringUtils.isNotBlank(item.getPropertyReleaseName())){//可能存在物权文件,此时的物权文件是 123.jpg,456.jpg这种类型的
					    	List<String> m_release =  Arrays.asList(item.getModelReleaseName());
					    	ResourceUploadReleaseExample rexample = new ResourceUploadReleaseExample();
					    	rexample.setColunms(Arrays.asList("file_name","oss_path"));
				        	Criteria criteria = rexample.createCriteria();
				        	criteria.andFileNameIn(m_release).andBatchIdEqualTo(batchId);//本批次的
				            criteria.andReleaseTypeEqualTo(2);//物权
				        	List<ResourceUploadRelease> rlist = resourceUploadReleaseService.selectByExample(rexample);
				        	List<String> m_releases  = rlist.stream().map(e->e.getFileName()).filter(f->!f.isEmpty()).distinct().collect(Collectors.toList());
				        	if(m_releases.size()>0){
				        		resourceUpload.setModelRelease(listToString(m_releases));
				        	}
				        }
		        	}

		        	resourceUploadService.insertSelective(resourceUpload);
		            i  = resourceUpload.getId();
		            retdata.put("imgId", i);
		            String tt = ProviderOSSClientUtil.getProviderFeiyuantu(resourceUpload.getUrl());
		            //String tt = ProviderOSSClientUtil.getProviderObject(isInternal, resourceUpload.getUrl());
		            retdata.put("imgUrl", tt);
		            return RestfulResultFactory.getInstance(200, retdata,  "成功上传");


	        }else if(fileType==13||fileType==16){//13:授权文件-肖像权   16:授权文件-物权
	            if(originalFilename.contains(" ")){
	            	return new RestfulResult<PageInfo<ResultMap>>(Status.ERROR, null, "文件名存在空格!");
	            }
	            
	            //查询重复文件
	        	ResourceUploadReleaseExample example = new ResourceUploadReleaseExample();
	        	example.setColunms(Arrays.asList("file_name"));
	        	Criteria criteria = example.createCriteria();
	        	criteria.andFileNameEqualTo(originalFilename).andBatchIdEqualTo(batchId);
	        	if(fileType==13){
	        		criteria.andReleaseTypeEqualTo(1);
	        	}else if(fileType==16){
	        		criteria.andReleaseTypeEqualTo(2);
	        	}
	        	List<ResourceUploadRelease> list = resourceUploadReleaseService.selectByExample(example);
	        	if(list.size()>0){
	        		  return RestfulResultFactory.getInstance(Status.ERROR, null,  originalFilename+"已经存在!");
	        	}
	        	
	        	//保存到oss
	        	imgObjectId = "provider/"+providerId+"/creativePic/"+batchId+"/release/"+originalFilename;
	        	ProviderOSSClientUtil.putProviderFeiyuantu(isInternal, imgObjectId, inputStream);
	        	
	        	//保存到数据库
	        	ResourceUploadRelease resourceUploadRelease = new ResourceUploadRelease();
	        	resourceUploadRelease.setFileName(originalFilename);
	        	resourceUploadRelease.setOssPath(imgObjectId);
	        	resourceUploadRelease.setProviderId(providerId);
	        	resourceUploadRelease.setCreatedTime(DateUtils.getNowDate());
	        	resourceUploadRelease.setBatchId(batchId);
	        	if(fileType==13){
	        		resourceUploadRelease.setReleaseType(1);
	        	}else{
	        		resourceUploadRelease.setReleaseType(2);
	        	}
	        	resourceUploadReleaseService.insertSelective(resourceUploadRelease);
	        	  i  = resourceUploadRelease.getId();
	        	  
	        	   //这些文件的授权文件需要重新匹配
	        	  List<ResourceUpload> photonames =  getPhotoNameFromMetaContentByReleaseName(resourceUploadRelease.getFileName(),resourceUploadRelease.getReleaseType(), batchId,providerId);
	        	  //重新匹配这些图的授权文件
	        	  if(photonames!=null&&photonames.size()>0){
	        		  matchPhotoWithMeta(photonames,resourceUploadRelease.getReleaseType());
	        	  }
 
	        	  return RestfulResultFactory.getInstance(200, i,  "成功上传");
	        }else if(fileType==12){//12:meta表

	        	//检测格式问题  
	        	Map<String, Object> map = providerValidateUtil.checkMeta(file, providerId,assetFamily);
	        	if(map.get("status")!=null&& !map.get("status").toString().equals("200")){//检验失败
	        		return new RestfulResult<PageInfo<ResultMap>>(Status.ERROR, null, map.get("msg").toString());
	        	}
	        	//检验是否重复了
	        	ResourceUploadMetaExample example = new ResourceUploadMetaExample();
	        	example.setColunms(Arrays.asList("file_name"));
	        	example.createCriteria().andBatchIdEqualTo(batchId);
	        	int count = resourceUploadMetaService.countByExample(example);
	        	if(count>0){
	        		 return RestfulResultFactory.getInstance(Status.ERROR, null,  "本批次的meta已存在,如要上传新的meta文件,请删除已有meta文件后重新上传!");
	        	}
	        	//保存至oss
	        	imgObjectId = "provider/"+providerId+"/creativePic/"+batchId+"/meta/"+originalFilename;
	        	ProviderOSSClientUtil.putProviderFeiyuantu(isInternal, imgObjectId, inputStream);
	        	
	   
	        	//查找少的图片文件和reslease文件
//	        	String url = ProviderOSSClientUtil.getProviderFeiyuantu(imgObjectId);
//	    		InputStream is = new URL(url).openStream();
	        	InputStream is = file.getInputStream();
	        	List<List<String>> metalist = excelUtil.readData(is);
		        List<String> metapicIds  = metalist.stream().map(e->e.get(0).trim()).filter(f->!f.isEmpty()).distinct().collect(Collectors.toList());
		        ResourceUploadExample rexample=new ResourceUploadExample();
		        //找出这个供应商的所有 "已上传,已匹配" 的图(所以可以重复匹配)
		        rexample.createCriteria().andProviderIdEqualTo(providerId).andAssetFamilyEqualTo(assetFamily).andResourceStatusIn(Arrays.asList(1,2)).andFileNameIn(metapicIds);
				List<ResourceUpload> lst = this.resourceUploadService.selectByExample(rexample);
	        	String checkmessage = checkFileMissingInMeta(metalist, metapicIds ,providerId,lst);
 
	        	

	        	
	        	//meta文件的保存
	        	ResourceUploadMeta resourceUploadMeta = new ResourceUploadMeta();
	        	resourceUploadMeta.setFileName(originalFilename);
	        	resourceUploadMeta.setCreatedTime(DateUtils.getNowDate());
	        	resourceUploadMeta.setOssPath(imgObjectId);
	        	resourceUploadMeta.setProviderId(providerId);
	        	resourceUploadMeta.setBatchId(batchId);
	        	resourceUploadMetaService.insertSelective(resourceUploadMeta);
                i  = resourceUploadMeta.getId();
	        	
//          ["100001","Patrick McMullan","测试caption1","RF","女人,光线,昏暗,俄罗斯,长发","Y","M1.jpg","Y","p1.jpg","签名","限制1","2016-03-05","Photography","Color Image",""]
//    		["100002","Patrick McMullan","测试caption2","RF","女人,光线,昏暗,俄罗斯,抽烟","Y","M2,M3.jpg","Y","p2.jpg,p3.jpg","签名","限制2","2016-03-06","Photography","Black&White",""]
//    		["100003","Patrick McMullan","测试caption3","RF","女人,光线,昏暗,俄罗斯,裸露","N","","N","","签名","限制3","2016-03-07","Photography","Black&White",""]
//    		["100004","Patrick McMullan","测试caption4","RF","女人,光线,昏暗,俄罗斯,红唇","N","","N","","签名","限制4","2016-03-08","Photography","Black&White",""]
//    		["100005","Patrick McMullan","测试caption5","RF","女人,光线,昏暗,俄罗斯,性感","N","","N","","签名","限制5","2016-03-09","Photography","Color Image",""] 
 
                //meta文件的内容保存至数据库
                ResourceUploadMetaContent c = new ResourceUploadMetaContent();
                for(List<String> meta:metalist ){
	                	c = new ResourceUploadMetaContent();
	                	c.setBatchId(batchId);
	                	c.setProviderId(providerId);
	                	c.setImageName(meta.get(0));
	                	c.setCollection(meta.get(1));
	                	c.setCaption(meta.get(2));
	                	c.setLicenseType(lisensType(meta.get(3)));
	                	c.setKeywords(meta.get(4));
	                	c.setModelRelease(yesNo(meta.get(5)));
	                	if(yesNo(meta.get(5))==1 && StringUtils.isNotBlank(meta.get(6))){
	                		c.setModelReleaseName(meta.get(6));
	                	}
	                	c.setPropertyRelease(yesNo(meta.get(7).trim()));
	                	 if(yesNo(meta.get(7))==1 && StringUtils.isNotBlank(meta.get(8))){//可能存在物权文件
	                		 c.setPropertyReleaseName(meta.get(8));
	                		}
	                    c.setCreditLine(meta.get(9));
	     				c.setRest(meta.get(10));
	     				c.setCreateDate(DateUtils.parseDate(meta.get(11), "yyyy-MM-dd"));
	     				c.setMediaType(mediaType((meta.get(12).trim())));
	     				c.setColorType(colorType(meta.get(13).trim()));
	     				resourceUploadMetaContentService.insert(c);
	     				
	     				 //meta文件的内容保存至redis
	     				providerUtil.putMetaItem(batchId, meta.get(0).trim(), c);//放入redis	
                	}

                matchPhotoWithMeta(metalist,lst,providerId); 
                return RestfulResultFactory.getInstance(200, i,  checkmessage);
                }
                
	        return RestfulResultFactory.getInstance(200, i,  "");
	        	 
	        	
	        }  catch (Exception e) {
			e.printStackTrace();
			return new RestfulResult<PageInfo<ResultMap>>(Status.ERROR, null, originalFilename+"上传异常!");
		}  
	}
	
	
	
	/**
	 * 
	 * 删除一个文件
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "删除供应商portal里的一个文件,可能是12:meta表 13:授权文件 14:图", notes = "可能是12:meta表 13:授权文件 14:图")
	@RequestMapping(value = "/deleteOneFile", method = RequestMethod.POST)
	public Object deleteOneFile( @ApiParam(required = true,value = "12:meta表 13:授权文件-肖像权 14:摄影图  15:矢量图 16:授权文件-物权 18:绘画插画")@RequestParam Integer fileType, 
			                            @ApiParam(required = true,value = "如果是meta表,则id=meta表的主键id,如果是授权文件,则是授权文件表的id,如果是图,则是图的id")@RequestParam Integer id) throws Exception {
		try {
	        if(fileType==14||fileType==15||fileType==18){//14:创意图 15:矢量图 18:绘画插画
	        	ResourceUpload resourceUpload = resourceUploadService.selectByPrimaryKey(id);
	        	if(resourceUpload !=null){
	        		if(resourceUpload.getResourceStatus()==1||resourceUpload.getResourceStatus()==2||resourceUpload.getResourceStatus()==3||resourceUpload.getResourceStatus()==5){//刚上传的和匹配完的可以删除
	        			if(StringUtils.isNotBlank(resourceUpload.getOssPath())){
	        				ProviderOSSClientUtil.deleteProviderFeiyuantu(isInternal, resourceUpload.getOssPath());//从非原图
	        			}
	        			
		        		resourceUploadService.deleteByPrimaryKey(id);
		        		
		        		//清除缓存redis
		        		//providerUtil.deleteMetaItem(resourceUpload.getBatchId(),resourceUpload.getFileName());
	        		}else{
	        			return RestfulResultFactory.getInstance(Status.ERROR, null,  "文件已提交或者已入库,暂不能删除!");
	        		}
	        		
	        	}
	      
	        }else if(fileType==13){//13:授权文件
	        	 
	        	ResourceUploadRelease resourceUploadRelease = resourceUploadReleaseService.selectByPrimaryKey(id);
	        	if(resourceUploadRelease !=null){
	        		ProviderOSSClientUtil.deleteProviderFeiyuantu(isInternal, resourceUploadRelease.getOssPath());//从非原图删除
	        		resourceUploadReleaseService.deleteByPrimaryKey(id);
	        		  //查找所有受影响的图
	        		 List<ResourceUpload> photonames =  getPhotoNameFromMetaContentByReleaseName(resourceUploadRelease.getFileName(),
	        				                                                                     resourceUploadRelease.getReleaseType(), 
	        				                                                                     resourceUploadRelease.getBatchId(),
	        				                                                                     resourceUploadRelease.getProviderId());
		        	  //重新匹配这些图的授权文件
		        	  if(photonames!=null&&photonames.size()>0){
		        		  matchPhotoWithMeta(photonames,resourceUploadRelease.getReleaseType());
		        	  }
	        	}
 
	        }else if(fileType==12){//12:meta表
	         
	        	ResourceUploadMeta resourceUploadMeta = resourceUploadMetaService.selectByPrimaryKey(id);
	        	if(resourceUploadMeta !=null){
	        		ProviderOSSClientUtil.deleteProviderObject(isInternal, resourceUploadMeta.getOssPath());//从原图删除
	        		resourceUploadMetaService.deleteByPrimaryKey(id);
	        		
	        	}
	        	
	        }
			
	        return RestfulResultFactory.getInstance(200, null,  "成功删除");
		}  catch (Exception e) {
			e.printStackTrace();
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "异常");
		}  
 
		

	}
	
	
	/**
	 * 
	 * 删除多个图文件
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "删除供应商portal里的多个图文件 14:图")
	@RequestMapping(value = "/batchDeletePhotoFiles", method = RequestMethod.POST)
	public Object batchDeletePhotoFiles(  @ApiParam(required = true,value = "图的ids")@RequestParam String ids) throws Exception {
		try {
			 if(StringUtils.isNoneBlank(ids)){
			 	List<String> liststr =  Arrays.asList(ids.split(","));
			 	List<Integer> listint = liststr.stream().map(e->Integer.parseInt(e)).collect(Collectors.toList());
			 	listint.forEach(e->{
			     	ResourceUpload resourceUpload = resourceUploadService.selectByPrimaryKey(e);
			     	if(resourceUpload !=null){
			     		if(resourceUpload.getResourceStatus()==1||resourceUpload.getResourceStatus()==2||resourceUpload.getResourceStatus()==3||resourceUpload.getResourceStatus()==5){//刚上传的和匹配完的可以删除
			     			if(StringUtils.isNotBlank(resourceUpload.getOssPath())){
			     				ProviderOSSClientUtil.deleteProviderFeiyuantu(isInternal, resourceUpload.getOssPath());//从非原图删除
			     			}
				        		resourceUploadService.deleteByPrimaryKey(e);
			     		} 
			     	}
			 		
			 		
			 		
			 	});
				 
			 }

	       
			
	        return RestfulResultFactory.getInstance(200, null,  "成功删除");
		}  catch (Exception e) {
			e.printStackTrace();
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "异常");
		}  
 
		

	}
	

	
//	
//	/**
//	 * 
//	 * 图文件匹配
//	 * @return
//	 * @throws Exception
//	 */
//	@ApiOperation(value = "供应商portal的<匹配文件,生成json>", notes = "")
//	@RequestMapping(value = "/matchMeta", method = RequestMethod.POST)
//	public RestfulResult matchMeta(@ApiParam(value = "meta表里的主键id")@RequestParam(required = true) Integer id,@ApiParam(value = "如:419919")@RequestParam(required = true) Integer providerId,@ApiParam(value = "1:编辑类 2:创意类")@RequestParam(required = true) Integer assetFamily) throws Exception {
//		
// 
//    	ResourceUploadMeta rmeta  = resourceUploadMetaService.getById(id);
//    	if(rmeta==null){
//    		 return RestfulResultFactory.getInstance(Status.ERROR, null,  "本meta不存在!");
//    	}
//		
//		
//	   OSSClient ossClient = OssClient.getOssClient(isInternal);
//       String objecId = "provider/419519/meta/20161215155443-7f7abcb69a.xlsx";
//       //String objecId = rmeta.getOssPath();
//       OSSObject object = ossClient.getObject(providerbucket, objecId);
//       InputStream is2  =  object.getObjectContent();
////       String  fullpath =  pdfutil.getFullFilePath(objecId);
////       Map<String,Object> params =new HashMap<String,Object>();
////       params.put("metakey", fullpath);
////       RestTemplate rt= RestTemplateFactory.getTemplate();
////		String result = rt.postForObject("http://192.168.3.144:9000/providerInstorage/validate",params, String.class);
////       
////  
//       
//       ExcelUtil excelUtil = new ExcelUtil();
//       List<List<String>> metalist =  excelUtil.readData(is2);
//       String errorstring = checkReleaseExist(metalist,providerId);
//       if(StringUtils.isNotBlank(errorstring)){
//    	   return RestfulResultFactory.getInstance(Status.ERROR, null,  errorstring);
//       }
//       
//        ResourceUploadExample example=new ResourceUploadExample();
//		example.createCriteria().andProviderIdEqualTo(providerId).andAssetFamilyEqualTo(assetFamily).andResourceStatusEqualTo(1);//只匹配刚上传的
//		List<ResourceUpload> lst = this.resourceUploadService.selectByExample(example);
//		if(lst.size()==0){
//			return RestfulResultFactory.getInstance(Status.ERROR, null,  "请上传图片!");
//		}
////      ["100001","Patrick McMullan","测试caption1","RF","女人,光线,昏暗,俄罗斯,长发","Y","M1.jpg","Y","p1.jpg","签名","限制1","2016-03-05","Photography","Color Image",""]
////		["100002","Patrick McMullan","测试caption2","RF","女人,光线,昏暗,俄罗斯,抽烟","Y","M2,M3.jpg","Y","p2.jpg,p3.jpg","签名","限制2","2016-03-06","Photography","Black&White",""]
////		["100003","Patrick McMullan","测试caption3","RF","女人,光线,昏暗,俄罗斯,裸露","N","","N","","签名","限制3","2016-03-07","Photography","Black&White",""]
////		["100004","Patrick McMullan","测试caption4","RF","女人,光线,昏暗,俄罗斯,红唇","N","","N","","签名","限制4","2016-03-08","Photography","Black&White",""]
////		["100005","Patrick McMullan","测试caption5","RF","女人,光线,昏暗,俄罗斯,性感","N","","N","","签名","限制5","2016-03-09","Photography","Color Image",""] 
////
//		for(ResourceUpload resourceUpload:lst){//匹配
//			for(List<String> meta:metalist){
//				if(meta.get(0).trim().equals(resourceUpload.getFileName())){
//					resourceUpload.setCollection(meta.get(1));
//					resourceUpload.setCaption(meta.get(2));
//					resourceUpload.setLicenseType(lisensType(meta.get(3)));
//					resourceUpload.setKeywords(meta.get(4));
//					resourceUpload.setHaveModelRelease(yesNo(meta.get(5)));
//					resourceUpload.setModelRelease(meta.get(6));
//					resourceUpload.setHavePropertyRelease(yesNo(meta.get(7).trim()));
//					resourceUpload.setPropertyRelease(meta.get(8));
//					resourceUpload.setCreditLine(meta.get(9));
//					resourceUpload.setRestriction(meta.get(10));
//					resourceUpload.setShootDate(DateUtils.parseDate(meta.get(11), "YYYY-MM-DD"));
//					resourceUpload.setGraphicalStyle(mediaType((meta.get(12).trim())));
//					resourceUpload.setColorType(colorType(meta.get(12).trim()));
//					resourceUpload.setResourceStatus(2);//1:已上传 2:已匹配 3:已提交到入库程序 4: 已入库 5:已上线 6:已下线 7: 入库失败
//					resourceUploadService.updateByPrimaryKeySelective(resourceUpload);
//				}
//			}
//			 
//			//up.setUrl(pdfutil.getFullFilePath(up.getUrl()));
//		}
//       
// 		return RestfulResultFactory.getInstance(200, null,  "成功上传");
//
//	}
//	
	
	
	
	/**
	 * 
	 * 图文件匹配
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "供应商portal的<提交>", notes = "生成json,并且提交")
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public Object submit(
			                    @ApiParam(value = "如:419519")@RequestParam(required = true) Integer providerId,
			                    @ApiParam(value = "1:编辑类 2:创意类")@RequestParam(required = true) Integer assetFamily,
			                    @ApiParam(value = "本批次的id")@RequestParam(required = true) Integer batchId,
			                    @ApiParam(value = "图片类型：1摄影图片2 插画 3漫画 4图表 5矢量图")@RequestParam(required = true) Integer graphicalStyle) throws Exception {
		
  
		
		
//	   OSSClient ossClient = OssClient.getOssClient(isInternal);
//       //String objecId = "provider/410519/meta/20161214165543-fad20eedb4.xlsx";
//       String objecId = release.getOssPath();
//       OSSObject object = ossClient.getObject(providerbucket, objecId);
//       InputStream is2  =  object.getObjectContent();
//       
//       
//       RestTemplate rt=new RestTemplate();
//		rt.getForObject("http://192.168.3.144:9000/providerInstorage/validate?metakey="+providerId,String.class);
//       
//       
//       ExcelUtil excelUtil = new ExcelUtil();
//       List<List<String>> metalist =  excelUtil.readData(is2);
//       String errorstring = checkReleaseExist(metalist,providerId);
//       if(StringUtils.isNotBlank(errorstring)){
//    	   return RestfulResultFactory.getInstance(Status.ERROR, null,  errorstring);
//       }
	   
	   
		
 
 
	   
 
       
        ResourceUploadExample example=new ResourceUploadExample();
		example.createCriteria().andProviderIdEqualTo(providerId).andAssetFamilyEqualTo(assetFamily).andResourceStatusIn(Arrays.asList(1,2)).andBatchIdEqualTo(batchId);//只提交已匹配完的
		List<ResourceUpload> lst = this.resourceUploadService.selectByExample(example);
		if(lst.size()==0){
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "请上传图片!");
		}
 
		//打上可提交状态
		lst.forEach(e->{
			Map<String,Object> check =checkResourceSubmitable(e);
			if(check.get("submitable").toString().equals("1")){//信息完备
				e.setCanSubmit(1);
			}if(check.get("submitable").toString().equals("2")){//信息完备,但是可能还缺东西
				e.setCanSubmit(2);
			}else if(check.get("submitable").toString().equals("0")){//不能提交
				e.setCanSubmit(0);
			}			
		});
		
		
		List<ResourceInfo> pics= new ArrayList<ResourceInfo>();
		ResourceInfo resourceInfo =new ResourceInfo();
		//provider/419519/creativePic/268/100004.jpg
        String releasefolder = "provider/"+providerId+"/creativePic/"+batchId+"/release/";
        Integer submitcount =0;
		for(ResourceUpload r:lst){//生成json
			
			//可提交的才能入库
			if(r.getCanSubmit()!=0){
				submitcount++;
				resourceInfo =new ResourceInfo();
				resourceInfo.setModel_release(r.getHaveModelRelease());
				if(StringUtils.isNotBlank(r.getModelRelease())){//1.jpg,2.jpg
		            String[] temp = r.getModelRelease().split(",");
					 for(int i=0;i<temp.length;i++){
						 temp[i]=releasefolder+temp[i];
					}
					resourceInfo.setModel_release_id( temp);
				}
				resourceInfo.setKeywords(r.getKeywords());
				if(r.getShootDate()!=null){
					resourceInfo.setDate_camera_shot(r.getShootDate().getTime());
				}
				if(StringUtils.isNotBlank(r.getPropertyRelease())){
		            String[] temp = r.getPropertyRelease().split(",");
					 for(int i=0;i<temp.length;i++){
						 temp[i]=releasefolder+temp[i];
					}
					resourceInfo.setProperty_release_id(temp);
				}
				resourceInfo.setProvider_res_id(r.getFileName());
				resourceInfo.setPeople(r.getPersonNumber());
				resourceInfo.setUrl(r.getOssPath());//provider/419519/creativePic/100005.jpg
				resourceInfo.setAsset_family(r.getAssetFamily());
				resourceInfo.setProperty_release(r.getHavePropertyRelease());
				resourceInfo.setGraphical_style(r.getGraphicalStyle());
				resourceInfo.setColor_type(r.getColorType());
				resourceInfo.setCredit_line(r.getCreditLine());
				resourceInfo.setCaption(r.getCaption());
				resourceInfo.setFileName(r.getFileName()+".jpg");
				resourceInfo.setCollection(r.getCollection());
				resourceInfo.setLicenseType(r.getLicenseType());
				resourceInfo.setLocation(r.getShootPlace());
				pics.add(resourceInfo);
				
			}

		}
		if(submitcount==0){//没有可提交的东西
			return RestfulResultFactory.getInstance(201, null,  "没有可提交的图");
			
		}
		GroupInfo groupInfo = new GroupInfo();
		groupInfo.setPics(pics);
		groupInfo.setAsset_family(assetFamily);
		groupInfo.setCreative_provider_id(providerId+"");
		groupInfo.setGraphical_style(graphicalStyle);
		groupInfo.setProvider_id(providerId+"");
		groupInfo.setCreativeBatchId(batchId);//批次

		String randomstring=UUIDUtil.generateUUID().substring(22).replace(".", "");
	    String objectId = "provider/"+providerId+"/creativePic/"+batchId+"/"+randomstring+".json";
		
		String jsonStr = JSONObject.toJSONString(groupInfo);
		System.err.println("submit json:===>"+objectId);
		InputStream  json =new ByteArrayInputStream(jsonStr.getBytes("UTF-8"));
		
		ProviderOSSClientUtil.putProviderFeiyuantu(isInternal, objectId, json);
		
		RemoteMsgForm instorageResult =   instock2Client.submit(objectId);
		
		
//        RestTemplate rt=new RestTemplate();//60.205.208.59:9900
//		//String result =  rt.postForObject("http://60.205.208.59:9900/providerInstorage/submit?jsonKey=",objectId,String.class);
//		String result =  rt.postForObject(instorageUrl,objectId,String.class);
//		
//		System.err.println(result);  //{"status":401,"msg":"403 Forbidden","content":null}
//		
//		InstorageMsg instorageMsg = JSON.parseObject(result, InstorageMsg.class);
		
		//更新批次状态
		//ResourceUploadBatch  resourceUploadBatch =resourceUploadBatchService.getById(batchId);
		ResourceUploadBatch  update = new ResourceUploadBatch();
		update.setId(batchId);
		update.setSubmitTime(DateUtils.getNowDate());
		update.setBatchStatus(2);//批次状态 1:新建 2:已入库
		resourceUploadBatchService.updateByPrimaryKeySelective(update);
		
		if(instorageResult.getStatus()==200){//完全入库
			
			//成功入库的
			Map<String,List<String>> mapi = (Map<String, List<String>>) instorageResult.getContent();
			List<String> instorageIdList = mapi.get("instorage");//入库的
			example=new ResourceUploadExample();
            //改状态
			example.createCriteria().andFileNameIn(instorageIdList).andBatchIdEqualTo(batchId);
			ResourceUpload resourceUpload = new ResourceUpload();
			resourceUpload.setResourceStatus(Code.resourcestatus_instorage);//1:已上传 2:已匹配  3:入库失败 4: 已入库 5:已上线 6:已下线 
			resourceUploadService.updateByExampleSelective(resourceUpload, example);
			
			
 
		}else{//部分入库
			Map<String,List<String>> mapi = (Map<String, List<String>>) instorageResult.getContent();
			//入库失败的
			List<String> unInstorageIdList = mapi.get("unistorage");
			example=new ResourceUploadExample();
            //该状态
			example.createCriteria().andFileNameIn(unInstorageIdList).andBatchIdEqualTo(batchId);
			ResourceUpload resourceUpload = new ResourceUpload();
			resourceUpload.setResourceStatus(Code.resourcestatus_instoragefail);//1:已上传 2:已匹配  3:入库失败 4: 已入库 5:已上线 6:已下线 
			resourceUploadService.updateByExampleSelective(resourceUpload, example);
			
			
			 
			//入库成功的
			List<String> instorageIdList = mapi.get("istorage");//入库的
			example=new ResourceUploadExample();
            //该状态
			example.createCriteria().andFileNameIn(instorageIdList).andBatchIdEqualTo(batchId);
			resourceUpload = new ResourceUpload();
			resourceUpload.setResourceStatus(Code.resourcestatus_instorage);//1:已上传 2:已匹配  3:入库失败 4: 已入库 5:上传失败
			resourceUploadService.updateByExampleSelective(resourceUpload, example);

		}
		
		
	    example=new ResourceUploadExample();
		example.createCriteria().andBatchIdEqualTo(batchId);//本批次文件大图全部删除
		lst = this.resourceUploadService.selectByExample(example);
		lst.forEach(
				e->{
					//清除缓存
					providerUtil.deleteMetaItem(e.getBatchId(),e.getFileName());
					//清空oss地址
					ResourceUpload resourceUpload = new ResourceUpload();
					//删除大图 
					if(StringUtils.isNotBlank(e.getOssPath())&& e.getResourceStatus()!=5){//入库失败给的是默认图，不能删除
						ProviderOSSClientUtil.deleteProviderFeiyuantu(isInternal, e.getOssPath());
					}
					resourceUpload.setId(e.getId());
					resourceUpload.setOssPath("");
                    resourceUploadService.updateByPrimaryKeySelective(resourceUpload);
		});
		
		//删除release
		ResourceUploadReleaseExample rexample = new ResourceUploadReleaseExample();
    	Criteria criteria = rexample.createCriteria();
    	criteria.andBatchIdEqualTo(batchId);
    	resourceUploadReleaseService.deleteByExample(rexample);
    	
    	//删除上传的meta文件
    	ResourceUploadMetaExample mexample = new ResourceUploadMetaExample();
    	example.createCriteria().andBatchIdEqualTo(batchId);
    	resourceUploadMetaService.deleteByExample(mexample);
    	
        //删除mete表内容
		ResourceUploadMetaContentExample mcexample=new ResourceUploadMetaContentExample();
		mcexample.createCriteria().andBatchIdEqualTo(batchId);
		resourceUploadMetaContentService.deleteByExample(mcexample);
 
		return RestfulResultFactory.getInstance(200, null,  "成功入库!");
		
 
	}
	
	
	/**
	 * 
	 * 保存按钮
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "上传管理-<更新>", notes = "多个文件")
	@RequestMapping(value = "/updateResources", method = RequestMethod.POST)
	public RestfulResult updateResources( @ApiParam(required = true,value = "多个ResourceUpload对象list")@RequestBody List<ResourceUpload> list) throws Exception {
		
		if(list.size()==0){
			 return RestfulResultFactory.getInstance(200, null,  "更新成功！");
		}
		
		//根据rm rf获得本供应商的collection  ,如果
		ResourceUpload resource =  resourceUploadService.getById(list.get(0).getId());
		
		ResourceUpload resourceUpload = list.get(0);
		
		if(StringUtils.isBlank(resourceUpload.getCaption())||resourceUpload.getLicenseType()==null||resourceUpload.getColorType()==null
				|| resourceUpload.getShootDate()==null || StringUtils.isBlank(resourceUpload.getKeywords())  || StringUtils.isBlank(resourceUpload.getCreditLine()) 
				){
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "必填项不完整!");
			
		}
		
		
		CollectionExample example=new CollectionExample();
		example.createCriteria().andProviderIdEqualTo(resource.getProviderId()).andLicenseTypeEqualTo(resourceUpload.getLicenseType());
		List<Collection> listcoll = this.collectionService.selectByExample(example);

		if(listcoll.size()==0){
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "用户不存在collection,请联系VCG");
		}
//		if(StringUtils.isBlank(listcoll.get(0).getOriginalName()) ){
//			return RestfulResultFactory.getInstance(Status.ERROR, null,  "此用户不存在collection original name 为空,请先维护collection数据");
//		}
		//String originalName =null;//根据rm rf 获取本次图片对应的collection name
//		if(listcoll.size()==1){
//			originalName = listcoll.get(0).getOriginalName();
//		}else if(listcoll.size()>1){
//			for(Collection coll: listcoll){//多个collection  取低价
//				if("2".equals( coll.getCollectionLevel()) ){ 
//					originalName = coll.getOriginalName();
//				}
//			}
//		}
		try {
			for(ResourceUpload r:list){
				r.setUpdatedTime(DateUtils.getNowDate());
				//r.setCollection(originalName);
				resourceUploadService.updateByPrimaryKeySelective(r);
			}
	        return RestfulResultFactory.getInstance(200, null,  "成功更新");
		}  catch (Exception e) {
			e.printStackTrace();
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "异常");
		}  
	}
	
	
	/**
	 * 
	 * 上传统计
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "上传管理-<上传情况统计>", notes = "包含上传失败的和入库失败的")
	@RequestMapping(value = "/getUploadAndInstorageStatistics", method = RequestMethod.POST)
	public Object getUploadAndInstorageStatistics(@RequestBody SearchUploadFail requestParam  ) throws Exception {
		 
		Map<String,Object> result = new  HashMap<String,Object>();
		try{

		
		        ResourceUploadExample example=new ResourceUploadExample();
	             //找出这个供应商的这个批次的所有 "已上传,已匹配" 的图
		        example.setOrderByClause("resource_status");
				example.createCriteria().andBatchIdEqualTo(requestParam.getBatchId()).andProviderIdEqualTo(requestParam.getProviderId()).andAssetFamilyEqualTo(requestParam.getAssetFamily()).andResourceStatusNotEqualTo(4);
				PageHelper.startPage(requestParam.getPageNum(), requestParam.getPageSize());
				List<ResourceUpload> lst = this.resourceUploadService.selectByExample(example);
				
				if(lst.size()>0){
					for(ResourceUpload resourceUpload:lst){
						
						resourceUpload.setUrl(failPic);
						resourceUpload.setCanSubmit(3);//都是失败的标记
						//入库失败和上传失败的 reson已经有值
						if(resourceUpload.getResourceStatus()==1){//1:已上传 2:已匹配  3:入库失败 4: 已入库 5: 上传失败
							Map<String,Object> check =checkResourceSubmitable(resourceUpload);
							resourceUpload.setReason(check.get("reason").toString());
						}
					}
				}
				
				example=new ResourceUploadExample();
				 com.vcg.provider.model.query.ResourceUploadExample.Criteria   criteria1  = example.createCriteria();
				 criteria1.andBatchIdEqualTo(requestParam.getBatchId()).andProviderIdEqualTo(requestParam.getProviderId()).andResourceStatusEqualTo(4).andAssetFamilyEqualTo(requestParam.getAssetFamily());;//已入库
				int instorage = this.resourceUploadService.countByExample(example);//已入库
				
				example=new ResourceUploadExample();
				com.vcg.provider.model.query.ResourceUploadExample.Criteria   criteria2  = example.createCriteria();
				
				criteria2.andBatchIdEqualTo(requestParam.getBatchId()).andProviderIdEqualTo(requestParam.getProviderId()).andAssetFamilyEqualTo(requestParam.getAssetFamily());;
				int total = this.resourceUploadService.countByExample(example);//总数
				
 
				result.put("status", "200");
				result.put("list", lst);
				result.put("total", total);
				result.put("instorage", instorage);
				result.put("fail", total-instorage);

	        return result;
		}  catch (Exception e) {
			e.printStackTrace();
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "异常");
		}  
	}
	
	
	
//	/**
//	 * 
//	 * 导出excel
//	 * @return
//	 * @throws Exception
//	 */
//	@ApiOperation(value = "上传管理-上传情况统计-<导出excel>", notes = "包含上传失败的和入库失败的")
//	@RequestMapping(value = "/excelStatistics", method = RequestMethod.POST)
//	public Object excelStatistics(@RequestBody ExcelUploadFail requestParam  ) throws Exception {
//		if(requestParam.getAssetFamily()==null||requestParam.getBatchId()==null||requestParam.getProviderId()==null){
//			return RestfulResultFactory.getInstance(Status.ERROR, null,  "某参数为空");
//		}
//		 
//		Map<String,Object> result = new  HashMap<String,Object>();
//		try{
//
//		
//		        ResourceUploadExample example=new ResourceUploadExample();
//	             //找出这个供应商的这个批次的所有的没入库的图
//				example.createCriteria().andBatchIdEqualTo(requestParam.getBatchId()).andProviderIdEqualTo(requestParam.getProviderId()).andAssetFamilyEqualTo(requestParam.getAssetFamily()).andResourceStatusNotEqualTo(4);
//				List<ResourceUpload> lst = this.resourceUploadService.selectByExample(example);
//				
//				if(lst.size()>0){
//					for(ResourceUpload resourceUpload:lst){
//						resourceUpload.setUrl(pdfutil.getFullFilePath(resourceUpload.getUrl()));
//						resourceUpload.setCanSubmit(3);//都是失败的标记
//						//入库失败和上传失败的 reson已经有值
//						if(resourceUpload.getResourceStatus()==1){//1:已上传 2:已匹配  3:入库失败 4: 已入库 5: 上传失败
//							Map<String,Object> check =checkResourceSubmitable(resourceUpload);
//							resourceUpload.setReason(check.get("reason").toString());
//						}
//					}
//				}
//				
//				example=new ResourceUploadExample();
//				 com.vcg.provider.model.query.ResourceUploadExample.Criteria   criteria1  = example.createCriteria();
//				 criteria1.andBatchIdEqualTo(requestParam.getBatchId()).andProviderIdEqualTo(requestParam.getProviderId()).andResourceStatusEqualTo(4);//已入库
//				int instorage = this.resourceUploadService.countByExample(example);//已入库
//				
//				example=new ResourceUploadExample();
//				com.vcg.provider.model.query.ResourceUploadExample.Criteria   criteria2  = example.createCriteria();
//				
//				criteria2.andBatchIdEqualTo(requestParam.getBatchId()).andProviderIdEqualTo(requestParam.getProviderId());
//				int total = this.resourceUploadService.countByExample(example);//总数
//				
// 
//				result.put("status", "200");
//				result.put("list", lst);
//				result.put("total", total);
//				result.put("instorage", instorage);
//				result.put("fail", total-instorage);
//
//	        return result;
//		}  catch (Exception e) {
//			e.printStackTrace();
//			return RestfulResultFactory.getInstance(Status.ERROR, null,  "异常");
//		}  
//	}
	
	
	
//	/**
//	 * 批量下载
//	 * 
//	 * @param resourceIds
//	 * @param request
//	 * @throws IOException 
//	 */
//	@ApiOperation(value = "编审编辑类页面图片上的小按钮-下载图", notes = "resouceId")
//	@RequestMapping(value = "/downLoadYuantu", method = { RequestMethod.GET })
//	public void downLoadYuantu(@RequestParam Integer groupId, @RequestParam String resourceIds,
//			HttpServletRequest request, HttpServletResponse response) throws IOException {
//		
//		response.setContentType("APPLICATION/OCTET-STREAM");  
//		  response.setHeader("Content-Disposition","attachment; filename="+groupId+".zip");  
//		  
//		//zip 压缩
//		ZipOutputStream zipOut=new ZipOutputStream(response.getOutputStream());
//		
//		OSSClient client=OssClient.getOssClient(editUtil.getIsInternal());
//		Map<String, Object> paramsMap = super.getParams();
//		for(String resouceId:resourceIds.split(",")){
//			if(StringUtils.isBlank(resouceId))continue;
//			paramsMap = super.getParams();
//			paramsMap.put("columns", "id,oss_id1,res_id");
//			paramsMap.put("id", Integer.parseInt(resouceId));
//			ResultMap rm = this.queryService.queryOneForCustom("ResourceCustom", "resourceById", paramsMap);
//			String value = rm.getValue("ossId1");
//			if(StringUtils.isNotBlank(value)){
//				
//				boolean isExist = ProviderOSSClientUtil.objectExist(client, OssClient.yuantuBucket, value);
//				if(!isExist){
//					continue;
//				}
//				
//				OSSObject object = client.getObject(OssClient.yuantuBucket, value);
//				InputStream input= object.getObjectContent();
//				
//				zipOut.putNextEntry(new ZipEntry(rm.getValue("resId")+".jpg"));
//				int temp = 0;
//                while((temp = input.read()) != -1){
//                    zipOut.write(temp);
//                }
//                input.close();
//			}
//		}
//		zipOut.flush();
//		zipOut.close(); 
//		OssClient.closeClient(client);
// 
//
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String checkReleaseExist( List<List<String>> list,Integer providerId){
		String result="";
		List<String> metareleaselist_m = new ArrayList<String>() ;
		List<String> metareleaselist_p = new ArrayList<String>() ;
		List<String> metareleaselist = new ArrayList<String>() ;
		if(list.size()==0){
			return "meta 文件内容为空!";
		}else{
			 
			 metareleaselist_m  = list.stream().map(e->e.get(6).trim()).filter(f->!f.isEmpty()).distinct().collect(Collectors.toList());
			 for(String rs:metareleaselist_m ){//有一些字段有多个授权
				 if(rs.contains(",")){
					 metareleaselist.addAll(Arrays.asList(rs.split(","))) ;
				 }else{
					 metareleaselist.add(rs);
				 }
			 }
			 metareleaselist_p  = list.stream().map(e->e.get(8).trim()).filter(f->!f.isEmpty()).distinct().collect(Collectors.toList());
			 for(String rs:metareleaselist_p ){//有一些字段有多个授权
				 if(rs.contains(",")){
					 metareleaselist.addAll(Arrays.asList(rs.split(","))) ;
				 }else{
					 metareleaselist.add(rs);
				 }
			 }
		 
			 if(metareleaselist.size()==0){//meta文件不为空,但是没有任何release文件
				 return "";
			 }else{//meta文件不为空,且有release文件,则检查这些文件是否已经上传
					ResourceUploadReleaseExample example = new ResourceUploadReleaseExample();
			    	example.setColunms(Arrays.asList("file_name"));
			    	example.createCriteria().andProviderIdEqualTo(providerId);
			    	List<ResourceUploadRelease> releaselist = resourceUploadReleaseService.selectByExample(example);
			    	List<String> databasereleaselist  = releaselist.stream().map(e->e.getFileName().trim()).collect(Collectors.toList());
			    	
			    	List<String> shortRelease = minus(metareleaselist,databasereleaselist);
			    	if(shortRelease.size()>0){
			    		result= "缺少meta文件中列出的授权文件:"+ shortRelease.toString();
			    	}
			    	
			    	 
			 }
			
		}
    	return result;
	}
	
	public Integer lisensType( String type){
		 
		if(StringUtils.isBlank(type)){
			return null;
		}else{
			 if(type.equals("RM")){
				 return 1;
			 }else if(type.equals("RF")){
				 return 2;
			 }else{
				 return null;
			 }
			
		}
    	 
	}
	public Integer mediaType( String type){
		 
		if(StringUtils.isBlank(type)){//1摄影图片2 插画 3漫画 4图表 5矢量图
			return null;
		}else{
			 if(type.equals("Photography")){
				 return 1;
			 }else if(type.equals("Illustration")){
				 return 2;
			 }else if(type.equals("Vector")){
				 return 5;
			 }else{
				 return null;
			 }
			
		}
    	 
	}
	public Integer colorType( String type){
		 
		if(StringUtils.isBlank(type)){//1黑白2彩色
			return null;
		}else{
			 if(type.equals("Color Image")){
				 return 2;
			 }else if(type.equals("Black&White")){
				 return 1;
			 }else{
				 return null;
			 }
			
		}
    	 
	}
	public Integer yesNo( String type){
		 
		if(StringUtils.isBlank(type)){//1是2否
			return null;
		}else{
			 if(type.equals("Y")){
				 return 1;
			 }else if(type.equals("N")){
				 return 0;
			 }else{
				 return null;
			 }
			
		}
    	 
	}
	
	// 忽略大小写
	public List<String>  minus( List<String> a, List<String> b){
		List<String> result= new ArrayList<String>();; 
		if(a==null){
			 return result;
		 }
		 if(b==null){
			 return a;
		 }
		 
		 List<String> a1= new ArrayList<String>();
		 List<String> b1= new ArrayList<String>();
		 String temp="";
		 for(String original: a){
			temp = original.toLowerCase();
			 a1.add(temp);
		 }
		 for(String original: b){
			 temp = original.toLowerCase();
			 b1.add(temp);
		 }
		 
		 for(String a11:a1){
			 if(!b1.contains(a11.trim())){
				 result.add(a11.trim());
			 }
		 }
	 return result;
    	 
	}
	
 
	
	
	//此时,meta文件格式完全正确 release也完全匹配的上
	public void matchPhotoWithMeta( List<List<String>> metalist,  List<ResourceUpload> resourceList,Integer providerId){
 
//	        ["100001","Patrick McMullan","测试caption1","RF","女人,光线,昏暗,俄罗斯,长发","Y","M1.jpg","Y","p1.jpg","签名","限制1","2016-03-05","Photography","Color Image",""]
//			["100002","Patrick McMullan","测试caption2","RF","女人,光线,昏暗,俄罗斯,抽烟","Y","M2,M3.jpg","Y","p2.jpg,p3.jpg","签名","限制2","2016-03-06","Photography","Black&White",""]
//			["100003","Patrick McMullan","测试caption3","RF","女人,光线,昏暗,俄罗斯,裸露","N","","N","","签名","限制3","2016-03-07","Photography","Black&White",""]
//			["100004","Patrick McMullan","测试caption4","RF","女人,光线,昏暗,俄罗斯,红唇","N","","N","","签名","限制4","2016-03-08","Photography","Black&White",""]
//			["100005","Patrick McMullan","测试caption5","RF","女人,光线,昏暗,俄罗斯,性感","N","","N","","签名","限制5","2016-03-09","Photography","Color Image",""] 
//
			for(ResourceUpload resourceUpload:resourceList){//匹配
				for(List<String> meta:metalist){
					if(meta.get(0).trim().equals(resourceUpload.getFileName())){
						resourceUpload.setCollection(meta.get(1));
						resourceUpload.setCaption(meta.get(2));
						resourceUpload.setLicenseType(lisensType(meta.get(3)));
						resourceUpload.setKeywords(meta.get(4));
						resourceUpload.setHaveModelRelease(yesNo(meta.get(5)));
					    if(yesNo(meta.get(5))==1 && StringUtils.isNotBlank(meta.get(6))){//可能存在肖像权文件
					    	List<String> m_release =  Arrays.asList(meta.get(6).split(","));
					    	ResourceUploadReleaseExample example = new ResourceUploadReleaseExample();
				        	example.setColunms(Arrays.asList("file_name","oss_path"));
				        	Criteria criteria = example.createCriteria();
				        	criteria.andFileNameIn(m_release).andProviderIdEqualTo(providerId);
				            criteria.andReleaseTypeEqualTo(1);//肖像权
				         
				        	List<ResourceUploadRelease> list = resourceUploadReleaseService.selectByExample(example);
				        	 List<String> m_releases  = list.stream().map(e->e.getFileName()).filter(f->!f.isEmpty()).distinct().collect(Collectors.toList());
				        	if(m_releases.size()>0){
				        		resourceUpload.setModelRelease(listToString(m_releases));
				        	}
					    	
					    }
						
						resourceUpload.setHavePropertyRelease(yesNo(meta.get(7).trim()));
						
					    if(yesNo(meta.get(7))==1 && StringUtils.isNotBlank(meta.get(8))){//可能存在物权文件
					    	List<String> p_release =  Arrays.asList(meta.get(8).split(","));
					    	ResourceUploadReleaseExample example = new ResourceUploadReleaseExample();
				        	example.setColunms(Arrays.asList("file_name","oss_path"));
				        	Criteria criteria = example.createCriteria();
				        	criteria.andFileNameIn(p_release).andProviderIdEqualTo(providerId);
				            criteria.andReleaseTypeEqualTo(2);//物权
				         
				        	List<ResourceUploadRelease> list = resourceUploadReleaseService.selectByExample(example);
				        	 List<String> p_releases  = list.stream().map(e->e.getFileName()).filter(f->!f.isEmpty()).distinct().collect(Collectors.toList());
				        	if(p_releases.size()>0){
				        		resourceUpload.setPropertyRelease(listToString(p_releases));
				        	}
					    	
					    }
	 
						resourceUpload.setCreditLine(meta.get(9));
						resourceUpload.setRestriction(meta.get(10));
						resourceUpload.setShootDate(DateUtils.parseDate(meta.get(11), "yyyy-MM-dd"));
						resourceUpload.setGraphicalStyle(mediaType((meta.get(12).trim())));
						resourceUpload.setColorType(colorType(meta.get(13).trim()));
						resourceUpload.setResourceStatus(2);//1:已上传 2:已匹配 3:已提交到入库程序 4: 已入库 5:已上线 6:已下线 7: 入库失败
						resourceUploadService.updateByPrimaryKeySelective(resourceUpload);
					}
				}
			}
    	 
	}
	
	
	
	
	//此时,meta文件格式完全正确 release也完全匹配的上
	public void matchPhotoWithMeta(List<ResourceUpload> resourceList,Integer  releaseType){
 
//	        ["100001","Patrick McMullan","测试caption1","RF","女人,光线,昏暗,俄罗斯,长发","Y","M1.jpg","Y","p1.jpg","签名","限制1","2016-03-05","Photography","Color Image",""]
//			["100002","Patrick McMullan","测试caption2","RF","女人,光线,昏暗,俄罗斯,抽烟","Y","M2,M3.jpg","Y","p2.jpg,p3.jpg","签名","限制2","2016-03-06","Photography","Black&White",""]
//			["100003","Patrick McMullan","测试caption3","RF","女人,光线,昏暗,俄罗斯,裸露","N","","N","","签名","限制3","2016-03-07","Photography","Black&White",""]
//			["100004","Patrick McMullan","测试caption4","RF","女人,光线,昏暗,俄罗斯,红唇","N","","N","","签名","限制4","2016-03-08","Photography","Black&White",""]
//			["100005","Patrick McMullan","测试caption5","RF","女人,光线,昏暗,俄罗斯,性感","N","","N","","签名","限制5","2016-03-09","Photography","Color Image",""] 
//
			for(ResourceUpload resourceUpload:resourceList){//匹配
				
				ResourceUploadMetaContent meta = providerUtil.getMetaItem(resourceUpload.getBatchId(), resourceUpload.getFileName());
				if(meta!=null){
					
					ResourceUpload resource = new ResourceUpload();
					resource.setId(resourceUpload.getId());
					if(releaseType==1){
				    	List<String> m_release =  Arrays.asList(meta.getModelReleaseName().split(","));
				    	ResourceUploadReleaseExample example = new ResourceUploadReleaseExample();
			        	example.setColunms(Arrays.asList("file_name","oss_path"));
			        	Criteria criteria = example.createCriteria();
			        	criteria.andFileNameIn(m_release).andProviderIdEqualTo(resourceUpload.getProviderId());
			            criteria.andReleaseTypeEqualTo(1).andBatchIdEqualTo(resourceUpload.getBatchId());//肖像权
			         
			        	List<ResourceUploadRelease> list = resourceUploadReleaseService.selectByExample(example);
			        	 List<String> m_releases  = list.stream().map(e->e.getFileName()).filter(f->!f.isEmpty()).distinct().collect(Collectors.toList());
			        	if(m_releases.size()>0){
			        		resourceUpload.setModelRelease(listToString(m_releases));
			        	}
						
					}else if(releaseType==2){
				    	List<String> p_release =  Arrays.asList(meta.getPropertyReleaseName().split(","));
				    	ResourceUploadReleaseExample example = new ResourceUploadReleaseExample();
			        	example.setColunms(Arrays.asList("file_name","oss_path"));
			        	Criteria criteria = example.createCriteria();
			        	criteria.andFileNameIn(p_release).andProviderIdEqualTo(resourceUpload.getProviderId());
			            criteria.andReleaseTypeEqualTo(2).andBatchIdEqualTo(resourceUpload.getBatchId());//物权
			        	List<ResourceUploadRelease> list = resourceUploadReleaseService.selectByExample(example);
			        	List<String> p_releases  = list.stream().map(e->e.getFileName()).filter(f->!f.isEmpty()).distinct().collect(Collectors.toList());
			        	if(p_releases.size()>0){
			        		resourceUpload.setPropertyRelease(listToString(p_releases));//逗号分隔的地址
			        	}
					}	
					 resourceUploadService.updateByPrimaryKeySelective(resourceUpload);
				}
			}
    	 
	}
	
	
	
	 public  String listToString(List<String> stringList){
	        if (stringList==null) {
	            return null;
	        }
	        StringBuilder result=new StringBuilder();
	        boolean flag=false;
	        for (String string : stringList) {
	            if (flag) {
	                result.append(",");
	            }else {
	                flag=true;
	            }
	            result.append(string);
	        }
	        return result.toString();
	    }
	 
	 public  Map<String,Object> checkResourceSubmitable(ResourceUpload resourceUpload){
		 Map<String,Object> map = new  HashMap<String,Object>();
         String reason = "";
			if(StringUtils.isBlank(resourceUpload.getCaption())
					||resourceUpload.getLicenseType()==null
					||resourceUpload.getColorType()==null
					||resourceUpload.getShootDate()==null
					||resourceUpload.getHaveModelRelease()==null
					||resourceUpload.getHavePropertyRelease()==null
					||StringUtils.isBlank(resourceUpload.getCreditLine())){//这些字段为空时不能提交的 
				
				if(StringUtils.isBlank(resourceUpload.getCaption())){
					reason=reason+"标题为空;";
				}
				if(resourceUpload.getLicenseType()==null){
					reason=reason+"授权类型为空;";
				}
				if(resourceUpload.getColorType()==null){
					reason=reason+"颜色类型为空;";
				}
				if(resourceUpload.getShootDate()==null){
					reason=reason+"拍摄日期为空;";
				}
				if(resourceUpload.getHaveModelRelease()==null){
					reason=reason+"是否有肖像权授权为空;";
				}
				if(resourceUpload.getHavePropertyRelease()==null){
					reason=reason+"是否有物权授权为空;";
				}
				if(StringUtils.isBlank(resourceUpload.getCreditLine())){
					reason=reason+"签名为空;";
				}
				
				map.put("reason", reason);
				map.put("submitable", "0");
	            return map;
				 
			}else{//这些提示不影响提交
				map.put("submitable", "1");
				
				if(resourceUpload.getHaveModelRelease()==1){
					ResourceUploadMetaContent content = providerUtil.getMetaItem(resourceUpload.getBatchId(), resourceUpload.getFileName());
					if(content!=null){
						if(StringUtils.isNotBlank(content.getModelReleaseName())){//meta文件中列出来的,那就应该提示
							if(StringUtils.isBlank(resourceUpload.getModelRelease())){//图上的release一张都没有
								reason=reason + "缺少肖像权:"+ content.getModelReleaseName() ;
								map.put("submitable", "2");
							}else{//需要比较
								List<String> r_release = Arrays.asList(resourceUpload.getModelRelease().split(",")  )  ;
								List<String> m_release =  Arrays.asList(content.getModelReleaseName().split(","));
								List<String> shortfiles = minus(m_release, r_release);// meta里有,但是数据库里没有的
								if(shortfiles.size()>0){
									map.put("submitable", "2");
									reason = reason + "缺少肖像权:" + listToString(shortfiles);
								}
								
							}
						}
						
						
					}

				}
				
				if(resourceUpload.getHavePropertyRelease()==1){
					ResourceUploadMetaContent content = providerUtil.getMetaItem(resourceUpload.getBatchId(), resourceUpload.getFileName());
					if(StringUtils.isNotBlank(content.getPropertyReleaseName())){//meta文件中列出来的,那就应该提示
						if(StringUtils.isBlank(resourceUpload.getPropertyRelease())){//meta上要求的,但是图上的release一张都没有
							map.put("submitable", "2");
							reason=reason + "缺少物权:"+ content.getPropertyReleaseName();
						}else{//需要比较
							List<String> r_release = Arrays.asList(resourceUpload.getPropertyRelease().split(",")  )  ;
							List<String> m_release =  Arrays.asList(content.getPropertyReleaseName().split(","));
							List<String> shortfiles = minus(m_release, r_release);// meta里有,但是数据库里没有的
							if(shortfiles.size()>0){
								map.put("submitable", "2");
								reason = reason + "缺少物权:" + listToString(shortfiles);
							}
							
						}
					}
				}
 
				map.put("reason", reason);
	            return map;
			}
	    }
	 
	 
	 //检查meta文件的缺失的东西
	public String checkFileMissingInMeta(List<List<String>> metalist, List<String> metapicIds, Integer providerId,
			List<ResourceUpload> lst) {

		try {

			String errorstring = checkReleaseExist(metalist, providerId);
			List<String> datapicIds = lst.stream().map(e -> e.getFileName().trim()).collect(Collectors.toList());
			List<String> shortfiles = minus(metapicIds, datapicIds);// excel里有,但是数据库里没有的
			String shortphotomessage = "缺少meta文件中列出的如下图片:" + shortfiles;
			if (StringUtils.isBlank(errorstring)) {
				return shortphotomessage;
			} else {
				return errorstring + "," + shortphotomessage;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			return "未知错误,请重新上传meta文件!";
		}

	}
	
	
	public  List<ResourceUpload>  getPhotoNameFromMetaContentByReleaseName(String  releaseName,Integer releaseType, Integer batchId,Integer providerId) {
		try {
				ResourceUploadMetaContentExample example=new ResourceUploadMetaContentExample();
				example.setColunms(Arrays.asList("id","image_name","model_release","model_release_name","property_release","property_release_name"));
				com.vcg.provider.model.query.ResourceUploadMetaContentExample.Criteria   criteria  = example.createCriteria();
				criteria.andBatchIdEqualTo(batchId).andProviderIdEqualTo(providerId);
				releaseName ='%'+releaseName+"%";
			if(releaseType==1){//肖像权
				criteria.andModelReleaseEqualTo(1).andModelReleaseNameLike(releaseName);
			}else{//物权
				criteria.andPropertyReleaseEqualTo(1).andPropertyReleaseNameLike(releaseName);
			}
			 
			List<ResourceUploadMetaContent> lst = this.resourceUploadMetaContentService.selectByExample(example);
			if(lst.size()==0){
				return null;
			}else{
				List<String> imageList =  lst.stream().map(e->e.getImageName()).filter(f->!f.isEmpty()).distinct().collect(Collectors.toList());
				if(imageList.size()==0){
					return null;
				}else{
					ResourceUploadExample rExample  = new ResourceUploadExample(); 
					rExample.createCriteria().andFileNameIn(imageList).andBatchIdEqualTo(batchId);
					 List<ResourceUpload> photolist =  resourceUploadService.selectByExample(rExample);
					
					return photolist;
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			return null;
		}

	} 
 
	
	
	
}
