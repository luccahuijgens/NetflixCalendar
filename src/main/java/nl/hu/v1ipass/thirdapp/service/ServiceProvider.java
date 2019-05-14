package nl.hu.v1ipass.thirdapp.service;

public class ServiceProvider {
	private static CustomerSeriesService customerSeriesService = CustomerSeriesService.getInstance();
	public static SeriesService seriesService=SeriesService.getInstance();
	public static CustomerService customerService=CustomerService.getInstance();
	public static ReviewService reviewService=ReviewService.getInstance();
	public static StudioService studioService=StudioService.getInstance();
	
	private ServiceProvider() {}

	public static CustomerSeriesService getCustomerSeriesService() {
		return customerSeriesService;
	}
	public static CustomerService getCustomerService() {
		return customerService;
	}
	public static SeriesService getSeriesService() {
		return seriesService;
	}
	public static ReviewService getReviewService() {
		return reviewService;
	}
	public static StudioService getStudioService() {
		return studioService;
	}
}