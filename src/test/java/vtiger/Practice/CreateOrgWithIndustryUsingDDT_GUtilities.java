package vtiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateOrgWithIndustryUsingDDT_GUtilities {
	
	public static void main(String[] args) throws Throwable {
		//create object of required utilities
		JavaUtility jutil=new JavaUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		WebDriver driver=null;
		
		
		//step1: read all the necessary data 
		
		/* read data from Properties File - CommonData*/
		
		String BROWSER = putil.getDataFromPropertyFile("browser");
		String URL = putil.getDataFromPropertyFile("url");
		String USERNAME = putil.getDataFromPropertyFile("username");
		String PASSWORD = putil.getDataFromPropertyFile("password");;
		
		/* read data from Excel Sheet - TestData*/
		
		String ORGNAME = eutil.getDataFromExcel("Organizations", 4, 2)+jutil.getRandomNumber();
		String INDUSTRY = eutil.getDataFromExcel("Organizations", 4, 3);
		
		//step2: launch the Browser - browser is acting based on runtime data- RunTimePolymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println(BROWSER+"---browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			System.out.println(BROWSER+"---browser launched");
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		wutil.maximizeWindow(driver);
		wutil.waitForElementsToLoad(driver);
		
		//step3: Load the URL
		driver.get(URL);
		
		//step4: login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step5: click on organization link
		driver.findElement(By.linkText("Organizations")).click();
				
		//step6: click on create organization look up image
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
				
		//step6: create organization
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
		//step6: choose chemicals in industry drop down
		WebElement industry = driver.findElement(By.name("industry"));
		wutil.handleDropDown(industry, INDUSTRY);
				
		//step7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		//step8: validation
		String orgHeader = driver.findElement(By.className("dvHeaderText")).getText();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("Pass");
			System.out.println(orgHeader);
		}
		else
		{
			System.out.println("Fail");
		}
				
		//step9: logout application
		WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutil.mouseHoverAction(driver, adminImg);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("logout successfully");
		
	}

}
