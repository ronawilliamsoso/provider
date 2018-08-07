package com.vcg.provider.service.impl;

import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vcg.common.DateUtils;
import com.vcg.common.RestfulResult;
import com.vcg.common.Status;
import com.vcg.common.base.BaseServiceImpl;
import com.vcg.oss.util.ProviderOSSClientUtil;
import com.vcg.provider.model.ContactApplication;
import com.vcg.provider.model.ContractApplication;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.ProviderApplication;
import com.vcg.provider.model.UploadContract;
import com.vcg.provider.model.query.ProviderExample;
import com.vcg.provider.dao.ProviderDao;
import com.vcg.provider.service.ContactApplicationService;
import com.vcg.provider.service.ContractApplicationService;
import com.vcg.provider.service.MeService;
import com.vcg.provider.util.UUIDUtil;

@Service
public class MeServiceImpl extends BaseServiceImpl<Provider,ProviderExample,Integer> implements MeService {

	@Autowired
	private ProviderDao providerDao;
	
	@Override
	public void setDao() {
		this.baseDao = providerDao;
	}
 
 
	
	@Autowired
	private ContactApplicationService contactApplicationService;
	
	@Autowired
	private ContractApplicationService contractApplicationService;
	
	@Value("${oss.isInternal}")
	private Integer isInternal;
 
	
	@Autowired
	private ProviderOSSClientUtil providerOSSClientUtil;


 

	@SuppressWarnings({ "static-access", "rawtypes", "unchecked" })
	@Override
	@Transactional(rollbackFor = Exception.class)
	public RestfulResult addMeContract(UploadContract uploadContract,ContactApplication contactApplication,ContractApplication contractApplication,ProviderApplication providerApplication)  {
		RestfulResult msg = new RestfulResult(200,null,"ok");

		try {
			
			

			//将社区的图读取过来,然后传到我们的bucket上
			InputStream inputStream;
			String imgObjectId="";
 
			inputStream = new URL(uploadContract.getIdCardImgPath()).openStream();
			String randomstring=UUIDUtil.generateUUID().substring(22);
			SimpleDateFormat sdf =   new SimpleDateFormat( "yyyyMMddHHmmss" );
		    String timestemp = sdf.format(new Date());
		    imgObjectId="provider/id/"+timestemp+"-"+randomstring+".jpg";
		    providerOSSClientUtil.putProviderObject(isInternal, imgObjectId, inputStream);
			    
			contactApplication.setIdCardimgpath(imgObjectId);
			
			if(contractApplication.getId() != null && providerApplication.getAssetFamily() != null){
				
				contractApplication.setAssetFamily(providerApplication.getAssetFamily());
				if(contractApplication.getAuditingStatus() == Status.AUDITING_STATUS_NOUPLOAD){
					contractApplication.setAuditingStatus(Status.AUDITING_STATUS_UPLOADED);
				}else{
					//驳回后重新上传
					contractApplication.setAuditingStatus(Status.AUDITING_STATUS_REUPLOAD);
				}
				
				//contractApplication.setModifyTime(DateUtils.getNowDate());
				contractApplicationService.updateByPrimaryKeySelective(contractApplication);
				if(contactApplication.getId() != null){
					contactApplication.setUpdatedTime(DateUtils.getNowDate());
					contactApplicationService.updateByPrimaryKeySelective(contactApplication);
				}
				msg.setStatus(200);
				msg.setMessage("上传成功");
				
			}else{
				msg.setStatus(400);
				msg.setMessage("上传失败");
			}
			

 
			return msg;
		} catch (Exception e) {
		 
			e.printStackTrace();
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			return new RestfulResult(Status.ERROR,null, fullStackTrace);
		}
 
	 
	}
 

}