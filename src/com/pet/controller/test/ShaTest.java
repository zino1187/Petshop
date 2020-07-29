package com.pet.controller.test;

import java.security.MessageDigest;

public class ShaTest {
	public static void main(String[] args) {
		String password = "minzino";

		try{

			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			
			byte[] hash = digest.digest(password.getBytes("UTF-8"));
			
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				System.out.println(hex);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}

			//출력
			System.out.println(hexString.toString());
			System.out.println(hexString.toString().length());

		} catch(Exception ex){
			throw new RuntimeException(ex);
		}		
	}
}
