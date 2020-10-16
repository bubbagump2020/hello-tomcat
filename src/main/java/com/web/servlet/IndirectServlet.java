package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * heirarchy of a servlet
 * 
 * 		Servlet (interface)
 * 			GenericServlet (AC)
 * 				HttpServlet (AC)
 * 					CustomServlet (our class)
 * 
 * 		status codes
 * 			100 - information
 * 			200	- ok
 * 			300	- redirected
 * 			400 - client side errors
 * 			500 - server side errors
 * 
 * 		Redirect
 * 			2 request, 2 responses
 * 		Forward
 * 			1 request, 1 response
 * 
 * 
 */

public class IndirectServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getServletConfig().getInitParameter("servlet"));
		System.out.println(this.getServletName());
		System.out.println(this.getServletContext().getInitParameter("application"));
		//redirect will change the url and send the user somewhere elese
//		resp.sendRedirect("myApp/html/introHTML.html");
		// url stays the same, the server handles all information gathering
		req.getRequestDispatcher("myApp/html/login.html").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(username.equals("john")) {
			if(password.equals("pass")) {
				req.getRequestDispatcher("myApp/html/success.html").forward(req, resp);
			} else {
				req.getRequestDispatcher("myApp/html/introHTML.html").forward(req, resp);
			}
		} else {
			req.getRequestDispatcher("myApp/html/introHTML.html").forward(req, resp);
		}
	}
	
}
