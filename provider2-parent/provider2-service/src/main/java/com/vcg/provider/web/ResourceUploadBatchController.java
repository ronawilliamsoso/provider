package com.vcg.provider.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageHelper;
import com.vcg.common.DateUtils;
import com.vcg.common.RestfulResultFactory;
import com.vcg.provider.entity.SearchBatch;
import com.vcg.provider.model.ResourceUploadBatch;
import com.vcg.provider.model.query.ResourceUploadBatchExample;
import com.vcg.provider.model.query.ResourceUploadBatchExample.Criteria;
import com.vcg.provider.service.ResourceUploadBatchService;
import com.vcg.provider.util.SearchUtil;
import ch.qos.logback.core.status.Status;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/resourceUploadBatch")
public class ResourceUploadBatchController {

	@Autowired
	private ResourceUploadBatchService resourceUploadBatchService;
	
	
	
	@ApiOperation(value = "供应商portal-上传管理-<批次列表>", notes = "providerId为必填")
	@RequestMapping(value="/pageList",method={RequestMethod.POST})
	public Object pageList(@RequestBody(required=true) SearchBatch searchBatch){
 
		if(searchBatch.getProviderId()==null){
			 return RestfulResultFactory.getInstance(Status.ERROR, null, "provider is null");
		}
		ResourceUploadBatchExample example=new ResourceUploadBatchExample();
		 Criteria   criteria  = example.createCriteria();
		 example.setOrderByClause("created_time desc");
		 criteria.andProviderIdEqualTo(searchBatch.getProviderId());
		 if(searchBatch.getBatchStatus()!=null){
			 criteria.andBatchStatusEqualTo(searchBatch.getBatchStatus());
		 }
		 if(StringUtils.isNotBlank(searchBatch.getSearchName())){
			 criteria.andBatchNameLike("%"+searchBatch.getSearchName()+"%");
		 }
		 Map<String,Object> time = SearchUtil.getSubmitTime(searchBatch);
		 if(time!=null && time.get("createFrom")!=null&&time.get("createTo")!=null){
			 SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
			 
			 try {
				criteria.andSubmitTimeBetween(sdf.parse(time.get("createFrom").toString()), sdf.parse(time.get("createTo").toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
 
		PageHelper.startPage(searchBatch.getPageNum(), searchBatch.getPageSize());
		List<ResourceUploadBatch> lst = this.resourceUploadBatchService.selectByExample(example);
		
		Map<String,Object> result = new  HashMap<String,Object>();
		result.put("status", 200);
		result.put("data", lst);
		result.put("msg", "ok");
		result.put("total", this.resourceUploadBatchService.countByExample(example));
		
		return result;
	}
	

	
	@ApiOperation(value = "供应商portal-上传管理-<新建批次>", notes = "providerId为必填")
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Object create(@RequestBody ResourceUploadBatch resourceUploadBatch){
		if(StringUtils.isBlank(resourceUploadBatch.getBatchName())){
			 return RestfulResultFactory.getInstance(Status.ERROR, null, "请填入批次名");
		}
		if(resourceUploadBatch.getProviderId()==null){
			 return RestfulResultFactory.getInstance(Status.ERROR, null, "providerid 为空");
		}
		resourceUploadBatch.setCreatedTime(DateUtils.getNowDate());
		this.resourceUploadBatchService.insertSelective(resourceUploadBatch);
		return RestfulResultFactory.getInstance(200, null, "成功");
		
	}
	
 

	@ApiOperation(value = "供应商portal-上传管理-<删除批次>", notes = "")
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Object delete(@RequestParam  Integer  id){
		ResourceUploadBatch resourceUploadBatch =  resourceUploadBatchService.getById(id);
		if(resourceUploadBatch==null){
			 return RestfulResultFactory.getInstance(Status.ERROR, null, "此批次为空");
		}
		if(resourceUploadBatch.getBatchStatus()==1||resourceUploadBatch.getBatchStatus()==2){
			this.resourceUploadBatchService.deleteByPrimaryKey(resourceUploadBatch.getId() );
			return RestfulResultFactory.getInstance(200, null, "成功");
		}else{
			return RestfulResultFactory.getInstance(Status.ERROR, null, "此批已提交,不能删除");
		}
		
		
	}
	
}
