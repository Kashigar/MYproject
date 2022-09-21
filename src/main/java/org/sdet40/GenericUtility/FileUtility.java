package org.sdet40.GenericUtility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	Properties property;
	String key;
	/*
	 * This method is used to initialize property file
	 */
	public void initializepropertyFile(String propertFilePth) {
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propertFilePth);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
	public String getDataFrompropertyFile(String key) {
		return property.getProperty(key);
	}

}