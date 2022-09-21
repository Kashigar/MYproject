package org.hrm.ObjectRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.GenericUtility.JavaUtility;

public class deleteAdminPage {
	//WebDriver driver;
	@FindBy (xpath="//input[@class='form-control form-control-sm']") private WebElement searchField;
	@FindBy (xpath="//table[@id='example1']/tbody/tr[1]/td/i[@class='fa fa-trash']") private WebElement deleteIcon;
	//@FindBy (xpath="//div[@id='modal-deletex34']//div[@class='modal-footer justify-content-between']//button[@name='delete_admin']")
//private WebElement deleteButton;
	@FindBy(name="delete_admin") private WebElement deleteButton;
	public deleteAdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void deleteAdmin(String adminName, JavaUtility javaUtil) throws AWTException
	{
		searchField.sendKeys(adminName);
		javaUtil.robotAction();
		deleteIcon.click();
		deleteButton.click();
	}

}
