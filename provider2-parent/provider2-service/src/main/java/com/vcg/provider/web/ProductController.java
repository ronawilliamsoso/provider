package com.vcg.provider.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.vcg.common.DateUtils;
import com.vcg.common.RestTemplateFactory;
import com.vcg.common.RestfulResult;
import com.vcg.common.RestfulResultFactory;
import com.vcg.common.Status;
import com.vcg.provider.entity.KCategory;
import com.vcg.provider.entity.SearchCollection;
import com.vcg.provider.entity.SearchProductBrand;
import com.vcg.provider.entity.SearchTopic;
import com.vcg.provider.model.Brand;
import com.vcg.provider.model.Collection;
import com.vcg.provider.model.Contract;
import com.vcg.provider.model.Product;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.query.BrandExample;
import com.vcg.provider.model.query.CollectionExample;
import com.vcg.provider.model.query.ContractExample;
import com.vcg.provider.model.query.ProductExample;
import com.vcg.provider.model.query.ProviderExample;
import com.vcg.provider.service.BrandService;
import com.vcg.provider.service.CollectionService;
import com.vcg.provider.service.ContractService;
import com.vcg.provider.service.ProductService;
import com.vcg.provider.service.ProviderService;
import com.vcg.provider.util.AccountUtil;
import com.vcg.provider.util.RedisUtil;
import com.vcg.provider.util.SearchEngineUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private BrandService brandService;
	
	@Autowired
	private CollectionService collectionService;
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private AccountUtil accountUtil;
	
	@Autowired
	private SearchEngineUtil searchEngineUtil;
	
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private ContractService contractService;
	
	@Value("${topic.resourceservice}")
	private String resourceservice;
	
	
	
	
	@ApiOperation(value = "产品管理-<产品查询>", notes = "产品管理-<产品查询>")
	@RequestMapping(value="/treeList",method={RequestMethod.POST})
	public Object pageList(){
		
		ProductExample example=new ProductExample();
		List<Product> lst = this.productService.selectByExample(example);
		Map<String,Object> result = new  HashMap<String,Object>();
		result.put("code", 200);
		result.put("data", lst );
		result.put("msg", "ok");
		result.put("total", this.productService.countByExample(example));
		return result;
		 
	}
	

	
	
	@ApiOperation(value = "产品管理-<有效,失效>", notes = "产品管理-<有效,失效>")
	@RequestMapping(value="/setStatus",method={RequestMethod.POST})
	public Object setStatus(@ApiParam(required = true,value = "本行的产品id,如1") @RequestParam Integer id,@ApiParam(required = true,value = "1:有效0:失效") @RequestParam Integer productStatus, @RequestParam String token){
		String userId = accountUtil.getUserId(token);
        Product update=new Product();
        update.setId(id);
        update.setProductStatus(productStatus);
        update.setUpdatedBy(userId);
        update.setUpdatedTime(DateUtils.getNowDate());
        productService.updateByPrimaryKeySelective(update);
        redisUtil.deleteRedisProduct(id);
		return RestfulResultFactory.getInstance(200, null,  "成功");
		 
	}
//	
//	
//	@RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST})
//	public Object list(@RequestBody(required=false) Product product){
//		
//		ProductExample example=new ProductExample();
//		//TODO Product 与 example关联
//		
//		
//		List<Product> lst = this.productService.selectByExample(example);
//		return  lst;
//	}
	
	
	@ApiOperation(value = "产品管理-<新建产品>", notes = "产品管理-<新建产品>")
	@RequestMapping(value="/create",method={RequestMethod.POST})
	public RestfulResult create(@RequestBody Product product, @RequestParam String token){
		
		String userId = accountUtil.getUserId(token);
//		if(StringUtil.isEmpty(product.getFormula())){
//			return RestfulResultFactory.getInstance(Status.ERROR, null,  "公式必须有值");
//		}
		if(StringUtil.isEmpty(product.getProductName())){
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "公式必须有名字");
		}
		if(product.getParentId()==null){
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "公式必须有上级");
		}
//		if(product.getPriceLimitlevel()==null){
//			return RestfulResultFactory.getInstance(Status.ERROR, null,  "公式必须有限价等级");
//		}
//		if(StringUtils.isBlank(product.getMinPrice()) ){
//			return RestfulResultFactory.getInstance(Status.ERROR, null,  "公式必须有最低价");
//		}
		 
		product.setCreatedBy(userId);
		product.setProductStatus(2);//1有效0是无效 2新建
		 
		
		 this.productService.insertSelective(product);
		 
		 return RestfulResultFactory.getInstance(200, null,  "ok");
		
	}
	@ApiOperation(value = "产品管理-<brand下拉列表>", notes = "产品管理-<brand列表>")
	@RequestMapping(value="/brandList",method={RequestMethod.POST})
	public Object brandList(@RequestBody SearchProductBrand requestParam ){
		if(StringUtils.isNotBlank(requestParam.getSearchName())  && requestParam.getSearchType()==null ){
			return RestfulResultFactory.getInstance(Status.ERROR, null,  "SearchType为空!");
		}
		BrandExample example=new BrandExample();
		com.vcg.provider.model.query.BrandExample.Criteria  criteria  = example.createCriteria();
//			 1:Brand名字  2:Brand id  
		
		if(requestParam.getSearchName()!=null&&StringUtils.isNotBlank(requestParam.getSearchName())){
			String searchName  = requestParam.getSearchName();
			if(requestParam.getSearchType()==1 ){
				searchName = "%" + searchName + "%";
			}
			if(requestParam.getSearchType()==1){
				criteria.andBrandNameLike(searchName).andBrandStatusEqualTo(1);
			}else if(requestParam.getSearchType()==2 ){
				criteria.andIdEqualTo(Integer.parseInt(searchName)).andBrandStatusEqualTo(1);
			} 
		}
		

		PageHelper.startPage(requestParam.getPageNum(), requestParam.getPageSize());
		List<Brand> list = this.brandService.selectByExample(example);
		Map<String,Object> result = new  HashMap<String,Object>();
		result.put("status", 200);
		result.put("msg", "ok");
		if(list.size()>0){
			List<Map<String,Object>> ret = new ArrayList<Map<String,Object>>();
			list.forEach(e->{
				Map<String,Object> map = new  HashMap<String,Object>();
				map.put("id", e.getId());
				map.put("brandName", e.getBrandName());
				ret.add(map);
				});
			result.put("data", ret);
			result.put("total", this.brandService.countByExample(example));
		}else{
			result.put("data", null);
			result.put("total", 0);
		}
		return result;
	}	
	
	@ApiOperation(value = "产品管理-<获取分类树形结构的下级数据>", notes = "产品管理-<分类树形结构的下级数据>")
	@RequestMapping(value="/getChildCategory",method={RequestMethod.POST})
	public Object getChildCategory(@ApiParam(value = "-1获取所有,0获取一级") @RequestParam Integer id ){
		 if(id==-1){
			 id=null;
		 }
		List<KCategory> list = searchEngineUtil.getCategory(id);
		return RestfulResultFactory.getInstance(200, list,  "成功获得下级数据");
	}
	
	
	
	@ApiOperation(value = "产品管理-<专题下拉列表>", notes = "产品管理-<专题下拉列表>")
	@RequestMapping(value="/topicList",method={RequestMethod.POST})
	public Object topicList(@RequestBody(required=true)SearchTopic requestParam ){
		String url = "";
		JSONObject topic=null;
		if(requestParam.getSearchName()!=null&&StringUtils.isNotBlank(requestParam.getSearchName())){
			if(requestParam.getSearchType()==1){   
				    url =  resourceservice+"getTopicByTitle?keyword=";
				    //http://192.168.3.205:7700/api/topic/getTopicByTitle?keyword=CBA&pageNum=1&pageSize=20
				    url=url+requestParam.getSearchName()+"&pageNum="+requestParam.getPageNum()+"&pageSize="+requestParam.getPageSize();
				    
				    
					RestTemplate rt= RestTemplateFactory.getTemplate();
					topic = rt.getForObject(url, JSONObject.class);
					
					
					
					if(topic!=null){
						
						topic.replace("status", 200); 
						 
					 
						JSONObject data= topic.getJSONObject("data");
						Integer total = data.getInteger("count");
						data.put("total", total);
						JSONObject dat  = (JSONObject) data.clone();
						dat.remove("count");
						topic.remove("data");
						topic.put("data", dat);
					}
					
					
			}else if(requestParam.getSearchType()==2 && StringUtils.isNumeric(requestParam.getSearchName())){
				    url =  resourceservice+ "getTopicByID?id=";
				    url = url+requestParam.getSearchName();
					RestTemplate rt= RestTemplateFactory.getTemplate();
					topic = rt.getForObject(url, JSONObject.class);
					
					if(topic!=null){
						
						topic.replace("status", 200); 
					}
			}  
        }
 


        return  topic;
 		
//		System.err.println(infomsg);
//		
//		RestTemplate rs = new RestTemplate();
//		JSONObject re = rs.postForObject(url, param, JSONObject.class);
		
		
//		TopicExample example=new TopicExample();
//		String name = "";
//		 if(requestParam.getSearchName()!=null&&StringUtils.isNotBlank(requestParam.getSearchName())){
//				if(requestParam.getSearchType()==1){   
//					name = "%" + requestParam.getSearchName() + "%";  
//					example.createCriteria().andTopicNameLike(name);
//				}else if(requestParam.getSearchType()==2 && StringUtils.isNumeric(requestParam.getSearchName())){
//					example.createCriteria().andIdEqualTo(Integer.parseInt(requestParam.getSearchName()));
//				}  
//		 }
//		PageHelper.startPage(requestParam.getPageNum(), requestParam.getPageSize());
//		List<Topic> list = this.topicService.selectByExample(example);
//		
//		List<Map<String,Object>> ret = new ArrayList<Map<String,Object>>();
// //result.put("total",editGroupResourceService.countByExample(countEx));
//		list.forEach(e->{
//			Map<String,Object> map = new  HashMap<String,Object>();
//			map.put("id", e.getId());
//			map.put("topicName", e.getTopicName());
//			ret.add(map);
//			});
//		Map<String,Object> result = new  HashMap<String,Object>();
//		result.put("code", 200);
//		result.put("data", ret);
//		result.put("msg", "ok");
//		result.put("total", this.topicService.countByExample(example));
//		return RestfulResultFactory.getInstance(200, result,  "成功");
	}
	
	@ApiOperation(value = "产品管理-<collection下拉列表>", notes = "产品管理-<collection下拉列表>")
	@RequestMapping(value="/collectionList",method={RequestMethod.POST})
	public Object collectionList(@RequestBody(required=true)SearchCollection requestParam ){
		Map<String,Object> result = new  HashMap<String,Object>();
		List<Collection> list = null;
		 if(requestParam.getSearchType()==null){
			 return RestfulResultFactory.getInstance(Status.ERROR, null,  "搜索类型为空");
		 }
 
		 //1:查机构名,如'王威雪敏' 2:查brand名,如Aurora 3:查collection名,如:'Sino Images' 4:供应商id 5:brand Id 6:collectionId 7:合同id 8:合同名称
		 List<Integer> intlist = null;
			CollectionExample cexample=new CollectionExample();
			
		 if(requestParam.getSearchName()!=null&&StringUtils.isNotBlank(requestParam.getSearchName())){
			 String	searcName = "";  
			 if(requestParam.getSearchType() ==4||requestParam.getSearchType() ==5||requestParam.getSearchType() ==6||requestParam.getSearchType() ==7){
				 	searcName =   requestParam.getSearchName();
			 }else if(requestParam.getSearchType() ==1||requestParam.getSearchType() ==2||requestParam.getSearchType() ==3||requestParam.getSearchType() ==8){
				    searcName = "%"+  requestParam.getSearchName() + "%";
			 }
				
				
				if(requestParam.getSearchType() ==1){//1:查机构名 2:查brand名3:查collection名
					ProviderExample example = new ProviderExample();
					example.createCriteria().andNameCnLike(searcName).andStatusEqualTo(3);
					List<Provider> plist = providerService.selectByExample(example);
					if(plist.size()==0){
						result.put("status", 200);
						result.put("data", list);
						result.put("msg", "ok");
						result.put("total",0);
						return  result;
					}
					intlist = plist.stream().map(e->e.getId()).collect(Collectors.toList());
					cexample.createCriteria().andProviderIdIn(intlist);
					
				}else if(requestParam.getSearchType() ==3){
					cexample.createCriteria().andNameLike(searcName);
				}else if(requestParam.getSearchType() ==2 ){
					BrandExample example=new BrandExample();
					example.createCriteria().andBrandNameLike(searcName);
					List<Brand> blist = brandService.selectByExample(example);
					if(blist.size()==0){
						result.put("status", 200);
						result.put("data", list);
						result.put("msg", "ok");
						result.put("total",0);
						return  result;
					}
					intlist = blist.stream().map(e->e.getId()).collect(Collectors.toList());
					cexample.createCriteria().andBrandIdIn(intlist);
				}else if(requestParam.getSearchType() ==4 && StringUtils.isNumeric(searcName)){
					cexample.createCriteria().andProviderIdEqualTo(Integer.parseInt(searcName));
				}else if(requestParam.getSearchType() ==5 && StringUtils.isNumeric(searcName)){//5:brand Id 6:collectionId 7:合同id 8:合同名称
					cexample.createCriteria().andBrandIdEqualTo(Integer.parseInt(searcName));
				}else if(requestParam.getSearchType() ==6 && StringUtils.isNumeric(searcName)){
					cexample.createCriteria().andIdEqualTo(Integer.parseInt(searcName));
				}else if(requestParam.getSearchType() ==7 && StringUtils.isNumeric(searcName)){
					cexample.createCriteria().andContractIdEqualTo(Integer.parseInt(searcName));
				}else if(requestParam.getSearchType() ==8 ){
					ContractExample example = new ContractExample();
					example.createCriteria().andContractNameLike(searcName).andContractStatusEqualTo(1);
					List<Contract> clist = contractService.selectByExample(example);
					if(clist.size()==0){
						result.put("status", 200);
						result.put("data", list);
						result.put("msg", "ok");
						result.put("total",0);
						return  result;
					}
					intlist = clist.stream().map(e->e.getId()).collect(Collectors.toList());
					cexample.createCriteria().andContractIdIn(intlist);
				}
			 
		 }
		 
		 
		
		cexample.setColunms(Arrays.asList("id","name"));
		PageHelper.startPage(requestParam.getPageNum(), requestParam.getPageSize());
		list = collectionService.selectByExample(cexample);
		List<Map<String,Object>> ret = new ArrayList<Map<String,Object>>();
		list.forEach(e->{
			Map<String,Object> map = new  HashMap<String,Object>();
			map.put("id", e.getId());
			map.put("name", e.getName());
			ret.add(map);
			});
		
		result = new  HashMap<String,Object>();
		result.put("code", 200);
		result.put("data", ret);
		result.put("msg", "ok");
		result.put("total", this.collectionService.countByExample(cexample));
		return  result;
 
		 
 
	}

	@ApiOperation(value = "产品管理-<删除>", notes = "产品管理-<删除>")
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Object delete(@RequestParam  Integer  id){
		   productService.deleteByPrimaryKey(id);
		 return RestfulResultFactory.getInstance(200, null,  "ok");
	}
 
}
