package com.vcg.provider.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.Contact;
import com.vcg.provider.model.query.ContactExample;
import com.vcg.provider.dao.ContactDao;
import com.vcg.provider.service.ContactService;

@Service
public class ContactServiceImpl extends BaseServiceImpl<Contact,ContactExample,Integer> implements ContactService {

	@Autowired
	private ContactDao contactDao;

	@Override
	public void setDao() {
		this.baseDao = contactDao;
	}

	@Override
	public Contact getContactByProviderId(Integer providerId) {
		if(providerId != null){
			ContactExample example = new ContactExample();
			example.createCriteria().andProviderIdEqualTo(providerId);
			List<Contact> contacts = this.contactDao.selectByExample(example);
			if(CollectionUtils.isNotEmpty(contacts)){
				return contacts.get(0);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

}