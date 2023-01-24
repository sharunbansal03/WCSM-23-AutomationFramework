package vtiger.Organizations.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenersImplentationClass.class)
public class CreateOrganizationWithIndustryUsingPOMTest extends BaseClass {

	@Test(groups = { "SmokeSuite", "RegressionSuite" })
	public void createOrgWithIndustryUsingPOMTest() throws IOException {
		// Step 1: Read all the required test data
		String ORGNAME = eUtil.readDataFromExcelSheet("Organizations", 4, 2) + jUtil.getRandomNumber();
		String INDUSTRY = eUtil.readDataFromExcelSheet("Organizations", 4, 3);

		// Step 2: Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		Reporter.log("Step: Clicked on Organizations link", true);

		// Step 3: Click on Create Organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrganizationLookUpImage();
		Reporter.log("Step: Clicked on Create Organization look up image", true);

		// Step 4: Create Organization With Mandatory fields
		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createNewOrganization(ORGNAME, INDUSTRY);
		Reporter.log("Step: Created new organization with industry", true);

		// Step 5: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualOrgHeaderText = oip.getOrganizationHeader();
		Assert.assertTrue(actualOrgHeaderText.contains(ORGNAME),
				"[Assertion Failed]: Organization creation failed. Actual details in application:\n Organization name: "
						+ oip.getOrgNameText().getText() + "Industry name: " + oip.getIndustryNameText().getText());
		Reporter.log("[Assertion Pass]: Organization created with details: ", true);
		Reporter.log("Organization name: " + ORGNAME, true);
		Reporter.log("Industry name: " + INDUSTRY, true);
	}

	@Test(groups = "SmokeSuite")
	public void demo1() {
		System.out.println("demo 1");
	}

	@Test
	public void demo2() {
		System.out.println("demo 2");
	}
}