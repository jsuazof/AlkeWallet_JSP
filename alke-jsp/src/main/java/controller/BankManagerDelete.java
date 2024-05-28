package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BankManagerService;

@WebServlet("/del")
public class BankManagerDelete extends HttpServlet {

    BankManagerService bankManagerService = new BankManagerService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean result = bankManagerService.deleteBankManagerById(id);
        if (result) {
        	 RequestDispatcher requestDispatcher = request.getRequestDispatcher("allManagers.jsp");
	            requestDispatcher.forward(request, response);
	        } else {
	        	RequestDispatcher requestDispatcher = request.getRequestDispatcher("deleteManager.jsp");
	            requestDispatcher.forward(request, response);
	            
	        }
	    }
	}