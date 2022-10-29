package org.sdet40.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This method is used to launch the required browser
 * 
 * @author LENOVO
 *
 */
public class WebDriverUtility {
	private WebDriver driver;

	public WebDriver launchBrowser(String browser) {

		// WebDriverManager.chromedriver().setup();
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup(); // method chaining
			driver = new ChromeDriver(); // Abstractin
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("You entered the wrong Browserkey in the Property file");
			break;
		}
		return driver;
	}

	/**
	 * This method is used to maximize the browser
	 * 
	 * @param driver
	 */
	public static void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * Th till loadis method is used to wait the controller implicitly
	 * 
	 * @param TimeOuts
	 */

	public void waitTillPageLoads(WebDriver driver, long TimeOuts) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeOuts));
	}

	/**
	 * This method is used to
	 * 
	 * @param driver
	 * @param url1
	 */
	public void navigateApplication(WebDriver driver, String url) {
		driver.get(url);
	}

	/**
	 * This method is used to launch browser, maximize browser, Wait page implicitly
	 * and navigate application
	 * 
	 * @param browser
	 * @param TimeOuts
	 * @param url
	 * @return
	 */

	public WebDriver openBrowserWithApplication(String browser, long TimeOuts, String url) {
		WebDriver driver = launchBrowser(browser);
		maximizeBrowser(driver);
		waitTillPageLoads(driver, TimeOuts);
		navigateApplication(driver, url);
		return driver;
	}

	/**
	 * This method is used to do mouse hover Action
	 * 
	 * 
	 * @param driver
	 * @param element
	 */
	public static void mouseHoverAction(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}

	/**
	 * This method is used to handle dropdownlist by values
	 * @param element
	 * @param value
	 */

	public void dropDownList(WebElement ele, String text) {
		new Select(ele).selectByVisibleText(text);
	}

	/**
	 * This method is used to double click action
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleclickAction(WebDriver driver, WebElement element) {
		new Actions(driver).doubleClick(element).perform();
	}

	/**
	 * This method is used to accept the alert pop up
	 * 
	 * @param driver
	 */
	public void alertPopup(WebDriver driver) {
		Alert a = driver.switchTo().alert();
		a.accept();

	}

	/**
	 * This method is used to close the browser
	 * 
	 * @param driver
	 */
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}

	/**
	 * This methos is used to Wait until the element is visible
	 * 
	 * @param driver
	 * @param timeouts
	 * @param element
	 */
	public void waitTillElementVisible(WebDriver driver, long timeouts, WebElement element) {
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		Wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to switch to the window based on patial text
	 * 
	 * @param driver
	 * @param partialText
	 */
	public void switchToWindow(WebDriver driver, String partialText) {
		Set<String> winId = driver.getWindowHandles();
		for (String id : winId) {
			driver.switchTo().window(id);
			if (driver.getCurrentUrl().contains(partialText)) {
				break;
			}
		}
	}

	/**
	 * This method is used to convert the dynamic xpath in By locator
	 * ********IMPORTANT************
	 * 
	 * @param dynamicXpath
	 * @param replaceData
	 * @param driver
	 * @return
	 */
//	public By convertDynamicXpathIntoByClass(String dynamicxpath,String replaceData, WebDriver driver)
//	{
//		String requiredXpath= String.format(dynamicxpath,replaceData);
//		By element = By.xpath(requiredXpath);
//		return element;
//	}
	/**
	 * This method is userd to convert dynamic xpath by using webelement class
	 * 
	 * @param dynamicxpath
	 * @param corporate
	 * @param driver
	 * @return
	 */
	public WebElement convertDynamicXpathIntoWebElement(String dynamicxpath, String replaceData, WebDriver driver) {
		String requiredXpath = String.format(dynamicxpath, replaceData);
		WebElement element = driver.findElement(By.xpath(requiredXpath));
		return element;
	}

	/**
	 * This method is used to scroll till the element
	 * 
	 * @param ele
	 * @param driver
	 * @param loc
	 * @param x
	 * @param y
	 */

	public void scrollBar(WebElement ele, WebDriver driver, Point loc, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		loc = ele.getLocation();
		x = loc.getX();
		y = loc.getY();
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
		ele.click();
	}

	public void screeshot(WebDriver driver, JavaUtility javautil, String className) throws IOException {
		String currentTime = javautil.currentTime();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/" + getClass().getSimpleName() + "_" + currentTime + ".png");
		FileUtils.copyFile(scr, dest);
	}

	public void verifyWebPage(WebElement element, WebDriver driver, long longTimeOut, String expectedText) {
		for (;;) {
			try {
				Assert.assertEquals(element.getText(), expectedText);
				break;
			} catch (Exception e) {
				waitTillElementVisible(driver, longTimeOut, element);
			}
		}
	}

}
