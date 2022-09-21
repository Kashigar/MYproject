package org.hrm.HrHead;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyTheDataFromDataBase {

	public static void main(String[] args) throws SQLException {
	
			//step 1: create the object for the Driver
			Driver dbdriver=new Driver();
			
			//step 2:register the driver instance to the jdbc
			DriverManager.registerDriver(dbdriver);
			
			//step 3:get/establish the database connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root" , "root");
			
			try {
			//step 4: create the statement 
			Statement statement = connection.createStatement();
			
			
			//step 5: execute the querry
			int result = statement.executeUpdate("update sdet40 set contry='India';");
			
			//step 6: verify the iteration and fetch the data
			System.out.println(result + "Database updated successfully");

			}
			finally {
				//step 7: close the db connection
				connection.close();//mandatory
				System.out.println("Connection closed successfully");
			}
			
		}

	}


