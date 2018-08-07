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

import com.vcg.provider.model.ContactApplication;
import com.vcg.provider.model.query.ContactApplicationExample;
import com.vcg.provider.service.ContactApplicationService;

@RestController
@RequestMapping("/contactApplication")
public class ContactApplicationController {

	@Autowired
	private ContactApplicationService contactApplicationService;
	
	@RequestMapping(value="/pageList",method={RequestMethod.GET,RequestMethod.POST})
	public Object pageList(@RequestBody(required=false) ContactApplication contactApplication,@RequestParam(defaultValue="1") int pageNum,
			@RequestParam(defaultValue="10") int pageSize,HttpServletRequest request){
		
		ContactApplicationExample example=new ContactApplicationExample();
		
		//TODO ContactApplication 与 example关联
		
		
		PageHelper.startPage(pageNum, pageSize);
		List<ContactApplication> lst = this.contactApplicationService.selectByExample(example);
		return  new PageInfo<ContactApplication>(lst);
	}
	
	
	@RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST})
	public Object list(@RequestBody(required=false) ContactApplication contactApplication){
		
		ContactApplicationExample example=new ContactApplicationExample();
		//TODO ContactApplication 与 example关联
		
		
		List<ContactApplication> lst = this.contactApplicationService.selectByExample(example);
		return  lst;
	}
	
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Object create(@RequestBody ContactApplication contactApplication){
		
		return this.contactApplicationService.insertSelective(contactApplication);
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Object update(@RequestBody ContactApplication contactApplication){
		
		return this.contactApplicationService.updateByPrimaryKeySelective(contactApplication);
		
	}
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public Object view(@RequestParam Integer id){
		
		return this.contactApplicationService.selectByPrimaryKey(id);
		
	}
	

	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Object delete(@RequestBody Map<String,Integer> ids){
		
		return this.contactApplicationService.deleteByPrimaryKey(ids.get("id"));
		
	}
	
}
