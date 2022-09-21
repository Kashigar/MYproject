package TestNGPractice;

import org.testng.annotations.Test;

public class TestCaseClass3 {
	@Test
	public void testMethod1() {
		System.out.println("Class 3----> Method 1" + Thread.currentThread().getId());
	}

}
