package vtiger.Practice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopUpHandleTest {
	@Test
	public void bookFlightOn1stMarch2023Test() throws InterruptedException {
		String fromCity = "Mumbai";
		String toCity = "Chennai";
		String deptDate = "Mar 01 2023";

		// Step 1: Setup browser and launch makemytrip.com
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/");

		// closed advertisment pop-up in footer
		driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();

		// Step 2: Click on 'from' input box
		driver.findElement(By.id("fromCity")).click();
		System.out.println("[STEP]: Clicked on 'from' city");

		// Step 3: Type "city" in "from" search input box
		driver.findElement(By.xpath("//div[contains(@class,'autoSuggestPlugin')]//input")).sendKeys(fromCity);
		System.out.println("[STEP]: entered '" + fromCity + "' in 'from' search box");

		// Step 4: Select 'Mumbai' from auto-suggestions
		driver.findElement(By.xpath("//div[contains(@class,'searchCity')]//p[starts-with(text(),'" + fromCity + "')]"))
				.click();

		// Step 5: Click on 'to' input box
		driver.findElement(By.id("toCity")).click();
		System.out.println("[STEP]: Clicked on 'to' city");

		// Step 6: Type city in "to city" search input box
		driver.findElement(By.xpath("//div[contains(@class,'autoSuggestPlugin')]//input")).sendKeys(toCity);
		System.out.println("[STEP]: entered '" + toCity + "' in 'to' search box");

		// Step 7: Select 'Chennai' from auto-suggestions
		WebElement toCityOption = driver.findElement(
				By.xpath("//div[contains(@class,'searchToCity')]//p[starts-with(text(),'" + toCity + "')]"));

		toCityOption.click();

		// Step 8: Select date from date picker
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(@aria-label,'" + deptDate + "') and @aria-disabled='false']")));
		driver.findElement(By.xpath("//div[contains(@aria-label,'" + deptDate + "') and @aria-disabled='false']"))
				.click();
		System.out.println("[Step]: Selected date: " + deptDate);
		driver.quit();
	}

	@Test
	public void bookFlightInFutureDateTest() throws InterruptedException {
		String fromCity = "Mumbai";
		String toCity = "Chennai";
		String deptDate = "Aug 03 2023";

		// Step 1: Setup browser and launch makemytrip.com
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/");

		// closed advertisment pop-up in footer
		driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();

		// Step 2: Click on 'from' input box
		driver.findElement(By.id("fromCity")).click();
		System.out.println("[STEP]: Clicked on 'from' city");

		// Step 3: Type "city" in "from" search input box
		driver.findElement(By.xpath("//div[contains(@class,'autoSuggestPlugin')]//input")).sendKeys(fromCity);
		System.out.println("[STEP]: entered '" + fromCity + "' in 'from' search box");

		// Step 4: Select 'Mumbai' from auto-suggestions
		driver.findElement(By.xpath("//div[contains(@class,'searchCity')]//p[starts-with(text(),'" + fromCity + "')]"))
				.click();

		// Step 5: Click on 'to' input box
		driver.findElement(By.id("toCity")).click();
		System.out.println("[STEP]: Clicked on 'to' city");

		// Step 6: Type city in "to city" search input box
		driver.findElement(By.xpath("//div[contains(@class,'autoSuggestPlugin')]//input")).sendKeys(toCity);
		System.out.println("[STEP]: entered '" + toCity + "' in 'to' search box");

		// Step 7: Select 'Chennai' from auto-suggestions
		WebElement toCityOption = driver.findElement(
				By.xpath("//div[contains(@class,'searchToCity')]//p[starts-with(text(),'" + toCity + "')]"));

		toCityOption.click();

		// Step 8: Select date from date picker

		Thread.sleep(1000);

		while (true) {
			try {
				driver.findElement(
						By.xpath("//div[contains(@aria-label,'" + deptDate + "') and @aria-disabled='false']")).click();
				System.out.println("[Step]: Selected date: " + deptDate);
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				System.out.println("[Step]: Clicked next month button");
			}
		}
		driver.quit();
	}

	@Test
	public void bookFlightOnCurrentDateTest() throws InterruptedException {

		String fromCity = "Mumbai";
		String toCity = "Chennai";
		Date dt = new Date();
		System.out.println(dt);
		String month = dt.toString().split(" ")[1];
		String date = dt.toString().split(" ")[2];
		String year = dt.toString().split(" ")[5];
		String currentDate = month + " " + date + " " + year;
		System.out.println(currentDate);

		// Step 1: Launch chrome browser and navigate to app
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.makemytrip.com/");

		driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();

		// Step 2: Click on 'from' city
		driver.findElement(By.id("fromCity")).click();

		// Step 3: Enter 'from' city in input box
		driver.findElement(By.xpath("//div[contains(@class,'autoSuggestPlugin')]//input")).sendKeys(fromCity);

		// Step 4: Select the city
		driver.findElement(By.xpath("//div[contains(@class,'searchCity')]//p[starts-with(text(),'" + fromCity + "')]"))
				.click();

		// Step 5: Click on 'to' city
		driver.findElement(By.id("toCity")).click();

		// Step 6: Enter 'to' city in input box
		driver.findElement(By.xpath("//div[contains(@class,'searchToCity')]//div[@role='combobox']//input")).click();

		// Step 7: Select city from list
		driver.findElement(By.xpath("//div[contains(@class,'searchToCity')]//p[starts-with(text(),'" + toCity + "')]"))
				.click();

		// Step 8: Select current date as departure date
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@aria-label,'" + currentDate + "') and @aria-disabled='false']"))
				.click();
		driver.quit();
	}

}
