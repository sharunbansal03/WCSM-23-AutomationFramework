package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {

	// Step 1: IDENTIFICATION: Identify all the web elements using @FindBy,
	// @FindAll, @FindBys annotations
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement CreateContactLookUpImg;

	// Step 2: INITILIZATION: Create a constructor to initialize variables/web
	// elements
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Step 3: UTILIZATION: Provide getters to access the web elements
	public WebElement getCreateContactLookUpImg() {
		return CreateContactLookUpImg;
	}

	// Business library
	/**
	 * This method will click on Create Organization Look up image
	 */
	public void clickOnCreateContactLookUpImage() {
		CreateContactLookUpImg.click();
	}
}