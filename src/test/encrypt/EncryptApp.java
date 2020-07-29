package test.encrypt;

//Hash와 달리 암호화는 다시 복호화도 시킬수 있다!!
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

import com.pet.controller.test.AES256Util;

public class EncryptApp {
	private Key keySpec;
	private String byteString;
	private static String key = "minzinokingwangjjang"; // 16자리 이상으로 key값을 부여하자

	public EncryptApp() throws UnsupportedEncodingException{
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

	public String encodeData(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
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
		
		System.out.println(obj.encodeData(key));//암호화 출력
		
		//복호화 결과 출력 
		System.out.println(obj.decodeData(obj.encodeData(key)));
		
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	} catch (InvalidKeyException e) {
		e.printStackTrace();
	} catch (NoSuchAlgorithmException e) {
	
		e.printStackTrace();
	} catch (NoSuchPaddingException e) {
		e.printStackTrace();
	} catch (InvalidAlgorithmParameterException e) {
		e.printStackTrace();
	} catch (IllegalBlockSizeException e) {
		e.printStackTrace();
	} catch (BadPaddingException e) {
		e.printStackTrace();
	}
	}
}