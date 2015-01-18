package com.bhargav;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StatmentPrac {

	public static void main(String[] args) throws Exception {
		Connection con=null;
		Statement stmt=null;
		Scanner scan= new Scanner(System.in);
		System.out.println("enter the acc no");
		int i=scan.nextInt();
		String viewQry="select * from bank_app.acc_details where Acc_no=?";
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql//localhost:8080","root","root");
		stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery(viewQry);
		if(rs!=null)
		{
			
		}
	}

}
