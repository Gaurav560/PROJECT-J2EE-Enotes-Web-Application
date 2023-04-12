package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.spi.RegisterableService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDao;
import com.Db.DBConnect;
import com.User.UserDetails;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
String firstName=request.getParameter("fname");
String lastName=request.getParameter("lname");
String email=request.getParameter("uemail");
String number=request.getParameter("unumber");
String password=request.getParameter("upassword");

UserDetails userDetails=new UserDetails();
userDetails.setFirstNameString(firstName);
userDetails.setLastNameString(lastName);;
userDetails.setEmailString(email);
userDetails.setPhoneString(number);;
userDetails.setPasswordString(password);;
 

UserDao dao=new UserDao(DBConnect.getConnection());
boolean f=dao.addUserDetails(userDetails);
HttpSession session;
if (f) {
	session=request.getSession();
	session.setAttribute("reg-success","Registration successfully");
	response.sendRedirect("register.jsp");
} else {
	session=request.getSession();
	session.setAttribute("failed-msg","OOPs! Something went wrong in Server");
	response.sendRedirect("register.jsp");
}
}
}
