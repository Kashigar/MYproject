package org.hrm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.GenericUtility.WebDriverUtility;

public class LoginPage {
	WebDriverUtility webutil= new WebDriverUtility();
	@FindBy(name="hr_email") private WebElement userNameTextField;
	@FindBy(name="hr_password") private WebElement passwordTextField;
	@FindBy(id="hr_type") private WebElement selectHrHeadField;
	@FindBy(name="login_hr") private WebElement loginButton;
	
	//initialise all elements
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);	
		}
	
	//business libraries
	public void loginAction(String username, String password) {
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
	}
	public void hrtype() {
		webutil.dropDownList(selectHrHeadField, "→ HR Head");
	}
	
	public void login() {
		loginButton.click();
	}
}
