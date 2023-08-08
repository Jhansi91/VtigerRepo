package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	//declaration
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business library
	/**
	 * This method will create organization with mandatory fields
	 * @param ORGNAME
	 */
	public void createOrganization(String ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	/**
	 * this method will create organization with industry
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createOrganization(String ORGNAME, String INDUSTRY)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDD, INDUSTRY);
		saveBtn.click();	
	}
	
	/** 
	 * This method will create organization with industry and type
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param TYPE
	 */
	public void createOrganization(String ORGNAME, String INDUSTRY,String TYPE)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDD, INDUSTRY);
		handleDropDown(typeDD, TYPE);
		saveBtn.click();	
	}
	
}
