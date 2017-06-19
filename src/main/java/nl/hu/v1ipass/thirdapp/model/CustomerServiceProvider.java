package nl.hu.v1ipass.thirdapp.model;

public class CustomerServiceProvider {
	private static CustomerService customerservice = new CustomerService();

	public static CustomerService getCustomerService() {
		return customerservice;
	}
}