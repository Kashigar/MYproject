package TestNGPractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeAutomationTestCase {
	public static void main(String[] args) throws AWTException, InterruptedException, EncryptedDocumentException, IOException {
		 
		
		WebDriverManager.chromedriver().setup();
		FileInputStream fis = new FileInputStream("./src/test/resources/TESTDATA.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		//DataFormatter df=new DataFormatter();
		String username = sheet.getRow(1).getCell(1).getStringCellValue();
		String password = sheet.getRow(1).getCell(2).getStringCellValue();
		String searchValue = sheet.getRow(1).getCell(3).getStringCellValue();
		String newValue = sheet.getRow(1).getCell(4).getStringCellValue();
	
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("http://rmgtestingserver/domain/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='HRM_System/']")).click(); /// INSPECT HRM LINK ON SERVER
		driver.findElement(By.name("hr_email")).sendKeys(username); // enters username
		driver.findElement(By.name("hr_password")).sendKeys(password);//enters password

		WebElement ele = driver.findElement(By.id("hr_type"));// choose the option
		Select s = new Select(ele); // HR Head from the
		s.selectByVisibleText("→ HR Head"); // Drop-down list

		driver.findElement(By.name("login_hr")).click(); // click on login
		Alert a = driver.switchTo().alert(); // Click on ok in alert pop up
		a.accept();

		WebElement ele1 = driver.findElement(By.xpath("(//a[@class='nav-link'])[9]"));
		Actions a1 = new Actions(driver);
		a1.moveToElement(ele1);
		ele1.click(); // Navigate to admin using mousehover and click on admin

		WebElement ele2 = driver.findElement(By.xpath("(//a[@class='nav-link'])[10]"));
		Actions a2 = new Actions(driver);
		a2.moveToElement(ele2);
		ele2.click(); // Navigate to suboption add admin using mousehover

		driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys("+9663870389");

	Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL); // give control to keyboard so it will click
		r.keyPress(KeyEvent.VK_MINUS); // ctrl+ minus button 2 times
		r.keyPress(KeyEvent.VK_MINUS);

		r.keyRelease(KeyEvent.VK_CONTROL); // To release the pressed keys
		r.keyRelease(KeyEvent.VK_MINUS);
		r.keyRelease(KeyEvent.VK_MINUS);

		driver.findElement(By.xpath("//i[@class='fa fa-edit']")).click(); // click on edit icon
		driver.findElement(By.xpath("//input[@value='+9663870389']")).clear(); // clear the data present in the field
		driver.findElement(By.xpath("//input[@value='+9663870389']")).sendKeys("+9035346156"); // to write new value (new
																							// phone num

		driver.findElement(By.xpath("(//button[text()='Save'])[4]")).click(); // click on save button

		Alert a4 = driver.switchTo().alert(); // switch the alert pop up displayed
		a4.accept(); // to click on ok

		driver.close();
		
	}


}
