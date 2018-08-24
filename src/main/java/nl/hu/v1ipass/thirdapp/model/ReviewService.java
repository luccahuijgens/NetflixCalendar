package nl.hu.v1ipass.thirdapp.model;

import java.util.ArrayList;
import java.util.List;

import nl.hu.v1ipass.thirdapp.persistence.ReviewDAO;

public class ReviewService {

	private ReviewDAO reviewdao = new ReviewDAO();
	
	public ArrayList<Review> getReviewsBySeries(int id) {
		return reviewdao.getAllReviewsBySeriesID(id);
	}
}
