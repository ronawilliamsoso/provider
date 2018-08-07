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

import com.vcg.provider.model.Collection;
import com.vcg.provider.model.query.CollectionExample;
import com.vcg.provider.service.CollectionService;

@RestController
@RequestMapping("/collection")
public class CollectionController {

	@Autowired
	private CollectionService collectionService;
	
	@RequestMapping(value="/pageList",method={RequestMethod.GET,RequestMethod.POST})
	public Object pageList(@RequestBody(required=false) Collection collection,@RequestParam(defaultValue="1") int pageNum,
			@RequestParam(defaultValue="10") int pageSize,HttpServletRequest request){
		
		CollectionExample example=new CollectionExample();
		
		//TODO Collection 与 example关联
		
		
		PageHelper.startPage(pageNum, pageSize);
		List<Collection> lst = this.collectionService.selectByExample(example);
		return  new PageInfo<Collection>(lst);
	}
	
	
	@RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST})
	public Object list(@RequestBody(required=false) Collection collection){
		
		CollectionExample example=new CollectionExample();
		//TODO Collection 与 example关联
		
		
		List<Collection> lst = this.collectionService.selectByExample(example);
		return  lst;
	}
	
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Object create(@RequestBody Collection collection){
		
		return this.collectionService.insertSelective(collection);
		
	}
	
//	@RequestMapping(value="/update",method=RequestMethod.POST)
//	public Object update(@RequestBody Collection collection){
//		
//		return this.collectionService.updateByPrimaryKeySelective(collection);
//		
//	}
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public Object view(@RequestParam Integer id){
		
		return this.collectionService.selectByPrimaryKey(id);
		
	}
	

	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Object delete(@RequestBody Map<String,Integer> ids){
		
		return this.collectionService.deleteByPrimaryKey(ids.get("id"));
		
	}
	
}
