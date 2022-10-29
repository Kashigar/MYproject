package org.hrm.HrHead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleValuesFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		FileInputStream fis = new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Commondata");
		DataFormatter df = new DataFormatter();
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
			for(int j=1;j<sheet.getRow(i).getLastCellNum();j++)
			{
				String value = df.formatCellValue(sheet.getRow(i).getCell(j));
				System.out.print(value+ "||");
			}
			System.out.println();
		}
	}

}
