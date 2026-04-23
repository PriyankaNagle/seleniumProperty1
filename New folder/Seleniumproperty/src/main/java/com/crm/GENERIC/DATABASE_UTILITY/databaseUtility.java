package com.crm.GENERIC.DATABASE_UTILITY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class databaseUtility {
	Connection conn;
	
	public void getDBConnection(String url,String username,String password) throws SQLException {
		try{
		Driver driver=new Driver();
		
		DriverManager.registerDriver(driver);
		 conn = DriverManager.getConnection(url, username, password);
		 }
		catch(Exception e) {
		}
	}

	//no need to pass credentials and um pswrd.
	public void getDBConnection() throws SQLException {
		try{
		Driver driver=new Driver();
		
		DriverManager.registerDriver(driver);
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		 }
		catch(Exception e) {
		}
	}

	
	

    public void closedbConnection() {
    try{
    	conn.close();
    }
    catch(Exception e) {
    	
    }
    }
    
    public ResultSet executeSelectQuery(String Query) throws SQLException {
    	ResultSet result=null;
    	try{
    		Statement stat = conn.createStatement();
    		result = stat.executeQuery(Query);
    	}
    	catch(Exception e) {
    		
    	}
    	return result;
	}
    
    
    
    public int executeNonSelectQuery(String Query) {
    	int result=0;
    	try{
    		Statement stat = conn.createStatement();
    		result= stat.executeUpdate(Query);
    	}
    	catch(Exception e) {
    		
    	}
    	return result;
    	
    }
	}   
    
    
    