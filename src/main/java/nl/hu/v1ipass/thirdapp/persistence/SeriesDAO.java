package nl.hu.v1ipass.thirdapp.persistence;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nl.hu.v1ipass.thirdapp.model.Customer;
import nl.hu.v1ipass.thirdapp.model.CustomerSeries;
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
				Statement stmt = conn.createStatement();
				
				// Een tweede statement maken dat een resultaat oplevert
 				String queryText = "SELECT * FROM Series";
 				
 				// Een tweede statement uitvoeren
 				ResultSet rs = stmt.executeQuery(queryText);
 				
 				int code;
 				String title;
 				String genre;
 				int episodes;
 				String startdate;
 				String enddate;
 				String airday;
 				int duration;
 				double score;
 				String productionstudio;
 				int rating;
 				int viewers;
 				String synopsis;
 				Series Series;
 				
 				while (rs.next()) {
 					
 					code = rs.getInt("ID");	
 					title = rs.getString("title");
 					genre= rs.getString("genre");
 					episodes = rs.getInt("episodes");	
 					startdate = rs.getString("startdate");
 					enddate= rs.getString("enddate");
 					airday = rs.getString("airday");
 					duration = rs.getInt("duration");
 					score = rs.getDouble("score");	
 					productionstudio = rs.getString("studio");
 					rating = rs.getInt("rating");
 					viewers= rs.getInt("viewers");
 					synopsis=rs.getString("synopsis");
 					Series=new Series(code, title, genre, episodes, startdate, enddate, airday, duration, score, productionstudio, rating, viewers,synopsis);
 					Serieslijst.add(Series);
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
				Statement stmt = conn.createStatement();
				
				// Een tweede statement maken dat een resultaat oplevert
 				String queryText = "SELECT * FROM Series s WHERE s.enddate>to_date('"+date+"','dd/mm/yy')";
 				
 				// Een tweede statement uitvoeren
 				ResultSet rs = stmt.executeQuery(queryText);
 				
 				int code;
 				String title;
 				String genre;
 				int episodes;
 				String startdate;
 				String enddate;
 				String airday;
 				int duration;
 				double score;
 				String productionstudio;
 				int rating;
 				int viewers;
 				String synopsis;
 				Series Series;
 				
 				while (rs.next()) {
 					
 					code = rs.getInt("ID");	
 					title = rs.getString("title");
 					genre= rs.getString("genre");
 					episodes = rs.getInt("episodes");	
 					startdate = rs.getString("startdate");
 					enddate= rs.getString("enddate");
 					airday = rs.getString("airday");
 					duration = rs.getInt("duration");
 					score = rs.getDouble("score");	
 					productionstudio = rs.getString("studio");
 					rating = rs.getInt("rating");
 					viewers= rs.getInt("viewers");
 					synopsis=rs.getString("synopsis");
 					Series=new Series(code, title, genre, episodes, startdate, enddate, airday, duration, score, productionstudio, rating, viewers,synopsis);
 					Serieslijst.add(Series);
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
				Statement stmt = conn.createStatement();
				
				// Een tweede statement maken dat een resultaat oplevert
 				String queryText = "SELECT * FROM Series s WHERE s.enddate<to_date('"+date+"','dd/mm/yy')";
 				
 				// Een tweede statement uitvoeren
 				ResultSet rs = stmt.executeQuery(queryText);
 				
 				int code;
 				String title;
 				String genre;
 				int episodes;
 				String startdate;
 				String enddate;
 				String airday;
 				int duration;
 				double score;
 				String productionstudio;
 				int rating;
 				int viewers;
 				String synopsis;
 				Series Series;
 				
 				while (rs.next()) {
 					
 					code = rs.getInt("ID");	
 					title = rs.getString("title");
 					genre= rs.getString("genre");
 					episodes = rs.getInt("episodes");	
 					startdate = rs.getString("startdate");
 					enddate= rs.getString("enddate");
 					airday = rs.getString("airday");
 					duration = rs.getInt("duration");
 					score = rs.getDouble("score");	
 					productionstudio = rs.getString("studio");
 					rating = rs.getInt("rating");
 					viewers= rs.getInt("viewers");
 					synopsis=rs.getString("synopsis");
 					Series=new Series(code, title, genre, episodes, startdate, enddate, airday, duration, score, productionstudio, rating, viewers,synopsis);
 					Serieslijst.add(Series);
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
		ArrayList<Series>Serieslijst=new ArrayList<Series>();
		// Leg de connectie met de database
		try{
			Connection conn=super.getConnection();
				//System.out.println("Connection made");

				// Een eerste SQL statement maken
				Statement stmt = conn.createStatement();
				
				// Een tweede statement maken dat een resultaat oplevert
 				String queryText = "SELECT * FROM Series s WHERE s.id="+cd;
 				
 				// Een tweede statement uitvoeren
 				ResultSet rs = stmt.executeQuery(queryText);
 				
 				int code;
 				String title;
 				String genre;
 				int episodes;
 				String startdate;
 				String enddate;
 				String airday;
 				int duration;
 				double score;
 				String productionstudio;
 				int rating;
 				int viewers;
 				String synopsis;
 				Series Series;
 				
 				while (rs.next()) {
 					
 					code = rs.getInt("ID");	
 					title = rs.getString("title");
 					genre= rs.getString("genre");
 					episodes = rs.getInt("episodes");	
 					startdate = rs.getString("startdate");
 					enddate= rs.getString("enddate");
 					airday = rs.getString("airday");
 					duration = rs.getInt("duration");
 					score = rs.getDouble("score");	
 					productionstudio = rs.getString("studio");
 					rating = rs.getInt("rating");
 					viewers= rs.getInt("viewers");
 					synopsis=rs.getString("synopsis");
 					Series=new Series(code, title, genre, episodes, startdate, enddate, airday, duration, score, productionstudio, rating, viewers,synopsis);
 					Serieslijst.add(Series);
 					}
 				// De resultset, het statement en de verbinding sluiten
 				rs.close();
 				stmt.close();
 				conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Serieslijst.get(0);
 	}

		public ArrayList<Series> getSeriesbyCustomerID(int cd, String date){
			ArrayList<Series> Serieslijst = new ArrayList<Series>();
		try{			
		Connection conn=super.getConnection();
				
					// Een eerste SQL statement maken
					Statement stmt = conn.createStatement();
					
					// Een tweede statement maken dat een resultaat oplevert
	 				String queryText = "SELECT * FROM Series s WHERE s.enddate>to_date('"+date+"','dd/mm/yy') AND s.ID IN (SELECT cs.SeriesID FROM CustomerSeries cs WHERE cs.CustomerID ="+cd+")";
                          
	 				
	 				// Een tweede statement uitvoeren
	 				ResultSet rs = stmt.executeQuery(queryText);
	 				
	 				int code;
	 				String title;
	 				String genre;
	 				int episodes;
	 				String startdate;
	 				String enddate;
	 				String airday;
	 				int duration;
	 				double score;
	 				String productionstudio;
	 				int rating;
	 				int viewers;
	 				String synopsis;
	 				Series Series;
	 				
	 				while (rs.next()) {
	 					
	 					code = rs.getInt("ID");	
	 					title = rs.getString("title");
	 					genre= rs.getString("genre");
	 					episodes = rs.getInt("episodes");	
	 					startdate = rs.getString("startdate");
	 					enddate= rs.getString("enddate");
	 					airday = rs.getString("airday");
	 					duration = rs.getInt("duration");
	 					score = rs.getDouble("score");	
	 					productionstudio = rs.getString("studio");
	 					rating = rs.getInt("rating");
	 					viewers= rs.getInt("viewers");
	 					synopsis=rs.getString("synopsis");
	 					Series=new Series(code, title, genre, episodes, startdate, enddate, airday, duration, score, productionstudio, rating, viewers,synopsis);
	 					Serieslijst.add(Series);
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
					Statement stmt = conn.createStatement();
					
					// Een tweede statement maken dat een resultaat oplevert
	 				String queryText = "select* from series s where s.enddate>to_date('"+date+"','dd/mm/yy') AND s.airday='"+day+"' AND s.id IN(select seriesid from customerseries where customerid="+cd+")";
	                      
	 				
	 				// Een tweede statement uitvoeren
	 				ResultSet rs = stmt.executeQuery(queryText);
	 				
	 				int code;
	 				String title;
	 				String genre;
	 				int episodes;
	 				String startdate;
	 				String enddate;
	 				String airday;
	 				int duration;
	 				double score;
	 				String productionstudio;
	 				int rating;
	 				int viewers;
	 				String synopsis;
	 				Series Series;
	 				
	 				while (rs.next()) {
	 					
	 					code = rs.getInt("ID");	
	 					title = rs.getString("title");
	 					genre= rs.getString("genre");
	 					episodes = rs.getInt("episodes");	
	 					startdate = rs.getString("startdate");
	 					enddate= rs.getString("enddate");
	 					airday = rs.getString("airday");
	 					duration = rs.getInt("duration");
	 					score = rs.getDouble("score");	
	 					productionstudio = rs.getString("studio");
	 					rating = rs.getInt("rating");
	 					viewers= rs.getInt("viewers");
	 					synopsis=rs.getString("synopsis");
	 					Series=new Series(code, title, genre, episodes, startdate, enddate, airday, duration, score, productionstudio, rating, viewers,synopsis);
	 					Serieslijst.add(Series);
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
					Statement stmt = conn.createStatement();
					
					// Een tweede statement maken dat een resultaat oplevert
	 				String queryText = "SELECT * FROM Series s WHERE s.enddate<to_date('"+date+"','dd/mm/yy') AND s.id IN (Select SeriesID from CustomerSeries Where CustomerID="+cd+")";
	                      
	 				
	 				// Een tweede statement uitvoeren
	 				ResultSet rs = stmt.executeQuery(queryText);
	 				
	 				int code;
	 				String title;
	 				String genre;
	 				int episodes;
	 				String startdate;
	 				String enddate;
	 				String airday;
	 				int duration;
	 				double score;
	 				String productionstudio;
	 				int rating;
	 				int viewers;
	 				String synopsis;
	 				Series Series;
	 				
	 				while (rs.next()) {
	 					
	 					code = rs.getInt("ID");	
	 					title = rs.getString("title");
	 					genre= rs.getString("genre");
	 					episodes = rs.getInt("episodes");	
	 					startdate = rs.getString("startdate");
	 					enddate= rs.getString("enddate");
	 					airday = rs.getString("airday");
	 					duration = rs.getInt("duration");
	 					score = rs.getDouble("score");	
	 					productionstudio = rs.getString("studio");
	 					rating = rs.getInt("rating");
	 					viewers= rs.getInt("viewers");
	 					synopsis=rs.getString("synopsis");
	 					Series=new Series(code, title, genre, episodes, startdate, enddate, airday, duration, score, productionstudio, rating, viewers,synopsis);
	 					Serieslijst.add(Series);
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
}