package org.hrm.HrHead;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WrittingDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step 1: Convert the data into java readable object
				FileInputStream fis=new FileInputStream("./src/test/resources/Book1.xlsx");
				
				//step 2: open excel workbook
				Workbook wb=WorkbookFactory.create(fis);
				
				
				//step 3: get the control on sheet
				Sheet sheet = wb.getSheet("Organization");
				
				//step 4: get control on row
				Row row = sheet.createRow(10);
				
				//step 5: get control on column/cell
				Cell cell = row.createCell(3);	
				
				//step 6 : update  the data 
				cell.setCellValue("Skip");
				
				FileOutputStream fos=new FileOutputStream("./src/test/resources/Book1.xlsx");
				wb.write(fos);
				
				System.out.println("Data updated successfully");
				wb.close();
				
	}

}
