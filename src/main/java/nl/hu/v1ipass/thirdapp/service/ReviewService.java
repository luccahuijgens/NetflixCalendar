package nl.hu.v1ipass.thirdapp.service;

import java.util.List;

import nl.hu.v1ipass.thirdapp.model.Review;
import nl.hu.v1ipass.thirdapp.persistence.ReviewDAO;

public class ReviewService {
	private static ReviewService instance;

	private ReviewDAO reviewdao = new ReviewDAO();
	
	private ReviewService() {}
	
	public static ReviewService getInstance() {
		if (instance==null) {
			instance=new ReviewService();
		}
		return instance;
	}
	
	public List<Review> getReviewsBySeries(int id) {
		return reviewdao.getAllReviewsBySeriesID(id);
	}
}
