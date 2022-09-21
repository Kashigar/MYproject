package TestNGPractice;

import org.testng.annotations.Test;


public class RetryFailDemo {
	@Test
	public void test1() {
		System.out.println("Inside Test 1");
	}
	@Test
	public void test2() {
		System.out.println("Inside Test 2");
	}
	@Test(retryAnalyzer = org.sdet40.GenericUtility.RetryAnalyzerImplement.class)
	public void test3() {
		int i=1/0;
		System.out.println("Inside Test 3");
	}
	@Test
	public void test4() {
		System.out.println("Inside Test 4");
	}



}
