package org.hrm.ObjectRepository;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.GenericUtility.ExcelUtility;
import org.sdet40.GenericUtility.WebDriverUtility;

public class createAdminPage {
		//WebDriver driver;
		@FindBy(xpath = "//button[contains(text(),'Add Admin')]") private WebElement addAdminButton;
		@FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_companyid']")
		private WebElement companyIdButton;
		@FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_firstname']")
		private WebElement firstNameButton;
		@FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_middlename']")
		private WebElement middleNameButton;
		@FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_lastname']")
		private WebElement lastNameButton;
		@FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_contactno']")
		private WebElement contactNoButton;
		@FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']//select[@name='hr_type']")
		private WebElement positionButton;
		@FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_email']")
		private WebElement emailButton;
		@FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_password']")
		private WebElement passwordButton;
		@FindBy(xpath = "//div[@id='modal-overlay']//div[@class='modal-body']/following::button[@name='hr_admin']")
		private WebElement saveButton;
		@FindBy (xpath="//div[@class='card-body']//div[@id='example1_length']/following::th[text()='HR CompanyID']/following::tr/td[text()='1009']")
		private WebElement actualvalue;
		
		@FindBy (xpath="//a[text()='Next']") private WebElement nextButton;

		

		public createAdminPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
			public Map<String, String> addAdminDetails(WebDriverUtility webdriverutil, ExcelUtility excelutil) {
			addAdminButton.click();
			Map<String, String> map = excelutil.getDataFromexcelBasedOnKey("Test Data", "Create_Admin");
			companyIdButton.sendKeys(map.get("Company_Id"));
			firstNameButton.sendKeys(map.get("First_Name"));
			lastNameButton.sendKeys(map.get("Last_Name"));
			middleNameButton.sendKeys(map.get("Mid_Name"));
			contactNoButton.sendKeys(map.get("Contact_Num"));
			webdriverutil.dropDownList(positionButton, "→ HR Head");
			emailButton.sendKeys(map.get("Email"));
			passwordButton.sendKeys(map.get("User_Password"));
			saveButton.click();
			return map;		
		}

			public WebElement getActualvalue() {
				return actualvalue;
			}
			public WebElement getNextButton() {
				return nextButton;
			}
	
}