package nl.hu.v1ipass.thirdapp.persistence;

import java.io.IOException;
import java.sql.*;

public class BaseDAO {
    private String connectionURL = "jdbc:postgresql://localhost:5432/netflix";
    private String username = "postgres";
    private String password = "Burdeos1";
    private String driver = "org.postgresql.Driver";
    private Connection con;

    BaseDAO() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Connection getConnection(){
        // URL, User and Password
        try {
			con = DriverManager.getConnection(connectionURL, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return con;
    }

    void close() throws SQLException {
        if (con != null) {
            con.close();
        }
    }


}

