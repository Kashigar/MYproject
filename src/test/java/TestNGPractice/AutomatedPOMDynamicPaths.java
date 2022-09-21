package TestNGPractice;

import java.awt.AWTException;

import org.hrm.ObjectRepository.LogOutAdminPage;
import org.hrm.ObjectRepository.LoginPage;
import org.hrm.ObjectRepository.TabNames;
import org.hrm.ObjectRepository.commonPage;
import org.hrm.ObjectRepository.editAdminPage;
import org.hrm.ObjectRepository.homePages;
import org.openqa.selenium.WebDriver;
import org.sdet40.GenericUtility.ExcelUtility;
import org.sdet40.GenericUtility.FileUtility;
import org.sdet40.GenericUtility.IconstantPath;
import org.sdet40.GenericUtility.WebDriverUtility;

public class AutomatedPOMDynamicPaths {

	public static void main(String[] args) throws AWTException {
		String url = null;
		String browser = null;
		String username = null;
		String password = null;

		WebDriverUtility webdriverUtil = new WebDriverUtility();
		ExcelUtility excelutil = new ExcelUtility();
		FileUtility fileUtil = new FileUtility();

		fileUtil.initializepropertyFile(IconstantPath.PROPERTY_FILE_PATH);
		url = fileUtil.getDataFrompropertyFile("url");
		browser = fileUtil.getDataFrompropertyFile("browser");
		WebDriver driver = webdriverUtil.openBrowserWithApplication(browser, 3, url);
		username = fileUtil.getDataFrompropertyFile("username");
		password = fileUtil.getDataFrompropertyFile("password");

		excelutil.initializeExcel(IconstantPath.EXCEL_PATH);
		String oldPhnNum = excelutil.getDataFromExcel("Sheet1", 1, 3);
		String NewPhnNum = excelutil.getDataFromExcel("Sheet1", 1, 4);

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginAction(username, password);
		loginPage.hrtype();
		loginPage.login();
		webdriverUtil.alertPopup(driver);
		LogOutAdminPage logout=new LogOutAdminPage(driver);
		homePages hm = new homePages(driver);

		commonPage common = new commonPage(driver);
		common.clickRequiredTab(TabNames.ADMIN, webdriverUtil,driver);
		editAdminPage editadmin = new editAdminPage(driver);
		editadmin.editingAdminPhoneNumber(oldPhnNum, NewPhnNum);
		webdriverUtil.alertPopup(driver);
		logout.adminLogoutAction();
		webdriverUtil.alertPopup(driver);
	}

}
