package com.bhargav;

import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class ConOracle {

	public static void main(String[] args) {
		OracleDriver od=new OracleDriver();
		try {
			DriverManager.registerDriver(od);
			System.out.println("conn");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
