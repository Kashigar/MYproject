package org.hrm.HrHead;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step 1: Convert the data into java readable object
		FileInputStream fis=new FileInputStream("./src/test/resources/Book1.xlsx");
		
		//step 2: open excel workbook
		Workbook wb=WorkbookFactory.create(fis);
		
		//step 3: get the control on sheet
		Sheet sheet = wb.getSheet("Commondata");
		
		//step 4: get control on row
		Row row = sheet.getRow(1);
		
		//step 5: get control on column
		Cell cell = row.getCell(1);	
		
		//step 6 : fetch the data 
		String username = cell.getStringCellValue();
		System.out.println(username);
		
		//step 7 close the workbook
		wb.close();
			
	}
		

}
