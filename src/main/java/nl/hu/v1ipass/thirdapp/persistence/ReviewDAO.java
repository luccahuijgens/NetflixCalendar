package nl.hu.v1ipass.thirdapp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.hu.v1ipass.thirdapp.model.Customer;
import nl.hu.v1ipass.thirdapp.model.Review;
import nl.hu.v1ipass.thirdapp.model.Series;

public class ReviewDAO extends BaseDAO {
	private CustomerDAO cdao;
	private SeriesDAO sdao;

	public ReviewDAO() {
		cdao = new CustomerDAO();
		sdao = new SeriesDAO();
	}

	public List<Review> getAllReviewsBySeriesID(int id) {
		ArrayList<Review> reviews = new ArrayList<>();
		try (Connection conn = super.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Reviews where seriesid=?")) {
			stmt.setInt(1, id);

			// Een tweede statement uitvoeren
			getReviewsFromStatement(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviews;
	}

	private void getReviewsFromStatement(PreparedStatement stmt) {
		ArrayList<Review> reviews=new ArrayList<>();
		try(ResultSet rs = stmt.executeQuery()){

		while (rs.next()) {

			Customer cust = cdao.findCustomerbyCode(rs.getInt("CUSTOMERID"));
			Series ser = sdao.getSeriesbyCode(rs.getInt("SERIESID"));
			String content = rs.getString("CONTENT");
			int score = rs.getInt("SCORE");
			Review rev = new Review(cust, ser, content, score);
			reviews.add(rev);
		}}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}