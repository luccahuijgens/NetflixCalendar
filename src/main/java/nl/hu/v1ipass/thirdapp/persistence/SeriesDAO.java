package nl.hu.v1ipass.thirdapp.persistence;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nl.hu.v1ipass.thirdapp.model.Series;

public class SeriesDAO extends BaseDAO{
	//Zorg ter voorbereiding dat je ojdbc.jar download en toevoegt aan je project.
	
	//Aanmaken van de variabelen die je connectie specificeren. In dit geval een gebruiker "harry" met password "harry"

	public SeriesDAO(){}
	
	// De methode die met JDBC aan de slag gaat moet een SQLException opvangen of gooien
	public ArrayList<Series> getAll(){
		ArrayList<Series>Serieslijst=new ArrayList<Series>();
		// Leg de connectie met de database
		try{
			Connection conn=super.getConnection();
				//System.out.println("Connection made");

				// Een eerste SQL statement maken
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SERIES");
 				
 				// Een tweede statement uitvoeren
 				ResultSet rs = stmt.executeQuery();
 				
 				while (rs.next()) {
 					
 					Serieslijst.add(convertSeries(rs));
 					}
 				// De resultset, het statement en de verbinding sluiten
 				rs.close();
 				stmt.close();
 				conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Serieslijst;
 	}
	
	public ArrayList<Series> getAiringSeries(String date){
		ArrayList<Series>Serieslijst=new ArrayList<Series>();
		// Leg de connectie met de database
		try{
			Connection conn=super.getConnection();
				//System.out.println("Connection made");

				// Een eerste SQL statement maken
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Series s WHERE s.enddate is null or s.enddate>to_date(?,'dd/mm/yy')");
 				stmt.setString(1, date);
				
 				// Een tweede statement uitvoeren
 				ResultSet rs = stmt.executeQuery();
 				
 				while (rs.next()) {
 					
 					Serieslijst.add(convertSeries(rs));
 					}
 				
 				// De resultset, het statement en de verbinding sluiten
 				rs.close();
 				stmt.close();
 				conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Serieslijst;
 	}
	public ArrayList<Series> getFinishedSeries(String date){
		ArrayList<Series>Serieslijst=new ArrayList<Series>();
		// Leg de connectie met de database
		try{
			Connection conn=super.getConnection();
				//System.out.println("Connection made");

				// Een eerste SQL statement maken
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Series s WHERE s.enddate<to_date(?,'dd/mm/yy')");
 				stmt.setString(1, date);
 				// Een tweede statement uitvoeren
 				ResultSet rs = stmt.executeQuery();
 				
 				while (rs.next()) {
 					
 					Serieslijst.add(convertSeries(rs));
 					}
 				// De resultset, het statement en de verbinding sluiten
 				rs.close();
 				stmt.close();
 				conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Serieslijst;
 	}
	public Series getSeriesbyCode(int cd){
		Series series=null;
		// Leg de connectie met de database
		try{
			Connection conn=super.getConnection();
				//System.out.println("Connection made");

				// Een eerste SQL statement maken
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SERIES WHERE ID=?");
				stmt.setInt(1,cd);
 				
 				// Een tweede statement uitvoeren
 				ResultSet rs = stmt.executeQuery();
 				
 				if (rs.next()) {
 					
 					series=convertSeries(rs);
 					}
 				// De resultset, het statement en de verbinding sluiten
 				rs.close();
 				stmt.close();
 				conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return series;
 	}

		public ArrayList<Series> getSeriesbyCustomerID(int cd, String date){
			ArrayList<Series> Serieslijst = new ArrayList<Series>();
		try{			
		Connection conn=super.getConnection();
				
					// Een eerste SQL statement maken
					PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Series s WHERE s.enddate>to_date(?,'dd/mm/yy') AND s.ID IN (SELECT cs.SeriesID FROM CustomerSeries cs WHERE cs.CustomerID =?)");
                    stmt.setString(1, date);
                    stmt.setInt(2, cd);
	 				
	 				// Een tweede statement uitvoeren
	 				ResultSet rs = stmt.executeQuery();
	 				
	 				while (rs.next()) {
	 					
	 					Serieslijst.add(convertSeries(rs));
	 					}
	 				// De resultset, het statement en de verbinding sluiten
	 				rs.close();
	 				stmt.close();
	 				conn.close();
		}
	 				catch (SQLException e){
	 					e.printStackTrace();
	 				}
	 				return Serieslijst;
	}
		public ArrayList<Series> getSeriesbyCustomerIDDate(int cd, String day, String date){
			ArrayList<Series> Serieslijst = new ArrayList<Series>();
		try{			
		Connection conn=super.getConnection();
				
					// Een eerste SQL statement maken
					PreparedStatement stmt = conn.prepareStatement("select* from series s where (s.enddate is null OR s.enddate>to_date(?,'dd/mm/yy')) AND s.airday=? AND s.id IN(select seriesid from customerseries where customerid=?)");
	 				stmt.setString(1,date);
	 				stmt.setString(2,day);
	 				stmt.setInt(3,cd);
	                      
	 				
	 				// Een tweede statement uitvoeren
	 				ResultSet rs = stmt.executeQuery();
	 				
	 				while (rs.next()) {
	 					
	 					Serieslijst.add(convertSeries(rs));
	 					}
	 				// De resultset, het statement en de verbinding sluiten
	 				rs.close();
	 				stmt.close();
	 				conn.close();
		}
	 				catch (SQLException e){
	 					e.printStackTrace();
	 				}
	 				return Serieslijst;
}
		public ArrayList<Series> getFinishedSeriesbyCustomerID(int cd, String date){
			ArrayList<Series> Serieslijst = new ArrayList<Series>();
		try{			
		Connection conn=super.getConnection();
				
					// Een eerste SQL statement maken
					PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Series s WHERE s.enddate<to_date(?,'dd/mm/yy') AND s.id IN (Select SeriesID from CustomerSeries Where CustomerID=?)");
	                      
	 				
	 				// Een tweede statement uitvoeren
	 				ResultSet rs = stmt.executeQuery();
	 				
	 				while (rs.next()) {
	 					
	 					Serieslijst.add(convertSeries(rs));
	 					}
	 				// De resultset, het statement en de verbinding sluiten
	 				rs.close();
	 				stmt.close();
	 				conn.close();
		}
	 				catch (SQLException e){
	 					e.printStackTrace();
	 				}
	 				return Serieslijst;
	}
		private Series convertSeries(ResultSet rs) throws SQLException{
				int code = rs.getInt("ID");	
				String title = rs.getString("title");
				String genre= rs.getString("genre");
				int episodes = rs.getInt("episodes");	
				String startdate = rs.getString("startdate");
				String enddate= rs.getString("enddate");
				String airday = rs.getString("airday");
				int duration = rs.getInt("duration");
			    double score = rs.getDouble("score");	
				String productionstudio = rs.getString("studio");
				int rating = rs.getInt("rating");
				int viewers= rs.getInt("viewers");
				String synopsis=rs.getString("synopsis");
				Series series=new Series(code, title, genre, episodes, startdate, enddate, airday, duration, score, productionstudio, rating, viewers,synopsis);
				return series;
		}
}