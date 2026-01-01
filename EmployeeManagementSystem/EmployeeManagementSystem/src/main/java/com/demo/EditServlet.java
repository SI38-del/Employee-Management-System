package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editServlet")
public class EditServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		int id= Integer.parseInt(req.getParameter("id"));
		Employee e1 = EmpDao.getEmployeeByID(id);
//      System.out.println(e);
		PrintWriter out= resp.getWriter();
		//out.print(e1.getName()+"  "+e1.getCountry());
		out.print("<form action='editServlet2' method='post' style='border:2px solid black;padding:35px;'>");
		out.print(" ID :  <input type='hidden' name='id' value='"+e1.getId()+"'> ");
		out.print("</br></br> Name :  <input type='text' name='name' value='"+e1.getName()+"'> ");
		out.print("</br></br> Password :  <input type='text' name='password' value='"+e1.getPassword()+"'> ");
		out.print("</br></br>  Email:  <input type='text' name='email' value='"+e1.getEmail()+"'>");
		out.print("</br></br>  Country:  <select name='country' style='width:200px'>");
		
		
		out.print("<option>india</option>");
        out.print("<option>australiya</option>");
        out.print("<option>USA</option>");
        out.print("<option>UK</option>");
        out.print("</select>");
        
        out.print(" </br></br>  <input type='submit' value='Edit And Save' > ");
        out.print("</form>");

	}

}
