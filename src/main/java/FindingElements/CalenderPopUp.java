 package FindingElements;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopUp {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String requireddate = "29";
		String requiredmonth = "May";
		String requiredyear = "2028";
		
		driver.get("http://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.id("datepicker")).click();
		
		String actualmonthyear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		String[] str = actualmonthyear.split(" ");
		String actualmonth = str[0];
		String actualyear = str[1];
		
		while(! (actualmonth.equals(requiredmonth) && actualyear.equals(requiredyear)) )
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			
			actualmonthyear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			str = actualmonthyear.split(" ");
			actualmonth = str[0];
			actualyear = str[1];
		}
		driver.findElement(By.xpath("//a[text()='"+requireddate+"']")).click(); 
		
	}

}
