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




import com.vcg.provider.model.ProviderPortalaccounts;
import com.vcg.provider.model.query.ProviderPortalaccountsExample;
import com.vcg.provider.service.ProviderPortalaccountsService;

//@Api(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/providerPortalaccounts")
public class ProviderPortalaccountsController {

	@Autowired
	private ProviderPortalaccountsService providerPortalaccountsService;
	
	//@ApiOperation(value = "pageList", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/pageList",method={RequestMethod.GET,RequestMethod.POST})
	public Object pageList(@RequestBody(required=false) ProviderPortalaccounts providerPortalaccounts,@RequestParam(defaultValue="1") int pageNum,
			@RequestParam(defaultValue="10") int pageSize,HttpServletRequest request){
		
		ProviderPortalaccountsExample example=new ProviderPortalaccountsExample();
		
		//TODO ProviderPortalaccounts 与 example关联
		
		
		PageHelper.startPage(pageNum, pageSize);
		List<ProviderPortalaccounts> lst = this.providerPortalaccountsService.selectByExample(example);
		return  new PageInfo<ProviderPortalaccounts>(lst);
	}
	
	
	@RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST})
	public Object list(@RequestBody(required=false) ProviderPortalaccounts providerPortalaccounts){
		
		ProviderPortalaccountsExample example=new ProviderPortalaccountsExample();
		//TODO ProviderPortalaccounts 与 example关联
		
		
		List<ProviderPortalaccounts> lst = this.providerPortalaccountsService.selectByExample(example);
		return  lst;
	}
	
	//@ApiOperation(value = "添加用户", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Object create(@RequestBody ProviderPortalaccounts providerPortalaccounts){
		
		return this.providerPortalaccountsService.insertSelective(providerPortalaccounts);
		
	}
	//@ApiOperation(value = "update", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Object update(@RequestBody ProviderPortalaccounts providerPortalaccounts){
		
		return this.providerPortalaccountsService.updateByPrimaryKeySelective(providerPortalaccounts);
		
	}
	
	//@ApiOperation(value = "view", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public Object view(@RequestParam Integer id){
		
		return this.providerPortalaccountsService.selectByPrimaryKey(id);
		
	}
	

	//@ApiOperation(value = "delete", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Object delete(@RequestBody Map<String,Integer> ids){
		
		return this.providerPortalaccountsService.deleteByPrimaryKey(ids.get("id"));
		
	}
	
}
