package test.hash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashApp {
	
	public static void main(String[] args) {
		String password="minzino";
		
		//자바언어 자체적으로 해시값 처리를 지원하는 API 제공됨 
		try {
			MessageDigest digest=MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes("UTF-8"));
			
			//문자 하나 하나 마다 매칭되는 16진수로 변환
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<hash.length;i++) {
				String hex=Integer.toHexString(0xff&hash[i]); //16진수 문자열로 변환
				System.out.println(hex);
				if(hex.length()==1) { //1~9라면 앞에 0을 조합  예) 03
					sb.append("0");
				}
				sb.append(hex);
			}
			System.out.println(sb.toString());
			System.out.println(sb.toString().length());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
}
