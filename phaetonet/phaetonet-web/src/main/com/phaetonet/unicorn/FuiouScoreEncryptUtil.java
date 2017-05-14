package com.phaetonet.unicorn;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FuiouScoreEncryptUtil {

	public static Log log = LogFactory.getLog(FuiouScoreEncryptUtil.class);

	private final static String AES_CIPHER = "AES/CBC/NoPadding";
	private final static String AES_SECRET = "AES";

	public static void main(String[] args) {
		String radom = genRandom();
		System.out.println("radom:" + radom);
		System.out.println(md5(radom + "|LN201109|2013120200042510|0CA5EAE5E326D791E6231E3A71E92AB7" ));
		System.out.println(md5(radom + "|LN201109|2013120200042510|95|2017-04-01|2017-05-05|1|20|0CA5EAE5E326D791E6231E3A71E92AB7" ));
	}

	public static byte[] genKey() {
		byte[] result = null;
		try {
			// KeyGenerator提供对称密钥生成器的功能，支持各种算法
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			keygen.init(128, new SecureRandom());
			// SecretKey负责保存对称密钥
			SecretKey deskey = keygen.generateKey();
			result = deskey.getEncoded();
		} catch (NoSuchAlgorithmException e) {
			log.warn("[AES密钥生成]系统不支持AES算法", e);
		}
		return result;
	}

	public static byte[] genMD5Key() {
		byte[] result = null;
		try {
			// KeyGenerator提供对称密钥生成器的功能，支持各种算法
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			keygen.init(128, new SecureRandom());
			// SecretKey负责保存对称密钥
			SecretKey deskey = keygen.generateKey();
			result = deskey.getEncoded();
		} catch (NoSuchAlgorithmException e) {
			log.warn("[AES密钥生成]系统不支持AES算法", e);
		}
		return result;
	}

	private static final char[] h = "0123456789ABCDEF".toCharArray();

	private static Map<Character, Integer> hs = new HashMap<Character, Integer>();
	static {
		for (int i = 'A'; i <= 'F'; i++) {
			hs.put(((char) i), i - 'A' + 10);
		}
		for (int i = 'a'; i <= 'f'; i++) {
			hs.put(((char) i), i - 'a' + 10);
		}
		for (int i = '0'; i <= '9'; i++) {
			hs.put(((char) i), i - '0');
		}
	}

	/**
	 * 十六进制字符串转二进制数据流
	 * 把密钥两位两位的做位操作，前一位数左移4位或上后一位数然后组成新的一个byte
	 * @param hex
	 * @return
	 */
	public static byte[] h2b(String hex) {

		byte[] bs = new byte[hex.length() / 2];
		int i = 0;
		char[] s = hex.toCharArray();
		for (int j = 0; j < s.length;) {
			bs[i++] = (byte) ((hs.get(s[j++]) << 4) | hs.get(s[j++]));
		}
		for(byte b:bs){
			System.out.print(b+" ");
		}
		System.out.println();
		return bs;
	}

	/**
	 * 二进制数据流转十六进制字符串
	 *
	 * @param bytes
	 * @return
	 */
	public static String h2s(byte[] bytes) {

		StringBuilder s = new StringBuilder();
		for (byte b : bytes) {
			s.append(h[(b >>> 4) & 0xF]);
			s.append(h[b & 0xF]);
		}

		return s.toString();
	}

	/**
	 * AES加密
	 *
	 * @param data
	 *            明文
	 * @param key
	 *            密钥
	 * @return 密文
	 */
	public static String encrypt(String data, String key) {
		log.debug("[AES加密]加密前--明文 : " + data + "; 加密密钥 : " + key);

		int len = data.length();
		StringBuilder d = new StringBuilder();
		d.append(leftFill(len, 2, "0"));
		d.append(rightFill(data, 14, "F"));
		String tmp = null;
		String result = h2s(encrypt((tmp = d.toString()).getBytes(), h2b(key)));
		log.debug("[AES加密]加密后--明文 : " + data + "(" + tmp + "); 加密密钥 : " + key
				+ "; 加密密文 : " + result);
		return result;
	}

	/**
	 * AES解密
	 *
	 * @param data
	 *            密文
	 * @param key
	 *            密钥
	 * @return 明文
	 */
	public static String decrypt(String data, String key) {
		log.debug("[AES解密]解密前--密文 : " + data + "; 解密密钥 : " + key);
		byte[] bytes = decrypt(h2b(data), h2b(key));
		log.debug("[AES解密]解密结束 : " + (bytes == null ? "null" : h2s(bytes)));
		String result = bytes == null ? null : new String(bytes);
		if (result != null && result.length() > 1) {
			int len = Integer.valueOf(result.substring(0, 2));
			if (len + 2 <= result.length())
				result = result.substring(2, len + 2);
		}
		log.debug("[AES解密]解密后--密文 : " + data + "; 解密密钥 : " + key + "; 解密明文 : "
				+ result);
		return result;
	}

	/**
	 * AES加密方法
	 *
	 * @param data
	 *            待加密明文
	 * @param key
	 *            加密密钥
	 * @return
	 */
	public static byte[] encrypt(byte[] data, byte[] key) {

		byte[] encryptedData = null;
		try {
			Cipher cipher = Cipher.getInstance(AES_CIPHER);// 创建密码器
			IvParameterSpec iv = new IvParameterSpec(key);
			SecretKeySpec sp = new SecretKeySpec(createKey(key), AES_SECRET);
			cipher.init(Cipher.ENCRYPT_MODE, sp, iv);// 初始化
			// 执行加密操作
			encryptedData = cipher.doFinal(data);
		} catch (NoSuchAlgorithmException e) {
			log.warn("[AES加密]系统不支持AES算法", e);
		} catch (InvalidKeyException e) {
			log.warn("[AES加密]非法的密钥格式", e);
		} catch (NoSuchPaddingException e) {
			log.warn("[AES加密]加密算法运算出错", e);
		} catch (IllegalBlockSizeException e) {
			log.warn("[AES加密]加密数据块大小不正确", e);
		} catch (BadPaddingException e) {
			log.warn("[AES加密]错误的加密数据封装", e);
		} catch (InvalidAlgorithmParameterException e) {
			log.warn("[AES加密]错误的加密算法参数", e);
		}
		return encryptedData;
	}

	/**
	 * AES解密算法
	 *
	 * @param data
	 *            待解密密文
	 * @param key
	 *            解密密钥
	 * @return
	 */
	public static byte[] decrypt(byte[] data, byte[] key) {
		byte[] decryptedData = null;

		try {
			Cipher cipher = Cipher.getInstance(AES_CIPHER);// 创建密码器
			IvParameterSpec iv = new IvParameterSpec(key);
			SecretKeySpec sp = new SecretKeySpec(createKey(key), AES_SECRET);

			cipher.init(Cipher.DECRYPT_MODE, sp,iv);// 初始化

			// 执行加密操作
			decryptedData = cipher.doFinal(data);

		} catch (NoSuchAlgorithmException e) {
			log.warn("[AES解密]系统不支持AES算法", e);
		} catch (InvalidKeyException e) {
			log.warn("[AES解密]解法的密钥格式", e);
		} catch (NoSuchPaddingException e) {
			log.warn("[AES解密]解密算法运算出错", e);
		} catch (IllegalBlockSizeException e) {
			log.warn("[AES解密]解密数据块大小不正确", e);
		} catch (BadPaddingException e) {
			log.warn("[AES解密]错误的解密数据封装", e);
		} catch (InvalidAlgorithmParameterException e) {
			log.warn("[AES加密]错误的解密算法参数", e);
		}

		return decryptedData;
	}

	public static byte[] createKey(byte[] key) {
		return key;
//		String algorithmName = "";
//		try {
//			algorithmName = "AES";
//			KeyGenerator kgen = KeyGenerator.getInstance(algorithmName);
//			algorithmName = "SHA1PRNG";
//			SecureRandom secureRandom = SecureRandom.getInstance(algorithmName);
//			secureRandom.setSeed(key);
//			kgen.init(128, secureRandom);
//			SecretKey secretKey = kgen.generateKey();
//			return secretKey.getEncoded();
//		} catch (NoSuchAlgorithmException e) {
//			log.warn("[密钥生成]系统不支持此算法", e);
//		}
//		return null;
	}

	public static String genRandom() {
		java.util.Random r=new java.util.Random();

		Long genRandom = null;
		do {
			genRandom = r.nextLong();
		} while (genRandom < 0);

		return String.valueOf(genRandom);
	}

	public static String md5(String... args) {
		StringBuilder sb = new StringBuilder();
		for (String arg : args) {
			sb.append(arg + "|");
		}

		if (sb.lastIndexOf("|") == sb.length() - 1) {
			sb.deleteCharAt(sb.length() -1);
		}

		return md5(sb.toString());
	}

	/**
	 * MD5 校验
	 *
	 * @param data
	 * @return
	 */
	public static String md5(String data) {

		String result = null;
		try {
			result = h2s(md5(data.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			log.warn("[MD5加密]程序不支持 UTF-8 编码");
		}

		return result;
	}

	/**
	 * MD5加密
	 *
	 * @param data
	 * @return
	 */
	public static byte[] md5(byte[] data) {

		byte[] result = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(data);
			result = messageDigest.digest();
		} catch (NoSuchAlgorithmException e) {
			log.warn("[MD5加密]不支持MD5算法", e);
		}

		return result;
	}

	/**
	 * 左补充
	 *
	 * @param obj
	 * @param len
	 * @param fill
	 * @return
	 */
	public static String leftFill(Object obj, int len, String fill) {

		if (obj == null)
			return null;
		String src = String.valueOf(obj);
		StringBuilder s = new StringBuilder();
		for (int l = src.length(); l < len; l++) {
			s.append(fill);
		}
		s.append(src);
		return s.toString();
	}

	/**
	 * 右补充
	 *
	 * @param obj
	 * @param len
	 * @param fill
	 * @return
	 */
	public static String rightFill(Object obj, int len, String fill) {

		if (obj == null)
			return null;
		String src = String.valueOf(obj);
		StringBuilder s = new StringBuilder();
		s.append(src);
		for (int l = src.length(); l < len; l++) {
			s.append(fill);
		}
		return s.toString();
	}

}
