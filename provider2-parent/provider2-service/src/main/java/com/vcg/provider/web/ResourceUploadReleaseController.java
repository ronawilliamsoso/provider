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




import com.vcg.provider.model.ResourceUploadRelease;
import com.vcg.provider.model.query.ResourceUploadReleaseExample;
import com.vcg.provider.service.ResourceUploadReleaseService;

//@Api(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/resourceUploadRelease")
public class ResourceUploadReleaseController {

	@Autowired
	private ResourceUploadReleaseService resourceUploadReleaseService;
	
	//@ApiOperation(value = "pageList", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/pageList",method={RequestMethod.GET,RequestMethod.POST})
	public Object pageList(@RequestBody(required=false) ResourceUploadRelease resourceUploadRelease,@RequestParam(defaultValue="1") int pageNum,
			@RequestParam(defaultValue="10") int pageSize,HttpServletRequest request){
		
		ResourceUploadReleaseExample example=new ResourceUploadReleaseExample();
		
		//TODO ResourceUploadRelease 与 example关联
		
		
		PageHelper.startPage(pageNum, pageSize);
		List<ResourceUploadRelease> lst = this.resourceUploadReleaseService.selectByExample(example);
		return  new PageInfo<ResourceUploadRelease>(lst);
	}
	
	
	@RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST})
	public Object list(@RequestBody(required=false) ResourceUploadRelease resourceUploadRelease){
		
		ResourceUploadReleaseExample example=new ResourceUploadReleaseExample();
		//TODO ResourceUploadRelease 与 example关联
		
		
		List<ResourceUploadRelease> lst = this.resourceUploadReleaseService.selectByExample(example);
		return  lst;
	}
	
	//@ApiOperation(value = "添加用户", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Object create(@RequestBody ResourceUploadRelease resourceUploadRelease){
		
		return this.resourceUploadReleaseService.insertSelective(resourceUploadRelease);
		
	}
	//@ApiOperation(value = "update", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Object update(@RequestBody ResourceUploadRelease resourceUploadRelease){
		
		return this.resourceUploadReleaseService.updateByPrimaryKeySelective(resourceUploadRelease);
		
	}
	
	//@ApiOperation(value = "view", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public Object view(@RequestParam Integer id){
		
		return this.resourceUploadReleaseService.selectByPrimaryKey(id);
		
	}
	

	//@ApiOperation(value = "delete", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Object delete(@RequestBody Map<String,Integer> ids){
		
		return this.resourceUploadReleaseService.deleteByPrimaryKey(ids.get("id"));
		
	}
	
}
