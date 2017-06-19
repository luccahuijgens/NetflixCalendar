package nl.hu.v1ipass.thirdapp.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nl.hu.v1ipass.thirdapp.model.Series;
import nl.hu.v1ipass.thirdapp.model.Studio;

public class StudioDAO extends BaseDAO {
		// Zorg ter voorbereiding dat je ojdbc.jar download en toevoegt aan je
		// project.

		// Aanmaken van de variabelen die je connectie specificeren. In dit geval
		// een gebruiker "harry" met password "harry"

		public StudioDAO() {
		}

		// De methode die met JDBC aan de slag gaat moet een SQLException opvangen
		// of gooien

		public ArrayList<Studio> getStudios(){
			ArrayList<Studio> Studiolijst = new ArrayList<Studio>();
				// Leg de connectie met de database
			try{			
			Connection conn=super.getConnection();
						System.out.println("Connection made");
					
						// Een eerste SQL statement maken
						Statement stmt = conn.createStatement();
						
						// Een tweede statement maken dat een resultaat oplevert
		 				String queryText = "SELECT * FROM Studios";
		 				
		 				// Een tweede statement uitvoeren
		 				ResultSet rs = stmt.executeQuery(queryText);
		 				
		 				String name;
		 				String ordate;
		
		 				Studio Studio;
		 				
		 				while (rs.next()) {
		 					
		 					name = rs.getString("name");
		 					ordate = rs.getString("ordate");
		 					
		 					Studio=new Studio(name, ordate);
		 					Studiolijst.add(Studio);
		 				}
		 				// De resultset, het statement en de verbinding sluiten
		 				rs.close();
		 				stmt.close();
		 				conn.close();
			}
		 				catch (SQLException e){
		 					e.printStackTrace();
		 				}
		 				return Studiolijst;
		}
		
		public Studio findStudiobyCode(String cd){
			ArrayList<Studio> Studiolijst = new ArrayList<Studio>();
		try{			
		Connection conn=super.getConnection();
				
					// Een eerste SQL statement maken
					Statement stmt = conn.createStatement();
					
					// Een tweede statement maken dat een resultaat oplevert
	 				String queryText = "SELECT * FROM Studio WHERE name="+cd;
	 				
	 				// Een tweede statement uitvoeren
	 				ResultSet rs = stmt.executeQuery(queryText);
	 				
	 				String name;
	 				String ordate;
	
	 				Studio Studio;
	 				
	 				while (rs.next()) {
	 					
	 					name = rs.getString("name");
	 					ordate = rs.getString("ordate");
	 					
	 					Studio=new Studio(name, ordate);
	 					Studiolijst.add(Studio);
	 				}
	 				// De resultset, het statement en de verbinding sluiten
	 				rs.close();
	 				stmt.close();
	 				conn.close();
		}
	 				catch (SQLException e){
	 					e.printStackTrace();
	 				}
	 				return Studiolijst.get(0);
	}
		public ArrayList<Series> getSeriesbyStudio(String studio, String date){
			ArrayList<Series> Serieslijst = new ArrayList<Series>();
		try{			
		Connection conn=super.getConnection();
				
					// Een eerste SQL statement maken
					Statement stmt = conn.createStatement();
					
					// Een tweede statement maken dat een resultaat oplevert
	 				String queryText = "SELECT * FROM Series s WHERE s.enddate>to_date('"+date+"','dd/mm/yy') AND s.studio='"+studio+"'";
                          
	 				
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
	 				int score;
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
	 					score = rs.getInt("score");	
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