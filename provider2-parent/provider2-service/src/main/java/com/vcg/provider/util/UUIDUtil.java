package com.vcg.provider.util;

 

import java.util.Random;
import java.util.UUID;

/**
 * 生成UUID
 * 
 * @author 19128_000
 * 
 */
public class UUIDUtil {

	static Random random = new Random();

	public static String generateUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {

			String generateUUID = generateUUID();
			System.out.println(generateUUID);
		}
		
	}
}
