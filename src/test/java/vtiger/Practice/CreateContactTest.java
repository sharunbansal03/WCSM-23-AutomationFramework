package vtiger.Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CreateContactTest {

	public static void main(String[] args) {
		//Step 1: Launch the browser
		// Create instance of ChromeDriver and upcast to WebDriver interface
		// Maximize browser and set implicit wait
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Navigate to URL - vtiger
		driver.get("http://localhost:8888/");

		//Step 2: Login to the application
		// Enter username, password and login
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		//Step 3: Click on Contacts link
		driver.findElement(By.xpath("//td[contains(@class,'tab')]/a[text()='Contacts']")).click();

		//Step 4: Click Create Contant look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		//Step 5: Create contact with mandatory field - last name
		Random random = new Random();
		String lastName = "Automated_Last_Name_" + random.nextInt(80000);
		System.out.println("Random generated Last name: " + lastName);
		driver.findElement(By.name("lastname")).sendKeys(lastName);

		//Step 6: click Save
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

		//Step 7: Validate
		Assert.assertTrue(driver.findElement(By.className("dvHeaderText")).getText().contains(lastName),
				"[Assertion Failed]: 'Create new contact' failed");

		Assert.assertTrue(driver.findElement(By.id("dtlview_Last Name")).getText().equals(lastName),
				"[Assertion Failed]: 'Create new contact' failed");
		System.out.println("[Assertion Passed]: Created new contact successfully with last name: " + lastName);

		//Step 8: Logout of the application
		WebElement logoutBtn = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logoutBtn).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		// close browser
		driver.quit();
	}
}
