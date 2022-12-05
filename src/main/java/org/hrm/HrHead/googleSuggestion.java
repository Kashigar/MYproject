package org.hrm.HrHead;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class googleSuggestion 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		Alert a =driver.switchTo().alert();
		driver.findElement(By.name("//input[@name='q']")).sendKeys("virat");
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='G43f7e']/../ul/li"));
		for(WebElement s:options)
		{
			System.out.println(s.getText());
		}
	}
}
		
		
		

