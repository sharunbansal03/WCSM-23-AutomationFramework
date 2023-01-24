package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility {

	// Step 1: IDENTIFICATION: Identify all the web elements using @FindBy,
	// @FindAll, @FindBys annotations
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateOrgLookUpImg;

	// Step 2: INITILIZATION: Create a constructor to initialize variables/web
	// elements
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Step 3: UTILIZATION: Provide getters to access the web elements
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}

	// Business library
	/**
	 * This method will click on Create Organization Look up image
	 */
	public void clickOnCreateOrganizationLookUpImage() {
		CreateOrgLookUpImg.click();
	}
}