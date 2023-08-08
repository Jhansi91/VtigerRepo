package vtiger.ProductsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import vtiger.GenericUtilities.BaseClass;

@Test
public class CreateProductWithVendorTest extends BaseClass {
	@Test
	public void createProductWithVendorTest() throws Throwable {	
						
		/* read data from Excel Sheet - TestData*/
		String PRODNAME = eutil.getDataFromExcel("Products", 1, 2);
		String VENDORNAME = eutil.getDataFromExcel("Products", 1, 3);
		String GLACCOUNT = eutil.getDataFromExcel("Products", 1, 4);
		
		//Step5:  Go to More and click on Vendors
		WebElement moreLink = driver.findElement(By.linkText("More"));
		wutil.mouseHoverAction(driver, moreLink);
		driver.findElement(By.name("Vendors")).click();
		
		//step6: create vendor
		//click on vendor look up image
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		//create vendor with mandatory field
		driver.findElement(By.name("vendorname")).sendKeys(VENDORNAME);
		
		//choose 303-Interest-Income in GLAccount drop down
		WebElement Vendor_GLAcount = driver.findElement(By.name("glacct"));
		wutil.handleDropDown(Vendor_GLAcount, GLACCOUNT);
		
		//step7:save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step8:validation
		String VendorHeader = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
		Assert.assertTrue(VendorHeader.contains(VENDORNAME));
		System.out.println(VendorHeader);
		
		//step8: click on Products link
		driver.findElement(By.linkText("Products")).click();
		
		//step9: click on products look up icon
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		//step10: create product
		driver.findElement(By.name("productname")).sendKeys(PRODNAME);
		
		//step10:click on vendor look up img
		driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling::img[@alt='Select']")).click();
		
		//step11:switch to child window
		wutil.switchToWindow(driver, "Vendors");
		
		//step12: search for vendor
		driver.findElement(By.id("search_txt")).sendKeys(VENDORNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[.='"+VENDORNAME+"']")).click();
		
		//step13: switch to Parent window
		wutil.switchToWindow(driver, "Products");
		
		//step14: choose 303-Interest-Income in GLAccount drop down
		WebElement Prod_GLAccount = driver.findElement(By.name("glacct"));
		wutil.handleDropDown(Prod_GLAccount, GLACCOUNT);
		
		//step15: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step16: product validation
		String ProdHeader = driver.findElement(By.className("lvtHeaderText")).getText();
		Assert.assertTrue(ProdHeader.contains(PRODNAME));
		System.out.println(ProdHeader);		
	}
}
