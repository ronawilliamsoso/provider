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




import com.vcg.provider.model.ResourceUploadMeta;
import com.vcg.provider.model.query.ResourceUploadMetaExample;
import com.vcg.provider.service.ResourceUploadMetaService;

//@Api(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/resourceUploadMeta")
public class ResourceUploadMetaController {

	@Autowired
	private ResourceUploadMetaService resourceUploadMetaService;
	
	//@ApiOperation(value = "pageList", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/pageList",method={RequestMethod.GET,RequestMethod.POST})
	public Object pageList(@RequestBody(required=false) ResourceUploadMeta resourceUploadMeta,@RequestParam(defaultValue="1") int pageNum,
			@RequestParam(defaultValue="10") int pageSize,HttpServletRequest request){
		
		ResourceUploadMetaExample example=new ResourceUploadMetaExample();
		
		//TODO ResourceUploadMeta 与 example关联
		
		
		PageHelper.startPage(pageNum, pageSize);
		List<ResourceUploadMeta> lst = this.resourceUploadMetaService.selectByExample(example);
		return  new PageInfo<ResourceUploadMeta>(lst);
	}
	
	
	@RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST})
	public Object list(@RequestBody(required=false) ResourceUploadMeta resourceUploadMeta){
		
		ResourceUploadMetaExample example=new ResourceUploadMetaExample();
		//TODO ResourceUploadMeta 与 example关联
		
		
		List<ResourceUploadMeta> lst = this.resourceUploadMetaService.selectByExample(example);
		return  lst;
	}
	
	//@ApiOperation(value = "添加用户", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Object create(@RequestBody ResourceUploadMeta resourceUploadMeta){
		
		return this.resourceUploadMetaService.insertSelective(resourceUploadMeta);
		
	}
	//@ApiOperation(value = "update", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Object update(@RequestBody ResourceUploadMeta resourceUploadMeta){
		
		return this.resourceUploadMetaService.updateByPrimaryKeySelective(resourceUploadMeta);
		
	}
	
	//@ApiOperation(value = "view", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public Object view(@RequestParam Integer id){
		
		return this.resourceUploadMetaService.selectByPrimaryKey(id);
		
	}
	

	//@ApiOperation(value = "delete", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Object delete(@RequestBody Map<String,Integer> ids){
		
		return this.resourceUploadMetaService.deleteByPrimaryKey(ids.get("id"));
		
	}
	
}
