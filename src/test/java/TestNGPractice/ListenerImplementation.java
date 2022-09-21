package TestNGPractice;

import java.io.IOException;

import org.sdet40.GenericUtility.BaseClass;
import org.sdet40.GenericUtility.WebDriverUtility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	private ExtentReports reports;
	public static ExtentTest stest;
	private ExtentTest test;
	
	@Override //BeforeTest
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentreport.html");
		spark.config().setDocumentTitle("Document Title - SDET 40");
		spark.config().setReportName("Report Name- SDET 40");
		spark.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author", "Suma");
		reports.setSystemInfo("OS","Win 11");
		reports.setSystemInfo("Browser", "Chrome");	
		
	}

	@Override //BeforeMethod
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		stest=test;
		
	}

	@Override //AfterMethod
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+ "pass");
		
	}

	@Override //AfterMethod
	public void onTestFailure(ITestResult result) {	
		test.fail(result.getMethod().getMethodName()+ "fail");
		System.out.println(Thread.currentThread().getId());
		try {
			new WebDriverUtility().screeshot(BaseClass.sdriver, BaseClass.sjavautility, 
					result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName() +"test skipped");
		test.fail(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	@Override //AfterTest
	public void onFinish(ITestContext context) {
		reports.flush();
		
	}

}
