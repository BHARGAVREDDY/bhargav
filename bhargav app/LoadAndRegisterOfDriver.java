package com.bhargav;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class LoadAndRegisterOfDriver {

	public  void Driver()  {
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
	
	}

}
