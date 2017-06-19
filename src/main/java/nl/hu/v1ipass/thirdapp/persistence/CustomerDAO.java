package nl.hu.v1ipass.thirdapp.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nl.hu.v1ipass.thirdapp.model.Customer;

public class CustomerDAO extends BaseDAO {
	// Zorg ter voorbereiding dat je ojdbc.jar download en toevoegt aan je
	// project.

	// Aanmaken van de variabelen die je connectie specificeren. In dit geval
	// een gebruiker "harry" met password "harry"

	public CustomerDAO() {
	}

	// De methode die met JDBC aan de slag gaat moet een SQLException opvangen
	// of gooien

	public ArrayList<Customer> getCustomers(){
		ArrayList<Customer> Customerlijst = new ArrayList<Customer>();
			// Leg de connectie met de database
		try{			
		Connection conn=super.getConnection();
					System.out.println("Connection made");
				
					// Een eerste SQL statement maken
					Statement stmt = conn.createStatement();
					
					// Een tweede statement maken dat een resultaat oplevert
	 				String queryText = "SELECT * FROM Customers";
	 				
	 				// Een tweede statement uitvoeren
	 				ResultSet rs = stmt.executeQuery(queryText);
	 				
	 				int code;
	 				String name;
	 				String surname;
	 				String password;
	 				String birthday;
	 				String email;
	 				Customer Customer;
	 				
	 				while (rs.next()) {
	 					
	 					code = rs.getInt("ID");	
	 					name = rs.getString("name");
	 					surname = rs.getString("surname");
	 					password = rs.getString("password");
	 					birthday= rs.getString("birthday");
	 					email = rs.getString("email");
	 					Customer=new Customer(code, name, surname, password, birthday, email);
	 					Customerlijst.add(Customer);
	 					}
	 				// De resultset, het statement en de verbinding sluiten
	 				rs.close();
	 				stmt.close();
	 				conn.close();
		}
	 				catch (SQLException e){
	 					e.printStackTrace();
	 				}
	 				return Customerlijst;
	}
	
	public Customer findCustomerbyCode(int cd){
		ArrayList<Customer> Customerlijst = new ArrayList<Customer>();
	try{			
	Connection conn=super.getConnection();
			
				// Een eerste SQL statement maken
				Statement stmt = conn.createStatement();
				
				// Een tweede statement maken dat een resultaat oplevert
 				String queryText = "SELECT * FROM Customer WHERE id="+cd;
 				
 				// Een tweede statement uitvoeren
 				ResultSet rs = stmt.executeQuery(queryText);
 				
 				int code;
 				String name;
 				String surname;
 				String password;
 				String birthday;
 				String email;
 				Customer Customer;
 				
 				while (rs.next()) {
 					
 					code = rs.getInt("ID");	
 					name = rs.getString("name");
 					surname = rs.getString("surname");
 					password = rs.getString("password");
 					birthday= rs.getString("birthday");
 					email = rs.getString("email");
 					Customer=new Customer(code, name, surname, password, birthday, email);
 					Customerlijst.add(Customer);
 				}
 				// De resultset, het statement en de verbinding sluiten
 				rs.close();
 				stmt.close();
 				conn.close();
	}
 				catch (SQLException e){
 					e.printStackTrace();
 				}
 				return Customerlijst.get(0);
}
public Customer login(String email, String password){
	ArrayList<Customer> Customerlijst = new ArrayList<Customer>();
try{			
Connection conn=super.getConnection();
		
			// Een eerste SQL statement maken
			Statement stmt = conn.createStatement();
			
			// Een tweede statement maken dat een resultaat oplevert
				String queryText = "SELECT * FROM Customers WHERE email='"+email+"' AND password='"+password+"'";
				
				// Een tweede statement uitvoeren
				ResultSet rs = stmt.executeQuery(queryText);
				
				int code;
				String name;
				String surname;
				String password2;
				String birthday;
				String email2;
				Customer Customer;
				
				while (rs.next()) {
					
					code = rs.getInt("ID");	
					name = rs.getString("name");
					surname = rs.getString("surname");
					password2 = rs.getString("password");
					birthday= rs.getString("birthday");
					email2 = rs.getString("email");
					Customer=new Customer(code, name, surname, password2, birthday, email2);
					Customerlijst.add(Customer);
				}
				// De resultset, het statement en de verbinding sluiten
				rs.close();
				stmt.close();
				conn.close();
}
				catch (SQLException e){
					e.printStackTrace();
				}
				return Customerlijst.get(0);
}}