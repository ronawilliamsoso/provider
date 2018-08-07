package com.vcg.common;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	/**
	 * 获取泛型的Collection Type
	 * @param jsonStr json字符串
	 * @param collectionClass 泛型的Collection
	 * @param elementClasses 元素类型
	 */
	public static <T> T readJson(String jsonStr, Class<?> collectionClass, Class<?>... elementClasses) throws Exception {

	       ObjectMapper mapper = new ObjectMapper();

	       JavaType javaType = mapper.getTypeFactory().constructParametrizedType(collectionClass,collectionClass, elementClasses);

	       return mapper.readValue(jsonStr, javaType);
	}
}
