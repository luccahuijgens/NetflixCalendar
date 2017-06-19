package nl.hu.v1ipass.thirdapp.model;

public class CustomerSeriesServiceProvider {
	private static CustomerSeriesService customerservice = new CustomerSeriesService();

	public static CustomerSeriesService getCustomerService() {
		return customerservice;
	}
}