package com.vcg.provider.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.vcg.common.RestfulResultFactory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.vcg.provider.util.SearchEngineUtil;


@RestController
@RequestMapping("/common")
public class CommonController {

	@Autowired
	private SearchEngineUtil searchEngineUtil;
	
 
	@ApiOperation(value = "获取地区的下级目录")
	@RequestMapping(value="/getChildLocations",method={RequestMethod.POST})
	public Object getChildLocations(@ApiParam(value = "0获取一级") @RequestParam Integer id ){
        Map<String, Object> param = new HashMap<String, Object>();
        if (id == 0) {//世界
            param.put("type", 1);
        } else {
            param.put("pid", id);
        }
        String searchResults = searchEngineUtil.searchLocations(param);
        Object json = JSON.toJSON(searchResults);
		return json;
	}
 
	
	
}
