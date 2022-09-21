package TestNGPractice;

import org.sdet40.GenericUtility.WebDriverUtility;
import org.testng.annotations.Test;

public class MavenPracticeTest {
@Test
public void step1test() {
	String browser=System.getProperty("b");
	String url=System.clearProperty("u");
	
	System.out.println("Browser name is ------->>> " + "browser");
	System.out.println("URL is -------->>>> " + "url");
	WebDriverUtility webdriverutil= new WebDriverUtility();
	webdriverutil.openBrowserWithApplication(browser, 10, url);
}
}
