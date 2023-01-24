package vtiger.Organizations.TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;

@Listeners(vTiger.GenericUtilities.ListenersImplentationClass.class)
public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass {

	@Test
	public void createOrgWithIndustryAndTypeTest() throws IOException {

		// Step 1: Create objects of all the required libraries
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

		/* Read data from Excel sheet */
		String ORGNAME = eUtil.readDataFromExcelSheet("Organizations", 10, 2) + jUtil.getRandomNumber();
		String INDUSTRY = eUtil.readDataFromExcelSheet("Organizations", 10, 3);
		String TYPE = eUtil.readDataFromExcelSheet("Organizations", 10, 4);

		// Step 2: Launch the browser and navigate to application
		/*
		 * WebDriver driver = null; if (BROWSER.equalsIgnoreCase("chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); } else
		 * if (BROWSER.equalsIgnoreCase("firefox")) {
		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); }
		 * else System.out.println("Invalid browser");
		 * 
		 * wUtil.maximizeWindow(driver); wUtil.waitForPageLoad(driver); driver.get(URL);
		 */
		// Step 3: Login into the application
		/*
		 * driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 * driver.findElement(By.id("submitButton")).click();
		 */
		// Step 4: Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		Reporter.log("Step: Clicked on Organization link", true);

		// Step 5: Click on Create Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Reporter.log("Step: Clicked on Create Organization look up image", true);

		// Step 6: Create Organization with mandatory fields, industry name and type
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		wUtil.handleDropDown(driver.findElement(By.name("industry")), INDUSTRY);
		wUtil.handleDropDown(driver.findElement(By.name("accounttype")), TYPE);

		// Step 7: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("Step: created organization", true);

		// Step 8: Validate
		String actualOrgName = driver.findElement(By.className("dvHeaderText")).getText();
		String actualIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		String actualType = driver.findElement(By.id("dtlview_Type")).getText();

		Assert.assertTrue(actualOrgName.contains(ORGNAME) && actualIndustry.equals(INDUSTRY) && actualType.equals(TYPE),
				"[Assertion Failed]: Organization creation faild; \nExpected Organization name: " + ORGNAME
						+ "; Actual Organization name: " + actualOrgName + "\n Expected Industry type: " + INDUSTRY
						+ "; Actual Industry type: " + actualIndustry + " \n Expected Type: " + TYPE + "; Actual Type: "
						+ actualType);
		Reporter.log("[Assertion Passed]: Organization created with details as: ", true);
		Reporter.log("Organization name: " + ORGNAME);
		Reporter.log("Industry type: " + INDUSTRY);
		Reporter.log("Type: " + TYPE);

	}
}