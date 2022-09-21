package org.hrm.TestNg;

import java.awt.AWTException;
import java.io.IOException;

import org.hrm.ObjectRepository.TabNames;
import org.sdet40.GenericUtility.BaseClass;
import org.testng.annotations.Test;

public class deleteAdminTest extends BaseClass{
	
	@Test
	public void DeleteAdminTest() throws IOException, AWTException {
		common.clickRequiredTab(TabNames.ADMIN, webdriverUtility, driver);
		delete.deleteAdmin(adminName,javaUtil);
		webdriverUtility.alertPopup(driver);
		
		
		
	}
}