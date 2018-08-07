package com.vcg.provider.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.PageInfo;
import com.vcg.common.AbstractController;
import com.vcg.common.ResultMap;
import com.vcg.common.Status;
import com.vcg.provider.entity.SearchContractInfo;
import com.vcg.provider.model.Collection;
import com.vcg.provider.service.CollectionService;
import com.vcg.provider.util.AccountUtil;
import com.vcg.provider.util.PdfUtil;
import com.vcg.provider.util.RedisUtil;
import com.vcg.provider.util.SearchUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import com.vcg.oss.util.ProviderOSSClientUtil;
import com.vcg.common.RestfulResult;
import com.vcg.common.RestfulResultFactory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

 

@RestController
@RequestMapping("/contract")
public class ContractController extends AbstractController{
 
	
	@Autowired
	private CollectionService collectionService;
	
	@Autowired
	private PdfUtil pdfutil;
	
	@Value("${oss.isInternal}")
	private Integer isInternal;
	
	@Value("${oss.providerbucket}")
	private String providerbucket;
	
	@Autowired
	private AccountUtil accountUtil;
	
	@Autowired
	private ProviderOSSClientUtil providerOSSClientUtil;
	
	
	@Autowired
	private RedisUtil redisUtil;
	
	//String userId = accountUtil.getUserId(token);
	
 

 
	/**
	 * HTML生成PDF（合同文本）
	 * @param htmlUrl
	 * @return
	 * @throws FileNotFoundException 
	 */
 
	@RequestMapping(value="/generatePdf",method=RequestMethod.GET)
	public Object generatePdf(@ApiParam(value = "本合同文档的完整URL") @RequestParam String htmlUrl) throws FileNotFoundException{
		
		//获取正确的名字
		String pdfName="";
		File file =null;
		try {
			//获取正确的名字
			pdfName = pdfutil.createOssFileName("test.pdf", 1);
			//生成pdf文件到特定的目录,文件名为timestemp.pdf
			pdfutil.htmlToPdf(htmlUrl, pdfutil.getPdfOut() + pdfName);
			
			pdfutil.iSignature( pdfName);
 
			file = new File( pdfutil.getSigout() + pdfName);   
			 long fr= file.length();
			 if(fr==0){
				 return RestfulResultFactory.getInstance(Status.ERROR, null,  "生成的pdf为空"); 
			 }
		     InputStream inputStream = new FileInputStream(file); 

		     //上传oss
		     String imgObjectId = "provider/"+pdfName;
		     providerOSSClientUtil.putProviderObject(isInternal, imgObjectId, inputStream);
		     return RestfulResultFactory.getInstance(200, imgObjectId,  "成功"); 
		     
		} catch (Exception e) {
			e.printStackTrace();
			
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			 
			
			return RestfulResultFactory.getInstance(Status.ERROR, null, fullStackTrace); 
		}finally {
			//删除打了时间戳文件的pdf
			file = new File( pdfutil.getSigout() + pdfName);  
		    if (file.isFile() && file.exists()) {  
		        file.delete();  
		    } 
		    //删除生成的pdf文件
		    file = new File( pdfutil.getPdfOut() + pdfName);  
		    if (file.isFile() && file.exists()) {  
		        file.delete();  
		    }  
		}
		
		
		
	}
	

	
	
	/**
	 * 供稿人-合同信息-搜索
	 * @param requestParam
	 * @return
	 */
	@ApiOperation(value = "供稿人-合同-<合同搜索>", notes = "供稿人基本信息-合同<合同搜索和列表>")
	@RequestMapping(value="/searchContractInfo",method=RequestMethod.POST)
	public RestfulResult searchContractInfo(@RequestBody SearchContractInfo requestParam){
		
		try {
			Map<String,Object> searchParam = SearchUtil.parseContractsParam(requestParam);
			PageInfo<ResultMap> result = this.queryService.queryPageForCustom("providerManage", "searchContractInfo", searchParam);
			return RestfulResultFactory.getInstance(200, result,  "ok");
		}  catch (Exception e) {
			e.printStackTrace();
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return RestfulResultFactory.getInstance(Status.ERROR, null,  fullStackTrace);
		}  
	}
	
	/**
	 * 供稿人-合同信息-详细信息
	 * @param contractId
	 * @param token
	 * @return
	 */
	@ApiOperation(value = "供稿人-合同-<点击单行查看详情>", notes = "供稿人-合同<点击单行查看详情>")
	@RequestMapping(value="/getContractMoreDetailInfo",method=RequestMethod.GET)
	public RestfulResult getContractMoreDetailInfo(@ApiParam(value = "本行的合同id") @RequestParam Integer id){
		
		Map<String,Object> searchParam = new HashMap<String,Object>();
		searchParam.put("id", id);
		
		try {
			ResultMap result = this.queryService.queryOneForCustom("providerManage", "searchContractDetailedInfo", searchParam);
			if(result != null){
				if(result.getIntegerValue("providerId")!=null && result.getIntegerValue("contractId")!=null){//一个人的某份合同对应多个collection
					List<Collection> collections = this.collectionService.getCollectionByContractIdAndProviderId(result.getIntegerValue("contractId"), result.getIntegerValue("providerId"));
					result.put("collections", collections);
				}
			} 
			return RestfulResultFactory.getInstance(200, result,  "ok");
		}  catch (Exception e) {
			 
			e.printStackTrace();
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return RestfulResultFactory.getInstance(Status.ERROR, null,  fullStackTrace);
		}  
	}
	
	/**
	 * 供稿人-合同信息-详细信息
	 * @param contractId
	 * @param token
	 * @return
	 */
	@ApiOperation(value = "供稿人-合同-合同详情-<添加collection>", notes = "供稿人-合同-合同详情-添加collection")
	@RequestMapping(value="/addContractCollection",method=RequestMethod.GET)
	public RestfulResult addContractCollection( @RequestBody  Collection  collection,@RequestParam String token){
		String userId = accountUtil.getUserId(token);
		
		try {
			if(collection.getProviderId()==null||collection.getContractId()==null){
				return RestfulResultFactory.getInstance(Status.ERROR, null,  "ProviderId,ContractId不能为空");
			}
				collection.setCreatedBy(userId);
			collectionService.insertSelective(collection);
			return RestfulResultFactory.getInstance(200, null,  "插入成功");
		}  catch (Exception e) {
			 
			e.printStackTrace();
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return RestfulResultFactory.getInstance(Status.ERROR, null,  fullStackTrace);
		}  
	}
	
	/**
	 * 供稿人-合同信息-详细信息
	 * @param contractId
	 * @param token
	 * @return
	 */
	@ApiOperation(value = "供稿人-合同-合同详情-<修改collection,关闭collection>", notes = "供稿人-合同-合同详情-<修改collection,关闭collection>")
	@RequestMapping(value="/updateContractCollection",method=RequestMethod.GET)
	public RestfulResult updateContractCollection( @RequestBody  Collection  collection,@RequestParam String token){
		String userId = accountUtil.getUserId(token);
		
		try {
			if(collection.getProviderId()==null||collection.getContractId()==null){
				return RestfulResultFactory.getInstance(Status.ERROR, null,  "ProviderId,ContractId不能为空");
			}
			if(collection.getId()==null){
				return RestfulResultFactory.getInstance(Status.ERROR, null,  "主键Id不能为空");
			}
			collection.setCreatedBy(userId);
			collectionService.updateByPrimaryKeySelective(collection);
			redisUtil.deleteRedisCollection(collection.getId());
			return RestfulResultFactory.getInstance(200, null,  "插入成功");
		}  catch (Exception e) {
			 
			e.printStackTrace();
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return RestfulResultFactory.getInstance(Status.ERROR, null,  fullStackTrace);
		}  
	}
	
	/**
	 * 
	 * 文件上传
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "供应商系统的<上传文件>", notes = "只是给供应商用的上传")
	@RequestMapping(value = "/uploadOneFile", method = RequestMethod.POST)
	public RestfulResult uploadOneFile(@RequestParam MultipartFile file,@ApiParam(value = "1:标准合同pdf 2:买断合同PDF 3:解约合同PDF 4:外购合同pdf 5:续约合同PDF 6:身份证图 7:营业执照图 8:税务登记图 9:月报表 10:发票11:其他")@RequestParam Integer fileType) throws Exception {
		if (file == null) {
            throw new Exception("上传失败：文件为空");    
        }
        if(file.getSize()>10000000)        
        {
            throw new Exception("上传失败：文件大小不能超过10M");            
        }
        //得到文件名
        String originalFilename=file.getOriginalFilename();  
        String imgObjectId =  pdfutil.createOssFilePath(originalFilename, fileType);
		try {
			InputStream inputStream = file.getInputStream();
			providerOSSClientUtil.putProviderObject(isInternal, imgObjectId, inputStream);
 
		}  catch (Exception e) {
			e.printStackTrace();
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return RestfulResultFactory.getInstance(Status.ERROR, null,  fullStackTrace);
		}  
 
		return RestfulResultFactory.getInstance(200, imgObjectId,  "成功上传");

	}
	
	
	/**
	 * 
	 * 文件下载
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "供应商系统的<获取文件RUL>", notes = "参数为文件路径")
	@RequestMapping(value = "/getAuthFileLink", method = RequestMethod.POST)
	public RestfulResult getAuthFileLink( @ApiParam(value = "不包含域名的文件路径,如provider/recepts/20161104140205-recept-400802c97f.jpg")@RequestParam String filePath) throws Exception {
		    String  r =  pdfutil.getFullFilePath(filePath);
			return RestfulResultFactory.getInstance(200, r,  "成功获取");
		 
	}
	
	
	/**
	 * 
	 * 查看合同pdf 查看发票pic
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "供稿人或者机构-合同信息-<查看合同><查看发票>", notes = "供稿人-合同信息-<查看合同>")
	@RequestMapping(value = "/getFileLink", method = RequestMethod.POST)
	public RestfulResult getFileLink( @ApiParam(value = "不包含域名的文件路径,如provider/recepts/20161104140205-recept-400802c97f.jpg")@RequestParam String filePath) throws Exception {
	    String  r =  pdfutil.getFullFilePath(filePath);
		return RestfulResultFactory.getInstance(200, r,  "成功获取");
		

	}
	
	
	
}
