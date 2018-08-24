package nl.hu.v1ipass.thirdapp.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nl.hu.v1ipass.thirdapp.model.Customer;
import nl.hu.v1ipass.thirdapp.model.Review;
import nl.hu.v1ipass.thirdapp.model.Series;

public class ReviewDAO extends BaseDAO{
	private CustomerDAO cdao;
	private SeriesDAO sdao;
	
	public ReviewDAO(){
		cdao=new CustomerDAO();
		sdao=new SeriesDAO();
	}
	public ArrayList<Review> getAllReviewsBySeriesID(int id){
		ArrayList<Review>reviews=new ArrayList<Review>();
		try{
			Connection conn=super.getConnection();
			
			// Een eerste SQL statement maken
			Statement stmt = conn.createStatement();
			
			// Een tweede statement maken dat een resultaat oplevert
				String queryText = "SELECT * FROM Reviews where seriesid="+id;
                  
				
				// Een tweede statement uitvoeren
				ResultSet rs = stmt.executeQuery(queryText);
				
				Customer cust;
				Series ser;
				String content;
				int score=0;
				
				while (rs.next()) {
					
					cust = cdao.findCustomerbyCode(rs.getInt("CUSTOMERID"));	
					ser=sdao.getSeriesbyCode(rs.getInt("SERIESID"));
					content=rs.getString("CONTENT");
					score=rs.getInt("SCORE");
					Review rev=new Review(cust,ser,content,score);
					reviews.add(rev);
		}
				stmt.close();
 				conn.close();
	}
 				catch (SQLException e){
 					e.printStackTrace();
 				}
		return reviews;
}
}