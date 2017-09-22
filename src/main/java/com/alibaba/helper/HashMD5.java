package com.alibaba.helper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMD5 {
//MD5哈希
public static String getMD5(String input) {
		
		String md5 = null;
		
		if(null == input) return null;
		
		try {
			
		//创建一个emssagedigest 哈希算法，指定算法是Md5，sha1，sha256，sha512
		MessageDigest digest = MessageDigest.getInstance("MD5");
		
		//输入消息
		digest.update(input.getBytes(), 0, input.length());

		//把加密数据在转换为16进制(hex) 
		md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		return md5;
	}
//MD5哈希 方法重载
public static String getMD5(String input,String salt){
	String intputTemp=input+salt;
	String result= getMD5(intputTemp);
	 return result;
}

}
