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




import com.vcg.provider.model.ContractAuthorization;
import com.vcg.provider.model.query.ContractAuthorizationExample;
import com.vcg.provider.service.ContractAuthorizationService;

//@Api(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/contractAuthorization")
public class ContractAuthorizationController {

	@Autowired
	private ContractAuthorizationService contractAuthorizationService;
	
	//@ApiOperation(value = "pageList", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/pageList",method={RequestMethod.GET,RequestMethod.POST})
	public Object pageList(@RequestBody(required=false) ContractAuthorization contractAuthorization,@RequestParam(defaultValue="1") int pageNum,
			@RequestParam(defaultValue="10") int pageSize,HttpServletRequest request){
		
		ContractAuthorizationExample example=new ContractAuthorizationExample();
		
		//TODO ContractAuthorization 与 example关联
		
		
		PageHelper.startPage(pageNum, pageSize);
		List<ContractAuthorization> lst = this.contractAuthorizationService.selectByExample(example);
		return  new PageInfo<ContractAuthorization>(lst);
	}
	
	
	@RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST})
	public Object list(@RequestBody(required=false) ContractAuthorization contractAuthorization){
		
		ContractAuthorizationExample example=new ContractAuthorizationExample();
		//TODO ContractAuthorization 与 example关联
		
		
		List<ContractAuthorization> lst = this.contractAuthorizationService.selectByExample(example);
		return  lst;
	}
	
	//@ApiOperation(value = "添加用户", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Object create(@RequestBody ContractAuthorization contractAuthorization){
		
		return this.contractAuthorizationService.insertSelective(contractAuthorization);
		
	}
	//@ApiOperation(value = "update", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Object update(@RequestBody ContractAuthorization contractAuthorization){
		
		return this.contractAuthorizationService.updateByPrimaryKeySelective(contractAuthorization);
		
	}
	
	//@ApiOperation(value = "view", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public Object view(@RequestParam Integer id){
		
		return this.contractAuthorizationService.selectByPrimaryKey(id);
		
	}
	

	//@ApiOperation(value = "delete", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Object delete(@RequestBody Map<String,Integer> ids){
		
		return this.contractAuthorizationService.deleteByPrimaryKey(ids.get("id"));
		
	}
	
}
