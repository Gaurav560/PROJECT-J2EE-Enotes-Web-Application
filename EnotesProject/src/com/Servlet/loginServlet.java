package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDao;
import com.Db.DBConnect;
import com.User.UserDetails;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
String email=request.getParameter("uemail");
String password=request.getParameter("upassword");


UserDetails userDetails =new UserDetails();
userDetails.setEmailString(email);
userDetails.setPasswordString(password);

UserDao dao=new UserDao(DBConnect.getConnection());
UserDetails user=dao.loginUser(userDetails);
if (user!= null) {
	HttpSession session=request.getSession();
	session.setAttribute("userD", user);
	response.sendRedirect("home.jsp");
}
else {
	HttpSession session=request.getSession();
	session.setAttribute("login-failed", "Invalid Username and Password");
	response.sendRedirect("login.jsp");
}
	}

}
