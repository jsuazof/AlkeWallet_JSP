package controller;

import java.io.IOException;

import dto.Admin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AdminService;
import service.BankManagerService;

@WebServlet("/adminRegister")
public class AdminSave extends HttpServlet {

	AdminService adminService = new AdminService();
	BankManagerService bankManagerService = new BankManagerService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("a_username");
		String password = req.getParameter("a_password");

		Admin admin = new Admin();
		admin.setAdmin_name(username);
		admin.setA_password(password);
		// admin.setBankManager();

		Admin a = adminService.saveAdmin(admin);

		if (a != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Home.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("adminregister.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}

