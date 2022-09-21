package org.hrm.TestNg;

import java.awt.AWTException;
import java.io.IOException;

import org.hrm.ObjectRepository.TabNames;
import org.sdet40.GenericUtility.BaseClass;
import org.testng.annotations.Test;
public class EditAdminTest extends BaseClass {

	@Test
	public void editAdminTest() throws AWTException, IOException {
		
		oldPhnNum = excelutil.getDataFromExcel("Sheet1", 1, 3);
		newPhnNum = excelutil.getDataFromExcel("Sheet1", 1, 4);
		
		common.clickRequiredTab(TabNames.ADMIN, webdriverUtility, driver);
		editAdminPage.editingAdminPhoneNumber(oldPhnNum, newPhnNum);
		webdriverUtility.alertPopup(driver);
		webdriverUtility.screeshot(driver, javaUtil, className);
	}
}
