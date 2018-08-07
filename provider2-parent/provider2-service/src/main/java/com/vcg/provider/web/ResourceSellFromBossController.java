package com.vcg.provider.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;




import com.vcg.provider.model.ResourceSellFromBoss;
import com.vcg.provider.model.query.ResourceSellFromBossExample;
import com.vcg.provider.service.ResourceSellFromBossService;

//@Api(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/resourceSellFromBoss")
public class ResourceSellFromBossController {

	@Autowired
	private ResourceSellFromBossService resourceSellFromBossService;
	
	//@ApiOperation(value = "pageList", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/pageList",method={RequestMethod.GET,RequestMethod.POST})
	public Object pageList(@RequestBody(required=false) ResourceSellFromBoss resourceSellFromBoss,@RequestParam(defaultValue="1") int pageNum,
			@RequestParam(defaultValue="10") int pageSize,HttpServletRequest request){
		
		ResourceSellFromBossExample example=new ResourceSellFromBossExample();
		
		//TODO ResourceSellFromBoss 与 example关联
		
		
		PageHelper.startPage(pageNum, pageSize);
		List<ResourceSellFromBoss> lst = this.resourceSellFromBossService.selectByExample(example);
		return  new PageInfo<ResourceSellFromBoss>(lst);
	}
	
	
	@RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST})
	public Object list(@RequestBody(required=false) ResourceSellFromBoss resourceSellFromBoss){
		
		ResourceSellFromBossExample example=new ResourceSellFromBossExample();
		//TODO ResourceSellFromBoss 与 example关联
		
		
		List<ResourceSellFromBoss> lst = this.resourceSellFromBossService.selectByExample(example);
		return  lst;
	}
	
	//@ApiOperation(value = "添加用户", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Object create(@RequestBody ResourceSellFromBoss resourceSellFromBoss){
		
		return this.resourceSellFromBossService.insertSelective(resourceSellFromBoss);
		
	}
	//@ApiOperation(value = "update", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Object update(@RequestBody ResourceSellFromBoss resourceSellFromBoss){
		
		return this.resourceSellFromBossService.updateByPrimaryKeySelective(resourceSellFromBoss);
		
	}
	
	//@ApiOperation(value = "view", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public Object view(@RequestParam String id){
		
		return this.resourceSellFromBossService.selectByPrimaryKey(id);
		
	}
	

	//@ApiOperation(value = "delete", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Object delete(@RequestBody Map<String,String> ids){
		
		return this.resourceSellFromBossService.deleteByPrimaryKey(ids.get("id"));
		
	}
	
}
