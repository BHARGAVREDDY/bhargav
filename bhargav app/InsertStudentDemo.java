package com.bhargav;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Statement;

public class InsertStudentDemo {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		FileReader fr=null;
		Properties prop=null;
		Connection con=null;
		Statement stmt=null;
		String insertQuery="insert into scott.student value('bhargav','bhargavreddy.pu','Bhargav06')";
		try {
			fr=new FileReader("config/dbconfig.properties ");
			prop.load(fr);
			Class.forName(prop.getProperty("driver"));
			con=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
			stmt=(Statement) con.createStatement();
			int nori=stmt.executeUpdate(insertQuery);
			System.out.println(nori+"record inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fr !=null){try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(con !=null){try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}}
			if(stmt !=null){try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
					}
		}

}
