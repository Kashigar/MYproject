package FindingElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
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

public class ReadingTableDataFromHrHead {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/TESTDATA.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("HrAdmin");
		String username = sheet.getRow(1).getCell(1).toString();
		String password = sheet.getRow(1).getCell(2).toString();
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://rmgtestingserver/domain/");
		driver.findElement(By.xpath("//a[text()='HRM_System/']")).click();   /// INSPECT HRM LINK ON SERVER
		driver.findElement(By.name("hr_email")).sendKeys(username); // enters user name
		driver.findElement(By.name("hr_password")).sendKeys(password);//enters password
		
		WebElement ele = driver.findElement(By.id("hr_type"));//choose the option
		Select s = new Select(ele);							//HR Head from the
		s.selectByVisibleText("→ HR Head"); 				// Drop-down list
		
		driver.findElement(By.name("login_hr")).click(); // click on login
		
		Alert a = driver.switchTo().alert();   // Click on ok in alert pop up
		a.accept();
		
		WebElement ele1 = driver.findElement(By.xpath("//p[contains(text(),'EMPLOYEE')]"));
		Actions a1 = new Actions(driver);
		a1.moveToElement(ele1).perform();
		ele1.click();		// Navigate to admin using mousehover and click on admin 
		
		WebElement ele2 = driver.findElement(By.xpath("//p[text()='Add Employee']"));
		Actions a2 = new Actions(driver);
		a2.moveToElement(ele2).perform();
		ele2.click();	// Navigate to suboption add admin using mousehover
		
		
		//List<WebElement> empnameheadlist = driver.findElements(By.xpath("//th[text()='First Name']"));
		
		List<WebElement> empnamelist = driver.findElements(By.xpath("//th[text()='First Name']/following::tr/td[3]"));
		for(WebElement ref:empnamelist)
			System.out.println(ref.getText());
		
		
		
		
		
		
		/*List<WebElement> empnamelist = driver.findElements(By.xpath("//th[text()='First Name']/following::tr/td[3]"));
		for(int i=0; i<empnameheadlist.size();i++)
		{
			String empname=empnameheadlist.get(i).getText();
			if(empname.equals("First Name"))
			{
				 WebElement empnames = driver.findElement(By.xpath("//th[text()='First Name']/following::tr/td["+(i+1)+"]"));
				break;
			}
			
		}
		for(WebElement ref:empnamelist)
		System.out.println(ref.getText());*/
		
		}
		
	}


