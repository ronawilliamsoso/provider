package com.vcg.provider.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vcg.boss.user.model.UInterUser;
import com.vcg.boss.feignClient.Boss_accountbaseClient;


@Component
public class AccountUtil {
	
	@Autowired
	private Boss_accountbaseClient boss_accountbaseClient;
	

	public   String getUserId(String token) {
		 String userId =null;
	        try {
	        	UInterUser person = boss_accountbaseClient.getUInterUserByUcToken(token);
//	        	{
//	        		  "address": "",
//	        		  "areaExpertise": "",
//	        		  "cfpStaffId": "147428",
//	        		  "contactMSN": "",
//	        		  "contactQQ": "",
//	        		  "databaseFlag": "Y",
//	        		  "department": "10021",
//	        		  "education": "",
//	        		  "email": "rui.liu@visualchina.com",
//	        		  "enabled": "1",
//	        		  "gender": "1",
//	        		  "homephone": "",
//	        		  "jobTitle": "",
//	        		  "language": "",
//	        		  "lastLocale": "zh",
//	        		  "level": "member",
//	        		  "maritalStatus": "1",
//	        		  "mobile": "",
//	        		  "name": "刘锐",
//	        		  "office": "BJ",
//	        		  "partyId": "200085",
//	        		  "personGroup": "",
//	        		  "personUnit": "",
//	        		  "personalFax": "",
//	        		  "personalTitle": "",
//	        		  "phone": "",
//	        		  "successiveFailedLogins": 0,
//	        		  "totalYearsWorkExperience": 0,
//	        		  "ucId": "boss200085",
//	        		  "updatedTime": 1479460921000
//	        		}
				if(person!=null){
					userId = person.getPartyId();//公司内部用户用PartyId
				} 
			} catch (Exception e) {
				// TODO: handle exception
			}
	        return userId;
	    
	}
	
	public   UInterUser getUserCenterAccount(String token) {
		UInterUser person  =null;
	        try {
	        	person = boss_accountbaseClient.getUInterUserByUcToken(token);
//	        	{
//	        		  "address": "",
//	        		  "areaExpertise": "",
//	        		  "cfpStaffId": "147428",
//	        		  "contactMSN": "",
//	        		  "contactQQ": "",
//	        		  "databaseFlag": "Y",
//	        		  "department": "10021",
//	        		  "education": "",
//	        		  "email": "rui.liu@visualchina.com",
//	        		  "enabled": "1",
//	        		  "gender": "1",
//	        		  "homephone": "",
//	        		  "jobTitle": "",
//	        		  "language": "",
//	        		  "lastLocale": "zh",
//	        		  "level": "member",
//	        		  "maritalStatus": "1",
//	        		  "mobile": "",
//	        		  "name": "刘锐",
//	        		  "office": "BJ",
//	        		  "partyId": "200085",
//	        		  "personGroup": "",
//	        		  "personUnit": "",
//	        		  "personalFax": "",
//	        		  "personalTitle": "",
//	        		  "phone": "",
//	        		  "successiveFailedLogins": 0,
//	        		  "totalYearsWorkExperience": 0,
//	        		  "ucId": "boss200085",
//	        		  "updatedTime": 1479460921000
//	        		}
 
			} catch (Exception e) {
				// TODO: handle exception
				 return person;
			}
	        return person;
	    
	}
 
	
	public   String getUserNameByPartyId(String id,String token) {
		 String userName =null;
	        try {
	        	UInterUser person = boss_accountbaseClient.getUInterUserByPartyId(id, token);
				if(person!=null){
					userName = person.getName();
				} 
				return userName;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return userName;
			}
	        
	    
	}
	
	
	
 
 


  
}
