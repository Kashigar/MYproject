package CrmTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTest{
	WebDriver driver=null;
	@Test
	public void checkFlightTest()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		WebElement frame=driver.findElement(By.xpath("//iframe[@data-notification-layout-name='model']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']")).click();
	
	}

}
