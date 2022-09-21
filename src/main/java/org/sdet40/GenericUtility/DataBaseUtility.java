package org.sdet40.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;


public class DataBaseUtility {
	Connection connection;
	
	/** 
	 * This method is used to get the data from database
	 * @param query
	 * @param columName
	 * @return
	 * @throws SQLException
	 */
	public List<String> getDataFromDatabase(String query,String columName) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		List<String> list=new ArrayList<>();
		while(result.next()) { 
			list.add(result.getString(columName));
		}
		return list;
	}
	/**
	 * This method is used to open the darabase connection
	 * @param dbURL
	 * @param dbUserName
	 * @param PassWord
	 * @throws SQLException
	 */
	public void openDataBaseConnection(String dbURL, String dbUserName,String PassWord) throws SQLException {
		Driver dbdriver = new Driver();
		DriverManager.registerDriver(dbdriver);
		connection = DriverManager.getConnection(dbURL,dbUserName ,PassWord);
	}
	
	/**
	 * This methos is usd to Close the database
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		connection.close();
	}
	
	public void modifyDataIntoDB(String query) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
	}
	
	public boolean verifyDataIntoDatabase(String query,String columName, String expectedData) throws SQLException {
		List<String> list = getDataFromDatabase(query, columName);
		boolean flag=false;
		for(String actualData:list) {
			if(actualData.equalsIgnoreCase(expectedData)) {
				flag=true;
				break;
			}
		}
		return flag;
			}
		}
		
	
		



