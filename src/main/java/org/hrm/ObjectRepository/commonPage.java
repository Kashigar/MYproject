package org.hrm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.GenericUtility.WebDriverUtility;

public class commonPage {
	//private WebDriver driver;
	private String dynamicxpath = "//p[contains(.,'%s')]";
	@FindBy(xpath = "ADMIN")
	private WebElement corporateButton;
	
	@FindBy (xpath="//p[text()='Add Admin']") private WebElement addadminbutton;
	@FindBy (xpath="//p[text()='Add Braches']") private WebElement addBranchButton;
	
	//private String dynamicxpath2="//html[@lang='en']//div[@class='card-body']//tr[@class='odd']/td[text()='&s']";
	//@FindBy(xpath="1001")
	//private WebElement adminId;

	@FindBy(xpath="//b[.='Welcome!,']") 
	private WebElement welcomeButton;
	@FindBy(xpath = "//a[@href='log_out.php']")
	private WebElement signOutbutton;

	// initiallization of all elements
	public commonPage(WebDriver driver) {
		// this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// business library

	public void clickRequiredTab(TabNames tabName, WebDriverUtility webdriverUtility, WebDriver driver) {
		webdriverUtility.convertDynamicXpathIntoWebElement(dynamicxpath, tabName.getTabName(), driver).click();
		addadminbutton.click();
	}
	
	public void clickRequiredTabforBranch(TabNames tabName, WebDriverUtility webdriverUtility, WebDriver driver) {
		webdriverUtility.convertDynamicXpathIntoWebElement(dynamicxpath, tabName.getTabName(), driver).click();
		addBranchButton.click();
	}


	public void signOut(WebDriver driver) {
		welcomeButton.click();
		signOutbutton.click();
	}
}
