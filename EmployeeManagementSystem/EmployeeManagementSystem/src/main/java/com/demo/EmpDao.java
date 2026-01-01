package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public static List<Employee> getAllEMployee(){
		ArrayList<Employee> list= new ArrayList<>();
		Connection con = EmpDao.getCon();
		
		try {
			PreparedStatement p=con.prepareStatement("select * from emp");
			ResultSet rs=p.executeQuery();
			
			while (rs.next()) {
				Employee e1= new  Employee();
				
			   e1.setId(rs.getInt(1));
     	       e1.setName(rs.getString(2));
     	       e1.setPassword(rs.getString(3));
     	       e1.setEmail(rs.getString(4));
     	       e1.setCountry(rs.getString(5));
     	       list.add(e1);
     	  
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public static int delete(int id) {
		 int i=0;
		 Connection con= EmpDao.getCon();
		 
		 try {
			PreparedStatement p = con.prepareStatement("delete from emp where id=?");
			p.setInt(1, id);
			i=   p.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
		
	}

	public static Employee getEmployeeByID(int id) {
		Connection con=EmpDao.getCon();
		Employee e= new Employee();
		try {
			PreparedStatement p = con.prepareStatement("select * from emp where id=?");
			p.setInt(1, id);
			ResultSet rs= p.executeQuery();
			
			while(rs.next())
	           {
	        	  e.setId(rs.getInt(1));
	        	  e.setName(rs.getString(2));
	        	  e.setPassword(rs.getString(3));
	        	  e.setEmail(rs.getString(4));
	        	  e.setCountry(rs.getString(5));
	        	     
	           }
		} catch (SQLException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		return e;
	}

	public static int UpdateEMp(Employee e) {
		// TODO Auto-generated method stub
		int status=0;
		Connection con = EmpDao.getCon();
		
		try {
			PreparedStatement p= con.prepareStatement("update  emp set name=?,password=?,email=?,country=? where id=?");
			
			 p.setString(1,e.getName() );
             p.setString(2, e.getPassword() );
             p.setString(3, e.getEmail());
             p.setString(4, e.getCountry());
             
             p.setInt(5, e.getId());
             
             status=p.executeUpdate();
		} catch (SQLException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		return status;
	}

}
