package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consistes of generic methods related to propertyfile
 * @author jhans
 *
 */
public class PropertyFileUtility {

	/**
	 * This method reads data from Property File based on given key
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String getDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IConstants.propertyFilePath);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}
}
