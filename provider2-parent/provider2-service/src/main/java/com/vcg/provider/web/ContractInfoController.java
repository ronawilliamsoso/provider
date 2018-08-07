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
import com.vcg.provider.model.ContractInfo;
import com.vcg.provider.model.query.ContractInfoExample;
import com.vcg.provider.service.ContractInfoService;

@RestController
@RequestMapping("/contractInfo")
public class ContractInfoController {

	@Autowired
	private ContractInfoService contractInfoService;
	
	@RequestMapping(value="/pageList",method={RequestMethod.GET,RequestMethod.POST})
	public Object pageList(@RequestBody(required=false) ContractInfo contractInfo,@RequestParam(defaultValue="1") int pageNum,
			@RequestParam(defaultValue="10") int pageSize,HttpServletRequest request){
		
		ContractInfoExample example=new ContractInfoExample();
		
		//TODO ContractInfo 与 example关联
		
		
		PageHelper.startPage(pageNum, pageSize);
		List<ContractInfo> lst = this.contractInfoService.selectByExample(example);
		return  new PageInfo<ContractInfo>(lst);
	}
	
	
	@RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST})
	public Object list(@RequestBody(required=false) ContractInfo contractInfo){
		
		ContractInfoExample example=new ContractInfoExample();
		//TODO ContractInfo 与 example关联
		
		
		List<ContractInfo> lst = this.contractInfoService.selectByExample(example);
		return  lst;
	}
	
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Object create(@RequestBody ContractInfo contractInfo){
		
		return this.contractInfoService.insertSelective(contractInfo);
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Object update(@RequestBody ContractInfo contractInfo){
		
		return this.contractInfoService.updateByPrimaryKeySelective(contractInfo);
		
	}
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public Object view(@RequestParam Integer id){
		
		return this.contractInfoService.selectByPrimaryKey(id);
		
	}
	

	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Object delete(@RequestBody Map<String,Integer> ids){
		
		return this.contractInfoService.deleteByPrimaryKey(ids.get("id"));
		
	}
	
}
