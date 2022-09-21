package FindingElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//div[text()='Mobiles']"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		ele.click();
		
		WebElement ele1 = driver.findElement(By.xpath("//span[@class='_2I9KP_']"));
		Actions a1=new Actions(driver);
		a.moveToElement(ele1).perform();
		ele1.click();
		
		driver.findElement(By.xpath("//a[text()='Realme']")).click();
		
		driver.findElement(By.xpath("//div[text()='realme C25_Y (Metal Grey, 64 GB)']")).click();
		
		driver.findElement(By.xpath("//span[text()='realme C25_Y (Metal Grey, 64 GB)']/following::div[@class='_30jeq3 _16Jk6d']")).click();
		
		
	}

}
