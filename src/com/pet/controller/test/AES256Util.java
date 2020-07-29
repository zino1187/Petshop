package com.pet.controller.test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class AES256Util {
	private Key keySpec;
	private String byteString;
	private static String key = "kingwangjjang!!!";

	public AES256Util() throws UnsupportedEncodingException {
		byteString = this.key.substring(0, 16);
		byte[] keyBytes = new byte[16];
		byte[] b = byteString.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length)
			len = keyBytes.length;
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

		this.keySpec = keySpec;
	}

	/*---------------------------------------------------------------------
	암호화
	---------------------------------------------------------------------*/
	public String encodeData(String str)
			throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(this.byteString.getBytes()));

		byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
		String enStr = new String(Base64.encodeBase64(encrypted));

		return enStr;
	}

	/*---------------------------------------------------------------------
	복호화
	---------------------------------------------------------------------*/
	public String decodeData(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException,
		NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException,
		IllegalBlockSizeException, BadPaddingException {
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(this.byteString.getBytes("UTF-8")));
	
		byte[] byteStr = Base64.decodeBase64(str.getBytes());
	
		return new String(c.doFinal(byteStr),"UTF-8");
	}
	public static void main(String[] args) {
		try {
			AES256Util obj = new AES256Util();
			System.out.println(obj.encodeData(key));
			
			System.out.println(obj.decodeData(obj.encodeData(key)));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
