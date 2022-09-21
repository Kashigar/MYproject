package FindingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
		
        String from="BOM";
        String to="BKK";
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(from);
		driver.findElement(By.xpath("//div[text()='"+from+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(to);
		driver.findElement(By.xpath("//div[text()='"+to+"']")).click();
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		}
		
	}

	
		
		
		
		
		