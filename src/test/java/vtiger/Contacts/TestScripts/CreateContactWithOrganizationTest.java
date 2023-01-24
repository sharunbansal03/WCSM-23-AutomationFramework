package vtiger.Contacts.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vTiger.GenericUtilities.BaseClass;

import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactsPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

/**
 * Example of Integration test This class Creates a Contact with Organization
 * name We must create Organization first and then use the same while creating
 * contact
 * 
 * @author sharu
 *
 */

@Listeners(vTiger.GenericUtilities.ListenersImplentationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass {

	@Test
	public void createContactWithOrgTest() throws IOException {
		// Step 1: Read all the required Data
		String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 7, 2);
		String ORGNAME = eUtil.readDataFromExcelSheet("Contacts", 7, 3) + jUtil.getRandomNumber();

		// Step 5: Navigate to Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		Reporter.log("Step: Clicked Organizations link", true);

		// Step 6: Click on Organizations look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrganizationLookUpImage();
		Reporter.log("Step: Clicked Organizations lookup image", true);

		// Step 7: Create new organization and save
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		Reporter.log("Step: Created new Organization and saved", true);

		// Step 8: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME), "Org not created");

		Reporter.log(OrgHeader + " Org created", true);

		// Step 9: Navigate to contacts link
		hp.clickOnContactsLink();
		Reporter.log("Step: Clicked on Contacts link", true);

		// Step 10: Click on create contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImage();
		Reporter.log("Step: Clicked on create contact look up image", true);

		// Step 11: Create new Contact
		CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		Reporter.log("Step: Created new contact wit organization", true);

		// Step 12: Validate
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		Assert.assertTrue(ContactHeader.contains(LASTNAME), "Fail");
		Reporter.log(ContactHeader + "-PASS", true);

	}
}