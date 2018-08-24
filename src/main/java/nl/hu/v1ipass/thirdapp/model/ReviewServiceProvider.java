package nl.hu.v1ipass.thirdapp.model;

public class ReviewServiceProvider {
	private static ReviewService reviewservice = new ReviewService();

	public static ReviewService getReviewService() {
		return reviewservice;
	}
}
