package org.hrm.HrHead;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FetchDataBasedOnKeyInExcelUsingWhile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Commondata");
		DataFormatter df=new DataFormatter();
		String value=null;
		int i=0;
		while(i<=sheet.getLastRowNum())
		{
			String key = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(key.equalsIgnoreCase("browser"))
			{
				 value = df.formatCellValue(sheet.getRow(i).getCell(1));	
				break;
			}
			i++;
		}	
		System.out.println(value);
	}

}
