package vtiger.Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateOrg_Industry_Test {
	public static void main(String[] args) {

		// Create instance of ChromeDriver and upcast to WebDriver interface
		// Maximize browser and set implicit wait
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Navigate to URL - vtiger
		driver.get("http://localhost:8888/");

		// Enter username, password and login
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		// Click "Organizations" tab
		driver.findElement(By.xpath("//td[contains(@class,'tab')]/a[text()='Organizations']")).click();

		// Click "Create Organization look up image"
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Create Organization with mandatory field - Organization name and Industry -
		// Chemicals
		Random random = new Random();
		String OrganizationName = "Automated_Org_Name_" + random.nextInt(80000);
		System.out.println("Random generated Organization name: " + OrganizationName);
		driver.findElement(By.name("accountname")).sendKeys(OrganizationName);

		// Select industry- chemicals
		String industryName = "Chemicals";
		Select sel = new Select(driver.findElement(By.name("industry")));
		sel.selectByValue(industryName);

		// click Save
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

		// Verify Organization created
		// Verify Organization name in header
		Assert.assertTrue(driver.findElement(By.className("dvHeaderText")).getText().contains(OrganizationName),
				"[Assertion Failed]: 'Create new Organization' failed - incorrect Organization name");

		// Verify Organization name in details
		Assert.assertTrue(driver.findElement(By.id("dtlview_Organization Name")).getText().equals(OrganizationName),
				"[Assertion Failed]: 'Create new Organization' failed - incorrect Organization name");

		// Verify Industry-Chemicals in details
		Assert.assertTrue(driver.findElement(By.id("dtlview_Industry")).getText().equals(industryName),
				"[Assertion Failed]: 'Create new Organization' with Industry-Chemicals Failed");
		System.out.println("[Assertion Passed]: Created new Organization successfully with name: " + OrganizationName
				+ " and Industry-Chemicals");

		// Logout
		WebElement logoutBtn = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logoutBtn).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		// close browser
		driver.quit();
	}
}
