package nl.hu.v1ipass.thirdapp.service;

import java.util.List;

import nl.hu.v1ipass.thirdapp.model.Customer;
import nl.hu.v1ipass.thirdapp.persistence.CustomerDAO;

public class CustomerService {
	private static CustomerService instance;
	private CustomerDAO customerdao;
	
	private CustomerService() {
		customerdao=new CustomerDAO();
	}
	
	public static CustomerService getInstance() {
		if (instance==null) {
			instance=new CustomerService();
		}
		return instance;
	}
	
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
