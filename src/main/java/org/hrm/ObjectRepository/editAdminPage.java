package org.hrm.ObjectRepository;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.GenericUtility.JavaUtility;
import org.sdet40.GenericUtility.WebDriverUtility;

public class editAdminPage {
	WebDriver driver;
	@FindBy (xpath="//input[@class='form-control form-control-sm']") private WebElement searchTextField;
	@FindBy (xpath="//div[@class='content-wrapper']//i[@class='fa fa-edit']") private WebElement editButton;
	@FindBy (xpath="//td[text()='+9035346156']") private WebElement actualPhnNum;
	
	
	//String actual=driver.findElement(By.xpath("//td[text()='+9035346156']")).getText();
	WebDriverUtility webdriverutilpom=new WebDriverUtility();
	
	@FindBy (xpath="//input[@value='+9663870389']") private WebElement setNewPhnNum;
	@FindBy (xpath="//input[@value='+9663870389']") private WebElement clearData;
	@FindBy (xpath="//div[@id='modal-editx15']/descendant::div[@class='modal-content']/descendant::button[@name='hredit_admin']") private WebElement saveButton;
	public editAdminPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void editingAdminPhoneNumber(String oldPhnNum,String newPhnNum) throws AWTException
	{
		searchTextField.sendKeys(oldPhnNum);
		JavaUtility javautil= new JavaUtility();
		javautil.robotAction();
		editButton.click();
		clearData.clear();
		setNewPhnNum.sendKeys(newPhnNum);
		saveButton.click();	
	}
}
