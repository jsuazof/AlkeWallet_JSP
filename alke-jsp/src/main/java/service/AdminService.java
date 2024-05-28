package service;

import java.util.ArrayList;
import java.util.List;

import dto.Admin;
import dto.BankManager;
import jdbc.AdminJdbc;
import jdbc.BankManagerJdbc;

public class AdminService {
	
	AdminJdbc adminJdbc=new AdminJdbc();
	BankManagerJdbc bankManagerJdbc=new BankManagerJdbc();
	public boolean validateAdmin(int a_id, String a_username, String a_password) {
		Admin admin = adminJdbc.getAdminById(a_id);
		if(admin.getAdmin_name().equals(a_username) && admin.getA_password().equals(a_password)) {
			return true;
		}else {
			return false;
		}
	}

	public Admin saveAdmin(Admin admin) {
		if(admin.getAdmin_name()!= null && admin.getA_password() != null) {
			return adminJdbc.saveAdmin(admin);
		}
		return null;
	}
	
	public boolean deleteAdmin(int id) {
		return adminJdbc.deleteAdminById(id);
	}
	
	//approve
	public boolean approval(int a_id, int m_id, String status) {
		Admin admin = adminJdbc.getAdminById(a_id);
		BankManager bankManager = bankManagerJdbc.getBankManagerById(m_id);
		if(admin != null && bankManager != null) {
			bankManager.setM_status(status);
			bankManager.setAdmin(admin);
			return bankManagerJdbc.approval(a_id, m_id);
		}
		return false;
	}
	// View all approved BankManager
	
	public List<BankManager> viewAllApprovedBankManager() {
		List<BankManager> managers = bankManagerJdbc.getAllBankManager();
		List<BankManager> approvedManager = new ArrayList<>();
		if(managers != null) {
			for(BankManager b : managers) {
				if(b.getM_status().equalsIgnoreCase("Approved")) {
					approvedManager.add(b);
				}
			}
			return approvedManager;
		}
		else {
			return null;
		}	
	}
	
	// View All UnApproved BankManagers
	
	public List<BankManager> viewAllUnApprovedBankManager() {
		List<BankManager> managers = bankManagerJdbc.getAllBankManager();
		List<BankManager> approvedManager = new ArrayList<>();
		if(managers != null) {
			for(BankManager b : managers) {
				if(b.getM_status().equalsIgnoreCase("UnApproved")) {
					approvedManager.add(b);
				}
			}
			return approvedManager;
		}
		else {
			return null;
		}
	
	}
	public Admin getAdminById(int id) {
		return adminJdbc.getAdminById(id);
	}
	
	public boolean deleteBankManagerById(int id) {
        return bankManagerJdbc.deleteBankManagerById(id);
    }
	

}
