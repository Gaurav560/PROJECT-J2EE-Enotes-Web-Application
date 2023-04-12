package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ha.session.SessionMessage;

import com.DAO.postDao;
import com.Db.DBConnect;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
Integer noteIdInteger=Integer.parseInt(request.getParameter("note_id"));
postDao poDao=new postDao(DBConnect.getConnection());
boolean f=poDao.deleteNotes(noteIdInteger);
HttpSession session=null;
if (f) {
 session=request.getSession();
	session.setAttribute("updateMsg","Notes Deleted Successfully..");
	response.sendRedirect("showNotes.jsp");
	
}else {
	session=request.getSession();
session.setAttribute("wrongMsg", "OOps! SOmething went wrong on the server..");
response.sendRedirect("showNotes.jsp");
}
	}

}
