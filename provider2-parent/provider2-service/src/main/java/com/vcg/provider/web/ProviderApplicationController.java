package com.vcg.provider.web;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.vcg.common.AbstractController;
import com.vcg.common.RestfulResult;
import com.vcg.common.RestfulResultFactory;
import com.vcg.common.ResultMap;
import com.vcg.common.Status;
import com.vcg.provider.entity.ProviderApplicationSearch;
import com.vcg.provider.entity.ProviderQualification;
import com.vcg.provider.model.ContactApplication;
import com.vcg.provider.model.ProviderApplication;
import com.vcg.provider.model.query.ContactApplicationExample;
import com.vcg.provider.service.ContactApplicationService;
import com.vcg.provider.service.ProviderApplicationService;
import com.vcg.provider.smallService.ApplicationService;
import com.vcg.provider.util.AccountUtil;
import com.vcg.provider.util.SearchUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/providerApplication")
@Api("供应商申请")
public class ProviderApplicationController extends AbstractController{
	public static Logger log = Logger.getLogger(ProviderApplicationController.class);
	@Autowired
	private ProviderApplicationService providerApplicationService;
	
	@Autowired
	private ContactApplicationService contactApplicationService;
	
	
	@Autowired
	private AccountUtil accountUtil;
	
	@Autowired
	private ApplicationService applicationService;

	
 
	
	
	/**
	 * 供稿人资格审核
	 * @param requestParam
	 * @param token
	 * @return
	 * @throws IOException
	 * @throws RestClientException
	 * @throws URISyntaxException
	 */
	@ApiOperation(value = "申请供稿人审核-资格审核-<通过><不通过>", notes = "申请供稿人审核页面的")
	@RequestMapping(value="/providerQualificationExamination",method=RequestMethod.POST)
	public RestfulResult providerQualificationExamination(@RequestBody ProviderQualification requestParam,
			@RequestParam String token) throws IOException, RestClientException, URISyntaxException{
		String userId = accountUtil.getUserId(token);
		 if(StringUtils.isBlank(userId)){
			 System.err.println("userId is null");
			 return new RestfulResult(Status.ERROR,null, "Token失效,请重新登录");
		 }
		int status = 1;
 
		if(requestParam.getPass() == 0){
			//no pass
			status = 4;//不通过
		}else if(requestParam.getPass() == 1){
			 
			status = 2;//待签合同
		}
		ProviderApplication providerApplication = this.providerApplicationService.selectByPrimaryKey(requestParam.getId());
		if(providerApplication == null){
			 return RestfulResultFactory.getInstance(Status.ERROR, null,  "没有待审核信息"); 
		}else{
			RestfulResult result  = null;
			/*审核通过*/
			if(requestParam.getPass() == 1 && requestParam.getAssetFamily() != null){
				int type = this.applicationService.checkWhichTypeByUserCenterId(providerApplication.getUserCenterId());
				if(requestParam.getAssetFamily() == type || type == 3){
					return RestfulResultFactory.getInstance(Status.ERROR, null,  "用户已是该类型的签约摄影师"); 
				}
				 result  =this.providerApplicationService.passApplication(providerApplication, requestParam, status, userId);
			}else{//审核不通过
				if(providerApplication.getStatus() == 3){
					return RestfulResultFactory.getInstance(Status.ERROR, null,  "资料已审核通过"); 
				}
				result = this.providerApplicationService.nopassApplication(providerApplication, requestParam, status, userId);
			}
			return result;
		}
	}
 



	
	/**
	 * 申请供稿人审核-资格审核-搜索
	 * @param requestParam
	 * @return
	 */

	@ApiOperation(value = "申请供稿人审核-资格审核-<查询>", notes = "{\"pageSize\":20, \"pageNum\":1,\"createTimeBegin\":\"today\",\"status\":3,\"passUserId\":20521}")
	@RequestMapping(value="/searchProviderApplicationInfo", method=RequestMethod.POST)
	public RestfulResult searchProviderApplicationInfo(@ApiParam(value = "必填ParamMap对象") @RequestBody ProviderApplicationSearch  requestParam,@RequestParam String token){
		 
		
	     try {
	    	 Map<String,Object> searchParam = SearchUtil.parseProviderApplicationParam(requestParam);
	 		PageInfo<ResultMap> result = this.queryService.queryPageForCustom("providerManage", "searchProviderApplicationInfo", searchParam);
	 		//临时注释
	 		List<ResultMap> contractApplications = result.getList();
	 		for(ResultMap rt:contractApplications){
	 			//加入通过人信息  可能本地会报错,但是test环境不报错
	 			int type = this.applicationService.checkWhichTypeByUserCenterId(rt.getValue("userCenterId"));
	 			rt.put("has_pass", type);
	 			if(StringUtils.isNotBlank(rt.getValue("passUserId"))){
	 				String username = accountUtil.getUserNameByPartyId(rt.getValue("passUserId").toString(), token);
	 				 
	 					rt.put("pass_user_name", username);
	 				 
	 			}
	 			
	 		}
//	 		result.setList(contractApplications);
	 		return RestfulResultFactory.getInstance(200, result,  "成功");
		         
		     } catch (Exception e) {
		       e.printStackTrace(); 
		       return RestfulResultFactory.getInstance(201, null,  "失败");
		     }
		
		
		
		
		 
		
	}
	
//	@ApiOperation(value = "申请供稿人审核页面的<审核人>数据", notes = "申请供稿人审核页面的<审核人>")
//	@RequestMapping(value="/getPassUsersList", method=RequestMethod.POST)
//	public RestfulResult getPassUsersList(@RequestParam String token){
//		ProviderApplicationExample pae = new ProviderApplicationExample();
//		pae.setColunms(Arrays.asList("pass_user_id"));
//		pae.setDistinct(true);
//		pae.createCriteria().andPassUserIdIsNotNull();
//		 try {
//				List<ProviderApplication> passusers =  providerApplicationService.selectByExample(pae);
//				//获取所有通过人的id
//				List<String> passids = passusers.stream().map(e->e.getPassUserId()+"").collect(Collectors.toList());
//				Boss_coreClient boss_coreClient = SpringUtils.getBean(com.vcg.boss.core.feignClient.Boss_coreClient.class);
//				List<Map<String,String>> reslut=new ArrayList<Map<String,String>>();
//				//临时注释
////				List<Person>  passlist =   passids.stream().map(e->boss_coreClient.getPersonByPartyId(e, token, "yes")).collect(Collectors.toList());
////				Map<String, String> map = new  HashMap<String, String>();
////				for(Person p :passlist){
////					map.put("passUserId",p.getPartyId());
////					map.put("passUserName",p.getName());
////					reslut.add(map);
////					map = new  HashMap<String, String>();
////				}
//				  
//		 
//				return RestfulResultFactory.getInstance(200, reslut,  "操作成功"); 
//		     } catch (Exception e) {
//		       e.printStackTrace(); 
//		       return RestfulResultFactory.getInstance(201, null,  "操作失败"); 
//		     }
//
//  
//	}
	
 
	
	/**
	 * 申请供稿人-合同审核-详细信息
	 * @param id 供稿人申请id
	 * @return
	 */
	@ApiOperation(value = "合同审核点击一行数据获取<供应商详情>", notes = "合同审核<点击一行数据获取供应商详情>")
	@RequestMapping(value="/getProviderMoreApplicationInfo",method=RequestMethod.GET)
	public RestfulResult getProviderMoreApplicationInfo(@ApiParam(value = "本行的合同id") @RequestParam Integer id){
		Map<String,Object> infoMap = super.getParams();
		ProviderApplication providerApp = this.providerApplicationService.selectByPrimaryKey(id);
		if(providerApp != null && providerApp.getUserCenterId() != null){
			infoMap.put("id", providerApp.getId());
			infoMap.put("account",providerApp.getAccount());
			infoMap.put("nameCn", providerApp.getNameCn());
			infoMap.put("assetFamily", providerApp.getAssetFamily());
			infoMap.put("jobType",providerApp.getJobType());
			infoMap.put("providerCompany", providerApp.getProviderCompany());
			infoMap.put("status", providerApp.getStatus());
			ContactApplicationExample exam = new ContactApplicationExample();
			exam.createCriteria()
					.andUserCenterIdEqualTo(providerApp.getUserCenterId());
			List<ContactApplication> contactApps = this.contactApplicationService
					.selectByExample(exam);
			if(CollectionUtils.isNotEmpty(contactApps)){
				ContactApplication contactApp = contactApps.get(0);
				infoMap.put("sex",contactApp.getSex());
				infoMap.put("moblie", contactApp.getMobile());
				infoMap.put("email", contactApp.getEmail());
			}
		}
		return new RestfulResult<Map<String,Object>>(200,infoMap,"操作成功");
	}
	
	@ApiOperation(value = "申请供稿人审核-资格审核-<备注>", notes = "申请供稿人审核页面的<备注>")
	@RequestMapping(value="/addProviderComment", method=RequestMethod.GET)
	public RestfulResult addProviderComment(@ApiParam(value = "申请Id")@RequestParam Integer id,@ApiParam(value = "备注内容")@RequestParam String comment){
		try {
			if(StringUtil.isNotEmpty(comment) && id != null){
				
				
				ProviderApplication providerApplication = new ProviderApplication();
				providerApplication.setId(id);
				providerApplication.setComment(comment);
				this.providerApplicationService.updateByPrimaryKeySelective(providerApplication);
			} 
			return new RestfulResult<Object>(200, null, "ok");
			 
		} catch (Exception e) {
			return new RestfulResult<Object>(Status.ERROR, null, "错误");
		}
	}
	
}
