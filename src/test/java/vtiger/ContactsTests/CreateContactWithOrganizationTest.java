package vtiger.ContactsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;
@Test
public class CreateContactWithOrganizationTest extends BaseClass {

	@Test
	public void createContactWithOrgTest() throws Throwable {
				
		/* read data from Excel Sheet - TestData*/
		String ORGNAME = eutil.getDataFromExcel("Contacts", 4, 3)+jutil.getRandomNumber();
		String LASTNAME=eutil.getDataFromExcel("Contacts", 4, 2);
		
		
		//step5: click on organization link
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsLnk().click();
		
		//step6: click on create organization look up image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickCreateOrgLookUpImg();
							
		//step7: create organization
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);

						
		//step8: validation
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String orgHeader =oip.getHeaderText();

		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
		
		//step9: click on Contacts link
		hp.clickContactssLnk();
		
		//step10: click on contact look up image
		ContactsPage cp=new ContactsPage(driver);
		cp.ClickCreateContactLookupImg();
		
		//step11: create contact with organisation
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createContact(driver, LASTNAME, ORGNAME);

		//step12: validation for contact
		ContactInfoPage cip=new ContactInfoPage(driver);
		String ConHeader=cip.getContactHeader();
		Assert.assertTrue(ConHeader.contains(LASTNAME));
		System.out.println(ConHeader);
			
	}
}
