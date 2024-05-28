package service;



import java.util.List;

import dto.Customer;
import jdbc.CustomerJdbc;

public class CustomerService {
	Customer customer = new Customer();
	CustomerJdbc customerJdbc = new CustomerJdbc();

	public boolean validateCustomer(int c_id, String c_username, String c_password) {
		Customer customer = customerJdbc.getCustomerById(c_id);
		if (customer.getC_username().equals(c_username) && customer.getC_password().equals(c_password)) {
			return true;
		} else {
			return false;
		}
	}

//save
	public Customer saveCustomer(Customer customer) {
//		if (customer.getC_name() != null && customer.getC_email() != null && customer.getC_address() != null
//				&& customer.getC_mobno() > 0 && customer.getC_password() != null && customer.getC_username() != null) {
//			return customerJdbc.saveCustomer(customer);
//		}
//		return null;
		customer.setAccount_balance(0);
		customer.setC_status("UnApproved");
		return customerJdbc.saveCustomer(customer);
	}

//update 
	public boolean deleteCustomerById(int c_id) {
		return customerJdbc.deleteCustomerById(c_id);
	}

	public boolean updateCustomerByIdEmail(int c_id, String c_email) {
		Customer customer = customerJdbc.getCustomerById(c_id);
		customer.setC_email(c_email);
		return customerJdbc.updateCustomerByIdEmail(c_id, c_email);
	}

	public Customer depositMoneyById(int c_id, int account_balance) {
		Customer customer = customerJdbc.getCustomerById(c_id);
		int new_account_balance = customer.getAccount_balance() + account_balance;
		customer.setAccount_balance(new_account_balance);
		return customerJdbc.depositMoneyById(customer);

	}

	public Customer withdrawMoneyById(int c_id, String username, String password, int account_balance) {
		Customer customer = customerJdbc.getCustomerById(c_id);
		if (customer.getC_username().equals(username) && customer.getC_password().equals(password)) {
			int new_account_balance = customer.getAccount_balance() - account_balance;
			customer.setAccount_balance(new_account_balance);
			return customerJdbc.withdrawMoneyById(customer);
		}
		return null;
	}

	public boolean transferMoneyById(int login_c_id, int recipientId, String username, String password, int amount_transfer) {
		Customer customer1 = customerJdbc.getCustomerById(login_c_id);
		Customer customer2 = customerJdbc.getCustomerById(recipientId);
		if (customer1.getC_username().equals(username) && customer1.getC_password().equals(password)) {
			int cust1_account_balance = customer1.getAccount_balance() - amount_transfer;
			int cust2_account_balance = customer2.getAccount_balance() + amount_transfer;
			customer1.setAccount_balance(cust1_account_balance);
			customer2.setAccount_balance(cust2_account_balance);
			return customerJdbc.transferMoneyById(customer1, customer2);
		}
		return false;

	}

	// get all
	public List<Customer> getAll() {
		return customerJdbc.getAllCustomer();
	}

	public Customer getCustomerById(int c_id) {
		return customerJdbc.getCustomerById(c_id);
	}

	public boolean updateCustomerNameMono(String c_name, long c_mono) {
		customer.setC_name(c_name);
		customer.setC_mobno(c_mono);
		return customerJdbc.updateCustomerNameMono(c_name, c_mono);
	}

}
