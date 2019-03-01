package nl.hu.v1ipass.thirdapp.model;

public class ServiceProvider {
	private static CustomerSeriesService customerSeriesService = new CustomerSeriesService();
	public static SeriesService seriesService=new SeriesService();
	public static CustomerService customerService=new CustomerService();
	public static ReviewService reviewService=new ReviewService();
	public static StudioService studioService=new StudioService();

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