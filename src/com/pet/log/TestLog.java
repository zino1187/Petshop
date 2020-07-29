
package com.pet.log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/*
 * 濡쒓렇瑜� �쟾臾몄쟻�쑝濡� 泥섎━�빐二쇰뒗 �삤�뵂�냼�뒪 吏꾩쁺�쓽 �씪�씠釉뚮윭由� 
 * log4j ( �븞�뱶濡쒖씠�뱶�뿉�꽌�룄 �궗�슜)
 * */
public class TestLog {
	// 異쒕젰�젅踰� trace<debug < info < error < fatal
	Logger logger; 
	FileInputStream fis;
	String path="D:/web_app/Javaee_workspace/PetShop/src/com/pet/log/log4j.properties";
	Properties props;
	
	public TestLog() {
		logger = Logger.getLogger(this.getClass().getName());
		try {
			fis = new FileInputStream(path);
			props = new Properties();
			props.load(fis);
			//濡쒓굅�뿉 �꽕�젙�뙆�씪 �씤�떇 �떆�궎湲�!!
			PropertyConfigurator.configure(props);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showMessage() {
		logger.trace("異쒕젰");
		logger.debug("異쒕젰");
		logger.info("�긽�깭�굹 �젙蹂� 異쒕젰");
		logger.error("�뿉�윭");
		logger.fatal("移섎챸�쟻 �뿉�윭");
	}
}






