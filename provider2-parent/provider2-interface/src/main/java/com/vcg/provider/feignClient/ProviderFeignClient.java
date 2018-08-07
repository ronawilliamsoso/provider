package com.vcg.provider.feignClient;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vcg.provider.model.GerenRegister;
import com.vcg.provider.model.ProviderRegister;
import com.vcg.provider.model.UpdateOldInfo;
import com.vcg.provider.model.UploadContract;

 
@FeignClient("providerservice-vcg-com")
public interface ProviderFeignClient {

	
	
	@RequestMapping(value="/providerme/providerRegister",method=RequestMethod.POST,consumes = "application/json")
	public Object providerRegister(@RequestBody GerenRegister gerenRegister);
	
	@RequestMapping(value="/providerme/oauth2/token",method=RequestMethod.GET,consumes = "application/json")
	public Object getAccessToken(@RequestParam(value="client_id",required = true) String client_id,@RequestParam(value="client_secret",required = true) String client_secret);
	
	@RequestMapping(value="/providerme/uploadContract",method=RequestMethod.POST,consumes = "application/json")
	public Object uploadContract(@RequestBody UploadContract uploadContract);
	
	@RequestMapping(value="/providerme/getProviderContractPDFs",method=RequestMethod.GET,consumes = "application/json")
	public Object getProviderContractPDFs(@RequestParam(value="userCenterId",required = true) String userCenterId);
	
	@RequestMapping(value="/providerme/getApplicationFromRedis",method=RequestMethod.GET,consumes = "application/json")
	public Object getApplicationFromRedis(@RequestParam(value="userId",required = true) String userId);
	
	@RequestMapping(value="/providerme/deleteApplicationFromRedis",method=RequestMethod.GET,consumes = "application/json")
	public Object deleteApplicationFromRedis(@RequestParam(value="userId",required = true) String userId);
	
	@RequestMapping(value="/providerme/getProviderOldInfo",method=RequestMethod.GET,consumes = "application/json")
	public Object getProviderOldInfo(@RequestParam(value="userCenterId",required = true) String userCenterId);
	
	@RequestMapping(value="/providerme/updateProviderOldInfo",method=RequestMethod.POST,consumes = "application/json")
	public Object updateProviderOldInfo(@RequestBody UpdateOldInfo updateOldInfo);
	
	@RequestMapping(value="/providerme/findProviderAuditStatus",method=RequestMethod.GET,consumes = "application/json")
	public Object findProviderAuditStatus(@RequestParam(value="userCenterId",required = true) String userCenterId);
	
	@RequestMapping(value="/providerme/providerUpdate",method=RequestMethod.POST,consumes = "application/json")
	public Object providerUpdate(@RequestBody ProviderRegister providerRegister);
	
	@RequestMapping(value="/providerme/getRoyaltiesByMonth",method=RequestMethod.GET,consumes = "application/json")
	public Object getRoyaltiesByMonth(
			@RequestParam(value="providerId",required=true) Integer providerId,
			@RequestParam(value="searchType",required=true) Integer searchType,
			@RequestParam(value="beginMonth",required=true) String beginMonth,
			@RequestParam(value="endMonth",required=true) String endMonth,
			@RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
			@RequestParam(value="pageSize",defaultValue="10") Integer pageSize);
	
	
	@RequestMapping(value="/providerme/getProviderByUserCenterId",method=RequestMethod.GET,consumes = "application/json")
	public Object getProviderByUserCenterId(@RequestParam(value="userCenterId",required = true) String userCenterId);
	
	
	 

}
