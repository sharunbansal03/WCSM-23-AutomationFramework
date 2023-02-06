package vtiger.Practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationsPage;

public class WebTablePracticeTest extends BaseClass {

	@Test
	public void checkAllBoxesTest() {
		Reporter.log(" ********** TEST TO SELECT ALL CHECK-BOX  ********** ", true);
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		// Click on all checkboxes
		OrganizationsPage op = new OrganizationsPage(driver);
		op.selectAllCheckBoxes();
		Reporter.log("[STEP]: Selected all check-boxes", true);
	}

	@Test
	public void checkFifthCheckBoxTest() {
		Reporter.log(" ********** TEST TO SELECT 5th CHECK-BOX ********** ", true);
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		// Select 5th checkbox
		OrganizationsPage op = new OrganizationsPage(driver);
		op.selectCheckBoxByRowIndex(driver, 5);
	}

	@Test
	public void printAllOrgNamesTest() {
		Reporter.log(" ********** TEST TO PRINT ALL ORGANIZATION NAMES ********** ", true);
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		// Step 3: Fetch all org-names and print
		OrganizationsPage op = new OrganizationsPage(driver);
		String[] allOrgNames = op.getOrganizationNamesFromTable();
		Reporter.log("**********[INFO]: All Organization Names **********");
		for (String orgName : allOrgNames) {
			Reporter.log(orgName, true);
		}
	}

	@Test
	public void clickOnLastCheckBox() {
		Reporter.log("********** TEST TO SELECT LAST CHECK-BOX ********** ", true);
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		// Click last check-box
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickLastCheckBox();
	}

	@Test
	public void selectEightOrgAndThenDeleteTest() {
		Reporter.log(" ***** TEST TO SELECT 8TH CHECK-BOX, PRINT ORG NAME AND DELETE ORG ***** ", true);
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		// Select eight check-box
		OrganizationsPage op = new OrganizationsPage(driver);
		op.selectCheckBoxByRowIndex(driver, 8);

		// fetch organization name in 8th row and print
		String OrgName = op.getOrgNameInGivenRow(driver, 8);
		Reporter.log("[INFO]: 8th Organization name: " + OrgName, true);

		// delete organization from given row
		op.deleteOrgAtGivenRowIndex(driver, 8);
	}
}
