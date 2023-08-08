package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import vtiger.GenericUtilities.WebDriverUtility;
/**
 * @author jhans
 */
public class HomePage extends WebDriverUtility{
	//declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
   //utilization
	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}
	
	public WebElement getContactsLnk() {
		return contactsLnk;
	}
	
	public WebElement getadminImg() {
		return adminImg;
	}
	
	public WebElement getSignOutLnk() {
		return signOutLnk;
	}

	
	//business library
	/**
	 * this method will click on organizations link
	 */
	public void clickOrganizationsLnk()
	{
		organizationsLnk.click();
	}
	
	/**
	 * this method will click on Contacts link
	 */
	public void clickContactssLnk()
	{
		contactsLnk.click();
	}
	
	/**
	 * this method will logout application
	 * @param driver
	 */
	public void logoutApp(WebDriver driver)
	{
		mouseHoverAction(driver, adminImg);
		signOutLnk.click();
	}
	

}
