package FindingElements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripUsingExcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("MakemytripFrom");
		String FromCityCode = sheet.getRow(7).getCell(0).getStringCellValue();
		String ToCityCode=sheet.getRow(7).getCell(1).getStringCellValue();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        
        driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(FromCityCode);
		driver.findElement(By.xpath("//div[text()='"+FromCityCode+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(ToCityCode);
		driver.findElement(By.xpath("//div[text()='"+ToCityCode+"']")).click();
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		}
	}


