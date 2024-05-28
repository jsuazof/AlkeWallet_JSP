package bankManager.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BankManagerService;

@WebServlet("/delCustomer")
public class CustomerDelete extends HttpServlet {
	BankManagerService bankManagerService = new BankManagerService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		        String customer_id = req.getParameter("id");
		        int customer_idNo = Integer.parseInt(customer_id);

		        boolean c = bankManagerService.deleteCustomerById(customer_idNo);

		        if (c) {
		            RequestDispatcher requestDispatcher = req.getRequestDispatcher("allCustomers.jsp");
		            requestDispatcher.forward(req, resp);
		        } else {
		        	RequestDispatcher requestDispatcher = req.getRequestDispatcher("deleteCustomer.jsp");
		            requestDispatcher.forward(req, resp);
		            
		        }
		    }
		}
