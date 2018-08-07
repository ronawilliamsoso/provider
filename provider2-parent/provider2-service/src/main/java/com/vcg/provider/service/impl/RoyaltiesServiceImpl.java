package com.vcg.provider.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcg.common.base.BaseServiceImpl;
import com.vcg.provider.model.Royalties;
import com.vcg.provider.model.query.RoyaltiesExample;
import com.vcg.provider.dao.RoyaltiesDao;
import com.vcg.provider.service.RoyaltiesService;

@Service
public class RoyaltiesServiceImpl extends BaseServiceImpl<Royalties,RoyaltiesExample,Integer> implements RoyaltiesService {

	@Autowired
	private RoyaltiesDao royaltiesDao;

	@Override
	public void setDao() {
		this.baseDao = royaltiesDao;
	}

	@Override
	public Royalties getRoyaltiesByMonth(Integer providerId, Integer assetFamily, Integer year, Integer month) {
		boolean isNull = providerId == null && assetFamily == null && year == null && month == null;
		if(isNull){
			return null;
		}
		RoyaltiesExample example = new RoyaltiesExample();
		example.createCriteria().andProviderIdEqualTo(providerId)
			.andAssetFamilyEqualTo(assetFamily)
			.andYearEqualTo(year).andMonthEqualTo(month);
		example.setOrderByClause("create_time desc");
		List<Royalties> list = this.royaltiesDao.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)){
			return list.get(0);
		}else{
			return null;
		}
	}

}