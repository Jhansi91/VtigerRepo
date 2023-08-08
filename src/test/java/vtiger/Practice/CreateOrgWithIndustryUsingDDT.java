package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithIndustryUsingDDT {
	
public static void main(String[] args) throws IOException {
	
	WebDriver driver=null;
	//Step1: create Random Class
	Random r=new Random();
	int RAN = r.nextInt(1000);
	
	//step2: read all the necessary data 
	
	/* read data from Properties File - CommonData*/
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties pobj=new Properties();
	pobj.load(fisp);
	String BROWSER = pobj.getProperty("browser");
	String URL = pobj.getProperty("url");
	String USERNAME = pobj.getProperty("username");
	String PASSWORD = pobj.getProperty("password");
	
	/* read data from Excel Sheet - TestData*/
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fise);
	Sheet sh = wb.getSheet("Organizations");
	Row rw = sh.getRow(4);
	String ORGNAME = rw.getCell(2).getStringCellValue()+RAN;
	String INDUSTRY = rw.getCell(3).getStringCellValue();
	
	//step3: launch the Browser - browser is acting based on runtime data- RunTimePolymorphism
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
	
	//step4: maximize the browser
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//step5: Load the URL
	driver.get(URL);
	
	//step6: login to application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//step7: click on organisation link
	driver.findElement(By.linkText("Organizations")).click();
			
	//step8: click on create organisation look up icon
	driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
			
	//step9: enter orgnisation name
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			
	//step10: choose chemicals in industry dropdown
	WebElement industry = driver.findElement(By.name("industry"));
	Select s=new Select(industry);
	s.selectByValue(INDUSTRY);
			
	//step11: save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
	//step12: validation
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
			
	//step13: logout application
	WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act=new Actions(driver);
	act.moveToElement(adminImg).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("logout successfully");
	
	//step14: close the browser
	driver.quit();
}
}
