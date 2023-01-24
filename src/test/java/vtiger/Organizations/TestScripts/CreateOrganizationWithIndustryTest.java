package vtiger.Organizations.TestScripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenersImplentationClass.class)
public class CreateOrganizationWithIndustryTest extends BaseClass {

	@Test(groups = "RegressionSuite")
	public void createOrgWithIndustryTest() throws IOException {
		// Step 1: Create objects of all required libraries
		/*
		 * JavaUtility jUtil = new JavaUtility(); WebDriverUtility wUtil = new
		 * WebDriverUtility(); PropertyFileUtility pUtil = new PropertyFileUtility();
		 * ExcelFileUtility eUtil = new ExcelFileUtility();
		 */
		// Step 2: Read all the required data
		/*
		 * String BROWSER = pUtil.readDataFromPropertyFile("browser"); String URL =
		 * pUtil.readDataFromPropertyFile("url"); String USERNAME =
		 * pUtil.readDataFromPropertyFile("username"); String PASSWORD =
		 * pUtil.readDataFromPropertyFile("password");
		 */
		String ORGNAME = eUtil.readDataFromExcelSheet("Organizations", 4, 2) + jUtil.getRandomNumber();
		String INDUSTRY = eUtil.readDataFromExcelSheet("Organizations", 4, 3);

		// Step 3: Launch the browser and navigate to application
		/* WebDriver driver = null; */
		/*
		 * if (BROWSER.equalsIgnoreCase("Chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); } else
		 * if (BROWSER.equalsIgnoreCase("Firefox")) {
		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); }
		 * else System.out.println("Invalid driver");
		 * 
		 * wUtil.maximizeWindow(driver); wUtil.waitForPageLoad(driver); driver.get(URL);
		 */

		// Step 4: Login into the application
		/*
		 * driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 * driver.findElement(By.id("submitButton")).click();
		 */

		// Step 5: Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		// Step 6: Click on Create Organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrganizationLookUpImage();

		// Step 7: Create Organization With Mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRY);

		// Step 8: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		Assert.assertTrue(oip.getOrganizationHeader().contains(ORGNAME) && oip.getIndustryName().equals(INDUSTRY),
				"[ASSERTION FAILED]: failed");
		System.out.println("[Assertion Pass]: Organization created with details: ");
		System.out.println("Organization name: " + ORGNAME);
		System.out.println("Industry name: " + INDUSTRY);
	}
}