package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility {

	// Step 1: IDENTIFICATION: Identify all the web elements using @FindBy,
	// @FindAll, @FindBys annotations

	@FindBy(className = "dvHeaderText")
	private WebElement OrgHeaderText;

	@FindBy(id = "dtlview_Organization Name")
	private WebElement OrgNameText;

	@FindBy(id = "dtlview_Industry")
	private WebElement IndustryNameText;

	@FindBy(id = "dtlview_Type")
	private WebElement TypeNameText;

	// Step 2: INITILIZATION: Create a constructor to initialize variables/web
	// elements

	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Step 3: UTILIZATION: Provide getters to access the web elements

	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}

	public WebElement getOrgNameText() {
		return OrgNameText;
	}

	public WebElement getIndustryNameText() {
		return IndustryNameText;
	}

	public WebElement getTypeNameText() {
		return TypeNameText;
	}

	// Business Library

	/**
	 * This method will capture the organization header and return it to the caller
	 * 
	 * @return
	 */
	public String getOrganizationHeader() {
		return OrgHeaderText.getText();
	}

	/**
	 * This method will capture the Industry name and return it to the caller
	 * @return
	 */
	public String getIndustryName() {
		return IndustryNameText.getText();
	}
}