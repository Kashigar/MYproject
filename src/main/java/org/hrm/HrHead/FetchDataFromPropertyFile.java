package org.hrm.HrHead;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {
	public static void main(String[] args) throws IOException {
		// step 1: Convert physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/common.properties");

		// step 2: create object for properties file
		Properties property = new Properties();

		// step 3: load all the keys present in the property file
		property.load(fis);

		// step 4: fetch the data
		String url = property.getProperty("url").trim();
		String browser = property.getProperty("browser");

		System.out.println(url);
		System.out.println(browser.trim());

		FileOutputStream fos = new FileOutputStream("./src/test/resources/common.properties", true);
		//property.save(fos, "url data updated"); //deprecated
		property.store(fos, "url data updated");

	}

}
