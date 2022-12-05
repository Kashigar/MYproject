package org.hrm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class tripPage {
	@FindBy (xpath="//a[text()='Search']") private WebElement searchbutton;
	//@FindBy(xpath="") private WebElement popularflight;
	
	public void TripPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void enterIntoApl()
	{
		searchbutton.click();
	}

}
