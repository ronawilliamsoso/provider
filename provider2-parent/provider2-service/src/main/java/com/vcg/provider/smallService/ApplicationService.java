package com.vcg.provider.smallService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.StringUtil;
import com.vcg.boss.util.CollectionUtils;
import com.vcg.provider.model.Provider;
import com.vcg.provider.service.ProviderService;

/**
 * 中间服务
 * @author yanhua.ma
 *
 */
@Component
public class ApplicationService {
	@Autowired
	private ProviderService providerService;
	/**
	 * 查询用户通过了哪一类摄影师
	 * @param userCenterId 用户中心ID
	 * @return 0 未通过 1 编辑类 2 创意类 3 编辑&创意类
	 */
	public int checkWhichTypeByUserCenterId(String userCenterId){
		if(StringUtil.isNotEmpty(userCenterId)){
			List<Provider> providers = this.providerService.getProviderByUserCenterId(userCenterId);
			if(CollectionUtils.notEmpty(providers)){
				
				int type = 0;
				for(Provider p: providers){
					boolean edit = p.getAssetFamily() != null && p.getAssetFamily() == 1;
					boolean creative = p.getAssetFamily() != null && p.getAssetFamily() == 2;
					boolean mix = p.getAssetFamily() != null && p.getAssetFamily() == 3;
					if(edit){
						type = type + 1;
					}
					if(creative){
						type = type + 2;
					}
					if(mix){
						type = type + 3;
					}
				}
				return type;
			}
		}
		
		return 0;
	}
	
}
