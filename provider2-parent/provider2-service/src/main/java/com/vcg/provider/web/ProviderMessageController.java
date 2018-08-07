package com.vcg.provider.web;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vcg.common.DateUtils;
import com.vcg.common.RestfulResult;
import com.vcg.common.Status;
import com.vcg.provider.model.ProviderMessage;
import com.vcg.provider.model.query.ProviderMessageExample;
import com.vcg.provider.service.ProviderMessageService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

//@Api(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/providerMessage")
public class ProviderMessageController {

	@Autowired
	private ProviderMessageService providerMessageService;
	
//	//@ApiOperation(value = "pageList", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(value="/pageList",method={RequestMethod.GET,RequestMethod.POST})
//	public Object pageList(@RequestBody(required=false) ProviderMessage providerMessage,@RequestParam(defaultValue="1") int pageNum,
//			@RequestParam(defaultValue="10") int pageSize,HttpServletRequest request){
//		
//		ProviderMessageExample example=new ProviderMessageExample();
//		
//		//TODO ProviderMessage 与 example关联
//		
//		
//		PageHelper.startPage(pageNum, pageSize);
//		List<ProviderMessage> lst = this.providerMessageService.selectByExample(example);
//		return  new PageInfo<ProviderMessage>(lst);
//	}
	
	
	@ApiOperation(value = "portal-<我的消息>", notes = "portal-<我的消息>")
	@RequestMapping(value="/list",method={RequestMethod.POST})
	public Object list(@ApiParam(value = "本供应商id") @RequestParam Integer providerId){
		if(providerId==null){
			return new RestfulResult(Status.ERROR,null,"供应商id为空");
		}
		ProviderMessageExample example=new ProviderMessageExample();
		example.createCriteria().andProviderIdEqualTo(providerId);
 
		List<ProviderMessage> lst = this.providerMessageService.selectByExample(example);
		
		return new RestfulResult(200,lst,"ok");
	}
	
	@ApiOperation(value = "portal-我的消息-<阅读消息>", notes = "portal-我的消息-<阅读消息> 其实就是修改阅读状态")
	@RequestMapping(value="/readMessages",method={RequestMethod.POST})
	public Object readMessages(@ApiParam(value = "所有消息的主键id的字符串,英文逗号分隔",required = true) @RequestParam String ids){
		if(StringUtils.isBlank(ids)){
			return new RestfulResult(200,null,"ok");
		}else{
			try {
				List<String> str=  Arrays.asList(ids.split(","));
				List<Integer> intlist = str.stream().map(e->Integer.parseInt(e)).collect(Collectors.toList());
				ProviderMessageExample example=new ProviderMessageExample();
				example.createCriteria().andIdIn(intlist);
				ProviderMessage messages = new ProviderMessage();
				messages.setUpdatedTime(DateUtils.getNowDate());
				messages.setIsRead(1);
				this.providerMessageService.updateByExampleSelective(messages,example);
				return new RestfulResult(200,null,"ok");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
				return new RestfulResult(Status.ERROR,null,fullStackTrace);
			}
		}	
	}
	
	@ApiOperation(value = "portal-我的消息上的红点,1为需要显示红点,0为不给红点", notes = "portal-我的消息上的红点,1为红点,0为不给红点")
	@RequestMapping(value="/showRedDot",method={RequestMethod.POST})
	public Object showRedDot(@ApiParam(value = "此供应商的providerId",required = true) @RequestParam Integer providerId){
 
			try {
				ProviderMessageExample example=new ProviderMessageExample();
				example.createCriteria().andProviderIdEqualTo(providerId).andIsReadEqualTo(0);
				
				Integer cnt = this.providerMessageService.countByExample(example);
				if(cnt>0){//有没有阅读的信息,返回1,需要显示红点
					return new RestfulResult(200,1,"ok");
				}else{
					return new RestfulResult(200,0,"ok");
				}
 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
				return new RestfulResult(Status.ERROR,null,fullStackTrace);
			}
		 
	}
	
//	//@ApiOperation(value = "添加用户", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(value="/create",method=RequestMethod.POST)
//	public Object create(@RequestBody ProviderMessage providerMessage){
//		
//		return this.providerMessageService.insertSelective(providerMessage);
//		
//	}
//	//@ApiOperation(value = "update", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(value="/update",method=RequestMethod.POST)
//	public Object update(@RequestBody ProviderMessage providerMessage){
//		
//		return this.providerMessageService.updateByPrimaryKeySelective(providerMessage);
//		
//	}
//	
//	//@ApiOperation(value = "view", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(value="/view",method=RequestMethod.GET)
//	public Object view(@RequestParam Integer id){
//		
//		return this.providerMessageService.selectByPrimaryKey(id);
//		
//	}
	

	@ApiOperation(value = "portal-我的消息-<删除消息>", notes = "portal-我的消息-<删除消息>")
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Object delete(@ApiParam(value = "消息的主键id",required = true) Integer id){
		
		 Integer i  = this.providerMessageService.deleteByPrimaryKey(id);
		 
		 return new RestfulResult(200,i,"成功删除");
		
	}
	
}
