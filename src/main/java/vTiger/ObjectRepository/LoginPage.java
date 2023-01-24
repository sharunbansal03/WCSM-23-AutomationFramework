package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class LoginPage extends WebDriverUtility{
	// Rule 1: Create a POM class for every web page

	// Rule 2: Class name should be the title of page and ending with "Page"

	// Rule 3: Identify the web elements using @FindBy , @FindAll, @FindBys
	// annotations

	@FindBy(name = "user_name")
	private WebElement UserNameEdt;

	@FindBy(name = "user_password")
	private WebElement PasswordEdt;

	@FindBy(id = "submitButton")
	private WebElement SubmitBtn;

	// Rule 4: Create a constructor to initialize the variables/ web elements
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this); // initializes web element using updated driver reference
	}

	// Rule 5: Provide getters to access the web elements
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	// Rule 6: Business library - Generic methods for this application

	/**
	 * This method will login to the application
	 * 
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME, String PASSWORD) {
		UserNameEdt.sendKeys(USERNAME);
		PasswordEdt.sendKeys(PASSWORD);
		SubmitBtn.click();
	}

}
