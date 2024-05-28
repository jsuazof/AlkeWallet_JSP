package service;

import java.util.ArrayList;
import java.util.List;

import Dao.BankManagerDao;
import Dao.CustomerDao;
import dto.BankManager;
import dto.Customer;

public class BankManagerService {
	BankManagerDao bankManagerDao = new BankManagerDao();
	CustomerDao customerDao = new CustomerDao();

//check login @validate
	public boolean validateBankManager(int b_id, String b_username, String b_password) {
		BankManager bankManager = bankManagerDao.getBankManagerById(b_id);
		String pass = bankManager.getM_password();
		if (bankManager.getM_username().equals(b_username) && bankManager.getM_password().equals(b_password)
				&& pass != null && bankManager != null) {
			return true;
		} else {
			return false;
		}
	}

//save
	public BankManager saveBankManager(BankManager bankManager) {
		String pass = bankManager.getM_password();
//		if (bankManager.getM_username() != null && bankManager.getM_email() != null
//				&& bankManager.getM_password() != null && pass.length() >= 5 && pass.length() <= 7) {
//			return bankManagerDao.saveBankManager(bankManager);
//		}
//		return null;
		bankManager.setM_status("unapproved");
		return bankManagerDao.saveBankManager(bankManager);

	}

	public boolean deleteBankManagerById(int b_id) {
		boolean b = bankManagerDao.deleteBankManagerById(b_id);
		return b;
	}

	public BankManager updateBankManagerByIdEmail(int id, String email, String old_email) {
		BankManager bankManager = bankManagerDao.getBankManagerById(id);
		if (bankManager.getM_email().equals(old_email)) {
			bankManager.setM_email(email);
			return bankManagerDao.updateBankManagerByIdEmail(bankManager);
		} else {
			return null;
		}
	}

	public BankManager updateBankManagerByIdUsernamePassword(int id, String m_username, String password,
			String old_password) {
		BankManager bankManager = bankManagerDao.getBankManagerById(id);
		if (bankManager.getM_username().equals(m_username) && bankManager.getM_password().equals(old_password)
				&& password.length() >= 5 && password.length() <= 7) {
			bankManager.setM_password(password);
			return bankManagerDao.updateBankManagerByIdEmail(bankManager);
		}
		return null;

	}

	public List<BankManager> getAllBankManager() {
		return bankManagerDao.getAllBankManager();
	}

	public BankManager getBankManagerById(int id) {
		return bankManagerDao.getBankManagerById(id);
	}

	public boolean approveCustomer(int c_id, int m_id, String status) {
		Customer customer = customerDao.getCustomerById(c_id);
		BankManager bankManager = bankManagerDao.getBankManagerById(m_id);
		if (customer != null && bankManager != null) {
			customer.setC_status(status);
			customer.setBankManager(bankManager);
			return customerDao.approveCustomer(c_id, m_id);
		}
		return false;
	}
	
	 public boolean deleteCustomerById(int c_id) {
	        Customer customer = customerDao.getCustomerById(c_id);
	        if (customer != null) {
	            return customerDao.deleteCustomerById(c_id);
	        }
	        return false;
	    }

// View all approved Customers
	public List<Customer> viewAllApprovedCustomer() {
		List<Customer> customers = customerDao.getAllCustomer();
		List<Customer> approvedCustomers = new ArrayList<>();
		if (customers != null) {
			for (Customer c : customers) {
				if (c.getC_status().equalsIgnoreCase("Approved")) {
					approvedCustomers.add(c);
				}
			}
			return approvedCustomers;
		} else {
			return null;
		}
	}

// View All UnApproved Customers

	public List<Customer> viewAllUnApprovedBankCustomer() {
		List<Customer> customers = customerDao.getAllCustomer();
		List<Customer> unApprovedCustomers = new ArrayList<>();
		if (customers != null) {
			for (Customer c : customers) {
				if (c.getC_status().equalsIgnoreCase("UnApproved")) {
					unApprovedCustomers.add(c);
				}
			}
			return unApprovedCustomers;
		} else {
			return null;
		}
	}

//	public boolean rejectCustomerByUserNamePassword(int c_id, int b_id) {
//	Customer customer = customerDao.getCustomerById(c_id);
//	BankManager bankManager = bankManagerDao.getBankManagerById(b_id);
//	if (customer != null && bankManager != null) {
//		customer.setC_status("UnApproved");
//		customer.setBankManager(bankManager);
//		return customerDao.approveCustomerById(b_id, c_id);
//	}
//	return false;
//}

	// approveReject
//		public boolean approveCustomerByUserNamePassword(int c_id, int b_id) {
//			Customer customer = customerDao.getCustomerById(c_id);
//			BankManager bankManager = bankManagerDao.getBankManagerById(b_id);
//			if (customer != null && bankManager != null) {
//				customer.setC_status("Approved");
//				customer.setBankManager(bankManager);
//				return customerDao.approveRejectCustomer(customer);
//			}
//			return false;
//		}

//		public boolean approveCustomerById(int b_id, int c_id,String status) {
//			BankManager bankManager = bankManagerDao.getBankManagerById(b_id);
//			Customer customer = customerDao.getCustomerById(c_id);
//			if (customer != null && bankManager != null) {
//				customer.setC_status(status);
//				customer.setBankManager(bankManager);
//				return customerDao.approveCustomerById(b_id, c_id);
//			}
	//
//			return false;
//		}

}

