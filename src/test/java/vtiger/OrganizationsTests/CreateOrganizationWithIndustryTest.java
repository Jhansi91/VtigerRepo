package vtiger.OrganizationsTests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;
@Test
public class CreateOrganizationWithIndustryTest extends BaseClass{
	@Test
	public void createOrganizationWithIndustryTest() throws IOException, Throwable {
				
		/* read data from Excel Sheet - TestData*/
				
		String ORGNAME = eutil.getDataFromExcel("Organizations", 4, 2)+jutil.getRandomNumber();
		String INDUSTRY = eutil.getDataFromExcel("Organizations", 4, 3);
				
		//step5: click on organization link
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsLnk().click();
					
		//step6: click on create organization look up image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickCreateOrgLookUpImg();
		
		//step7: create organization
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME, INDUSTRY);
						
		//step8: validation
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
	}

}
