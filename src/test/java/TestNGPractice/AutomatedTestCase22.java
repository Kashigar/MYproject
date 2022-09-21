package TestNGPractice;

import org.openqa.selenium.WebDriver;
import org.sdet40.GenericUtility.ExcelUtility;
import org.sdet40.GenericUtility.FileUtility;
import org.sdet40.GenericUtility.JavaUtility;
import org.sdet40.GenericUtility.WebDriverUtility;

public class AutomatedTestCase22 {
  
 /* public static void main(String[] args) 
  {
	  WebDriverUtility webdriverUtil = new WebDriverUtility();
		JavaUtility javaUtil = new JavaUtility();
		ExcelUtility excelutil = new ExcelUtility();
		FileUtility fileUtil = new FileUtility();
		
		
		String url = fileUtil.getDataFromPropertyFile("url");
		WebDriver driver = webdriverUtil.openBrowserWithApplication("chrome", 3, url);
		
		String username = fileUtil.getDataFromPropertyFile("username");
		String password = fileUtil.getDataFromPropertyFile("password");
		String browser = fileUtil.getDataFromPropertyFile("browser");
		String url = fileUtil.getDataFromPropertyFile("url");
		
		WebDriver driver = webdriverUtil.openBrowserWithApplication("chrome", 3, url);
		
		
  }
  }
		
		/*
    
	  String url = new  PropertyFile().getDataFromPropertyFile(IconstantPath.PROPERTY_FILE_PATH ,"url");
	  WebDriver driver = new WebDriverUtility().launchBrowser("chrome");
	  
    new  WebDriverUtility().openBrowserWithApplication(driver,3,url);
    //dri.get("http://rmgtestingserver/");
   
    //dri.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    //dri.findElement(By.linkText("HRM_System/")).click();
    dri.findElement(By.name("hr_email")).sendKeys("hrhead@gmail.com");
    dri.findElement(By.name("hr_password")).sendKeys("hrhead@123");
      
    WebElement drdwn=dri.findElement(By.id("hr_type"));
       Select s = new Select(drdwn);
       s.selectByVisibleText("→ HR Head");
       dri.findElement(By.name("login_hr")).click();
       Alert pop= dri.switchTo().alert();
       pop.accept();
             
   WebElement aa=dri.findElement(By.xpath("(//a[(@class='nav-link')])[7]"));
 new  ebdriverUtility().MouseHoverAction(dri,aa);
   //Actions Act = new Actions(dri);
  // Act.moveToElement(aa).perform();
aa.click();
   
   
   
  WebElement drp=dri.findElement(By.xpath("(//a[@class='nav-link'])[8]"));
 new Webdriverutility().MouseHoverAction(dri,drp);
 // Actions Act2 = new Actions(dri);
 // Act.moveToElement(drp).perform();
  drp.click();
  
  
  
  dri.findElement(By.xpath("(//button[@type='button'])[1]")).click();
  dri.findElement(By.name("employee_companyid")).sendKeys("12345");
  dri.findElement(By.name("employee_firstname")).sendKeys("Madhu");
  dri.findElement(By.name("employee_lastname")).sendKeys("urs");
  dri.findElement(By.name("employee_middlename")).sendKeys("k");
  dri.findElement(By.name("branches_datefrom")).sendKeys("12/05/2022");
  dri.findElement(By.name("branches_recentdate")).sendKeys("25/05/2022");
  WebElement qq =dri.findElement(By.name("employee_department"));
  Select sss = new Select(qq);
  sss.selectByValue("Finance department");
   WebElement www=dri.findElement(By.name("employee_branches"));
   Select zz = new Select (www);
   zz.selectByValue("Bangaluru Branch");
   dri.findElement(By.name("employee_position")).sendKeys("Accoutant");
   dri.findElement(By.name("employee_contact")).sendKeys("9741694407");
   dri.findElement(By.name("employee_sss")).sendKeys("sdsadas");
   dri.findElement(By.name("employee_tin")).sendKeys("5635664651321654");
   dri.findElement(By.name("employee_hdmf_pagibig")).sendKeys("dsefsd-654684");
   dri.findElement(By.name("employee_gsis")).sendKeys("gdghfgb");
   dri.findElement(By.name("employee_file201")).sendKeys("C:\\Users\\madhu\\OneDriveb");

   
   */
}
   
  
  
      
  

