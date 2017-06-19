package nl.hu.v1ipass.thirdapp.model;

public class EmailServiceProvider {
	private static EmailService customerservice = new EmailService();

	public static EmailService getEmailService() {
		return customerservice;
	}
}
