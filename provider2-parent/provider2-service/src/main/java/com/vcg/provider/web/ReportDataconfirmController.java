package com.vcg.provider.web;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vcg.oss.util.ProviderOSSClientUtil;
import com.vcg.common.AbstractController;
import com.vcg.common.DateUtils;
import com.vcg.common.RestfulResult;
import com.vcg.common.RestfulResultFactory;
import com.vcg.common.ResultMap;
import com.vcg.common.Status;
import com.vcg.provider.entity.ReportConfirm;
import com.vcg.provider.entity.UploadReportMonth;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.ReportDataconfirm;
import com.vcg.provider.model.query.ReportDataconfirmExample;
import com.vcg.provider.service.ProviderService;
import com.vcg.provider.service.ReportDataconfirmService;
import com.vcg.provider.util.SearchUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.vcg.provider.util.PdfUtil;

 
@RestController
@RequestMapping("/reportDataconfirm")
public class ReportDataconfirmController extends AbstractController {
	public static Logger log = Logger.getLogger(ReportDataconfirmController.class);

	@Autowired
	private ReportDataconfirmService reportDataconfirmService;
	
	@Autowired
	private PdfUtil pdfutil;
	
	@Value("${oss.isInternal}")
	private Integer isInternal;
	
	@Autowired
	private ProviderService providerService;
	
 
	/**
	 * 申请供稿人审核-资格审核-搜索
	 * @param requestParam
	 * @return
	 */

	@ApiOperation(value = "结算管理-<机构报表确认>", notes = "")
	@RequestMapping(value="/getPageList", method=RequestMethod.POST)
	public RestfulResult getPageList(@ApiParam(value = "必填ParamMap对象") @RequestBody ReportConfirm  requestParam){
		 
		
	     try {
	    	 
	    	 Map<String,Object> searchParam = SearchUtil.parseconfirmReportsParam(requestParam);
	    	 
	 		PageHelper.startPage(requestParam.getPageNum(), requestParam.getPageSize());
	 		PageInfo<ResultMap> result = this.queryService.queryPageForCustom("ReportManage", "searchReportConfirm", searchParam);
	 		return RestfulResultFactory.getInstance(200, result,  "成功");
		         
		     } catch (Exception e) {
		       e.printStackTrace(); 
		       return RestfulResultFactory.getInstance(201, null,  "失败");
		     }
	}
	
	/**
	 * 
	 * 报表检测
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "结算管理-机构报表确认-批量上传报表-<检测报表是否重复>", notes = "结算管理-机构报表确认-批量上传报表-<检测报表是否重复>")
	@RequestMapping(value = "/checkFile", method = RequestMethod.POST)
	public RestfulResult checkFile(String file) throws Exception {
 

       String originalFilename=file ;
		String extention = originalFilename.substring(originalFilename.indexOf('.')+1);
		if(!extention.equals("xsl") && !extention.equals("xlsx") ){
			return RestfulResultFactory.getInstance(300, null,  "不是excel文件");
		}
       //蓝牛仔#25#HT00001#201611.xlsx
       List<String> info = Arrays.asList(originalFilename.split("#"));
       if(info.size()!=4){
    	   return RestfulResultFactory.getInstance(300, null,  "文件名不符合规范,规范例如(蓝牛仔#25#HT00001#201611.xlsx)");
       }
       ReportDataconfirmExample example = new ReportDataconfirmExample();
       example.createCriteria().andReportOriginalnameEqualTo(originalFilename);
       List<ReportDataconfirm> list = reportDataconfirmService.selectByExample(example);
       if(list.size()>0){
    	   return RestfulResultFactory.getInstance(Status.ERROR, null,  "有重复");
       }
		return RestfulResultFactory.getInstance(200, null,  "可以上传");
	}
	
	
	/**
	 * 
	 * 本月报表文件批量上传并且校验
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "结算管理-机构报表确认-<批量上传报表>", notes = "3: 错误:此文件名不符合规范,将不会被上传  2:警告:此文件将会被覆盖")
	@RequestMapping(value = "/uploadOneReportFile", method = RequestMethod.POST)
	public  Map<String,Object> uploadOneReportFile(@RequestParam MultipartFile file) throws Exception {
		Integer  fileType = 9;
		Map<String,Object> map = new HashMap<String,Object>();
		String originalFilename=file.getOriginalFilename();  //蓝牛仔#25#HT00001#201611.xlsx
        String imgObjectId =  pdfutil.createOssFilePath(originalFilename, fileType);
        InputStream inputStream = file.getInputStream();
        ProviderOSSClientUtil.putProviderObject(isInternal, imgObjectId, inputStream);
		map.put("fileName", originalFilename);
		map.put("filepath", imgObjectId);
		
	     try { 
			    List<String> info = Arrays.asList(originalFilename.split("#"));
		        if(info.size()!=4){
					map.put("relustType",3);// "错误:此文件名不符合规范,将不会被上传 "
		        }else{
		        	Provider provider = providerService.selectByPrimaryKey(Integer.parseInt(info.get(1)));
		        	if(provider==null){
		        		map.put("relustType", 1);//"错误:此供应商不存在"
		        	}
		        	ReportDataconfirmExample example = new ReportDataconfirmExample();
			       example.createCriteria().andReportOriginalnameEqualTo(originalFilename);
			       List<ReportDataconfirm> list = reportDataconfirmService.selectByExample(example);
			       if(list.size()>0){
						map.put("relustType", 2);//"警告:此文件将会被覆盖"
			       }
		        }
		        return map;
	     } catch (Exception e) {
		       e.printStackTrace(); 
		       map.put("relustType",4);// "其他错误 "
		       return map;
		     }

	}
	
 
	@ApiOperation(value = "结算管理-机构报表确认-<批量导入报表>", notes = "")
	@RequestMapping(value="/addReportConfirmMonth", method=RequestMethod.POST)
	public RestfulResult addReportConfirmMonth(@ApiParam(value = "必填") @RequestBody List<UploadReportMonth>  list){
		 
		
	     try {
 
	    	 list.forEach(e->{ 	
	    		 ReportDataconfirm reportDataconfirm = new ReportDataconfirm();
	    		
	    		 reportDataconfirm.setReportPath(e.getReportPath());//文件存储路径
	    		 reportDataconfirm.setReportUploaddate(DateUtils.getNowDate());//文件上传时间
	    		 reportDataconfirm.setIsConfirmed(0);//未确认
	    		 reportDataconfirm.setIsPublished(0);//未发布
	    		 reportDataconfirm.setIsPaid(0);//未付款
	    		 String filename = e.getReportName().replaceAll("$$$$$", "");//去掉标记
	    		 List<String> infoList =  Arrays.asList(filename.split("#"));
	    		 String month =infoList.get(3).substring(0,infoList.get(3).indexOf("."));
	    		 reportDataconfirm.setProviderId(Integer.parseInt(infoList.get(1)));//供应商id
	    		 reportDataconfirm.setProviderName(infoList.get(0));//供应商名字
	    		 reportDataconfirm.setReportMonth(month);//月份
	    		 reportDataconfirm.setContractName(infoList.get(2));//合同名
	    		 reportDataconfirm.setReportOriginalname(filename);
	    		 reportDataconfirmService.insertSelective(reportDataconfirm);
	    		 
	    	 });
	 		return RestfulResultFactory.getInstance(200, null,  "成功上传");
		         
		     } catch (Exception e) {
		       e.printStackTrace(); 
		       return RestfulResultFactory.getInstance(201, null,  "失败");
		     }
	}
	
	@ApiOperation(value = "结算管理-机构报表确认-<批量确认报表>", notes = "")
	@RequestMapping(value="/reportPublish", method=RequestMethod.POST)
	public RestfulResult reportPublish(@ApiParam(value = "必填") @RequestBody List<Integer>  list){
	     try {
	    	 list.forEach(e->{ 	
	    		 ReportDataconfirm reportDataconfirm = new ReportDataconfirm();
	    		 reportDataconfirm.setId(e);
	    		 reportDataconfirm.setIsPublished(1);//发布
	    		 reportDataconfirmService.updateByPrimaryKeySelective(reportDataconfirm);
	    		 
	    	 });
	 		   return RestfulResultFactory.getInstance(200, null,  "成功发布");
		         
		     } catch (Exception e) {
		       e.printStackTrace(); 
		       return RestfulResultFactory.getInstance(201, null,  "失败");
		     }
	}
	
	@ApiOperation(value = "结算管理-机构报表确认-<批量取消发布报表>", notes = "")
	@RequestMapping(value="/reportUnPublish", method=RequestMethod.POST)
	public RestfulResult reportUnPublish(@ApiParam(value = "必填") @RequestBody List<Integer>  list){
	     try {
	    	 list.forEach(e->{ 	
	    		 ReportDataconfirmExample example = new ReportDataconfirmExample();
	    		 example.createCriteria().andIsConfirmedEqualTo(0).andIsPaidEqualTo(0).andIdEqualTo(e);
	    		 ReportDataconfirm reportDataconfirm = new ReportDataconfirm();
	    		 reportDataconfirm.setIsPublished(0);//发布
	    		 reportDataconfirmService.updateByExampleSelective(reportDataconfirm,example);
	    		 
	    	 });
	 		   return RestfulResultFactory.getInstance(200, null,  "成功取消");
		         
		     } catch (Exception e) {
		       e.printStackTrace(); 
		       return RestfulResultFactory.getInstance(201, null,  "失败");
		     }
	}
	
	@ApiOperation(value = "结算管理-机构报表确认-<批量删除报表>", notes = "必须是未发布的报表才能删除")
	@RequestMapping(value="/deleteUnPublishedReport", method=RequestMethod.POST)
	public RestfulResult deleteUnPublishedReport(@ApiParam(value = "必填,本行数据的id") @RequestBody List<Integer>  ids){
	     try {
	    	 for(Integer id:ids){
	    		 ReportDataconfirmExample example = new ReportDataconfirmExample();
	    		 example.createCriteria().andIsPublishedEqualTo(0).andIdEqualTo(id);
	    		 reportDataconfirmService.deleteByExample( example);
	    	 }
	 		   return RestfulResultFactory.getInstance(200, null,  "成功取消");
		         
		     } catch (Exception e) {
		       e.printStackTrace(); 
		       return RestfulResultFactory.getInstance(201, null,  "失败");
		     }
	}
	
// 
//	
//	@ApiOperation(value = "结算管理-机构报表确认-<发送邮件>", notes = "")
//	@RequestMapping(value="/sendMail", method=RequestMethod.POST)
//	public RestfulResult sendMail(@ApiParam(value = "必填") @RequestBody String emailAddress){
//	     try {
//	    	  
//	    	 if(StringUtils.isNoneBlank(emailAddress)){
//	    		 messageUtil.reportMonthEmail(emailAddress);
//	    		 
//	    	 }
//	    	 
//	    	 
//	 		   return RestfulResultFactory.getInstance(200, null,  "成功发送");
//		         
//		     } catch (Exception e) {
//		       e.printStackTrace(); 
//		       return RestfulResultFactory.getInstance(201, null,  "失败");
//		     }
//	}
	
	@ApiOperation(value = "结算管理-机构报表确认-<报表导出>", notes = "也可以用在供应商portal网站里的报表下载")
	@RequestMapping(value="/downloadReport", method=RequestMethod.POST)
	public RestfulResult downloadReport(@ApiParam(value = "必填") @RequestBody String reportPath){
	    String  r =  pdfutil.getFullFilePath(reportPath);
	    if(StringUtils.isNotBlank(r)){
	    	return RestfulResultFactory.getInstance(200, r,  "成功获取");
	    }else{
	    	return RestfulResultFactory.getInstance(Status.ERROR, null,  "失败");
	    }
		
	}
	
	@ApiOperation(value = "结算管理-机构报表确认-<确认发票>", notes = "确认发票")
	@RequestMapping(value="/confirmReceipt", method=RequestMethod.POST)
	public RestfulResult confirmReceipt(@ApiParam(value = "必填") @RequestBody  List<Integer>  list){
	     try {
	    	 list.forEach(e->{ 	
	    		 ReportDataconfirm reportDataconfirm = new ReportDataconfirm();
	    		 reportDataconfirm.setId(e);
	    		 reportDataconfirm.setReceiptConfirmdate(DateUtils.getNowDate());//发布
	    		 reportDataconfirm.setReceiptConfirmed(1);
	    		 reportDataconfirmService.updateByPrimaryKeySelective(reportDataconfirm);
	    	 });
	 		   return RestfulResultFactory.getInstance(200, null,  "成功确认");
		         
		     } catch (Exception e) {
		       e.printStackTrace(); 
		       return RestfulResultFactory.getInstance(201, null,  "失败");
		     }
		
	}
	
	@ApiOperation(value = "结算管理-机构报表确认-<查看发票>", notes = "确认发票")
	@RequestMapping(value="/viewReceipt", method=RequestMethod.POST)
	public RestfulResult viewReceipt(@ApiParam(value = "必填") @RequestBody  String  receiptPath){
	    String  r =  pdfutil.getFullFilePath(receiptPath);
	    if(StringUtils.isNotBlank(r)){
	    	return RestfulResultFactory.getInstance(200, r,  "成功获取");
	    }else{
	    	return RestfulResultFactory.getInstance(Status.ERROR, null,  "失败");
	    }
		
	}
	
	
	@ApiOperation(value = "结算管理-机构报表确认-<付款>", notes = "付款完后点击")
	@RequestMapping(value="/confirmPaid", method=RequestMethod.POST)
	public RestfulResult confirmPaid(@ApiParam(value = "必填") @RequestBody  List<Integer>  list){
	     try {
	    	 list.forEach(e->{ 	
	    		 ReportDataconfirm reportDataconfirm = new ReportDataconfirm();
	    		 reportDataconfirm.setId(e);
	    		 reportDataconfirm.setPaidDate(DateUtils.getNowDate());//付款
	    		 reportDataconfirm.setIsPaid(1);
	    		 reportDataconfirmService.updateByPrimaryKeySelective(reportDataconfirm);
	    	 });
	 		   return RestfulResultFactory.getInstance(200, null,  "成功付款");
		         
		     } catch (Exception e) {
		       e.printStackTrace(); 
		       return RestfulResultFactory.getInstance(201, null,  "失败");
		     }
		
	}
 
	
 
}
