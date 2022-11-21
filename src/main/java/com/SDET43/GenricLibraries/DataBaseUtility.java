package com.SDET43.GenricLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	/**
	 * This method is used to register and get the connection from the database
	 * @author Admin
	 */
	
	Connection con = null;
	public void connectToDB() throws Throwable
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con =  DriverManager.getConnection(iPathConstant.dbURL, iPathConstant.dbUsername, iPathConstant.dbPassword);
	}

	/**
	 * This method is used to execute query and get the data for user
	 * @author Admin
	 * @param query
	 * @param ColumnIndex
	 * @param expdata
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndgetData(String query, int ColumnIndex, String expdata, String data) throws Throwable
	{
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			data = result.getString(ColumnIndex);
			if(data.equalsIgnoreCase(expdata))
			{
				flag = true;
				break;
			}
		}
			if(flag)
				{
					System.out.println(data+"------->data verified");
					return expdata;
				}
				else
				{
					System.out.println(data+"-------->not verified");
					return "";
				}
			}
	/**
	 * This method is used to close the database
	 * @throws Throwable
	 */
	public void close() throws Throwable 
	{
		con.close();
	}
}
