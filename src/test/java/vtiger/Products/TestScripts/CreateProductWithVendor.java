package vtiger.Products.TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

@Listeners(vTiger.GenericUtilities.ListenersImplentationClass.class)
public class CreateProductWithVendor {

	public static void main(String[] args) throws IOException {
		// Step 1: Create objects of all the required libraries
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();

		// Step 2: Read all required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		String VENDORNAME = eUtil.readDataFromExcelSheet("Products", 1, 2) + jUtil.getRandomNumber();
		String PRODUCTNAME = eUtil.readDataFromExcelSheet("Products", 1, 3);

		// Step 3: Launch the browser and navigate to app
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else
			System.out.println("Invalid browser detected updated");

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);

		// Step 4: Login into the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Step 5: Hover on "More" link
		wUtil.mouseHoverAction(driver, driver.findElement(By.linkText("More")));

		// Step 6: Click on "Vendors" link
		driver.findElement(By.linkText("Vendors")).click();

		// Step 7: Click on Create vendor look up image
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();

		// Step 8: Create new Vendor with mandatory fields
		driver.findElement(By.name("vendorname")).sendKeys(VENDORNAME);

		// Step 9: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 10: Validate Vendor created
		String actualVendorName = driver.findElement(By.id("dtlview_Vendor Name")).getText();
		if (actualVendorName.equals(VENDORNAME)) {
			System.out.println("[Assertion Passed]: Vendor created successfully");
		} else
			System.out.println("[Assertion Failed]: Vendor creation failed");

		// Step 11: Click on "Products" link
		driver.findElement(By.linkText("Products")).click();

		// Step 12: Click on Create Product look up image
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		// Step 13: Create product with mandatory details
		driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);

		// Step 14: Choose the vendor
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		wUtil.switchToWindow(driver, "Vendors");
		driver.findElement(By.id("search_txt")).sendKeys(VENDORNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(VENDORNAME)).click();
		wUtil.switchToWindow(driver, "Products");

		// Step 15: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 16: Validate
		String actualProductName = driver.findElement(By.id("dtlview_Product Name")).getText();
		String actVendorName = driver.findElement(By.xpath("//td[@id='mouseArea_Vendor Name']/a")).getText();
		if (actualProductName.equals(PRODUCTNAME) && actVendorName.equals(VENDORNAME)) {
			System.out.println("[Assertion Passed]: Product created successfully with vendor");
		} else {
			System.out.println("[Assertion Failed]: Product creation with vendor failed");
			System.out.println("Expected Product name: " + PRODUCTNAME + "; Actual Product name: " + actualProductName);
			System.out.println("Expected Vendor name: " + VENDORNAME + "; Actual Vendor name: " + actVendorName);
		}

		// Step 17: Logout from the application
		wUtil.mouseHoverAction(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();

	}
}