package FindingElements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	//public static WebDriver driver;
	
	public static void main(String[] args) {
		String browser="chrome";
		 WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rmgtestingserver/domain/HRM_System/Superadmin_Dashboard/Add_admin.php");
	}

}
