package vtiger.Organizations.TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;

@Listeners(vTiger.GenericUtilities.ListenersImplentationClass.class)
public class CreateOrganizationWithDDTAndGUTest extends BaseClass {

	@Test
	public void createOrgWithDDTAndGUTest() throws IOException {
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

		String ORGNAME = eUtil.readDataFromExcelSheet("Organizations", 1, 2) + jUtil.getRandomNumber();

		// Step 3: Launch the browser and navigate to application
		/*
		 * WebDriver driver = null; if (BROWSER.equalsIgnoreCase("Chrome")) {
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
		driver.findElement(By.linkText("Organizations")).click();
		Reporter.log("Step: Clicked on Organizations link", true);

		// Step 6: Click on Create Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Reporter.log("Step: Clicked on Create Organization look up image", true);

		// Step 7: Create Organization With Mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		// Step 9: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("Step: Created organization with mandatory fields and saved", true);

		// Step 10: Validate
		Assert.assertTrue(driver.findElement(By.className("dvHeaderText")).getText().contains(ORGNAME),
				"[Assertion Failed]: Organization creation failed. Actual details in application: ");
		Reporter.log("[Assertion Pass]: Organization created with details: ", true);
		Reporter.log("Organization name: " + ORGNAME, true);

		// Step 11: Logout from the application
		/*
		 * WebElement userImgElement =
		 * driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 * wUtil.mouseHoverAction(driver, userImgElement);
		 * driver.findElement(By.linkText("Sign Out")).click();
		 */
	}
}