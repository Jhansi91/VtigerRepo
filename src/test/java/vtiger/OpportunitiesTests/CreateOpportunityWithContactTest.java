package vtiger.OpportunitiesTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vtiger.GenericUtilities.BaseClass;
//@Listeners(vtiger.GenericUtilities.ListenerImplementationClass.class)
@Test
public class CreateOpportunityWithContactTest extends BaseClass{
	@Test(groups="SmokeSuite")
	public void createOpportunityWithContactTest() throws Throwable {
		
				
		/* read data from Excel Sheet - TestData*/
		String OPPORTUNITYNAME=eutil.getDataFromExcel("Opportunities", 1, 2);	
		String LASTNAME = eutil.getDataFromExcel("Opportunities", 1, 3);
		
		//step5: click on Contacts link
		driver.findElement(By.linkText("Contacts")).click();
		Reporter.log("contact link Clicked");
				
		//step6: click on create contact look up image
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		Reporter.log("contact lookup image clicked");
		//step6: create contact
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				
		//step7: save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
			
		Reporter.log("contact created");
		//step8: validation
		String ConHeader=driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		Assert.assertTrue(ConHeader.contains(LASTNAME));
		System.out.println(ConHeader);
		
		//step9:Click on Opportunities
		driver.findElement(By.linkText("Opportunities")).click();
		Reporter.log("Opportunities link clicked");
		
		//step10: click on create opportunity look up img
		driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		Reporter.log("opportunities lookup image clicked");
		//step10: create opportunity
		driver.findElement(By.name("potentialname")).sendKeys(OPPORTUNITYNAME);
		
		//step10: choose contacts in related to drop down
		WebElement RelatedTo = driver.findElement(By.id("related_to_type"));	
		wutil.handleDropDown(RelatedTo, "Contacts");
		//step10: click on related to lookup icon
		driver.findElement(By.xpath("//input[@id='related_to_display']/following-sibling::img[@alt='Select']")).click();
		
		//step11: switch to child window
		wutil.switchToWindow(driver, "Contacts");
		
		//step12:search contact 
		driver.findElement(By.id("search_txt")).sendKeys(LASTNAME);
		driver.findElement(By.name("search")).click();
		
		//step13:click on contact
		driver.findElement(By.xpath("//a[text()[normalize-space()='"+LASTNAME+"']]")).click();
		
		//step14: switch to parent window
		wutil.switchToWindow(driver, "Potentials");
		
		//step11:save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("oppertunity Created");
		//step12:validate
		String OpporHeader = driver.findElement(By.className("dvHeaderText")).getText();
		Assert.assertTrue(OpporHeader.contains(OPPORTUNITYNAME));
		System.out.println(OpporHeader);
		
	}
	@Test
	public void demoTest()
	{
		Assert.fail();
		System.out.println("demo");
	}
	

}
