package vtiger.Organizations.TestScripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;

@Listeners(vTiger.GenericUtilities.ListenersImplentationClass.class)
public class CreateOrganizationWithDDTTest extends BaseClass {

	@Test
	public void createOrgWithDDTTest() throws IOException {
		// Generated random number in provided range.
		/*
		 * Random ran = new Random(); int random = ran.nextInt(1000);
		 */

		// Step 1: Read all the data
		/* Read the data from Properties file */
		/*
		 * FileInputStream fisp = new
		 * FileInputStream(".\\src\\test\\resources\\CommonData.properties"); Properties
		 * pObj = new Properties(); pObj.load(fisp); String BROWSER =
		 * pObj.getProperty("browser"); String URL = pObj.getProperty("url"); String
		 * USERNAME = pObj.getProperty("username"); String PASSWORD =
		 * pObj.getProperty("password");
		 */

		/* Read the data from Excel Sheet */
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String ORGNAME = wb.getSheet("Organizations").getRow(1).getCell(2).getStringCellValue()
				+ jUtil.getRandomNumber();

		// Step 2: Launch the browser - based on the "browser" name provided in
		// CommonData.properties file
		/*
		 * Example of Runtime Polymorphism - driver is exhibiting Polymorphism as it is
		 * decided at runtime which method is called and which browser driver class
		 * object is assigned to this reference variable
		 */
		/*
		 * WebDriver driver = null;
		 * 
		 * if (BROWSER.equalsIgnoreCase("chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); } else
		 * if (BROWSER.equalsIgnoreCase("firefox")) {
		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); }
		 * else { System.out.println("invalid Browser name"); }
		 */

		/*
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 * driver.get(URL);
		 */
		// Step 3: Login to the application
		/*
		 * driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 * driver.findElement(By.id("submitButton")).click();
		 */

		// Step 4: Click on Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		Reporter.log("Step: Clicked on Organizations link", true);

		// Step 5: Click on Create Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Reporter.log("Step: Clicked on Create Organizations look up image", true);

		// Step 6: Create Organization with mandatory details
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		// Step 7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("Step: Clicked Organization with mandatory field and clicked save", true);

		// Step 8: Validate
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(orgHeader.contains(ORGNAME), "Fail");
		Reporter.log(orgHeader + " PASS");

		// Step 9: Logout of App
		/*
		 * WebElement ele =
		 * driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 * Actions act = new Actions(driver); act.moveToElement(ele).perform();
		 * driver.findElement(By.linkText("Sign Out")).click();
		 */
	}
}