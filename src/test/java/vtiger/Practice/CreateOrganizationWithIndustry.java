package vtiger.Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustry {
	public static void main(String[] args) throws Throwable {
		
		Random ran=new Random();
		int random=ran.nextInt(1000);		
		//step1: launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step2: load the url
		driver.get("http://localhost:8888/");
		
		//step3: login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//step4: click on organisation link
		driver.findElement(By.linkText("Organizations")).click();
		
		//step5: click on create organisation look up icon
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		
		//step6: enter orgnisation name
		String orgname="L&T"+random;
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		
		//step7: choose chemicals in industry dropdown
		WebElement industry = driver.findElement(By.name("industry"));
		Select s=new Select(industry);
		s.selectByValue("Chemicals");
		
		//step8: save
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		//step9: validation
		String orgHeader = driver.findElement(By.className("dvHeaderText")).getText();
		if(orgHeader.contains(orgname))
		{
			System.out.println("Pass");
			System.out.println(orgHeader);
		}
		else
		{
			System.out.println("Fail");
		}
		
		//step9: logout application
		WebElement adminImg = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions act=new Actions(driver);
		act.moveToElement(adminImg).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("logout successfully");
		
	}

}
