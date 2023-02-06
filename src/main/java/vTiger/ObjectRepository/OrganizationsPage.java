package vTiger.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import vTiger.GenericUtilities.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility {

	// Step 1: IDENTIFICATION: Identify all the web elements using @FindBy,
	// @FindAll, @FindBys annotations
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateOrgLookUpImg;

	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']")
	private List<WebElement> allCheckBoxes;

	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']")
	private List<WebElement> allOrgNames;

	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr[last()]/td/input")
	private WebElement lastRowCheckbox;

	// Step 2: INITILIZATION: Create a constructor to initialize variables/web
	// elements
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Step 3: UTILIZATION: Provide getters to access the web elements
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}

	public List<WebElement> getAllCheckBoxes() {
		return allCheckBoxes;
	}

	public List<WebElement> getAllOrgNames() {
		return allOrgNames;
	}

	public WebElement getLastRowCheckbox() {
		return lastRowCheckbox;
	}

	// Business library
	/**
	 * This method will click on Create Organization Look up image
	 */
	public void clickOnCreateOrganizationLookUpImage() {
		CreateOrgLookUpImg.click();
	}

	/**
	 * This method will select all the check-boxes one by one
	 */
	public void selectAllCheckBoxes() {
		for (WebElement eachCheckBox : allCheckBoxes) {
			eachCheckBox.click();
		}
	}

	/**
	 * This method will select particular checkbox by index
	 */
	public void selectCheckBoxByRowIndex(WebDriver driver, int rowIndex) {
		driver.findElement(
				By.xpath("(//table[@class='lvt small']/tbody/tr[contains(@id,'row')])[" + rowIndex + "]/td[1]/input"))
				.click();
		Reporter.log("[STEP]: Selected checkbox in row indexed: " + rowIndex, true);
	}

	/**
	 * This method will print all Organizations name in table
	 * 
	 */
	public String[] getOrganizationNamesFromTable() {
		String[] allOrganizationNames = new String[allOrgNames.size()];
		for (int i = 0; i < allOrgNames.size(); i++) {
			allOrganizationNames[i] = allOrgNames.get(i).getText();
		}
		return allOrganizationNames;
	}

	/**
	 * This method will click on last row's checkbox
	 */
	public void clickLastCheckBox() {
		lastRowCheckbox.click();
		Reporter.log("[STEP]: Clicked on last check-box", true);
	}

	/**
	 * This method will print Organization Name for given row index
	 */
	public String getOrgNameInGivenRow(WebDriver driver, int rowIndex) {
		return driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[" + rowIndex + "]/td[3]/a")).getText();
	}

	/**
	 * This method will click on 'del' link in given row and handle confirmation
	 * pop-up
	 * 
	 * @param driver
	 * @param index
	 */
	public void deleteOrgAtGivenRowIndex(WebDriver driver, int index) {
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[" + index + "]/td[last()]/a[text()='del']"))
				.click();
		acceptAlert(driver);
		Reporter.log("[STEP]: Deleted Organization at row indexed: " + index, true);
	}
}