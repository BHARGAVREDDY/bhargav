package com.bhargav;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.java.sample.MySqlConn;

public class InsertPrepared {

	public static void main(String[] args)
	{
			Scanner scn= new Scanner(System.in);
			Connection con=null;
			FileReader fr=null;
			Properties props= new Properties();
			
			try {
				fr=new FileReader("config/dbconfig.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				props.load(fr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("file is loaded");
			try {
				Class.forName(props.getProperty("driver"));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("driver is loaded");
			try {
				con=DriverManager.getConnection(props.getProperty("url"),props.getProperty("username"),props.getProperty("password"));
				System.out.println("connected to Mysql");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			System.out.println("enter number of data u want to enter");
			int n=scn.nextInt();
			
			for(int i=1;i<=n;i++)
			{
		String insertQuery="insert into student.domain_details value(?,?,?)";
		System.out.println("enter the domain name");
		String name=scn.next();
		System.out.println("enter the user name");
		String username=scn.next();
		System.out.println("enter the password");
		String password=scn.next();
		
		try {
			
			PreparedStatement pstmt= (PreparedStatement) con.prepareStatement(insertQuery);
			pstmt.setString(1, name);
			pstmt.setString(2,username);
			pstmt.setString(3, password);
			int ins=pstmt.executeUpdate();
			System.out.println("inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}System.out.println("end");
	}
	

}
