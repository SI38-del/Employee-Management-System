package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpDao {
	public static Connection getCon() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","Root");
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	public static int save(Employee e) {
		int status=0;
		
		try {
			Connection con=EmpDao.getCon();
			PreparedStatement p1=con.prepareStatement("insert into emp(name,password,email,country)values(?,?,?,?)");
			
			//String n1=e.getName();
			//p1.setString(1,n1);
			
			p1.setString(1,e.getName());
			p1.setString(2,e.getPassword());
			p1.setString(3,e.getEmail());
			p1.setString(4,e.getCountry());
			
			status= p1.executeUpdate();
		} catch (SQLException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		return status;
	}

	

}
