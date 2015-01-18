package com.bhargav;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Statement;

public class InsertData {
	public static void main(String[] args) {
		
		FileReader fr=null;
		Properties props= new Properties();
		Connection con=null;
		Statement stmt=null;
		String insertQuery="insert into student.student value('ymail','bhargav2','Bhargav06')";
		try {
			fr=new FileReader("config/dbconfig.properties");
			props.load(fr);
			System.out.println("file is loaded");
			Class.forName(props.getProperty("driver"));
			System.out.println("driver is loaded");
			con=DriverManager.getConnection(props.getProperty("url"),props.getProperty("username"),props.getProperty("password"));
			stmt=(Statement) con.createStatement();
			int noir=stmt.executeUpdate(insertQuery);
			System.out.println(noir + "  updated records ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con !=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fr !=null)
			{
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt !=null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}