package TestNGPractice;

import java.sql.SQLException;
import java.util.List;

import org.sdet40.GenericUtility.DataBaseUtility;
import org.sdet40.GenericUtility.IconstantPath;

public class fetchDataFromDataBase {
	// DDL statements
	public static void main(String[] args) throws SQLException {
		DataBaseUtility databaseUtil=new DataBaseUtility();
		
		//read data from database
		databaseUtil.openDataBaseConnection(IconstantPath.DB_URL, "root", "root");
		List<String> data1 = databaseUtil.getDataFromDatabase("select * from sdet40;","emp_name");
		List<String> data2 = databaseUtil.getDataFromDatabase("select * from sdet40;","emp_Id");
		
		System.out.println(data1);
		System.out.println(data2);
		
		//very the data and ptint boolean result
		boolean verify = databaseUtil.verifyDataIntoDatabase("select * from sdet40;", "emp_name", "shiva");
		System.out.println(verify);
		
		//modify the data into database
		databaseUtil.modifyDataIntoDB("update sdet40 set contry='America' where emp_id=1007;");
		 
		List<String> data3 = databaseUtil.getDataFromDatabase("select * from sdet40;","contry");
		System.out.println(data3);
	}

}
