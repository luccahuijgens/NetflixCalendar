package nl.hu.v1ipass.thirdapp.model;

public class SerieServiceProvider {
	private static SeriesService customerservice = new SeriesService();

	public static SeriesService getSeriesService() {
		return customerservice;
	}
}