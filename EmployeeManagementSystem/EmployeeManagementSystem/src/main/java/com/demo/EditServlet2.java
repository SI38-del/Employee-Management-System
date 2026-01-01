package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editServlet2")
public class EditServlet2 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html");
		 
		 PrintWriter out = resp.getWriter();
		 int id=Integer.parseInt(req.getParameter("id"));
		 String name=req.getParameter("name");
		 String password=req.getParameter("password");
		 String email=req.getParameter("email");
	     String country=req.getParameter("country");
	     
	     Employee e1= new Employee();
	     e1.setId(id);
	     e1.setName(name);
	     e1.setPassword(password);
	     e1.setEmail(email);
	     e1.setCountry(country);
	     
	     int status=EmpDao.UpdateEMp(e1);
	     
	     if(status>0) {
	    	 //out.print("data save successfully!!");
	    	 resp.sendRedirect("viewServlet");
	     }else {
	    	 out.print("something wentw rong!!1");
	     }
	}

}
