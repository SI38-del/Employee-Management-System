package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		
		int id= Integer.parseInt(req.getParameter("id"));
		
		int status = EmpDao.delete(id);
		
		if(status>0)
        {
     	   resp.sendRedirect("viewServlet");
        }else
        {
     	   out.print("Something went wrong");
        }
	}

}
