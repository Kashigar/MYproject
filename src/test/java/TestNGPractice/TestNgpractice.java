package TestNGPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgpractice {
	
	
	@BeforeMethod
	public void runTest2()
	{
		System.out.println("Before method 1 ");
	}
	@BeforeMethod 
	public void runTest3()
	{
		System.out.println("Before method 2 ");
	}
	@AfterMethod 
	public void runTest1()
	{
		System.out.println("After method 1");
	}
	@AfterMethod 
	public void runTest4()
	{
		System.out.println("After method 2");
	}
	@Test 
	public void testscript1()
	{
		System.out.println("Test 1");
	}
	@Test (priority=1)
	public void testscript2()
	{
		System.out.println("Test 2");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After test");
	}
	@BeforeTest 
	public void bfterTest() {
		System.out.println("Before test");
	}
	@BeforeClass 
	public void runTest6()
	{
		System.out.println("Before_Class 1 ");
	}
	@BeforeClass 
	public void runTest5()
	{
		System.out.println("Before_Class 2");
	}
	@AfterClass
	public void runTest7()
	{
		System.out.println("After_Class 1");
	}
	@AfterClass
	public void runTest8()
	{
		System.out.println("After_Class 2");
	}
	@AfterSuite( enabled=true)
	public void runTest10()
	{
		System.out.println("After suit 1");
	}
	@BeforeSuite
	public void runTest9()
	{
		System.out.println("Before suit 1");
	}
	@BeforeSuite 
	public void runTest11()
	{
		System.out.println("Before suit 2");
	}
	

}
