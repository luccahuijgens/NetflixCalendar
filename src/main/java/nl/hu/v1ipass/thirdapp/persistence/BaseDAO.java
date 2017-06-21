package nl.hu.v1ipass.thirdapp.persistence;

import java.io.IOException;
import java.sql.*;

public class BaseDAO {
    private String connectionURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private String username = "ipass";
    private String password = "ipass";
    private String driver = "oracle.jdbc.driver.OracleDriver";
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

