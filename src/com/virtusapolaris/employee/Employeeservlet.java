package com.virtusapolaris.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Employeeservlet
 */
public class Employeeservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("username");
		String password=request.getParameter("password");
		try{
			String valid=Employeeserviceimp.check(uname, password);
			if(valid.equals("10")){
			ResultSet rs=Employeeserviceimp.hr();
			while(rs.next()){
				out.println("<html>");
				out.println("<body>");
				out.println("<table border='2'>");
				out.println("<tr><td>"+rs.getString(1)+"</td></tr>");
				/*out.println(rs.getString(2));
				out.println(rs.getString(3));
				out.println(rs.getString(4));*/
				out.println("<table>");
				out.println("</body>");
				out.println("</html>");
			
			}}
			
			else if(valid.equals("20")){
				ResultSet rs=Employeeserviceimp.emp(uname, password);
				while(rs.next()){
					out.println("<html>");
					out.println("<body>");
					out.println("<table border='2'>");
					out.println("<tr><td>"+rs.getString(1)+"</td></tr>");
					/*out.println(rs.getString(2));
					out.println(rs.getString(3));
					out.println(rs.getString(4));*/
					out.println("<table>");
					out.println("</body>");
					out.println("</html>");
					}}
			
		else{
			out.println("no data found");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		}
	
}