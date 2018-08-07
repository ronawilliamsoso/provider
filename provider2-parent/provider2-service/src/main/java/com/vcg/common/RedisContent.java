package com.vcg.common;



public interface RedisContent {
	
	public static final String storage_pre="vcg_all_storage_";
	
	
	
	//1是最新的 0是需要更新 敏感词
	public static final String global_wordsentive="vcg_global_storage_word_sentive";
	
	//1是最新的 0是需要更新 供应商
	public static final String global_provider="vcg_global_storage_provider";
	
	//1是最新的 0是需要更新 水印
    public static final String global_wateRule="vcg_global_storage_wateRule";
	
    //1是最新的 0是需要更新 关键词分类
    public static final String global_keywordcategory="vcg_global_storage_keywordcategory";
    
    //1是最新的 0是需要更新  getty 法新 路透
    public static final String global_gettyafpreuters="vcg_global_storage_gettyafpreuter";
    
    //1是最新的 0是需要更新  免审
    public static final String global_autoIn="vcg_global_storage_autoIn";
    
    
  //1是最新的 0是需要更新
    public static final String global_categoryProduct="vcg_global_storage_categoryProduct";
    
    //1是最新的 0是需要更新 getty品牌
    public static final String global_gettyCollection="vcg_global_storage_gettyCollection";
    
    
    public static final String pre_provider="vcg:provider:";
    public static final String pre_provider_collections="vcg:prvider_collections:";
    public static final String pre_collection="vcg:collection:";
    public static final String pre_product="vcg:product:";
    public static final String pre_brand="vcg:brand:";
    
    public static final String pre_cbatchmeta="vcg:cbatchmeta:";//List<ResourceUploadMetaContent>
    
    public static final String pre_contract_application="vcg:contract:application:";//防止社区的请求收不到,放在缓存

    
}
