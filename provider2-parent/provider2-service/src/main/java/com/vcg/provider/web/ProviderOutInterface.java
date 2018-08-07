package com.vcg.provider.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vcg.common.AbstractController;
import com.vcg.common.RestfulResultFactory;
import com.vcg.common.ResultMap;
import com.vcg.provider.model.Brand;
import com.vcg.provider.model.Collection;
import com.vcg.provider.model.Product;
import com.vcg.provider.model.Provider;
import com.vcg.provider.model.query.BrandExample;
import com.vcg.provider.model.query.ProductExample;
import com.vcg.provider.model.query.ProviderExample;
import com.vcg.provider.model.query.ProviderExample.Criteria;
import com.vcg.provider.ro.ProductRO;
import com.vcg.provider.service.BrandService;
import com.vcg.provider.service.CollectionService;
import com.vcg.provider.service.ProductService;
import com.vcg.provider.service.ProviderService;
import com.vcg.provider.util.RedisUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "供应商对外接口", description="供应商对外接口")
@RestController
@RequestMapping("/outInterface")
public class ProviderOutInterface extends AbstractController {
	
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProviderService providerService;	
	 
	@Autowired
	private CollectionService collectionService;
	
	@Autowired
	private RedisUtil providerUtil;
	
	@Autowired
	private BrandService brandService;
	
 
	
	
	/**
	 * 根据parentId查询产品
	 * @param parentId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/productList",method={RequestMethod.GET})
	public Object productList( HttpServletRequest request){

		ProductExample example=new ProductExample();
		//example.createCriteria().andParentIdEqualTo(parentId);
		List<Product> lst = this.productService.selectByExample(example);
		Map<Integer, List<Product>> beans = lst.stream().collect(Collectors.groupingBy(Product::getParentId));
		//根节点
		Product root = productService.selectByPrimaryKey(1);
		ProductRO rootRo=new ProductRO();
		BeanUtils.copyProperties(root, rootRo);
		getChilds(beans,rootRo);
		
		if(super.isJava(request)){
			return rootRo;
		}else{
			return RestfulResultFactory.getInstance(rootRo);
		}
		
	}
	
	
	@ApiOperation(value = "brand管理-<所有有效的brand>", notes = "brand管理-<所有的brand>")
	@RequestMapping(value="/brandList",method={RequestMethod.POST})
	public Object list(){
		
		BrandExample example=new BrandExample();
		example.setColunms(Arrays.asList("id","brand_name"));
		com.vcg.provider.model.query.BrandExample.Criteria criteria= example.createCriteria();
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
		}
		
		
		return result;
	}	
	
	/**
	 * 递归得出所有产品
	 * @param beans
	 * @param ro
	 */
	private void getChilds(Map<Integer, List<Product>> beans,ProductRO ro){
		List<Product> one = beans.get(ro.getId());
		if(one!=null){
			one.forEach(e->{
				ProductRO oneRo=new ProductRO();
				BeanUtils.copyProperties(e, oneRo);
				ro.getChildren().add(oneRo);
				getChilds(beans, oneRo);
			});
		}
	}
	
	
	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/collectionView",method=RequestMethod.GET)
	public Object collectionView(@RequestParam Integer id,HttpServletRequest request){
		
		  Collection collection = providerUtil.getCollection(id);
		 
		 if(super.isJava(request)){
				return collection;
			}else{
				return RestfulResultFactory.getInstance(collection);
			}
	}
	
	
	
	/**
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/productView",method=RequestMethod.GET)
	public Object productView(@RequestParam Integer id,HttpServletRequest request){
		
		 Product product = providerUtil.getProduct(id);
		 
		 if(super.isJava(request)){
				return product;
			}else{
				return RestfulResultFactory.getInstance(product);
			}
	}
	

	
	/**
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/providerView",method=RequestMethod.GET)
	public Object providerView(@RequestParam Integer id,HttpServletRequest request){
		
		Provider provider =providerUtil.getProvider(id);
		 
		if (super.isJava(request)) {
			return provider;
		} else {
			return RestfulResultFactory.getInstance(provider);
		}
		
	}
	
	/**
	 * @param ids
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/findCollectionByIds",method=RequestMethod.GET)
	public Object findCollectionByIds(@RequestParam String ids,HttpServletRequest request){
		
		 List<Collection> collections=new ArrayList<Collection>();
		 
		 for(String id:ids.split(",")){
			 if(StringUtils.isNotBlank(id)){
				 Collection collectionView = providerUtil.getCollection(Integer.parseInt(id));
				 if(collectionView!=null){
					 collections.add(collectionView);
				 }
				
			 }
		 }
		 
		 if(super.isJava(request)){
				return collections;
			}else{
				return RestfulResultFactory.getInstance(collections);
			}
	}
	
	/**
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/findCollectionsByProviderId",method=RequestMethod.GET)
	public Object findCollectionsByProviderId(@RequestParam Integer id,HttpServletRequest request){
		 List<Collection> list  = collectionService.getCollectionByProviderId(id);
		 if(super.isJava(request)){
				return list;
			}else{
				return RestfulResultFactory.getInstance(list);
			}
	}
	
	
	/**
	 * @param ids
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/findBrandByIds",method=RequestMethod.GET)
	public Object findBrandByIds(@RequestParam String ids,HttpServletRequest request){
		
		 List<Brand> brands=new ArrayList<Brand>();
		 
		 for(String id:ids.split(",")){
			 if(StringUtils.isNotBlank(id)){
				 Brand brandView = providerUtil.getBrand(Integer.parseInt(id));
				 if(brandView!=null){
					 brands.add(brandView);
				 }
				
			 }
		 }
		 
		 if(super.isJava(request)){
				return brands;
			}else{
				return RestfulResultFactory.getInstance(brands);
			}
	}
	
	/**
	 * @param ids
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/findBrandById",method=RequestMethod.GET)
	public Object findBrandById(@RequestParam(required=false) String id,HttpServletRequest request){
		 Brand brandView = new Brand();
		 if(StringUtils.isNotBlank(id)&&StringUtils.isNumeric(id)){
			 	
			  brandView = providerUtil.getBrand(Integer.parseInt(id));
		 }else{
			 return null;
		 }
		 if(super.isJava(request)){
				return brandView;
		 }else{
				return RestfulResultFactory.getInstance(brandView);
		 }
	}
	
	
	
	/**
	 * @param ids
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/findProductByIds",method=RequestMethod.GET)
	public Object findProductByIds(@RequestParam String ids,HttpServletRequest request){

		 List<Product> collections=new ArrayList<Product>();
		 
		 for(String id:ids.split(",")){
			 if(StringUtils.isNotBlank(id)){
				 Product productView = providerUtil.getProduct(Integer.parseInt(id));
				 if(productView!=null){
					 collections.add(productView);
				 }
			 }
		 }
		 
		 if(super.isJava(request)){
				return collections;
			}else{
				return RestfulResultFactory.getInstance(collections);
			}
	}
	
	
	
	/**
	 * 查询供应商
	 * @param ids
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/findProviderByIds",method=RequestMethod.GET)
	public Object findProviderByIds(@RequestParam String ids,HttpServletRequest request){
		

		 List<Provider> collections=new ArrayList<Provider>();
		 
		 for(String id:ids.split(",")){
			 if(StringUtils.isNotBlank(id)){
				 Provider providerView = providerUtil.getProvider(Integer.parseInt(id));
				 if(providerView!=null){
					 collections.add(providerView);
				 }
			 }
		 }
		 
		 if(super.isJava(request)){
				return collections;
			}else{
				return RestfulResultFactory.getInstance(collections);
			}
		
	}
	
	/**
	 * 查询供应商详细信息  给编审系统用
	 * @param ids
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/findProviderDetailInfo",method=RequestMethod.GET)
	public Object findProviderDetailInfo(@RequestParam Integer id,HttpServletRequest request){
		

		Map<String,Object> searchParam = new HashMap<String,Object>();
		searchParam.put("id", id);
		ResultMap result = this.queryService.queryOneForCustom("providerManage", "getProviderDetailedInfoForEdit", searchParam);//详情
		return result;
 
	}
	
	
	/**
	 * 查询供应商
	 * @param type
	 * @param asseFamily
	 * @param searchName
	 * @param pageNum
	 * @param pageSize
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/searchProvider",method=RequestMethod.GET)
	public Object searchProvider(@RequestParam(required=false) Integer type,@RequestParam(required=false) Integer asseFamily,
			@RequestParam(required=false) String searchName,@RequestParam(defaultValue="1") int pageNum,@RequestParam(defaultValue="10") int pageSize,
			HttpServletRequest request){
		
		ProviderExample pe=new ProviderExample();
		Criteria cre=pe.createCriteria();
		Criteria or=null;
		if(asseFamily!=null&&asseFamily.intValue()!=0){
			or=pe.or();
			cre.andAssetFamilyEqualTo(asseFamily);
			or.andAssetFamilyEqualTo(3);
		}
		
		if(type!=null){
			cre.andAgentTypeEqualTo(type);
			if(or!=null){
				or.andAgentTypeEqualTo(type);
			}
			
		}
		
		if(StringUtils.isNotBlank(searchName)){
			cre.andNameCnLike(searchName+"%");
			if(or!=null){
				or.andNameCnLike(searchName+"%");
			}
		}
	
		PageHelper.startPage(pageNum, pageSize);
		
		List<Provider> lst = this.providerService.selectByExample(pe);
		
		if (super.isJava(request)) {
			return new PageInfo<Provider>(lst);
		} else {
			return RestfulResultFactory.getInstance(new PageInfo<Provider>(lst));
		}
		
	}
	
}
