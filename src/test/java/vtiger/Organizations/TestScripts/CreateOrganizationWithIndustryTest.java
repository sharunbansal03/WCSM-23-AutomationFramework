package vtiger.Organizations.TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vTiger.GenericUtilities.BaseClass;

@Listeners(vTiger.GenericUtilities.ListenersImplentationClass.class)
public class CreateOrganizationWithIndustryTest extends BaseClass{

	@Test
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
		driver.findElement(By.linkText("Organizations")).click();

		// Step 6: Click on Create Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// Step 7: Create Organization With Mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		// Step 8: Select "Healthcare" from Industry dropdown
		WebElement dropdownElement = driver.findElement(By.name("industry"));
		wUtil.handleDropDown(dropdownElement, INDUSTRY);

		// Step 9: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 10: Validate
		if (driver.findElement(By.className("dvHeaderText")).getText().contains(ORGNAME)
				&& driver.findElement(By.id("dtlview_Industry")).getText().equals(INDUSTRY)) {
			System.out.println("[Assertion Pass]: Organization created with details: ");
			System.out.println("Organization name: " + ORGNAME);
			System.out.println("Industry name: " + INDUSTRY);
		} else {
			System.out.println("[Assertion Failed]: Organization creation failed. Actual details in application: ");
			System.out
					.println("Organization name: " + driver.findElement(By.id("dtlview_Organization Name")).getText());
			System.out.println("Industry name: " + driver.findElement(By.id("dtlview_Industry")).getText());
		}

	}
}