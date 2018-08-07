package com.vcg.provider.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.vcg.common.RedisContent;
import com.vcg.provider.model.Brand;
import com.vcg.provider.model.Collection;
import com.vcg.provider.model.Product;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.ResourceUploadMetaContent;
import com.vcg.provider.model.query.CollectionExample;
import com.vcg.provider.model.query.ResourceUploadMetaContentExample;
import com.vcg.provider.service.BrandService;
import com.vcg.provider.service.CollectionService;
import com.vcg.provider.service.ProductService;
import com.vcg.provider.service.ProviderService;
import com.vcg.provider.service.ResourceUploadMetaContentService;

@Component
public class RedisUtil {

	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private CollectionService collectionService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Autowired
	private ResourceUploadMetaContentService resourceUploadMetaContentService;
	
	
	
	//provider
	public void updateRedisProvider(Provider p){
		String key = RedisContent.pre_provider+p.getId();
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		if(p != null &&p.getStatus()==3){
			String json = JSONObject.toJSON(p).toString();
			ops.set(key,json);
		}
	}
	
	
	/**
	 * 得到供应商
	 * @param providerId
	 * @return 
	 */
	public Provider getProvider(Integer providerId){
		if(providerId != null){
			ValueOperations<String, String> ops = redisTemplate.opsForValue();
			String key = RedisContent.pre_provider+providerId;
			Provider p = null;
			//redis缓存获取
			String providerJson = ops.get(key);
			if(providerJson != null && providerJson.trim().length()>0){
				p  = JSONObject.parseObject(providerJson, Provider.class);
			}else{
				//数据库获取
				p = providerService.selectByPrimaryKey(providerId);
				//存到redis
				if(p != null){
					String json = JSONObject.toJSON(p).toString();
					ops.set(key,json);
				}
			}
			//装载colltions
			List<Collection> colls = getCollectionsByProviderId(providerId);
			if(p != null){
				p.setColls(colls);
			}
			
			return p;
		}
		
		return null;
	}
	
	 
	
	
	/**
	 * 
	 * @param record
	 * @return
	 */
	//@CacheEvict(value="providers",key="#provider.getId()")
	public Integer providerMerge(@RequestParam Provider provider){
		//新增或者更新供应商信息
		 if(provider.getId() == null){
			  this.providerService.insertSelective(provider);
		 }else{
			  this.providerService.updateByPrimaryKeySelective(provider);
		 }
		 //更新redis   暂时注销
		 updateRedisProvider(provider);
		 
		 return provider.getId();
	}
	
	
 
	//collection--------------------------------------------------------------------------------------------------
	private List<Collection> getCollectionsByProviderId(Integer providerId){
		if(providerId != null){
			String key = RedisContent.pre_provider_collections+providerId;
			ValueOperations<String, String> ops = redisTemplate.opsForValue();
			String providerCollsJson = ops.get(key);
			if(providerCollsJson != null && providerCollsJson.trim().length()>0){
				List<Collection> colls= JSONObject.parseArray(providerCollsJson, Collection.class);
				
				return colls;
			}else{
				CollectionExample collExample = new CollectionExample();
				collExample.createCriteria().andProviderIdEqualTo(providerId);
				List<Collection> colls = collectionService.selectByExample(collExample);
				if(colls != null&& colls.size()>0){
					String json = JSONObject.toJSONString(colls);
					ops.set(key, json);
				}
				return colls;
			}
		}
		return null;
	}
	
 
	
	public Collection getCollection(Integer collectionId){
		if(collectionId != null){
			ValueOperations<String, String> ops = redisTemplate.opsForValue();
			String key = RedisContent.pre_collection+collectionId;
			Collection collection = null;
			//redis缓存获取
			String collectionJson = ops.get(key);
			System.err.println(collectionJson);
			if(collectionJson != null && collectionJson.trim().length()>0){
				collection  = JSONObject.parseObject(collectionJson, Collection.class);
			}else{
				//数据库获取
				collection = collectionService.selectByPrimaryKey(collectionId);
				//存到redis
				if(collection != null){
					String json = JSONObject.toJSON(collection).toString();
					ops.set(key,json);
				}
			}
			return collection;
		}
		return null;
	}
 
	public void updateRedisCollection(Collection collection){
		String key = RedisContent.pre_collection+collection.getId();
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		if(collection != null &&collection.getAvailableStatus()==1){
			String json = JSONObject.toJSON(collection).toString();
			ops.set(key,json);
		}
	}
	
	public void updateRedisCollection(Integer collectionId){
		Collection collection = collectionService.getById(collectionId);
		if(collection!=null){
			String key = RedisContent.pre_collection+collection.getId();
			ValueOperations<String, String> ops = redisTemplate.opsForValue();
				String json = JSONObject.toJSON(collection).toString();
				ops.set(key,json);
		}
	}
	
	
	/**
	 * 
	 * @param record
	 * @return
	 */
	//@CacheEvict(value="collections",key="#collection.getId()")
	public Integer collectionMerge(@RequestParam Collection collection){
		
		if(collection.getId() == null){
			 this.collectionService.insertSelective(collection);
		}else{
			 this.collectionService.updateByPrimaryKeySelective(collection);
		}
		Provider provider =providerService.selectByPrimaryKey(collection.getProviderId());
		updateRedisProvider(provider);
		return collection.getId();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	// brand ---------------------------------------------------------------------------------------------------------
	public Brand getBrand(Integer brandId){
		if(brandId != null){
			ValueOperations<String, String> ops = redisTemplate.opsForValue();
			String key = RedisContent.pre_brand+brandId;
			Brand brand = null;
			//redis缓存获取
			String brandJson = ops.get(key);
			if(brandJson != null && brandJson.trim().length()>0){
				brand  = JSONObject.parseObject(brandJson, Brand.class);
			}else{
				//数据库获取
				brand = brandService.selectByPrimaryKey(brandId);
				//存到redis
				if(brand != null){
					String json = JSONObject.toJSON(brand).toString();
					ops.set(key,json);
				}
			}
			return brand;
		}
		return null;
	}
	

//	public void updateRedisBrand(Brand brand){
//		String key = RedisContent.pre_brand+brand.getId();
//		ValueOperations<String, String> ops = redisTemplate.opsForValue();
//		if(brand != null &&brand.getBrandStatus()==1){
//			String json = JSONObject.toJSON(brand).toString();
//			ops.set(key,json);
//		}
//	}
//	
//	
//	public void updateRedisBrand(Integer brandId){
//		Brand brand = brandService.getById(brandId);
//		if(brand!=null){
//			String key = RedisContent.pre_brand+brand.getId();
//			ValueOperations<String, String> ops = redisTemplate.opsForValue();
//				String json = JSONObject.toJSON(brand).toString();
//				ops.set(key,json);
//		}
//	}
	 

	public void deleteRedisBrand(Integer brandId){
		if(brandId != null){
			ValueOperations<String, String> ops = redisTemplate.opsForValue();
			String key = RedisContent.pre_brand+brandId;
			ops.getOperations().delete(key);
	   }
	}
	
	public void deleteRedisProvider(Integer providerId){
		if(providerId != null){
			ValueOperations<String, String> ops = redisTemplate.opsForValue();
			String key = RedisContent.pre_provider+providerId;
			ops.getOperations().delete(key);
			
			key = RedisContent.pre_provider_collections+providerId;
			ops.getOperations().delete(key);
	   }
	}
	
	public void deleteRedisCollection(Integer collectionId){
		if(collectionId != null){
			ValueOperations<String, String> ops = redisTemplate.opsForValue();
			String key = RedisContent.pre_collection+collectionId;
			ops.getOperations().delete(key);
	   }
	}
	
	public void deleteRedisProduct(Integer productId){
		if(productId != null){
			ValueOperations<String, String> ops = redisTemplate.opsForValue();
			String key = RedisContent.pre_product+productId;
			ops.getOperations().delete(key);
	   }
	}
	
	/**
	 * 
	 * @param record
	 * @return
	 */
	//@CacheEvict(value="products",key="#product.getId()")
	public Integer productMerge(@RequestParam Product product){
		
		 if(product.getId() == null){
			  this.productService.insertSelective(product);
		 }else{
			  this.productService.updateByPrimaryKeySelective(product);
		 }
		 
		 return product.getId();
	}
	
	
	public Product getProduct(Integer productId){
		if(productId != null){
			ValueOperations<String, String> ops = redisTemplate.opsForValue();
			String key = RedisContent.pre_product+productId;
			Product product = null;
			//redis缓存获取
			String productJson = ops.get(key);
			if(productJson != null && productJson.trim().length()>0){
				product  = JSONObject.parseObject(productJson, Product.class);
			}else{
				//数据库获取
				product = productService.selectByPrimaryKey(productId);
				//存到redis
				if(product != null){
					String json = JSONObject.toJSON(product).toString();
					ops.set(key,json);
				}
			}
			return product;
		}
		return null;
	}
	
 

	
	
	
	
	
	//meta
	public ResourceUploadMetaContent getMetaItem(Integer batchId,String imageid){
		if(batchId != null){
			ValueOperations<String, String> ops = redisTemplate.opsForValue();
			String key = RedisContent.pre_cbatchmeta+batchId+":"+imageid;
			ResourceUploadMetaContent content = null;
			//redis缓存获取
			String contentJson = ops.get(key);
			if(contentJson != null && contentJson.trim().length()>0){
				content  = JSONObject.parseObject(contentJson, ResourceUploadMetaContent.class);
			}else{
				//数据库获取
				ResourceUploadMetaContentExample example=new ResourceUploadMetaContentExample();
				example.createCriteria().andBatchIdEqualTo(batchId).andImageNameEqualTo(imageid.trim());
				List<ResourceUploadMetaContent> lst = this.resourceUploadMetaContentService.selectByExample(example);
				if(lst.size()==0){
					return   null;
				}
				content = lst.get(0);
				if(content != null){
					String json = JSONObject.toJSON(content).toString();
					ops.set(key, json,12, TimeUnit.HOURS);  
				}
			}
			return   content;
		}
		return null;
	}
	
	public void putMetaItem(Integer batchId,String imageId,ResourceUploadMetaContent resourceUploadMetaContent){
		if(batchId != null && StringUtils.isNotBlank(imageId) && resourceUploadMetaContent!=null){
			ValueOperations<String, String> ops = redisTemplate.opsForValue();
			String key = RedisContent.pre_cbatchmeta+batchId+":"+imageId;
			ResourceUploadMetaContent content = null;
			String contentJson = JSONObject.toJSONString(resourceUploadMetaContent);
			if(contentJson != null && contentJson.trim().length()>0){
				ops.set(key, contentJson,12, TimeUnit.HOURS);  
			} 	 
	}
	
	}
	
	public void deleteMetaItem(Integer batchId,String imageId){
		if(batchId != null && StringUtils.isNotBlank(imageId)){
			ValueOperations<String, String> ops = redisTemplate.opsForValue();
			String key = RedisContent.pre_cbatchmeta+batchId+":"+imageId;
			ops.getOperations().delete(key);
	   }
	}
	
	
	
	//给社区的数据放到缓存
	public void putContractApplication(String userId,Object o){
		String key = RedisContent.pre_contract_application+userId;
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		 
		String json = JSONObject.toJSON(o).toString();
		System.out.println("社区数据加入redis,key:"+key+",value:"+json);
		ops.set(key,json);
		 
	}
	
	public void deleteContractApplication(String userId){
		if(userId != null && StringUtils.isNotBlank(userId)){
			ValueOperations<String, String> ops = redisTemplate.opsForValue();
			String key = RedisContent.pre_contract_application+userId;
			ops.getOperations().delete(key);
	   }
	}
	
	public String getContractApplication(String userId){
		if(userId != null && StringUtils.isNotBlank(userId)){
			ValueOperations<String, String> ops = redisTemplate.opsForValue();
			String key = RedisContent.pre_contract_application+userId;
			String contractApplicationJson = ops.get(key);
			return contractApplicationJson;
		}
		return "";
	}
	
	
}
