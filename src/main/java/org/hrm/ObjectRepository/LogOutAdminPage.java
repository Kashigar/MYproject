package org.hrm.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutAdminPage {

	@FindBy (xpath="//b[.='Welcome!,']") private WebElement  signoutButton;
	 @FindBy (xpath="//a[@href=\"log_out.php\"]") private WebElement logOutButton;
	
	 public LogOutAdminPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void adminLogoutAction() {
		 signoutButton.click(); 
		 logOutButton.click();
	 }
}
