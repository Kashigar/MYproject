package org.hrm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePages {
	@FindBy (xpath="//p[contains(text(),'ADMIN')]") private WebElement adminComponent;
	@FindBy(xpath="//p[contains(text(),'Add Admin')]") private WebElement clickOnAddAdmin;
		
public homePages(WebDriver driver)
{
	PageFactory.initElements(driver, this);	
}
 public void adminClickAction() {
	 adminComponent.click();
	 clickOnAddAdmin.click();
 }

}
