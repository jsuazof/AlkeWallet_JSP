package bankManager.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BankManagerService;

@WebServlet ("/updateCustomerStatus")
public class CustomerApproval extends HttpServlet {
	
	
	BankManagerService bankManagerService = new BankManagerService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession bank_manager_httpSession = req.getSession();
		String b_id = (String) bank_manager_httpSession.getAttribute("managersessionid");
		
		String manager_id = b_id;
		String customer_id = req.getParameter("customer_id");
		String status = req.getParameter("status");
		
		int manager_idNo = Integer.parseInt(manager_id); 
		int customer_idNo = Integer.parseInt(customer_id);
		
		boolean c = bankManagerService.approveCustomer(customer_idNo, manager_idNo, status);
		
		if(c == true) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("allCustomers.jsp");
			requestDispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateCustomerApprovalStatus.jsp");
			requestDispatcher.include(req, resp);
		}
	}

}