package vtiger.ContactsTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import vtiger.GenericUtilities.BaseClass;

@Test
public class CreateContactTest extends BaseClass {
	@Test
	public void createContactTest() throws Throwable {
		
				
		/* read data from Excel Sheet - TestData*/
				
		String LASTNAME = eutil.getDataFromExcel("Contacts", 1, 2)+jutil.getRandomNumber();
				
		//step5: click on Contacts link
		driver.findElement(By.linkText("Contacts")).click();
				
		//step6: click on create contact look up image
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();

		//step6: create contact
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				
		//step7: save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
				
		//step8: validation
		String ConHeader=driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		Assert.assertTrue(ConHeader.contains(LASTNAME));
		System.out.println(ConHeader);
		
				
		
	}
}
