package vTiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to WebDriver actions
 * 
 * @author sharu
 *
 */
public class WebDriverUtility {

	/**
	 * This method will maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method will minimize the window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method will wait for 20 seconds for all elements to get loaded
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	/**
	 * This method will wait until a particular element becomes visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will wait until a particular element becomes clickabe
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickabe(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will handle dropdown by using index
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * This method will handle dropdown by using value
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * This method will handle dropdown by using visible text
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropDown(String text, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * This method will perform mouse hover action on a specified element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method will perform double click anywhere on the page
	 * 
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * This method will perform double click on a specific element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method will perform right click anywhere on the page
	 * 
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	/**
	 * This method will perform right click on a specific element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * This method will perform drag and drop action from source to destination
	 * 
	 * @param driver
	 * @param srcElement
	 * @param dstElement
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement dstElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, dstElement).perform();
	}

	/**
	 * This method will switch to frame based on the index
	 * 
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrame(WebDriver driver, int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}

	/**
	 * This method will switch to frame based on the frame name or frame ID
	 * 
	 * @param driver
	 * @param frameIDOrName
	 */
	public void switchToFrame(WebDriver driver, String frameIDOrName) {
		driver.switchTo().frame(frameIDOrName);
	}

	/**
	 * This method will switch to frame based on the web element
	 * 
	 * @param driver
	 * @param frameElement
	 */
	public void switchToFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	/**
	 * This method will switch back to immediate parent
	 * 
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * This method will switch back to default frame
	 * 
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method will accept the alert pop up
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method will dismiss the alert pop up
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method will get the text of alert pop up and return it to the caller
	 * 
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	/**
	 * This method will switch to the window based on the partial window title
	 * 
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		// Step 1: capture all the window IDs
		Set<String> winIds = driver.getWindowHandles();

		// Step 2: Extract individual window ID
		for (String winID : winIds) {

			// Step 3: capture the currentWindow Title
			String currentTitle = driver.switchTo().window(winID).getTitle();

			// Step 4: compare the current window title with required title
			if (currentTitle.contains(partialWinTitle)) {
				break;
			}
		}
	}

	/**
	 * This method will take screenshot and store it in a folder
	 * 
	 * @param driver
	 * @param screenshotsName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenshot(WebDriver driver, String screenshotsName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destinationPath = ".\\Screenshots\\"+screenshotsName+".png";
		File dst = new File(destinationPath);
		FileUtils.copyFile(src, dst); // from commons io dependency

		return dst.getAbsolutePath(); // to attach screenshot to extent report
	}

	/**
	 * This method will scroll downwards randomly
	 * 
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", ""); // scroll down
	}

	/**
	 * This method will scroll downwards until the specific element
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0," + y + ")", element);
	}
}