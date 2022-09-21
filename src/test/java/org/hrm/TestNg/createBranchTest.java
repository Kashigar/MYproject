package org.hrm.TestNg;

import java.util.Map;

import org.hrm.ObjectRepository.TabNames;
import org.sdet40.GenericUtility.BaseClass;
import org.testng.annotations.Test;

public class createBranchTest extends BaseClass{
	@Test
	public void CreateBranchTest() {
		common.clickRequiredTabforBranch(TabNames.BRANCH, webdriverUtility, driver);
		
		Map<String, String> map = createbranch.CreateBranchAction(webdriverUtility, excelutil);	
	}
}
