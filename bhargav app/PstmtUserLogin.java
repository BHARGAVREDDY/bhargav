package com.bhargav;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bhargav.LoadAndRegisterOfDriver;
import com.mysql.jdbc.PreparedStatement;


public class PstmtUserLogin {

	public static void main(String[] args) {
	LoadAndRegisterOfDriver ld=new  LoadAndRegisterOfDriver();
	((LoadAndRegisterOfDriver) ld).Driver();
	Scanner scn=new Scanner(System.in);
	System.out.println("Enter The UserId");
	String ui=scn.next();
	System.out.println("Enter The Password");
	String pass=scn.next();
	scn.close();
	String qry="select domain name from student.domain_details where username=? and password=?";
	Connection con=null;
	try {
		
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(qry);
		pstmt.setString(1, ui);
		pstmt.setString(2, pass);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			String  name=rs.getString(1);
			System.out.println("Welcome to"+ name);
		}else {
			System.out.println("invalid user");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}

	
}
