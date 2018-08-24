package nl.hu.v1ipass.thirdapp.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nl.hu.v1ipass.thirdapp.model.CustomerSeries;
import nl.hu.v1ipass.thirdapp.model.Series;

public class CustomerSeriesDAO extends BaseDAO{

		public CustomerSeriesDAO() {
		}

		//Alle CustomerSeries ontvangen
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
	 				String status;
	 				CustomerSeries cs;
	 				
	 				while (rs.next()) {
	 					
	 					custid = rs.getInt("CUSTOMERID");	
	 					seriesid = rs.getInt("SERIESID");	
	 					score = rs.getInt("myscore");	
	 					finished = rs.getString("FINISHED");
	 					email=rs.getString("email_not");
	 					status=rs.getString("status");
	 					cs=new CustomerSeries(custid, seriesid, score, finished, email,status);
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
    //Alle CustomerSeries van een klant ophalen
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
 				String status;
 				CustomerSeries cs;
 				
 				while (rs.next()) {
 					
 					custid = rs.getInt("CUSTOMERID");	
 					seriesid = rs.getInt("SERIESID");	
 					score = rs.getInt("myscore");	
 					finished = rs.getString("FINISHED");
 					email=rs.getString("email_not");
 					status=rs.getString("status");
 					cs=new CustomerSeries(custid, seriesid, score, finished, email,status);
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
	//Informatie over Series+Email Notificaties ophalen van alle aan de klant gekoppelde CustomerSeries van airing Series
	public ArrayList<CustomerSeries> getFinishedCustomerSeriesbyCustomerID(int cd, String date){
		ArrayList<CustomerSeries> CustomerSerieslijst = new ArrayList<CustomerSeries>();
	try{			
	Connection conn=super.getConnection();
			
				// Een eerste SQL statement maken
				Statement stmt = conn.createStatement();
				// Een tweede statement maken dat een resultaat oplevert
 				String queryText = "SELECT * FROM customerseries cs where cs.customerid="+cd+" AND cs.seriesid in (select s.id from Series s WHERE s.enddate<to_date('"+date+"','DD/MM/YY'))";
                      
 				
 				// Een tweede statement uitvoeren
 				ResultSet rs = stmt.executeQuery(queryText);
 				
 				int custid;
 				int seriesid;
 				int score;
 				String finished;
 				String email;
 				String status;
 				CustomerSeries cs;
 				
 				while (rs.next()) {
 					
 					custid = rs.getInt("CUSTOMERID");	
 					seriesid = rs.getInt("SERIESID");	
 					score = rs.getInt("myscore");	
 					finished = rs.getString("FINISHED");
 					email=rs.getString("email_not");
 					status=rs.getString("status");
 					cs=new CustomerSeries(custid, seriesid, score, finished, email,status);
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
	//Informatie over Series+Email Notificaties ophalen van alle aan de klant gekoppelde CustomerSeries van afgelopen series
	public ArrayList<CustomerSeries> getUnfinishedCustomerSeriesbyCustomerID(int cd, String date){
		ArrayList<CustomerSeries> CustomerSerieslijst = new ArrayList<CustomerSeries>();
	try{			
	Connection conn=super.getConnection();
			
				// Een eerste SQL statement maken
				Statement stmt = conn.createStatement();
				// Een tweede statement maken dat een resultaat oplevert
 				String queryText = "SELECT * FROM customerseries cs where cs.customerid="+cd+" AND cs.seriesid in (select s.id from Series s WHERE s.enddate>to_date('"+date+"','DD/MM/YY'))";
                      
 				
 				// Een tweede statement uitvoeren
 				ResultSet rs = stmt.executeQuery(queryText);
 				
 				int custid;
 				int seriesid;
 				int score;
 				String finished;
 				String email;
 				String status;
 				CustomerSeries cs;
 				
 				while (rs.next()) {
 					
 					custid = rs.getInt("CUSTOMERID");	
 					seriesid = rs.getInt("SERIESID");	
 					score = rs.getInt("myscore");	
 					finished = rs.getString("FINISHED");
 					email=rs.getString("email_not");
 					status=rs.getString("status");
 					cs=new CustomerSeries(custid, seriesid, score, finished, email,status);
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
	public ArrayList<CustomerSeries> getEmailbyCustomerID(int cd, String date){
		ArrayList<CustomerSeries> CustomerSerieslijst = new ArrayList<CustomerSeries>();
	try{			
	Connection conn=super.getConnection();
			
				// Een eerste SQL statement maken
				Statement stmt = conn.createStatement();
				// Een tweede statement maken dat een resultaat oplevert
 				String queryText = "SELECT * FROM customerseries cs where cs.customerid="+cd+" AND email_not='Yes' AND finished='No' AND cs.seriesid in (select s.id from Series s WHERE s.enddate=(to_date('"+date+"','DD/MM/YY')+7))";
                      
 				
 				// Een tweede statement uitvoeren
 				ResultSet rs = stmt.executeQuery(queryText);
 				
 				int custid;
 				int seriesid;
 				int score;
 				String finished;
 				String email;
 				String status;
 				CustomerSeries cs;
 				
 				while (rs.next()) {
 					
 					custid = rs.getInt("CUSTOMERID");	
 					seriesid = rs.getInt("SERIESID");	
 					score = rs.getInt("myscore");	
 					finished = rs.getString("FINISHED");
 					email=rs.getString("email_not");
 					status=rs.getString("status");
 					cs=new CustomerSeries(custid, seriesid, score, finished, email,status);
 					CustomerSerieslijst.add(cs);
 					String query="Update CustomerSeries set finished='Yes' where customerid="+cd+" AND seriesid="+seriesid;
 					stmt.executeQuery(query);
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
	//Voeg CustomerSeries toe
	public void addEntry(CustomerSeries cs){
		try{			
			Connection conn=super.getConnection();
						System.out.println("Ready to put");
					
						// Een eerste SQL statement maken
						Statement stmt = conn.createStatement();
						
						// Een tweede statement maken dat een resultaat oplevert
		 				String queryText = "insert into customerseries values("+cs.getCustID()+", "+cs.getSeriesID()+",0, 'No','No','PTW')";
		 				
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
	//Verwijder CustomerSeries
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
	//Update Score van een CustomerSeries
	public void updateScore(CustomerSeries cs, int score){
		try{			
			Connection conn=super.getConnection();
					
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
	//Update emailnotificaties van een CustomerSeries
	public void updateEmail(CustomerSeries cs, String email){
		try{			
			Connection conn=super.getConnection();
						System.out.println("Ready to put");
					
						// Een eerste SQL statement maken
						Statement stmt = conn.createStatement();
						
						// Een tweede statement maken dat een resultaat oplevert
		 				String queryText = "update customerseries set email_not='"+email+"' where customerid="+cs.getCustID()+" AND seriesid="+cs.getSeriesID();
		 				
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

	public void updateStatus(CustomerSeries cs, String status) {
			try{			
				Connection conn=super.getConnection();
						
							// Een eerste SQL statement maken
							Statement stmt = conn.createStatement();
							
							// Een tweede statement maken dat een resultaat oplevert
			 				String queryText = "update customerseries set status='"+status+"' where customerid="+cs.getCustID()+" AND seriesid="+cs.getSeriesID();
			 				
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
