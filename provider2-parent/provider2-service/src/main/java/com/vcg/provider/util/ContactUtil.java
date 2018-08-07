package com.vcg.provider.util;

 
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vcg.provider.model.Contact;
import com.vcg.provider.model.ContactApplication;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.query.ContactApplicationExample;
import com.vcg.provider.model.query.ContactExample;
import com.vcg.provider.model.query.ProviderExample;
import com.vcg.provider.service.ContactApplicationService;
import com.vcg.provider.service.ContactService;
import com.vcg.provider.service.ProviderService;
 

 


@Component
public class ContactUtil {
	
	@Autowired
	private ContactApplicationService contactApplicationService;
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private ContactService contactService;
	
	
 
	
 
	//申请阶段获取用户的手机号和邮箱
	public List<String> getMobileAndEmailForNoticeInApplication(String userCenterId){

		List<String> ret = new ArrayList<String>();
		 
		String  mobile="";
		String email="";
		ContactApplicationExample  contactaexample = new ContactApplicationExample();
		contactaexample.createCriteria().andUserCenterIdEqualTo(userCenterId);
		List<ContactApplication> contactlist =  contactApplicationService.selectByExample(contactaexample);
		if(contactlist.size()>0){
			ContactApplication contactApplication = contactlist.get(0);
			mobile = contactApplication.getMobile();
			email = contactApplication.getEmail();
		}
		
		//有可能这个人已经是是正式用户,并且已经修改过他的联系人信息,即在contact表里的信息,那么通知发到新的联系方式上;
		ProviderExample  providerexample = new ProviderExample();
		providerexample.createCriteria().andUserCenterIdEqualTo(userCenterId);
		List<Provider> providerlist =  providerService.selectByExample(providerexample);
		if(providerlist.size()>0){
			Provider provider = providerlist.get(0);
			ContactExample  contactexample = new ContactExample();
			contactexample.createCriteria().andProviderIdEqualTo(provider.getId());
			List<Contact> contactlst =  contactService.selectByExample(contactexample);
			if(contactlst.size()>0){
				if(StringUtils.isNotBlank(contactlst.get(0).getMobile()) ){
					mobile = contactlst.get(0).getMobile();
				}
				if(StringUtils.isNotBlank(contactlst.get(0).getEmail()) ){
					email = contactlst.get(0).getEmail();
				}
			}
		}
		ret.add(mobile);
		ret.add(email);
		return ret;
		}
 
	 
	
  
     
     
    public static void main(String[] args) throws Exception{
    	ContactUtil messageUtil = new ContactUtil();
    	
    	try {
			List<String> list=  messageUtil.getMobileAndEmailForNoticeInApplication("218b60cb04ba3a03942c7f4c316177180");
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    }
	
	
	
  
}
