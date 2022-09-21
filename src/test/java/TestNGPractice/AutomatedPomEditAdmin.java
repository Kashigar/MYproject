package TestNGPractice;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.hrm.ObjectRepository.LoginPage;
import org.hrm.ObjectRepository.editAdminPage;
import org.hrm.ObjectRepository.homePages;
import org.openqa.selenium.WebDriver;
import org.sdet40.GenericUtility.ExcelUtility;
import org.sdet40.GenericUtility.FileUtility;
import org.sdet40.GenericUtility.IconstantPath;
import org.sdet40.GenericUtility.JavaUtility;
import org.sdet40.GenericUtility.WebDriverUtility;

public class AutomatedPomEditAdmin {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, AWTException {

		WebDriverUtility webdriverUtil = new WebDriverUtility();
		  ExcelUtility excelutil = new ExcelUtility();
		  FileUtility fileUtil = new FileUtility();
		  String url = null;
		  String browser=null;
		  WebDriver driver=null;
		  String username=null;
		  String password=null;
		  fileUtil.initializepropertyFile(IconstantPath.PROPERTY_FILE_PATH);
		  url= fileUtil.getDataFrompropertyFile("url");
		  browser= fileUtil.getDataFrompropertyFile("browser");
		driver=webdriverUtil.openBrowserWithApplication(browser, 3, url);
		username= fileUtil.getDataFrompropertyFile("username");
		password= fileUtil.getDataFrompropertyFile("password");
			
			excelutil.initializeExcel(IconstantPath.EXCEL_PATH);
			String oldPhnNum=excelutil.getDataFromExcel("Sheet1", 1, 3);
			String newPhnNum=excelutil.getDataFromExcel("Sheet1", 1, 4);
		
		// initiallise all object repository class
		LoginPage loginPage = new LoginPage(driver);

		// script--->test steps
		loginPage.loginAction(username, password);
		loginPage.hrtype();
		loginPage.login();
		webdriverUtil.alertPopup(driver);
		homePages hm = new homePages(driver);

		// commonPage common=new commonPage(driver);
		// common.clickRequiredTab( TabNames.CORPORATE, webdriverUtil);
		hm.adminClickAction();

		editAdminPage editadmin = new editAdminPage(driver);
		editadmin.editingAdminPhoneNumber(oldPhnNum, newPhnNum);
		webdriverUtil.alertPopup(driver);
		

	}

}
