package vtiger.Organizations.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenersImplentationClass.class)
public class CreateOrgWithIndustryDPTest extends BaseClass {
	@Test(dataProvider = "OrgWithIndustry")
	public void createOrgWithIndustryTest(String OrgName, String Industry) throws IOException {
		// Step 1: Create Objects of required generic classes

		// Step 2: Read all required data

		OrgName = OrgName + jUtil.getRandomNumber();

		// Step 3: Launch browser and navigate to app

		// Step 4: Login into the application

		// Step 5: Navigate to "Organizations" link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		Reporter.log("Step: Clicked on Organizations link", true);

		// Step 6: Click on "create organization look up image"
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrganizationLookUpImage();
		Reporter.log("Step: Clicked on Create Organization look up image", true);

		// Step 7: Create Organization with Industry and save
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(OrgName, Industry);
		Reporter.log("Step: Created new organization with industry", true);

		// Step 8: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualOrgName = oip.getOrganizationHeader();
		String actualIndustry = oip.getIndustryName();
		Assert.assertTrue(actualOrgName.contains(OrgName) && actualIndustry.equals(Industry), "Failed");
		Reporter.log("Organization created successfully with Industry", true);
		Reporter.log("Organization name: " + OrgName, true);
		Reporter.log("Industry name: " + actualIndustry, true);

	}

	@DataProvider(name = "OrgWithIndustry")
	public Object[][] getData() {
		Object[][] data = new Object[2][2];

		data[0][0] = "Honda";
		data[0][1] = "Manufacturing";

		data[1][0] = "QAInfotech";
		data[1][1] = "Engineering";

		return data;
	}
}
