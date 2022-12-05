package org.hrm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.GenericUtility.WebDriverUtility;

public class zohoCrmLoginPage {
	WebDriverUtility webutil= new WebDriverUtility();
	@FindBy(name="hr_email") private WebElement userNameTextField;
	@FindBy(name="hr_password") private WebElement passwordTextField;
	@FindBy(name="login_hr") private WebElement loginButton;
	
	public zohoCrmLoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);	
		}
	
	public void loginAction(String username, String password) {
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
	}
}