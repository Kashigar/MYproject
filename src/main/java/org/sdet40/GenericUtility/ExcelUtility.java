package org.sdet40.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of all common actions on excel
 * @author LENOVO
 *
 */

// Accessspecifier modifier , methodname (parameter){}
//Accessspecifier--> public,private,protected,default
//modifiers--> static, non static 
//return type-->primitive and clas type
//methodName--> follow camelCase-->give meaningfulname
//parameters--> optional---> based on the tatement input

/**
 * 
 * @author LENOVO
 *
 */
public class ExcelUtility {
	Workbook wb;
	
	public void initializeExcel(String excelpath) {
		FileInputStream fis=null;;
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
}

	/**
	 * This method is used to get the data from the excel file
	 * 
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param colunNumber
	 * @return
	 */
	

	public String getDataFromExcel(String sheetName, int rowNumber, int colunNumber) {
		
		Sheet sheet = wb.getSheet(sheetName);
		String data = new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(colunNumber));
		return data;
	}
	

	/**
	 * this method used to set the data into excel
	 * 
	 * @param sheetName
	 * @param rowNumber
	 * @param colunNumber
	 * @param text
	 */
	public void setDataIntoExceel(String sheetName, int rowNumber, int colunNumber, String text) {
		Sheet sheet = wb.getSheet(sheetName);
		sheet.getRow(rowNumber).createCell(colunNumber).setCellValue(text);

	}

	/**
	 * this method used to save the data into excel
	 * 
	 * @param outputpath
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void saveDataIntoExcel(String outputpath) throws FileNotFoundException, IOException {
		wb.write(new FileOutputStream(outputpath));

	}
	/**
	 * This methos is used to close the Excel
	 * @throws IOException
	 */

	public void  closeExcelWorkBoook() throws IOException {
		wb.close();
		
	}
	
	/**
	 * This method is used to get the data from excel based on colum usin Map
	 * @param sheetName
	 * @return
	 */
	public Map<String, String> getDataFromEcelInMap(String sheetName) 
	{
		Sheet sheet = wb.getSheet(sheetName);
		Map<String, String> map= new HashMap<>();
		DataFormatter df = new DataFormatter();
		for(int i=0;i<=sheet.getLastRowNum(); i++) 
		{
			map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(1)));
		}
		return map;
		}
	
	/**
	 * This method is used to read multiple data from excel
	 * @param sheetname
	 * @return
	 */
	public String [][] getMultipleDataFromExcel(String sheetname){
		Sheet sheet=wb.getSheet(sheetname);
		DataFormatter df= new DataFormatter();
		String[][] arr=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=1;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
{
				arr[i-1][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
			
			}
		}
		return arr;
		
		
	}

	/**
	 * This method is used to get the data from excel based on colum usin list
	 * @param sheetName
	 * @return
	 */
	public List<Map<String, String>> getDataFromExcelInList(String sheetName) {
		Sheet sheet = wb.getSheet(sheetName);
		
		List<Map<String,String>> list = new ArrayList<>();
		DataFormatter df = new DataFormatter();
		for(int k=1; k<=sheet.getRow(0).getLastCellNum(); k++)
		{
			Map<String,String> map=new HashMap<>();
			for(int i=0; i<sheet.getLastRowNum(); i++)
			{
				map.put(df.formatCellValue(sheet.getRow(i).getCell(0)),df.formatCellValue(sheet.getRow(i).getCell(k)));
			}
			list.add(map);	
		}
		return list;
	}
	public Map<String, String> getDataFromexcelBasedOnKey(String sheetname, String expectedValue) {
		Sheet sheet= wb.getSheet(sheetname);
		Map<String,String> map= new HashMap<>();
		DataFormatter df=new DataFormatter();
		for(int i=0; i<=sheet.getLastRowNum(); i++)
		{
			if(df.formatCellValue(sheet.getRow(i).getCell(1)).equals(expectedValue))
			{
				for(int j=1; j<=sheet.getLastRowNum(); j++) 
				{	
					map.put(df.formatCellValue(sheet.getRow(j).getCell(2)), df.formatCellValue(sheet.getRow(j).getCell(3)));
					if(df.formatCellValue(sheet.getRow(j).getCell(2)).equals("#####"))
					break;
				}
				break;
				}
			}
		return map;
	}
}
