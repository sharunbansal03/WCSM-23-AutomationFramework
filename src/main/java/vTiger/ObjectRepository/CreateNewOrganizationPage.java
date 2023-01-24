package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {

	// Step 1: IDENTIFICATION: Identify all the web elements using @FindBy,
	// @FindAll, @FindBys annotations

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement CancelBtn;

	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;

	@FindBy(name = "industry")
	private WebElement IndustryDropDown;

	@FindBy(name = "accounttype")
	private WebElement TypeDropDown;

	// Step 2: INITILIZATION: Create a constructor to initialize variables/web
	// elements

	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Step 3: UTILIZATION: Provide getters to access the web elements

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getCancelBtn() {
		return CancelBtn;
	}

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getTypeDropDown() {
		return TypeDropDown;
	}

	// Business Libraries: Generic methods for this application

	/**
	 * This method will create a simple organization with Mandatory field and save
	 * Organization Name
	 * 
	 * @param ORGNAME
	 */
	public void createNewOrganization(String OrgName) {
		OrgNameEdt.sendKeys(OrgName);
		SaveBtn.click();
	}

	/**
	 * This method will create an organization with Organization Name and Industry
	 * 
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrganization(String OrgName, String Industry) {
		OrgNameEdt.sendKeys(OrgName);
		handleDropDown(IndustryDropDown, Industry);
		SaveBtn.click();
	}

	/**
	 * This method will create organization with Organization name, Industry and
	 * Type
	 * 
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param TYPE
	 */
	public void createNewOrganization(String OrgName, String Industry, String Type) {
		OrgNameEdt.sendKeys(OrgName);
		handleDropDown(IndustryDropDown, Industry);
		handleDropDown(IndustryDropDown, Type);
		SaveBtn.click();
	}
}