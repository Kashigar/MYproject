package FindingElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sdet40.GenericUtility.JavaScriptUtility;
import org.sdet40.GenericUtility.JavaUtility;
import org.sdet40.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccRanking {
	JavascriptExecutor jsExecutor;
	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.icc-cricket.com/homepage");
		WebDriverUtility webutil= new WebDriverUtility();
		/*WebElement ele = driver.findElement(By.xpath("//h2[text()='ICC Rankings']"));
		
		webutil.scrollBar(ele, driver, loc, x, y);*/
		WebElement ele = driver.findElement(By.xpath("//h2[text()='ICC Rankings']"));
	JavaScriptUtility javasrutil=new JavaScriptUtility();
	javasrutil.scrollTillElementUsingJS(ele);
		ele.click();
		}
}
