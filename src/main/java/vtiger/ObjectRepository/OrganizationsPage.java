package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author jhans
 */
public class OrganizationsPage {
	//declaration
@FindBy(xpath="//img[@alt='Create Organization...']")
private WebElement CreateOrgLookUpImg;

//initialization
public OrganizationsPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//utilization
/**
 * This method will return CreateOrgLookUpImg
 * @return
 */
public WebElement getCreateOrgLookUpImg() {
	return CreateOrgLookUpImg;
}

//business library
/**
 * this method will click on create Organization lookup image
 */
public void clickCreateOrgLookUpImg()
{
	CreateOrgLookUpImg.click();
}
}
