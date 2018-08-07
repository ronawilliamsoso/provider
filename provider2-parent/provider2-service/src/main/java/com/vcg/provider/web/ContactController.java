package com.vcg.provider.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.vcg.provider.model.Contact;
import com.vcg.provider.model.query.ContactExample;
import com.vcg.provider.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value="/pageList",method={RequestMethod.GET,RequestMethod.POST})
	public Object pageList(@RequestBody(required=false) Contact contact,@RequestParam(defaultValue="1") int pageNum,
			@RequestParam(defaultValue="10") int pageSize,HttpServletRequest request){
		
		ContactExample example=new ContactExample();
		
		//TODO Contact 与 example关联
		
		
		PageHelper.startPage(pageNum, pageSize);
		List<Contact> lst = this.contactService.selectByExample(example);
		return  new PageInfo<Contact>(lst);
	}
	
	
	@RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST})
	public Object list(@RequestBody(required=false) Contact contact){
		
		ContactExample example=new ContactExample();
		//TODO Contact 与 example关联
		
		
		List<Contact> lst = this.contactService.selectByExample(example);
		return  lst;
	}
	
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Object create(@RequestBody Contact contact){
		
		return this.contactService.insertSelective(contact);
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Object update(@RequestBody Contact contact){
		
		return this.contactService.updateByPrimaryKeySelective(contact);
		
	}
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public Object view(@RequestParam Integer id){
		
		return this.contactService.selectByPrimaryKey(id);
		
	}
	

	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Object delete(@RequestBody Map<String,Integer> ids){
		
		return this.contactService.deleteByPrimaryKey(ids.get("id"));
		
	}
	
}
