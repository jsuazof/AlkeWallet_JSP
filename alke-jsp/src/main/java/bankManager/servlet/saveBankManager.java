package bankManager.servlet;

import java.io.IOException;

import dto.BankManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BankManagerService;

@WebServlet("/SignUp")
public class saveBankManager extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BankManagerService bankManagerService=new BankManagerService();

		String name=req.getParameter("m_name");
		String username = req.getParameter("m_username");
		String password = req.getParameter("m_password");
		String email = req.getParameter("m_email");
		
		BankManager bankmanager = new BankManager();
		bankmanager.setM_name(name);
		bankmanager.setM_username(username);
		bankmanager.setM_password(password);
		bankmanager.setM_email(email);

		BankManager bm1 = bankManagerService.saveBankManager(bankmanager);
		
		if (bm1 != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Home.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("managerReg.jsp");
			requestDispatcher.include(req, resp);
		}
		
	}
}

