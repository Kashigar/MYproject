package org.hrm.HrHead;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.sdet40.GenericUtility.ExcelUtility;
import org.sdet40.GenericUtility.IconstantPath;

public class FetchDataFromExcelTroughListMap {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtility excelutility= new ExcelUtility();
		
		 excelutility.initializeExcel(IconstantPath.EXCEL_PATH);
		 List<Map<String, String>> list=excelutility.getDataFromExcelInList("form");
		 System.out.println(list.get(6).get("First_Name"));
		 
		/* Map<String, String> map=excelutility.getDataFromEcelInMap("form");
		 System.out.println(map); */
	}

}
