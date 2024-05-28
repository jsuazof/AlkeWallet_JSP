package customer.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.CustomerService;

@WebServlet("/CustomerSignUp")
public class LoginCustomer extends HttpServlet{

	CustomerService customerService=new CustomerService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String customerId = req.getParameter("c_id");
		String username = req.getParameter("c_username");
		String password = req.getParameter("c_password");
		int cust_Id = Integer.parseInt(customerId);

		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("sessionid", customerId);
		httpSession.setAttribute("sessionname", username);
		httpSession.setAttribute("sessionpassword", password);
			
		if(customerService.validateCustomer(cust_Id, username, password) == true) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("customerHomePage.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("customerlogin.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}


