package vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This Class consists of all generic methods related to Java
 * @author jhans
 *
 */
public class JavaUtility {
	
	/**
	 * this method will generate a random number for every execution
	 * @return RandomValue
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
		int ran=r.nextInt(1000);
		return ran;
	}
	
	/**
	 * This method will generate the system date
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		String date = d.toString();
		return date;
	}
	
	public String getSystemDateInFormat()
	{
		Date d=new Date();
		String[] date = d.toString().split(" ");
		String day=date[2];
		String month=date[1];
		String year=date[5];
		String time=date[3].replace(":", "-");
		String dateInFormat=day+"_"+month+"_"+year+"_"+time;
		return dateInFormat;
	}

}
