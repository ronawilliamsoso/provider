package com.vcg.common;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESCoder {

	private final static String DES = "DES";
	private final static byte[] privateKey = "45^&*(qw".getBytes();

	public static String encrypt(String content) {
		// DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		try {
			// 从原始密匙数据创建DESKeySpec对象
			DESKeySpec dks = new DESKeySpec(privateKey);
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
			SecretKey securekey = keyFactory.generateSecret(dks);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance(DES);
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
			// 正式执行加密操作
			return byte2String(cipher.doFinal(content.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

	/**
	 * 
	 * @param content
	 *            数据源
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String content) {
		// DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		try {
			// 从原始密匙数据创建一个DESKeySpec对象
			DESKeySpec dks = new DESKeySpec(privateKey);
			// 创建一个密匙工厂，然后用它把DESKeySpec对象转换成一个SecretKey对象
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
			SecretKey securekey = keyFactory.generateSecret(dks);
			// Cipher对象实际完成解密操作
			Cipher cipher = Cipher.getInstance(DES);
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

			// 正式执行解密操作
			return new String(cipher.doFinal(string2byte(content.getBytes())));
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

	public static String byte2String(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();
	}

	public static byte[] string2byte(byte[] b) {
		if ((b.length % 2) != 0)
			throw new IllegalArgumentException("长度不是偶数");
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}

	public static void main(String[] args) {
		String key = "12";
		String encryptString = encrypt(key);
		System.out.println(encryptString);
		System.out.println(decrypt(encryptString));
		System.out.println(decrypt(encryptString).equals(key));
	}

	// 输出：B00542E93695F4CFCE34FC4393C2F4BF

}
