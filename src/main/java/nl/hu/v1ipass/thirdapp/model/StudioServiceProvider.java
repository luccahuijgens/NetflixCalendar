package nl.hu.v1ipass.thirdapp.model;

public class StudioServiceProvider {
	private static StudioService customerservice = new StudioService();

	public static StudioService getStudioService() {
		return customerservice;
	}
}
