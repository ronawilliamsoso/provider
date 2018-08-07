package com.vcg.provider.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageHelper;
import com.vcg.common.DateUtils;
import com.vcg.common.RestfulResult;
import com.vcg.common.RestfulResultFactory;
import com.vcg.common.Status;
import com.vcg.provider.entity.SearchBrand;
import com.vcg.provider.entity.SearchBrandCollections;
import com.vcg.provider.entity.SearchCollection;
import com.vcg.provider.entity.ViewBrandCollections;
import com.vcg.provider.model.Brand;
import com.vcg.provider.model.Collection;
import com.vcg.provider.model.Contract;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.query.BrandExample;
import com.vcg.provider.model.query.CollectionExample;
import com.vcg.provider.model.query.ProviderExample;
import com.vcg.provider.model.query.BrandExample.Criteria;
import com.vcg.provider.service.BrandService;
import com.vcg.provider.service.CollectionService;
import com.vcg.provider.service.ContractService;
import com.vcg.provider.service.ProviderService;
import com.vcg.provider.util.AccountUtil;
import com.vcg.provider.util.PinyinUtil;
import com.vcg.provider.util.RedisUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;
	
	
	@Autowired
	private AccountUtil accountUtil;
	
	@Autowired
	private CollectionService collectionService;
	
	@Autowired
	private ProviderService providerService;
 
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private PinyinUtil pinyinUtil;
	
	
	

	@ApiOperation(value = "brand管理-<分页搜索列表>", notes = "brand-<分页搜索列表>")
	@RequestMapping(value="/pageList",method={RequestMethod.POST})
	public Object pageList(@RequestBody SearchBrand requestParam){
		
	if(StringUtils.isNotBlank(requestParam.getSearchName())  && requestParam.getSearchType()==null ){
		return RestfulResultFactory.getInstance(Status.ERROR, null,  "SearchType为空!");
	}
		
		
		BrandExample example=new BrandExample();
		example.setOrderByClause("updated_time desc");
		Criteria criteria= example.createCriteria();
		
		if(requestParam.getSearchName()!=null&&StringUtils.isNotBlank(requestParam.getSearchName())){
	 
	      if(requestParam.getSearchType()==2 ){
					criteria.andBrandNameLike("%"+requestParam.getSearchName()+"%");
	      }
	      if(requestParam.getSearchType()==1 && StringUtils.isNumeric(requestParam.getSearchName())){
					criteria.andIdEqualTo(Integer.parseInt(requestParam.getSearchName()));
	      }
	 
			
			
		}
		

		if(requestParam.getBrandStatus()!=null){
			criteria.andBrandStatusEqualTo(requestParam.getBrandStatus());
		}
		if(requestParam.getHidenStatus()!=null){
			criteria.andHidenStatusEqualTo(requestParam.getHidenStatus());
		}

 
		PageHelper.startPage(requestParam.getPageNum(), requestParam.getPageSize());
		List<Brand> lst = this.brandService.selectByExample(example);
 
		lst.forEach(e->{
			CollectionExample cexample=new CollectionExample();
			cexample.createCriteria().andBrandIdEqualTo(e.getId());
			Integer number = collectionService.countByExample(cexample);
			 e.setCollectionNumber(number);
		});
		
		Map<String,Object> result = new  HashMap<String,Object>();
		result.put("status", 200);
		result.put("data", lst);
		result.put("msg", "ok");
		result.put("total", this.brandService.countByExample(example));
		 
		
		return result;
	}
	
	@ApiOperation(value = "brand管理-<所有有效的brand>", notes = "brand管理-<所有的brand>")
	@RequestMapping(value="/list",method={RequestMethod.POST})
	public Object list(){
		
		BrandExample example=new BrandExample();
		example.setColunms(Arrays.asList("id","brand_name"));
		Criteria criteria= example.createCriteria();
		criteria.andBrandStatusEqualTo(1);//有效的
		List<Brand> list = this.brandService.selectByExample(example);
		
		Map<String,Object> result = new  HashMap<String,Object>();
		if(list.size()>0){
			List<Map<String,Object>> ret = new ArrayList<Map<String,Object>>();
			list.forEach(e->{
				Map<String,Object> map = new  HashMap<String,Object>();
				map.put("id", e.getId());
				map.put("brandName", e.getBrandName());
				ret.add(map);
				});
			result.put("data", ret);
//			result.put("total", this.brandService.countByExample(example));
		}
		
		
		return result;
	}	

//	
	@ApiOperation(value = "brand管理-<添加brand>", notes = "brand管理-<添加brand>")
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Object create(@ApiParam(required = true,value = "多个collection id用逗号分隔") @RequestParam(required=true) String  collections,
			                             @ApiParam(value = "品牌名称") @RequestParam(required=true) String brandName,
			                             @ApiParam(value = "备注") @RequestParam(required=true) String comment,
			                             @ApiParam(value = "asset_family 1编辑类2创意类") @RequestParam(required=true) Integer assetFamily,
			                             @ApiParam(value = "asset_type 媒资类型1图片2视频3音频") @RequestParam(required=true) Integer assetType,
			                             @ApiParam(value = "license_type 授权客户类型1:RM2:RF3: RR") @RequestParam(required=true) Integer licenseType,
			                             @RequestParam String token){
		String userId = accountUtil.getUserId(token);

		Brand brand = new Brand();
		brand.setBrandName(brandName);
		brand.setBrandStatus(0);//失效
		brand.setHidenStatus(0);//隐藏
		brand.setCreatedBy(userId);
		brand.setComment(comment);
		brand.setAssetFamily(assetFamily);
		brand.setAssetType(assetType);
		brand.setLicenseType(licenseType);
		
		if(StringUtils.isNotBlank(brandName)){
			String pinyin = pinyinUtil.getAllFirstLetter(brandName);
			brand.setPinYin(pinyin);
		}
		
		
		this.brandService.insertSelective(brand);
		
		redisUtil.deleteRedisBrand(brand.getId());
		
		List<Integer> intlist  = Arrays.asList(collections.split(",")).stream().map(e->Integer.parseInt(e)).collect(Collectors.toList());
		
		intlist.forEach(e->{
			Collection collection = new Collection();
			collection.setBrandId(brand.getId());
			collection.setUpdatedBy(userId);
			collection.setUpdatedTime(DateUtils.getNowDate());
			collectionService.updateByPrimaryKeySelective(collection);
			redisUtil.deleteRedisCollection(collection.getId());
		});
		
		 
		
 
		return RestfulResultFactory.getInstance(200, null,  "成功");
		
	}
	
	@ApiOperation(value = "brand管理-<修改>", notes = "brand管理-<修改>")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	public Object update(@RequestBody Brand brand,@RequestParam String token,
			             @ApiParam(value = "编辑前的collections") @RequestParam(required=true) String before,
			             @ApiParam(value = "编辑后的collections") @RequestParam(required=true) String after){
		String userId = accountUtil.getUserId(token);
		List<Integer> intadd= new ArrayList<Integer>();
		List<Integer> intminus =  new ArrayList<Integer>();
		List<Integer> intbefore=  new ArrayList<Integer>();
		List<Integer> intafter=  new ArrayList<Integer>();
		if(brand.getId()==null){
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "brand的id为空");
		}
		if(StringUtils.isNotBlank(before)){//之前就有,那么就需要进行比较
			intbefore  = Arrays.asList(before.split(",")).stream().map(e->Integer.parseInt(e)).collect(Collectors.toList()); 
			intafter =  Arrays.asList(after.split(",")).stream().map(e->Integer.parseInt(e)).collect(Collectors.toList()); 
			for(Integer bef:intbefore)  
	        {  
	            if(!intafter.contains(bef))  //修改后的数组不包含修改前的元素,说明是减少的
	            {  
	            	intminus.add(bef);  
	            } 
	        }
			for(Integer aft:intafter)  
	        {  
	            if(!intbefore.contains(aft))  //修改前的数组不包含修改后的元素,说明是增加的
	            {  
	            	intadd.add(aft);  
	            } 
	        } 
		}
 
		
		
        if(intadd.size()>0){
        	for(Integer add:intadd){
        		Collection collection = collectionService.getById(add);
        		collection.setBrandId(brand.getId());
        		collection.setUpdatedBy(userId);
        		collection.setUpdatedTime(DateUtils.getNowDate());
        		collectionService.updateByPrimaryKeySelective(collection);
        		redisUtil.deleteRedisCollection(collection.getId());
        	}
        	
         
        }
        if(intminus.size()>0){
        	for(Integer minus:intminus){
        		
        		Collection collection = collectionService.getById(minus);
        		collection.setBrandId(null);
        		collection.setUpdatedBy(userId);
        		collection.setUpdatedTime(DateUtils.getNowDate());
        		collectionService.updateByPrimaryKey(collection);
        		redisUtil.deleteRedisCollection(collection.getId());
        	}
        }
         brand.setUpdatedBy(userId);
         brand.setUpdatedTime(DateUtils.getNowDate());
		 this.brandService.updateByPrimaryKeySelective(brand);
		 redisUtil.deleteRedisBrand(brand.getId());
		return RestfulResultFactory.getInstance(200, null,  "成功");
		
	}
//	
	@ApiOperation(value = "brand管理-<点击collection数字查看>", notes = "brand管理-<点击数字查看>")
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public Object view( @ApiParam(required = true,value = "id") Integer id){
		Brand view = this.brandService.selectByPrimaryKey(id);
		if(view==null){
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "brand为空");
		}
		Map<String,Object> result = new  HashMap<String,Object>();
		result.put("status", 200);
		result.put("msg", "ok");
		result.put("brand", view);
		
		CollectionExample cexample=new CollectionExample();
		cexample.createCriteria().andBrandIdEqualTo(id);
		cexample.setColunms(Arrays.asList("id","name"));
		List<Collection> list =  collectionService.selectByExample(cexample);
		
		if(list!=null){
			List<Map<String,Object>> ret = new ArrayList<Map<String,Object>>();
			list.forEach(e->{
				Map<String,Object> map = new  HashMap<String,Object>();
				map.put("id", e.getId());
				map.put("collectionName", e.getName());
				ret.add(map);
				});
			result.put("collections", ret);
		}
		
		return result;
		
	}
//	
//
//	//@ApiOperation(value = "delete", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
//	@ApiOperation(value = "brand管理-<删除>", notes = "brand管理-<删除>")
//	@RequestMapping(value="/delete",method=RequestMethod.POST)
//	public Object delete(@ApiParam(required = true,value = "id") Integer id){
//		
//		 this.brandService.deleteByPrimaryKey(id);
//		return RestfulResultFactory.getInstance(200, null,  "成功");
//		
//	}
	
	@ApiOperation(value = "brand管理-<隐藏或者显示>", notes = "brand管理-<隐藏或者显示>")
	@RequestMapping(value="/hideOrUnhide",method={RequestMethod.POST})
	public RestfulResult hideOrUnhide(@ApiParam(required = true,value = "本行的品牌id,如30") @RequestParam Integer id,@ApiParam(required = true,value = "0:隐藏 1:显示") @RequestParam Integer hidenStatus, @RequestParam String token){
		String userId = accountUtil.getUserId(token);
        
		Brand update=new Brand();
		update.setId(id);
		update.setHidenStatus(hidenStatus);
		update.setUpdatedBy(userId);
		brandService.updateByPrimaryKeySelective(update);
		redisUtil.deleteRedisBrand(update.getId());
		return RestfulResultFactory.getInstance(200, null,  "成功");
	}
	
	@ApiOperation(value = "brand管理-<取消关联collection>", notes = "brand管理-<取消关联>")
	@RequestMapping(value="/unConect",method={RequestMethod.POST})
	public RestfulResult unConect(@ApiParam(required = true,value = "本行的collection id") @RequestParam Integer collectionId , @RequestParam String token){
		String userId = accountUtil.getUserId(token);
		Collection collection = collectionService.getById(collectionId);
		 
		 
		collection.setBrandId(null);
		collection.setUpdatedBy(userId);
		collection.setUpdatedTime(DateUtils.getNowDate());
		collectionService.updateByPrimaryKey(collection);
		redisUtil.deleteRedisCollection(collection.getId());
		return RestfulResultFactory.getInstance(200, null,  "成功");
	}
	
	@ApiOperation(value = "brand管理-<批量取消关联collections>", notes = "brand管理-<取消关联>")
	@RequestMapping(value="/unConectCollections",method={RequestMethod.POST})
	public RestfulResult unConectCollections(@ApiParam(required = true,value = "多个collection用逗号分隔") @RequestParam String collectionIds , @RequestParam String token){
		String userId = accountUtil.getUserId(token);
		List<String> cols = Arrays.asList(collectionIds.split(","));
		List<Integer> colsi = cols.stream().map(e->Integer.parseInt(e)).collect(Collectors.toList());
		colsi.forEach(e->{
			Collection collection =  new Collection();
			collection.setId(e);
			collection.setBrandId(null);
			collection.setUpdatedBy(userId);
			collection.setUpdatedTime(DateUtils.getNowDate());
			collectionService.updateByPrimaryKey(collection);
			redisUtil.deleteRedisCollection(collection.getId());
		});

		return RestfulResultFactory.getInstance(200, null,  "成功");
	}
 
	
	@ApiOperation(value = "brand管理-<失效或者删除,或者有效>", notes = "brand管理-<隐藏或者显示>")
	@RequestMapping(value="/validOrDelete",method={RequestMethod.POST})
	public RestfulResult validOrDelete(@ApiParam(required = true,value = "本行的品牌id,如30") @RequestParam Integer id,@ApiParam(value = "1:有效0:失效 2:新建. 删除等效于失效") @RequestParam Integer brandStatus, @RequestParam String token){
		String userId = accountUtil.getUserId(token);
		Brand update=new Brand();
		update.setId(id);
		update.setBrandStatus(brandStatus);
		update.setUpdatedBy(userId);
		brandService.updateByPrimaryKeySelective(update);
		redisUtil.deleteRedisBrand(update.getId());
		return RestfulResultFactory.getInstance(200, null,  "成功");
	}
	
	
	@ApiOperation(value = "brand管理-<未关联的有效的collection列表>", notes = "brand管理-<未关联的有效的collection列表>")
	@RequestMapping(value="/noneConnectedCollectionList",method={RequestMethod.POST})
	public Object noneConnectedCollectionList(@RequestBody(required=true)SearchCollection requestParam ){
		List<Map<String,Object>> ret = new ArrayList<Map<String,Object>>();
		Map<String,Object> result = new  HashMap<String,Object>();
		
		
		 if(requestParam.getSearchType()==null){
			 return RestfulResultFactory.getInstance(Status.ERROR, null,  "搜索类型为空");
		 }

		 
		 //模糊搜索的需要加上通配符
		 
		 List<Integer> intlist = null;
			CollectionExample cexample=new CollectionExample();
			cexample.setColunms(Arrays.asList("id","name"));
			com.vcg.provider.model.query.CollectionExample.Criteria criteria  = cexample.createCriteria();
		 if(requestParam.getSearchName()!=null&&StringUtils.isNotBlank(requestParam.getSearchName())){
				String	searcName = "";
				if(requestParam.getSearchType()==1||requestParam.getSearchType()==2||requestParam.getSearchType()==3){
					searcName = "%" + requestParam.getSearchName() + "%";  
				}else if(requestParam.getSearchType()==4||requestParam.getSearchType()==5||requestParam.getSearchType()==6){
					searcName = requestParam.getSearchName();  
				}
				if(requestParam.getSearchType() ==1){//1:查机构名 
					ProviderExample example = new ProviderExample();
					example.createCriteria().andNameCnLike(searcName).andStatusEqualTo(3);
					List<Provider> plist = providerService.selectByExample(example);
					intlist = plist.stream().map(e->e.getId()).collect(Collectors.toList());
					if(intlist.size()==0){
						result.put("status", 200);
						result.put("data", ret);
						result.put("msg", "ok");
						result.put("total",0);
						return  result;
					}
					
					criteria.andProviderIdIn(intlist);
					
				}else if(requestParam.getSearchType() ==3){//3:查collection名
					criteria.andNameLike(searcName);
				}else if(requestParam.getSearchType() ==2){//2:查brand名
					BrandExample example=new BrandExample();
					example.createCriteria().andBrandNameLike(searcName).andBrandStatusEqualTo(1);
					List<Brand> blist = brandService.selectByExample(example);
					intlist = blist.stream().map(e->e.getId()).collect(Collectors.toList());
					if(intlist.size()==0){
						result.put("status", 200);
						result.put("data", ret);
						result.put("msg", "ok");
						result.put("total", 0);
						return  result;
					}
					criteria.andBrandIdIn(intlist);
				}else if(requestParam.getSearchType() ==4 && StringUtils.isNumeric(searcName)){// 4:供应商id
					Provider provider = providerService.selectByPrimaryKey(Integer.parseInt(searcName));
					criteria.andProviderIdEqualTo(provider.getId());
				}else if(requestParam.getSearchType() ==5 && StringUtils.isNumeric(searcName)){//5:brand Id
					criteria.andBrandIdEqualTo(Integer.parseInt(searcName));
				}else if(requestParam.getSearchType() ==6 && StringUtils.isNumeric(searcName)){//  6:collectionId
					criteria.andIdEqualTo(Integer.parseInt(searcName));
				}
			 
		 }
		 
	 
		criteria.andBrandIdIsNull().andAvailableStatusEqualTo(1);//brand不为空,并且状态为有效
		PageHelper.startPage(requestParam.getPageNum(), requestParam.getPageSize());
		List<Collection> list = collectionService.selectByExample(cexample);
		
		list.forEach(e->{
			Map<String,Object> map = new  HashMap<String,Object>();
			map.put("id", e.getId());
			map.put("name", e.getName());
			ret.add(map);
			});
		
		
		result.put("status", 200);
		result.put("data", ret);
		result.put("msg", "ok");
		result.put("total", this.collectionService.countByExample(cexample));
		return  result;
 
		 
 
	}
	

	
	
	@ApiOperation(value = "brand管理-点击数字已关联collection-<查询collection>", notes = "asset_type:媒资类型1图片2视频3音频 asset_family:内容属性 1编辑类2创意类 license_type:授权客户类型1:RM2:RF3: RR  auth_location: 授权区域1:全球2:中国大陆地区3:中国大陆加港澳台4:大陆加香港5:大陆加台湾6:大陆加澳门7:其他")
	@RequestMapping(value="/searchCollectionList",method={RequestMethod.POST})
	public Object searchCollectionList(@RequestBody(required=true)SearchBrandCollections requestParam ){
		
		List<Map<String,Object>> ret = new ArrayList<Map<String,Object>>();
		Map<String,Object> result = new  HashMap<String,Object>();
		Brand brand = this.brandService.selectByPrimaryKey(requestParam.getBrandId());
		 if(brand==null){
			 return RestfulResultFactory.getInstance(Status.ERROR, null,  "brand 为空");
		 }
 
			CollectionExample cexample=new CollectionExample();
			cexample.setColunms(Arrays.asList("id","name","collection_code","asset_type","asset_family","license_type","royalty_rate","auth_location"));
			com.vcg.provider.model.query.CollectionExample.Criteria criteria  = cexample.createCriteria();
			 if(requestParam.getSearchName()!=null&&StringUtils.isNotBlank(requestParam.getSearchName())){
			 
			 
				String	searcName = "";
				if(requestParam.getSearchType()==2||requestParam.getSearchType()==4){
					searcName = "%" + requestParam.getSearchName() + "%";  
				}else if(requestParam.getSearchType()==1||requestParam.getSearchType()==3){
					searcName = requestParam.getSearchName();  
				}
				if(requestParam.getSearchType() ==4 ){//1:collectionId  2:collection 名字 3:供应商id 4:供应商名称
					ProviderExample example = new ProviderExample();
					example.createCriteria().andNameCnLike(searcName).andStatusEqualTo(3);
					List<Provider> plist = providerService.selectByExample(example);
					List<Integer> intlist = plist.stream().map(e->e.getId()).collect(Collectors.toList());
					if(intlist.size()==0){
						result.put("status", 200);
						result.put("data", ret);
						result.put("msg", "ok");
						result.put("total",0);
						return  result;
					}
					
					criteria.andProviderIdIn(intlist);
					
				}else if(requestParam.getSearchType() ==2){//3:查collection名
					criteria.andNameLike(searcName);
				}else if(requestParam.getSearchType() ==3 && StringUtils.isNumeric(searcName)){// 3:供应商id
					Provider provider = providerService.selectByPrimaryKey(Integer.parseInt(searcName));
					criteria.andProviderIdEqualTo(provider.getId());
				}else if(requestParam.getSearchType() ==1 && StringUtils.isNumeric(searcName)){//  6:collectionId
					criteria.andIdEqualTo(Integer.parseInt(searcName));
				}
				  
				

			 
		 }
			 
			 criteria.andBrandIdEqualTo(brand.getId()).andAvailableStatusEqualTo(1);//brand为当前行,并且状态为有效
			if(requestParam.getAssetFamily()!=null){
				criteria.andAssetFamilyEqualTo(requestParam.getAssetFamily());
			}
			if(requestParam.getAssetType()!=null){
				criteria.andAssetTypeEqualTo(requestParam.getAssetType());
			}
			if(requestParam.getLicenseType()!=null){
				criteria.andLicenseTypeEqualTo(requestParam.getLicenseType());
			}
 
		PageHelper.startPage(requestParam.getPageNum(), requestParam.getPageSize());
		List<Collection> list = collectionService.selectByExample(cexample);
		
		 if(list.size()>0){
				List<Map<String,Object>> retlist = new ArrayList<Map<String,Object>>();
				list.forEach(e->{
					Map<String,Object> map = new  HashMap<String,Object>();
					map.put("id", e.getId());
					map.put("name", e.getName());
					map.put("collectionCode", e.getCollectionCode());
					map.put("assetType", e.getAssetType());
					map.put("assetFamily", e.getAssetFamily());
					map.put("licenseType", e.getLicenseType());
					map.put("royaltyRate", e.getRoyaltyRate());
					map.put("authLocation", e.getAuthLocation());
					retlist.add(map);
					});
				result.put("status", 200);
				result.put("data", retlist);
				result.put("msg", "ok");
				result.put("total", this.collectionService.countByExample(cexample));
				return  result;
		 } 
				result.put("status", 200);
				result.put("data", ret);
				result.put("msg", "ok");
				result.put("total", 0);
		 
		return result;
 
	}


	@ApiOperation(value = "brand管理-点击行已关联collection-<点击行查看collection详情>", notes = "asset_type:媒资类型1图片2视频3音频 asset_family:内容属性 1编辑类2创意类 license_type:授权客户类型1:RM2:RF3: RR  auth_location: 授权区域1:全球2:中国大陆地区3:中国大陆加港澳台4:大陆加香港5:大陆加台湾6:大陆加澳门7:其他")
	@RequestMapping(value="/viewCollection",method={RequestMethod.POST})
	public Object viewCollection(@RequestParam(required=true) Integer id ){
		Collection collection = redisUtil.getCollection(id);
		return RestfulResultFactory.getInstance(200, collection,  "成功");
	}
 
	
	
}
