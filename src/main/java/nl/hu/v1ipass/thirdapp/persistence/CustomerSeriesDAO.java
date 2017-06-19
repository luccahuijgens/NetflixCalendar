package nl.hu.v1ipass.thirdapp.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nl.hu.v1ipass.thirdapp.model.Comb;
import nl.hu.v1ipass.thirdapp.model.CustomerSeries;
import nl.hu.v1ipass.thirdapp.model.Series;

public class CustomerSeriesDAO extends BaseDAO{

		public CustomerSeriesDAO() {
		}

		// De methode die met JDBC aan de slag gaat moet een SQLException opvangen
		// of gooien
		public ArrayList<CustomerSeries> getAll(){
			ArrayList<CustomerSeries> CustomerSerieslijst = new ArrayList<CustomerSeries>();
		try{			
		Connection conn=super.getConnection();
				
					// Een eerste SQL statement maken
					Statement stmt = conn.createStatement();
					
					// Een tweede statement maken dat een resultaat oplevert
	 				String queryText = "SELECT * FROM CustomerSeries";
	                      
	 				
	 				// Een tweede statement uitvoeren
	 				ResultSet rs = stmt.executeQuery(queryText);
	 				
	 				int custid;
	 				int seriesid;
	 				int score;
	 				String finished;
	 				String email;
	 				CustomerSeries cs;
	 				
	 				while (rs.next()) {
	 					
	 					custid = rs.getInt("CUSTOMERID");	
	 					seriesid = rs.getInt("SERIESID");	
	 					score = rs.getInt("score");	
	 					finished = rs.getString("FINISHED");
	 					email=rs.getString("email_not");
	 					cs=new CustomerSeries(custid, seriesid, score, finished, email);
	 					CustomerSerieslijst.add(cs);
	 					}
	 				// De resultset, het statement en de verbinding sluiten
	 				rs.close();
	 				stmt.close();
	 				conn.close();
		}
	 				catch (SQLException e){
	 					e.printStackTrace();
	 				}
	 				return CustomerSerieslijst;
	}
	public ArrayList<CustomerSeries> getCustomerSeriesbyCustomerID(int cd){
		ArrayList<CustomerSeries> CustomerSerieslijst = new ArrayList<CustomerSeries>();
	try{			
	Connection conn=super.getConnection();
			
				// Een eerste SQL statement maken
				Statement stmt = conn.createStatement();
				
				// Een tweede statement maken dat een resultaat oplevert
 				String queryText = "SELECT * FROM CustomerSeries s WHERE s.ID="+cd;
                      
 				
 				// Een tweede statement uitvoeren
 				ResultSet rs = stmt.executeQuery(queryText);
 				
 				int custid;
 				int seriesid;
 				int score;
 				String finished;
 				String email;
 				CustomerSeries cs;
 				
 				while (rs.next()) {
 					
 					custid = rs.getInt("CUSTOMERID");	
 					seriesid = rs.getInt("SERIESID");	
 					score = rs.getInt("score");	
 					finished = rs.getString("FINISHED");
 					email=rs.getString("email_not");
 					cs=new CustomerSeries(custid, seriesid, score, finished, email);
 					CustomerSerieslijst.add(cs);
 					}
 				// De resultset, het statement en de verbinding sluiten
 				rs.close();
 				stmt.close();
 				conn.close();
	}
 				catch (SQLException e){
 					e.printStackTrace();
 				}
 				return CustomerSerieslijst;
}
	public ArrayList<Comb> getFinishedCustomerSeriesbyCustomerID(int cd, String date){
		ArrayList<Comb> Comblijst = new ArrayList<Comb>();
	try{			
	Connection conn=super.getConnection();
			
				// Een eerste SQL statement maken
				Statement stmt = conn.createStatement();
				// Een tweede statement maken dat een resultaat oplevert
 				String queryText = "SELECT cs.seriesid, cs.customerid, s.title, s.genre, s.episodes, s.startdate, s.enddate, s.airday, s.duration, s.score, cs.myscore, s.studio, s.rating, s.viewers, s.synopsis, cs.email_not FROM Series s, CustomerSeries cs Where s.id = cs.seriesid AND cs.CUSTOMERID="+cd+" AND s.enddate<to_date('"+date+"','DD/MM/YY')";
                      
 				
 				// Een tweede statement uitvoeren
 				ResultSet rs = stmt.executeQuery(queryText);
 				
 				int custid;
 				int seriesid;
 				int myscore;
 				String email;
 				Comb cs;
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
 				
 				while (rs.next()) {	
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
 					custid = rs.getInt("CUSTOMERID");	
 					seriesid = rs.getInt("SERIESID");	
 					myscore = rs.getInt("myscore");	
 					email=rs.getString("email_not");
 					cs=new Comb(custid, seriesid, myscore, email, title,
 							genre, episodes, startdate, enddate, airday, duration, score,
 							productionstudio, rating, viewers, synopsis);
 					Comblijst.add(cs);
 					}
 				// De resultset, het statement en de verbinding sluiten
 				rs.close();
 				stmt.close();
 				conn.close();
	}
 				catch (SQLException e){
 					e.printStackTrace();
 				}
 				return Comblijst;
}
	public ArrayList<Comb> getUnfinishedCustomerSeriesbyCustomerID(int cd, String date){
		ArrayList<Comb> Comblijst = new ArrayList<Comb>();
	try{			
	Connection conn=super.getConnection();
			
				// Een eerste SQL statement maken
				Statement stmt = conn.createStatement();
				// Een tweede statement maken dat een resultaat oplevert
 				String queryText = "SELECT cs.seriesid, cs.customerid, s.title, s.genre, s.episodes, s.startdate, s.enddate, s.airday, s.duration, s.score, cs.myscore, s.studio, s.rating, s.viewers, s.synopsis, cs.email_not FROM Series s, CustomerSeries cs Where s.id = cs.seriesid AND cs.CUSTOMERID="+cd+" AND s.enddate>to_date('"+date+"','DD/MM/YY')";
                      
 				
 				// Een tweede statement uitvoeren
 				ResultSet rs = stmt.executeQuery(queryText);
 				
 				int custid;
 				int seriesid;
 				int myscore;
 				String email;
 				Comb cs;
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
 				
 				while (rs.next()) {	
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
 					custid = rs.getInt("CUSTOMERID");	
 					seriesid = rs.getInt("SERIESID");	
 					myscore = rs.getInt("myscore");	
 					email=rs.getString("email_not");
 					cs=new Comb(custid, seriesid, myscore, email, title,
 							genre, episodes, startdate, enddate, airday, duration, score,
 							productionstudio, rating, viewers, synopsis);
 					Comblijst.add(cs);
 					}
 				// De resultset, het statement en de verbinding sluiten
 				rs.close();
 				stmt.close();
 				conn.close();
	}
 				catch (SQLException e){
 					e.printStackTrace();
 				}
 				return Comblijst;
}
	
	public void addEntry(CustomerSeries cs){
		try{			
			Connection conn=super.getConnection();
						System.out.println("Ready to put");
					
						// Een eerste SQL statement maken
						Statement stmt = conn.createStatement();
						
						// Een tweede statement maken dat een resultaat oplevert
		 				String queryText = "insert into customerseries values("+cs.getCustID()+", "+cs.getSeriesID()+",0, 'No','No')";
		 				
		 				// Een tweede statement uitvoeren
		 				stmt.executeQuery(queryText);
		 				conn.commit();
		 				stmt.close();
		 				conn.close();
		 }
		catch(Exception e){
			System.out.println(e);
		}
		}
	public void deleteEntry(CustomerSeries cs){
		try{			
			Connection conn=super.getConnection();
						System.out.println("Ready to delete");
					
						// Een eerste SQL statement maken
						Statement stmt = conn.createStatement();
						
						// Een tweede statement maken dat een resultaat oplevert
		 				String queryText = "delete from customerseries where customerid="+cs.getCustID()+"AND seriesid="+cs.getSeriesID();
		 				
		 				// Een tweede statement uitvoeren
		 				stmt.executeQuery(queryText);
		 				conn.commit();
		 				stmt.close();
		 				conn.close();
		 }
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void updateScore(CustomerSeries cs, int score){
		try{			
			Connection conn=super.getConnection();
						System.out.println("Ready to delete");
					
						// Een eerste SQL statement maken
						Statement stmt = conn.createStatement();
						
						// Een tweede statement maken dat een resultaat oplevert
		 				String queryText = "update customerseries set myscore="+score+"where customerid="+cs.getCustID()+"AND seriesid="+cs.getSeriesID();
		 				
		 				// Een tweede statement uitvoeren
		 				stmt.executeQuery(queryText);
		 				conn.commit();
		 				stmt.close();
		 				conn.close();
		 }
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void updateEmail(CustomerSeries cs, String email){
		try{			
			Connection conn=super.getConnection();
						System.out.println("Ready to put");
					
						// Een eerste SQL statement maken
						Statement stmt = conn.createStatement();
						
						// Een tweede statement maken dat een resultaat oplevert
		 				String queryText = "update customerseries set email_not='"+email+"'where customerid="+cs.getCustID()+"AND seriesid="+cs.getSeriesID();
		 				
		 				// Een tweede statement uitvoeren
		 				stmt.executeQuery(queryText);
		 				conn.commit();
		 				stmt.close();
		 				conn.close();
		 }
		catch(Exception e){
			System.out.println(e);
		}
	}
}
