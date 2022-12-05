package FindingElements;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZohoCrm {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.oracle.com/in/java/technologies/javase/javase8-archive-downloads.html");

		// Capture all links and store
		List<WebElement> links = driver.findElements(By.tagName("a"));
		//print the num of links
		System.out.println(links.size());

		for (int i = 0; i < links.size(); i++) {
			// to get url of links
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
//find whether target is there on not for url 
			URL link = new URL(url); //link a objrect of URL class for which u are passing url
			// create connection
			HttpURLConnection httpcon = (HttpURLConnection) link.openConnection(); //httpurlconnect is special class to check url is connected to target page or not without clicking
			httpcon.connect();

			int response = httpcon.getResponseCode(); // if code is above 400 means its a broken url

			if (response > 404) {
				System.out.println(url + " " + "is broken link");
			} else {
				System.out.println(url + " " + "its a valid link");
			}
		}

	}

}
