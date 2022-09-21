package org.sdet40.GenericUtility;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.hrm.ObjectRepository.LoginPage;
import org.hrm.ObjectRepository.commonPage;
import org.hrm.ObjectRepository.createAdminPage;
import org.hrm.ObjectRepository.createBranchPage;
import org.hrm.ObjectRepository.deleteAdminPage;
import org.hrm.ObjectRepository.editAdminPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {	
	//Declaration of all the utility class references
	protected WebDriverUtility webdriverUtility;
	protected ExcelUtility excelutil;
	protected FileUtility fileUtil;
	protected commonPage common;
	protected String username;
	protected String password;
	protected String oldPhnNum;
	protected String newPhnNum;
	protected editAdminPage editAdminPage;
	protected LoginPage log;
	protected WebDriver driver;
	protected String url;
	private String browser;
	private String timeout;
	protected JavaUtility javaUtil;
	protected createAdminPage create;
	protected deleteAdminPage delete;
	protected String adminName;
	
	protected String className;
	
	
	public static WebDriver sdriver;
	public static JavaUtility sjavautility;
	
	protected createBranchPage createbranch;
	protected String branchname;

	/**
	 * Initializing all the
	 * 
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 * 
	 */
	@BeforeClass
	public void ClassSetup() throws EncryptedDocumentException, IOException {
		// create instance for the Generic Utility
		webdriverUtility = new WebDriverUtility();
		 javaUtil = new JavaUtility();
		 excelutil = new ExcelUtility();
		fileUtil = new FileUtility();
		
		 
	sdriver=driver;
		
		fileUtil.initializepropertyFile(IconstantPath.PROPERTY_FILE_PATH);
		url = fileUtil.getDataFrompropertyFile("url");
		browser = fileUtil.getDataFrompropertyFile("browser");
		username = fileUtil.getDataFrompropertyFile("username");
		password = fileUtil.getDataFrompropertyFile("password");
		timeout =fileUtil.getDataFrompropertyFile("timeout");
		
		long wait=(long) javaUtil.convertStringToAnyDataType(timeout, DataType.LONG);
		driver = webdriverUtility.openBrowserWithApplication(browser, wait, url);
		

		sjavautility=javaUtil;
		
		excelutil.initializeExcel(IconstantPath.EXCEL_PATH);
		
		delete = new deleteAdminPage(driver);
		//adminName=excelutil.getDataFromExcel("Sheet4", 0, 1);
		
		
	}

	@BeforeMethod
	public void methodsetUp() {
		editAdminPage = new editAdminPage(driver);
		log = new LoginPage(driver);
		log.loginAction(username,password);
		log.hrtype();
		log.login();
		webdriverUtility.alertPopup(driver);
		common = new commonPage(driver);
		create= new createAdminPage(driver);
		createbranch= new createBranchPage(driver);
	}

	@AfterMethod
	public void methodTearDown() throws FileNotFoundException, IOException {
		common.signOut(driver);
		excelutil.saveDataIntoExcel(browser);
	}

	@AfterClass
	public void classTeardown() throws IOException {
		webdriverUtility.closeBrowser(driver);
		excelutil.closeExcelWorkBoook();
	}

}
