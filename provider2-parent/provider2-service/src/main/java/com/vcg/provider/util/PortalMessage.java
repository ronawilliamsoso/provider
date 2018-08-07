package com.vcg.provider.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vcg.boss.user.model.UInterUser;
import com.vcg.common.DateUtils;
import com.vcg.provider.model.ProviderMessage;
import com.vcg.provider.service.ProviderMessageService;
import com.vcg.boss.feignClient.Boss_accountbaseClient;


@Component
public class PortalMessage {
 
	
	@Autowired
	private ProviderMessageService providerMessageService;
	
	public void createMessge(String title,String content,Integer providerId) {
  
		ProviderMessage message = new ProviderMessage();
		message.setMessageTitle(title);
		message.setMessgeContent(content);
		message.setProviderId(providerId);
		message.setCreatedTime(DateUtils.getNowDate());
		
		providerMessageService.insertSelective(message);
	}
	
 
 


  
}
