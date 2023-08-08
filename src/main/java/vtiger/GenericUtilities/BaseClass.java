package vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {

	public JavaUtility jutil=new JavaUtility();
	public ExcelFileUtility eutil=new ExcelFileUtility();
	public PropertyFileUtility putil=new PropertyFileUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public WebDriver driver=null;
	
	public static WebDriver sdriver; /*only used for listeners to take screenshot*/
	
	@BeforeSuite(alwaysRun = true)
	//@BeforeSuite(groups="SmokeSuite")
	public void bsConfig()
	{
		System.out.println("====== db connection successful ======");
	}
	//@Parameters("browser")//holds a value
	//@BeforeTest(alwaysRun = true)
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws Throwable
	{
		//Read browser name and URL from property File
		String BROWSER = putil.getDataFromPropertyFile("browser");
		String URL = putil.getDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println(BROWSER+"=== Browser launched ===");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			System.out.println(BROWSER+"=== Browser launched ===");
		}
		else
		{
			System.out.println("==== invalid Browser name ====");
		}
		wutil.maximizeWindow(driver);
		wutil.waitForElementsToLoad(driver);
			
		sdriver=driver; /*only used for listeners to take screenshot*/
		//Load the URL
		driver.get(URL);
	}
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws Throwable
	{
		//read user name and pass word from property file
		String USERNAME = putil.getDataFromPropertyFile("username");
		String PASSWORD = putil.getDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("==== Login Successful ====");
	}
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		HomePage hp=new HomePage(driver);
        hp.logoutApp(driver);
		System.out.println("==== Logout Successful ====");
	}
	//@AfterTest(alwaysRun = true)
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println(" ========== Browser Closed ========");
	}
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("====== db connection closed ======");
	}
}
