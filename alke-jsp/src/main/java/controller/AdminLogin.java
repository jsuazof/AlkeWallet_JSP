package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.AdminService;

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminService adminService = new AdminService();
		String id = req.getParameter("a_id");
		String username = req.getParameter("a_username");
		String password = req.getParameter("a_password");

		int idNo = Integer.parseInt(id);

		HttpSession a_httpSession = req.getSession();
		a_httpSession.setAttribute("sessionid", id);
		a_httpSession.setAttribute("sessionname", username);
		a_httpSession.setAttribute("sessionpassword", password);

		boolean a = adminService.validateAdmin(idNo, username, password);

		if (a == true) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("adminHomePage.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("adminlogin.jsp");
			requestDispatcher.include(req, resp);
		}

	}

}
