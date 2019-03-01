package nl.hu.v1ipass.thirdapp.model;

import java.util.List;

import nl.hu.v1ipass.thirdapp.persistence.CustomerDAO;

public class CustomerService {

	private CustomerDAO customerdao = new CustomerDAO();
	
	public List<Customer> getAllCustomers() {
		return customerdao.getCustomers();
	}
	public Customer getCustbyLogin(String email, String password) {
		return customerdao.login(email, password);
	}
	public Customer getCustomerByID(int id) {
		return customerdao.findCustomerbyCode(id);
	}
	
}
