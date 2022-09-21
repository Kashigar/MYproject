package org.sdet40.GenericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
	
	JavascriptExecutor jsExecutor;
	public void jsInitialization(WebDriver driver) {
		 jsExecutor = (JavascriptExecutor)driver;
	}
	public void openApplicationUsingJS(String url) {
		jsExecutor.executeScript("window.location=arguments[0]",url);
	}
	public void sendKeysUsingJS(WebElement element,String data) {
		jsExecutor.executeScript("arguments[0].value=arguments[1]",element,data);
	}
	public void clickUsingJS(WebElement element) {
		jsExecutor.executeScript("arguments[0].click()",element);
	}
	public void scrollTillElementUsingJS(WebElement element) {
		 jsExecutor.executeScript("arguments[0].scrolIntoview()",element);
	}

}
