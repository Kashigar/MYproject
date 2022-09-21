package TestNGPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sdet40.GenericUtility.ExcelUtility;
import org.sdet40.GenericUtility.FileUtility;
import org.sdet40.GenericUtility.IconstantPath;
import org.sdet40.GenericUtility.WebDriverUtility;

public class AutomatedTestCaseCeateAdmin {
	// WebDriver driver=null;
	public static void main(String[] args) {
		WebDriverUtility webdriverUtil = new WebDriverUtility();
		// JavaUtility javaUtil = new JavaUtility();
		ExcelUtility excelutil = new ExcelUtility();
		FileUtility fileUtil = new FileUtility();
		// WebDriver driver = null;
		String url = null;
		String browser = null;
		String username = null;
		String password = null;
		fileUtil.initializepropertyFile(IconstantPath.PROPERTY_FILE_PATH);
		url = fileUtil.getDataFrompropertyFile("url");
		browser = fileUtil.getDataFrompropertyFile("browser");
		username = fileUtil.getDataFrompropertyFile("username");
		password = fileUtil.getDataFrompropertyFile("password");
		WebDriver driver = webdriverUtil.openBrowserWithApplication(browser, 3, url);

		excelutil.initializeExcel(IconstantPath.EXCEL_PATH);
		String compid = excelutil.getDataFromExcel("Sheet3", 0, 1);
		String firstname = excelutil.getDataFromExcel("Sheet3", 1, 1);
		String midname = excelutil.getDataFromExcel("Sheet3", 2, 1);
		String lastname = excelutil.getDataFromExcel("Sheet3", 3, 1);
		String contactnum = excelutil.getDataFromExcel("Sheet3", 4, 1);
		String email = excelutil.getDataFromExcel("Sheet3", 5, 1);
		String userpassword = excelutil.getDataFromExcel("Sheet3", 6, 1);

		driver.findElement(By.name("hr_email")).sendKeys(username);
		driver.findElement(By.name("hr_password")).sendKeys(password);

		WebElement ele = driver.findElement(By.id("hr_type"));
		webdriverUtil.dropDownList(ele, "→ HR Head");
		driver.findElement(By.name("login_hr")).click();
		webdriverUtil.alertPopup(driver);
		driver.findElement(By.xpath("//p[contains(text(),'ADMIN')]")).click();
		driver.findElement(By.xpath("//p[contains(text(),'Add Admin')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add Admin')]")).click();

		driver.findElement(
				By.xpath("//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_companyid']"))
				.sendKeys(compid);
		driver.findElement(
				By.xpath("//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_firstname']"))
				.sendKeys(firstname);
		driver.findElement(
				By.xpath("//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_middlename']"))
				.sendKeys(midname);
		driver.findElement(By.xpath("//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_lastname']"))
				.sendKeys(lastname);
		driver.findElement(
				By.xpath("//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_contactno']"))
				.sendKeys(contactnum);

		WebElement position = driver
				.findElement(By.xpath("//div[@id='modal-overlay']//div[@class='modal-body']//select[@name='hr_type']"));
		webdriverUtil.dropDownList(position, "→ HR Head");

		driver.findElement(By.xpath("//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_email']"))
				.sendKeys(email);
		driver.findElement(By.xpath("//div[@id='modal-overlay']//div[@class='modal-body']//input[@name='hr_password']"))
				.sendKeys(userpassword);
		driver.findElement(
				By.xpath("//div[@id='modal-overlay']//div[@class='modal-body']/following::button[@name='hr_admin']"))
				.click();
		webdriverUtil.alertPopup(driver);

		driver.findElement(By.xpath("//b[.='Welcome!,']")).click();
		driver.findElement(By.xpath("//a[@href=\"log_out.php\"]")).click();

		String expected = driver.findElement(By.xpath("//td[text()='+9035346156'])[2]")).toString();
		if (expected.equals(firstname)) {
			System.out.println("TC pass");
		} else {
			System.out.println("Tc faile");
		}
	}
}
