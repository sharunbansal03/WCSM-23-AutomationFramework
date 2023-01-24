package vTiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * This class contains all the basic configuration annotations
 * 
 * @author sharu
 *
 */
public class BaseClass {
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver;

	/**
	 * Open dabatase connection before suite
	 */
	@BeforeSuite(groups = { "SmokeSuite", "RegressionSuite" })
	public void bsConfig() {
		System.out.println("==== Database Connection successful ====");
	}

	/**
	 * Launch the browser before class and navigate to URL
	 * 
	 * @throws IOException
	 */
	//@Parameters("browser")
	// @BeforeTest
	@BeforeClass(groups = { "SmokeSuite", "RegressionSuite" })
	public void bcConfig(/*String BROWSER*/) throws IOException {
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");

		if (BROWSER.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			sdriver = driver;
			System.out.println("====" + BROWSER + " Launch successful=====");

		} else if (BROWSER.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			sdriver = driver;
			System.out.println("====" + BROWSER + " Launch successful=====");

		} else {
			System.out.println("invalid browser name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}

	/**
	 * Login to the application before every @Test method
	 * 
	 * @throws IOException
	 */
	@BeforeMethod(groups = { "SmokeSuite", "RegressionSuite" })
	public void bmConfig() throws IOException {
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("==== login successful =====");
	}

	/**
	 * Logout of the application after every @Test method
	 */
	@AfterMethod(groups = { "SmokeSuite", "RegressionSuite" })
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("==== logout successful ====");
	}

	/**
	 * Close the browser after every class
	 */
	@AfterClass(groups = { "SmokeSuite", "RegressionSuite" }, alwaysRun=true)
	public void acConfig() {
		driver.quit();
		System.out.println("==== browser Closed =====");
	}

	/**
	 * Close the database connection after suite
	 */
	@AfterSuite(groups = { "SmokeSuite", "RegressionSuite" })
	public void asConfig() {
		System.out.println("==== Database Connection closed ====");
	}

}
