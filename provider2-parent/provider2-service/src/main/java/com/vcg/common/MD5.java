package com.vcg.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {

	private static String convertToHex(byte[] data) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			int halfbyte = (data[i] >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[i] & 0x0F;
			} while (two_halfs++ < 1);
		}
		return buf.toString();
	}

	public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return str;
	}

	public static String encodePassword(String password) {
		return md5(password);
	}

	// mysql 4.1之后的加密算法
	public static String encoderMySQLPassword(String plainText) {
		byte[] utf8=null;
		try {
			utf8 = plainText.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] test = DigestUtils.sha(DigestUtils.sha(utf8));
		return "*" + convertToHex(test).toUpperCase();

	}

	// mysql 4.1之前的password算法
	public static String getMySQLPasswordBefore(String password) {
		long nr = 1345345333L, add = 7, nr2 = 0x12345671L;
		long tmp = 0;
		for (int i = 0; i < password.length(); i++) {
			tmp = password.charAt(i);
			if (tmp == ' ' || tmp == '\t') {
				continue;
			}
			nr ^= (((nr & 63) + add) * tmp) + (nr << 8);
			nr2 += (nr2 << 8) ^ nr;
			add += tmp;
		}
		long result_1 = nr & (((long) 1L << 31) - 1L);
		long result_2 = nr2 & (((long) 1L << 31) - 1L);

		String str1 = Long.toHexString(result_1);
		String str2 = Long.toHexString(result_2);
		return str1.concat(str2);
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		//String mySQLPassword = encoderMySQLPassword("Fday@1668*");
		//String mySQLPasswordBefore = getMySQLPasswordBefore("Fday@1668*");
		//System.out.println(mySQLPassword);
		//System.out.println(mySQLPasswordBefore);
		System.out.println(md5("sinafashion2016516"));
	}
}
