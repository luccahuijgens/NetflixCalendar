package nl.hu.v1ipass.thirdapp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.hu.v1ipass.thirdapp.model.Customer;

public class CustomerDAO extends BaseDAO {
	public CustomerDAO() {
	}

	public List<Customer> getCustomers() {
		ArrayList<Customer> customerList = new ArrayList<>();

		try (Connection conn = super.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT* FROM CUSTOMERS")) {

			customerList = getCustomerListFromStatement(stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	// Customer find op basis van Customer ID
	public Customer findCustomerbyCode(int cd) {
		ArrayList<Customer> customerList = new ArrayList<>();
		try (Connection conn = super.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Customers WHERE id=?")) {
			stmt.setInt(1, cd);

			customerList = getCustomerListFromStatement(stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList.get(0);
	}

//Customer vinden op basis van inloggegevens
	public Customer login(String email, String password) {
		ArrayList<Customer> customerList = new ArrayList<>();
		try (Connection conn = super.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("SELECT * FROM Customers WHERE email=? AND password=?")) {
			stmt.setString(1, email);
			stmt.setString(2, password);

			customerList = getCustomerListFromStatement(stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList.get(0);
	}

	private ArrayList<Customer> getCustomerListFromStatement(PreparedStatement stmt) throws SQLException {

		ArrayList<Customer> customerList = new ArrayList<>();
		try (ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {

				Customer customer = convertRStoCustomer(rs);
				customerList.add(customer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	private Customer convertRStoCustomer(ResultSet rs) throws SQLException {
		int code = rs.getInt("ID");
		String name = rs.getString("name");
		String surname = rs.getString("surname");
		String password2 = rs.getString("password");
		String birthday = rs.getString("birthday");
		String email2 = rs.getString("email");
		return new Customer(code, name, surname, password2, birthday, email2);
	}
}