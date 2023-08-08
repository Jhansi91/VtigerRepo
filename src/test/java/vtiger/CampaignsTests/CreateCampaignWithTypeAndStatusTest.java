package vtiger.CampaignsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vtiger.GenericUtilities.BaseClass;
@Listeners(vtiger.GenericUtilities.ListenerImplementationClass.class)
@Test
public class CreateCampaignWithTypeAndStatusTest extends BaseClass {
	@Test
	public void createCampaignWithTypeAndStatusTest() throws Throwable {

				
		/* read data from Excel Sheet - TestData*/		
		String CAMPNAME = eutil.getDataFromExcel("Campaigns", 1, 2);
		String CAMPTYPE = eutil.getDataFromExcel("Campaigns", 1, 3);
		String CAMPSTATUS = eutil.getDataFromExcel("Campaigns", 1, 4);
		
		
		//STEP5:go to more and click on Campaigns
		WebElement moreLink = driver.findElement(By.linkText("More"));
		wutil.mouseHoverAction(driver, moreLink);
		driver.findElement(By.name("Campaigns")).click();
		
		//step6: click on Campaigns look up icon
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		//step6:create campaign
		driver.findElement(By.name("campaignname")).sendKeys(CAMPNAME);
		//step6: choose webinar as campaign type
		WebElement CampaignType = driver.findElement(By.name("campaigntype"));
		wutil.handleDropDown(CampaignType, CAMPTYPE);
		
		//step6: choose Active as campaign status
		WebElement CampaignStatus = driver.findElement(By.name("campaignstatus"));
		wutil.handleDropDown(CampaignStatus, CAMPSTATUS);
		
		//step7:save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step8: validation
		String CampaignHeader = driver.findElement(By.className("dvHeaderText")).getText();
		Assert.assertTrue(CampaignHeader.contains(CAMPNAME));
		System.out.println(CampaignHeader);
		
		
	}

}
