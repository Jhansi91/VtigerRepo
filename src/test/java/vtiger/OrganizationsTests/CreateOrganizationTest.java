package vtiger.OrganizationsTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import vtiger.GenericUtilities.BaseClass;

@Test
public class CreateOrganizationTest extends BaseClass{
	
	@Test(groups="RegressionSuite")
	public  void createOrganizationTest() throws Throwable {
				
		/* read data from Excel Sheet - TestData*/
		String ORGNAME = eutil.getDataFromExcel("Organizations", 1, 2)+jutil.getRandomNumber();
				
		//step5: click on organization link
		driver.findElement(By.linkText("Organizations")).click();
						
		//step6: click on create organization look up image
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
						
		//step6: create organization
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//step7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
						
		//step8: validation
		String orgHeader = driver.findElement(By.className("dvHeaderText")).getText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
		
	}
}
