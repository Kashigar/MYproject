package org.hrm.HrHead;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MethodChaining {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/Book1.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
		try
		{
			Sheet sheet = wb.getSheet("Commondata");
			String username = sheet.getRow(1).getCell(1).getStringCellValue();
			String password = sheet.getRow(2).getCell(1).getStringCellValue();
			String url = sheet.getRow(0).getCell(1).getStringCellValue();
			String browser = sheet.getRow(3).getCell(1).getStringCellValue();
			
			System.out.println(username);
			System.out.println(password);
			System.out.println(url);
			System.out.println(browser);
			
			
		}
		finally 
		{
			wb.close();
		}
		
	}

}
