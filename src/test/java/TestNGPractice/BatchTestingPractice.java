package TestNGPractice;

import org.testng.annotations.Test;

public class BatchTestingPractice {
	
	@Test (groups={"sanity"})
	public void test1() {
		System.out.println("test case 1");
	}
	@Test (groups={"regression"})
	public void test2() {
		System.out.println("test case 2");
	}
	@Test (groups={"regression","sanity"})	
	public void test3() {
		System.out.println("test case 3");
	}
	@Test (groups={"regression"})	
	public void test4() {
		System.out.println("test case 4");
	}
}
