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

@WebServlet("/withdrawalMoney")
public class CustomerWithdraw  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerService customerService = new CustomerService();

		HttpSession httpSession=req.getSession();
		String login_c_id=(String) httpSession.getAttribute("sessionid");
		String login_c_cusername=(String) httpSession.getAttribute("sessionname");
		String login_password=(String) httpSession.getAttribute("sessionpassword");
		int login_cust_Id = Integer.parseInt(login_c_id);
		Customer customer=customerService.getCustomerById(login_cust_Id);
		
		String id = req.getParameter("c_id");
		String username=req.getParameter("c_username");
		String password=req.getParameter("c_password");
		String amount = req.getParameter("c_withdrawAmount");

		int cust_id = Integer.parseInt(id);
		int account_balance = Integer.parseInt(amount);

		Customer verify_customer = customerService.withdrawMoneyById(login_cust_Id, username, password, account_balance);

		if (verify_customer != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("customerHomePage.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("customerWithdraw.jsp");
			requestDispatcher.include(req, resp);
		}

	}
}
