package com.vcg.provider.web;
 
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.vcg.common.AbstractController;
import com.vcg.common.RestfulResult;
import com.vcg.common.Status;
import com.vcg.provider.util.AccountUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/provider")
@Api("供应商信息")
public class TestInterfaces extends AbstractController{
	
	public static Logger log = Logger.getLogger(TestInterfaces.class);

 
 
	@Autowired
	private AccountUtil accountUtil;
 
	
	@Value("${mepx.notifyservice}")
	private String notifyservice;
	
 
	@ApiOperation(value = "根据token从boss获取用户信息", notes = "根据token从boss获取用户信息")
	@RequestMapping(value="/getUserInfoFromBoss",method=RequestMethod.POST)
	public Object getUserInfoFromBoss(@ApiParam(required = true)@RequestParam String token){
		RestfulResult result=null;
		String userId = accountUtil.getUserId(token);
		if(StringUtils.isNotBlank(userId)){
			 result = new RestfulResult(200,userId, "pass");
		}else{
			 result = new RestfulResult(Status.ERROR,null, "nopass");
		}
 
		return result;
	}
	
	
	
	 
	
}
