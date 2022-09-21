package org.hrm.ObjectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.GenericUtility.ExcelUtility;
import org.sdet40.GenericUtility.WebDriverUtility;

public class createBranchPage {
	WebDriver driver;
	@FindBy (xpath="//button[contains(.,'Add Branches')]") private WebElement addBranchButton;
	@FindBy (xpath="//div[@id='modal-overlay']//div[@class='modal-header']/following::form[@action='process/addbranches_process.php']//input[@name='branches_name']")
	private WebElement branchNameTextField;
	@FindBy (xpath="//div[@id='modal-overlay']//div[@class='modal-header']/following::form[@action='process/addbranches_process.php']//button[@name='bran']") 
	private WebElement branchsaveButton;
	
	public createBranchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public Map<String, String> CreateBranchAction(WebDriverUtility webdriverutil, ExcelUtility excelutil) {
		addBranchButton.click();
		Map<String, String> map = excelutil.getDataFromexcelBasedOnKey("Branch", "Create_Branch");
		branchNameTextField.sendKeys(map.get("Branch_Name1"));
		branchsaveButton.click();
		return map;
	}
	
}
