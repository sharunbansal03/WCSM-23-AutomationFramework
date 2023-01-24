package vtiger.Contacts.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactsPage;
import vTiger.ObjectRepository.HomePage;

@Listeners(vTiger.GenericUtilities.ListenersImplentationClass.class)
public class CreateContactTest extends BaseClass {

	@Test(groups = {"SmokeSuite","RegressionSuite"})
	public void createContactTest() throws EncryptedDocumentException, IOException {
		// Step 1: Read all the required data
		String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 1, 2);

		// Step 2: Click on Contacts link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		Reporter.log("Step: Clicked on Contacts link", true);

		// Step 3: Click on Create Contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImage();
		Reporter.log("Step: Clicked on Create Contacts look up image", true);

		// Step 4: Create Contact With Mandatory fields
		CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
		cncp.createNewContact(LASTNAME);
		Reporter.log("Step: Created new Contact with last name: " + LASTNAME, true);

		// Step 5: Validate
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String actualLastName = cip.getContactHeader();
		//failed intentionally to test extent report behaviour on failure
		Assert.assertTrue(actualLastName.equals(LASTNAME),
				"[Assertion Failed]: Contact creation failed. Actual details in application: " + actualLastName);
		Reporter.log("[Assertion Pass]: Contact created with details: ", true);
		Reporter.log("Contact name: " + LASTNAME, true);

	}
}