package vtiger.Practice;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {
	public static void main(String[] args) throws Throwable {
		JavaUtility jutil=new JavaUtility();
		int value = jutil.getRandomNumber();
		System.out.println(value);
		System.out.println(jutil.getSystemDate());
		System.out.println(jutil.getSystemDateInFormat());
		
		PropertyFileUtility putil=new PropertyFileUtility();
		System.out.println(putil.getDataFromPropertyFile("username"));
		
		ExcelFileUtility eutil=new ExcelFileUtility();
		String value1=eutil.getDataFromExcel("Organizations", 1, 2);
		System.out.println(value1);
		
		eutil.writeDataIntoExcel("Test", 4, 4, "jhansi");
	}

}
