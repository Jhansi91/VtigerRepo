package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFilePractice {
	public static void main(String[] args) throws IOException {
		
		//step1: Load the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step2: create object for propeties class from java.util
		Properties pObj=new Properties();
		
		//step3: load the file into properties class
		pObj.load(fis);
		
		//step4: provide the key and get the value
		String value = pObj.getProperty("url");
		
		System.out.println(value);
		
		//FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\CommonData.properties");
		//pObj.store(fos, "hello");

	}

}
