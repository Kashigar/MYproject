package TestNGPractice;

import org.testng.annotations.Test;

public class TestCaseClass2 {
	@Test
	public void testMethod3() {
		System.out.println("Class 2 ---->Method 1" + Thread.currentThread().getId());
	}

}
