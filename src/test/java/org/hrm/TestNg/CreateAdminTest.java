package org.hrm.TestNg;

import java.io.IOException;
import java.util.Map;

import org.hrm.ObjectRepository.TabNames;
import org.sdet40.GenericUtility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAdminTest extends BaseClass {
	@Test
	public void createAdminTest() throws IOException {

		common.clickRequiredTab(TabNames.ADMIN, webdriverUtility, driver);
		
		Map<String, String> map = create.addAdminDetails(webdriverUtility, excelutil);
		
		webdriverUtility.alertPopup(driver);
		webdriverUtility.screeshot(driver, javaUtil, className);

		String expected = map.get("Branch_Name");
		String actualvalue = create.getActualvalue().getText();
		Assert.assertEquals(actualvalue, expected, " Actual & Expected values are not matching");

	}
}
