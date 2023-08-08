package vtiger.OrganizationsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import vtiger.GenericUtilities.BaseClass;
@Test
public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass{
	@Test
	public void createOrganizationWithIndustryAndTypeTest() throws Throwable {
				
		/* read data from Excel Sheet - TestData*/		
		String ORGNAME = eutil.getDataFromExcel("Organizations", 7, 2)+jutil.getRandomNumber();
		String INDUSTRY = eutil.getDataFromExcel("Organizations", 7, 3);
		String TYPE = eutil.getDataFromExcel("Organizations", 7, 4);
				
		//step5: click on organization link
		driver.findElement(By.linkText("Organizations")).click();
						
		//step6: click on create organization look up image
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
						
		//step6: create organization
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
						
		//step6: choose Energy in industry drop down
		WebElement industry = driver.findElement(By.name("industry"));
		wutil.handleDropDown(industry, INDUSTRY);
		
		//step6: choose Customer in Type drop down
		WebElement type = driver.findElement(By.name("accounttype"));
		wutil.handleDropDown(type, TYPE);
						
		//step7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
						
		//step8: validation
		String OrgHeader = driver.findElement(By.className("dvHeaderText")).getText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println(OrgHeader);
		
	}

}
