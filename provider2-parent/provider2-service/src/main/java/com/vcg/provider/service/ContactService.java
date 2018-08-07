package com.vcg.provider.service ;

import com.vcg.common.base.BaseService;
import com.vcg.provider.model.Contact;
import com.vcg.provider.model.query.ContactExample;

public interface ContactService extends BaseService<Contact,ContactExample,Integer>{
	/**
	 * Get Contact By providerId
	 * @param providerId
	 * @return if providerId is null or contact does not exist,return null
	 */
	public Contact getContactByProviderId(Integer providerId);
}