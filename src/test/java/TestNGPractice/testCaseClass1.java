package TestNGPractice;

import org.testng.annotations.Test;

public class testCaseClass1 {
	@Test 
	public void testMethod1()
	{
		System.out.println("Class 1---> Method 1" + Thread.currentThread().getId());
	}
	@Test (retryAnalyzer=org.sdet40.GenericUtility.RetryAnalyzerImplement.class)
	public void testMethod2()
	{
		System.out.println("Class 1---> Method 2" + Thread.currentThread().getId());
	}


}
