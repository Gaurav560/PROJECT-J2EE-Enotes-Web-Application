package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.postDao;
import com.Db.DBConnect;

@WebServlet("/NoteEditServlet")
public class NoteEditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Integer noteIdInteger =Integer.parseInt(request.getParameter("noteId"));
			
			String titleString = request.getParameter("title");
			String contentString = request.getParameter("content");

			postDao pDao = new postDao(DBConnect.getConnection());
			boolean f = pDao.PostUpdate(titleString,contentString,noteIdInteger);
			if (f) {
				System.out.println("data updated successfully");
				HttpSession session = request.getSession();
				session.setAttribute("updateMsg", "Note Updated Successfully...");
				response.sendRedirect("showNotes.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("wrongMsg", "oops! Something went wrong on the server...");
				response.sendRedirect("showNotes.jsp");
			}

		} catch (NumberFormatException ne) {
			ne.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
