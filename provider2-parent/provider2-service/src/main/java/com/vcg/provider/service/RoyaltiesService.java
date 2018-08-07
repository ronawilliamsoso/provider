package com.vcg.provider.service ;

import com.vcg.common.base.BaseService;
import com.vcg.provider.model.Royalties;
import com.vcg.provider.model.query.RoyaltiesExample;

public interface RoyaltiesService extends BaseService<Royalties,RoyaltiesExample,Integer>{
	/**
	 * 获取供应商某个月的稿费信息
	 * @param providerId 供应商ID
	 * @param assetFamily 媒资类型
	 * @param year 年份
	 * @param month 月份
	 * @return 供应商图片某月的销售额，稿费，个税，奖金，图片张数等信息,如果没有记录则返回null
	 */
	public Royalties getRoyaltiesByMonth(Integer providerId,Integer assetFamily,Integer year,Integer month);
}