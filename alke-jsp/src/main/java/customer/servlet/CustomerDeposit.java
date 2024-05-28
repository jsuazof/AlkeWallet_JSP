package customer.servlet;

import java.io.IOException;

import dto.Customer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.CustomerService;

@WebServlet("/depositMoney")
public class CustomerDeposit extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Provided id of the wrong type for class com.jsp.dto.Customer. Expected: class
		// java.lang.Integer, got class java.lang.Long

		CustomerService customerService = new CustomerService();

		String amount = req.getParameter("c_depositAmount");
//		int custInput_id = Integer.parseInt(id);
		int account_balance = Integer.parseInt(amount);

		HttpSession httpSession = req.getSession();
		String cid = (String) httpSession.getAttribute("sessionid");
		int cust_Id = Integer.parseInt(cid);
		

		Customer customer = customerService.depositMoneyById(cust_Id, account_balance);

		if (customer != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("customerHomePage.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("customerdeposit.jsp");
			requestDispatcher.include(req, resp);
		}

	}

}

