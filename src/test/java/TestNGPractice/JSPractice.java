package TestNGPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sdet40.GenericUtility.JavaScriptUtility;
import org.sdet40.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSPractice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		JavaScriptUtility javascutil=new JavaScriptUtility();
		driver.manage().window().maximize();
		javascutil.jsInitialization(driver);
		javascutil.openApplicationUsingJS("https://demo.actitime.com/login.do");
		javascutil.sendKeysUsingJS(driver.findElement(By.id("username")),"admin");
		javascutil.sendKeysUsingJS(driver.findElement(By.name("pwd")), "manager");
		javascutil.clickUsingJS(driver.findElement(By.xpath("//div[text()='Login ']")));
		javascutil.scrollTillElementUsingJS(driver.findElement(By.id("SubmitTTButton")));
	}

}
