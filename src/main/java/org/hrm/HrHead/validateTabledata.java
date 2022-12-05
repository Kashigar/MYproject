package org.hrm.HrHead;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;



public class validateTabledata {

	public static void main(String[] args) throws SQLException {
	Driver dbdriver=new Driver();
	DriverManager.registerDriver(dbdriver);
	Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root" , "root");
	Statement statement=connect.createStatement();
	ResultSet result = statement.executeQuery("select * from empl;");
	
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter the enployee name");
	 String ename = sc.nextLine();
	
	 ArrayList list = new ArrayList();
	 
	 while(result.next())
	 {
		 list.add(result.getString("empname"));
	 }	

	 if(list.contains(ename))
	 {
		 System.out.println("employee name is present");
	 }
	 else
	 {
		 System.out.println("Employee name is not there so add the employee whould like to add?? please enter yes"); 
		 String data = sc.next();
		 if (data.equalsIgnoreCase("Yes")) {
			 statement.executeUpdate("insert into empl values('"+ename+"');");
			 System.out.println(ename +": added");
		}
		 
	 }
	
	 
	}
}
