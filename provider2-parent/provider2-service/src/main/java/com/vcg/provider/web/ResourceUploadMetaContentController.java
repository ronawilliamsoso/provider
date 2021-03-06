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




import com.vcg.provider.model.ResourceUploadMetaContent;
import com.vcg.provider.model.query.ResourceUploadMetaContentExample;
import com.vcg.provider.service.ResourceUploadMetaContentService;

//@Api(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/resourceUploadMetaContent")
public class ResourceUploadMetaContentController {

	@Autowired
	private ResourceUploadMetaContentService resourceUploadMetaContentService;
	
	//@ApiOperation(value = "pageList", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/pageList",method={RequestMethod.GET,RequestMethod.POST})
	public Object pageList(@RequestBody(required=false) ResourceUploadMetaContent resourceUploadMetaContent,@RequestParam(defaultValue="1") int pageNum,
			@RequestParam(defaultValue="10") int pageSize,HttpServletRequest request){
		
		ResourceUploadMetaContentExample example=new ResourceUploadMetaContentExample();
		
		//TODO ResourceUploadMetaContent 与 example关联
		
		
		PageHelper.startPage(pageNum, pageSize);
		List<ResourceUploadMetaContent> lst = this.resourceUploadMetaContentService.selectByExample(example);
		return  new PageInfo<ResourceUploadMetaContent>(lst);
	}
	
	
	@RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST})
	public Object list(@RequestBody(required=false) ResourceUploadMetaContent resourceUploadMetaContent){
		
		ResourceUploadMetaContentExample example=new ResourceUploadMetaContentExample();
		//TODO ResourceUploadMetaContent 与 example关联
		
		
		List<ResourceUploadMetaContent> lst = this.resourceUploadMetaContentService.selectByExample(example);
		return  lst;
	}
	
	//@ApiOperation(value = "添加用户", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Object create(@RequestBody ResourceUploadMetaContent resourceUploadMetaContent){
		
		return this.resourceUploadMetaContentService.insertSelective(resourceUploadMetaContent);
		
	}
	//@ApiOperation(value = "update", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Object update(@RequestBody ResourceUploadMetaContent resourceUploadMetaContent){
		
		return this.resourceUploadMetaContentService.updateByPrimaryKeySelective(resourceUploadMetaContent);
		
	}
	
	//@ApiOperation(value = "view", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public Object view(@RequestParam Integer id){
		
		return this.resourceUploadMetaContentService.selectByPrimaryKey(id);
		
	}
	

	//@ApiOperation(value = "delete", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Object delete(@RequestBody Map<String,Integer> ids){
		
		return this.resourceUploadMetaContentService.deleteByPrimaryKey(ids.get("id"));
		
	}
	
}
