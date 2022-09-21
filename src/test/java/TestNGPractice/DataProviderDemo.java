package TestNGPractice;

import org.sdet40.GenericUtility.ExcelUtility;
import org.sdet40.GenericUtility.IconstantPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	@Test (dataProvider="getData")
	public void step2Test(String username, String password) {
		System.out.println(Thread.currentThread().getId());
		System.out.println("userName---->"+ username);
		System.out.println("Password---->"+ password);
		System.out.println();
	}
	@DataProvider
	public String[][] getData(){
		ExcelUtility exelutil= new ExcelUtility();
		exelutil.initializeExcel(IconstantPath.EXCEL_PATH);
		String[][] obj = exelutil.getMultipleDataFromExcel("dataProvider"); //sheet name 
		return obj;
	}
}
