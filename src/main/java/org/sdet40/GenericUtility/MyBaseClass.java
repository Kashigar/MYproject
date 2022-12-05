package org.sdet40.GenericUtility;
import org.hrm.ObjectRepository.tripPage;
import org.hrm.ObjectRepository.zohoCrmLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import FindingElements.MakeMyTrip;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyBaseClass {
	protected FileUtility fileUtil;
	protected WebDriver driver;
	protected String crmurl;
	protected String crmusername;
	protected String crmpassword;
	protected zohoCrmLoginPage logincrm;
	protected WebDriverUtility webutil;
	protected String makemytripurl;
	

	@BeforeClass
	public void ClassSetup() {
	
	fileUtil = new FileUtility();
	crmurl = fileUtil.getDataFrompropertyFile(crmurl);
	crmusername = fileUtil.getDataFrompropertyFile(crmusername);
	crmpassword = fileUtil.getDataFrompropertyFile(crmpassword);
	makemytripurl=fileUtil.getDataFrompropertyFile(makemytripurl);
	}
	
	@BeforeMethod
	public void methodsetUp() {
		
		WebDriverManager.chromedriver().setup();
		logincrm = new zohoCrmLoginPage(driver);
		logincrm.loginAction(crmusername,crmpassword);
		
		webutil.navigateApplication(driver, makemytripurl);
		tripPage trip=new tripPage();
		trip.enterIntoApl();
		
	}
	@AfterMethod
	public void methodTearDown()
	{
		
	}
	@AfterClass
	public void classTearDown()
	{
		
	}
	
}

