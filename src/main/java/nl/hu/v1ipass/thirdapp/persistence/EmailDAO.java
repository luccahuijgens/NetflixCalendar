package nl.hu.v1ipass.thirdapp.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nl.hu.v1ipass.thirdapp.model.Email;
import nl.hu.v1ipass.thirdapp.model.Series;

public class EmailDAO extends BaseDAO{
	public ArrayList<Email> getEmailByCustomerID(int custid, String date){
		ArrayList<Email> Serieslijst = new ArrayList<Email>();
	try{			
	Connection conn=super.getConnection();
			
				// Een eerste SQL statement maken
				Statement stmt = conn.createStatement();
				
				// Een tweede statement maken dat een resultaat oplevert
 				String queryText = "Select c.email, cs.customerid, cs.seriesid, s.title, cs.email_not, cs.finished, s.enddate from Customers c, Series s, CustomerSeries cs where cs.seriesid=s.id and email_not='Yes' and c.id=cs.customerid and finished='No' and cs.customerid="+custid+" and s.enddate=(to_date('"+date+"','DD/MM/YY')+7)";
                      
 				
 				// Een tweede statement uitvoeren
 				ResultSet rs = stmt.executeQuery(queryText);
 				
 				String email;
 				int csid;
 				int seriesid;
 				String title;
 				String emailnot;
 				String finished;
 				String enddate;
 				Email e;
 				
 				while (rs.next()) {
 						
 					email = rs.getString("email");
 					csid= rs.getInt("customerid");
 					seriesid = rs.getInt("seriesid");	
 					title=rs.getString("title");
 					emailnot = rs.getString("email_not");
 					finished = rs.getString("finished");
 					enddate = rs.getString("enddate");
 					e=new Email(csid, seriesid, title, email, emailnot, finished, enddate);
 					Serieslijst.add(e);
 					String query="Update CustomerSeries set finished='Yes' where customerid="+csid+" AND seriesid="+seriesid;
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
 				return Serieslijst;
}
}
