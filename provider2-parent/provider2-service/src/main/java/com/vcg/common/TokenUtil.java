package com.vcg.common;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class TokenUtil {
	
	private static final String st="VCG-ME-";
	
	private static final String split = ";;;";
	
	

	private static final String prefix = "_vcg!@#_";
	
	
	

	public static String encode(String user) {

		return DESCoder.encrypt(prefix + split + user);
	}

	public static String decode(String token) {
		String v = DESCoder.decrypt(token);

		if (v != null && v.startsWith(prefix)) {

			String arr[] = v.split(split);
			if (arr != null && arr.length == 2) {

				return arr[1];
			}
		}

		return null;
	}

	public static String createToken(String userId, Object expires) {
		return createToken(userId, null, expires);
	}

	public static String createToken(String userId, String userName, Object expires) {
		long exp = 7776000;
		try {
			if (!StringUtils.isBlank(expires.toString())) {
				exp = Long.parseLong(expires.toString());
			}
		} catch (Exception e) {
		}

		Token token = new Token(userId, exp);
		token.setUserName(userName);
		String tokenStr = encode(JSON.toJSONString(token));
		// 为了兼容cas php客户端, php正则匹配必须是以ST-开头
		return tokenStr;
	}

	public static boolean validateToken(String token) {
		try {
			String decode = decode(token);
			JSONObject parseObject = JSON.parseObject(decode);
			Long createDate = parseObject.getLong("createDate");
			Long expires = parseObject.getLong("expires");
			long tokenTimeOut = createDate + expires;
			long currentTimeMillis = System.currentTimeMillis();
			if (tokenTimeOut > currentTimeMillis) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String getTokenKey(String token) {
		String[] split = token.split("VCG@");
		return decode(split[split.length - 1]);
	}

	public static Token decodeToken(String token) {
		String decode = decode(token);
		return JSON.parseObject(decode, Token.class);
	}

	public static void main(String[] args) {
		
		// String createToken = createToken("123456", 70000+"");
		// System.out.println(createToken);
		// String tokenKey =
		// getTokenKey("6B7E8DE33C6F30B827CC0BF04E1971E5DBB6ACF90C047FA1BE8CE3A17AB515E813D3650D2D4F4323C08BEB51FFC39C3D7A551C62B67D98BD593E836917C91EA11691E1E62EE2BD0703D5E2A65939FD6DVCG@6B7E8DE33C6F30B837F814498C4B09781E68FFACA1085AD7");
		// String decode =
		// decode("6B7E8DE33C6F30B827CC0BF04E1971E5DBB6ACF90C047FA17B667F1E8CC99BFEC4D477F798C9C39BC08BEB51FFC39C3DB95F131277E883E9593E836917C91EA1749DC8B425CFD61A63B5FA25264737BA2373D0FF281C075589EF63BDDB7CBB6D9E944DA31B7F8B02");
		// System.out.println(decode);
		// System.out.println(encode("fbj"));
		// boolean validateToken =
		// validateToken("6B7E8DE33C6F30B827CC0BF04E1971E5DBB6ACF90C047FA1BE8CE3A17AB515E80D7CF3D2E4B8E94CC08BEB51FFC39C3D7A551C62B67D98BD593E836917C91EA11691E1E62EE2BD0703D5E2A65939FD6DVCG@6B7E8DE33C6F30B837F814498C4B09781E68FFACA1085AD7");
		// System.out.println(validateToken);
		// System.out.println(tokenKey);
		String tokenKey = decode(
				"6B7E8DE33C6F30B827CC0BF04E1971E5DBB6ACF90C047FA12BF7FA718325F87DDB909922F6E21075C08BEB51FFC39C3D66B7850E068202E6E45C4079351EF693B09EF946B1D0A05F34A6F893C9B441821D1BD39DC08AC4ADE1FD1FE913F8933B5692942D9A022FB93DB7B1D81C9C03199C6545C4FCD7DFBA");
		//System.out.println(tokenKey);
		
		String createToken = createToken("qazwsx", null);
		System.out.println(tokenKey);
	}

}
