package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	// Step 1: IDENTIFICATION: Identify all the web elements using @FindBy,
	// @FindAll, @FindBys annotations
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLnk;

	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;

	@FindBy(linkText = "Products")
	private WebElement ProductsLnk;

	@FindBy(linkText = "More")
	private WebElement MoreLnk;

	@FindBy(linkText = "Vendors")
	private WebElement VendorsLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;

	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;

	// Step 2: INITILIZATION: Create a constructor to initialize variables/web
	// elements
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Step 3: UTILIZATION: Provide getters to access the web elements
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getMoreLnk() {
		return MoreLnk;
	}

	public WebElement getVendorsLnk() {
		return VendorsLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}

	// Business libraries
	/**
	 * This method will click on Organizations link
	 */
	public void clickOnOrganizationsLink() {
		OrganizationsLnk.click();
	}

	/**
	 * This method will click on Contacts link
	 */
	public void clickOnContactsLink() {
		ContactsLnk.click();
	}

	/**
	 * This method will perform logout from application
	 */
	public void logoutOfApp(WebDriver driver) {
		mouseHoverAction(driver, AdministratorImg);
		SignOutLnk.click();
	}
}