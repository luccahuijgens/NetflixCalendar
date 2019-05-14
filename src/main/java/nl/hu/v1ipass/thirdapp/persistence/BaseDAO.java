package nl.hu.v1ipass.thirdapp.persistence;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class BaseDAO {
	private DataSource connectionPool;

	public BaseDAO() {
		try {
			final String DATABASE_URL_PROP = System.getenv("DATABASE_URL");
			if (DATABASE_URL_PROP != null) {
				URI dbUri = new URI(DATABASE_URL_PROP);
				String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
				getDataSource(dbUri, dbUrl);
			} else {
				InitialContext ic = new InitialContext();
				connectionPool = (DataSource) ic.lookup("java:comp/env/jdbc/PostgresDS");
			}}catch(NamingException | URISyntaxException e) {
				throw new RuntimeException (e);
			}
		}

	private void getDataSource(URI dbUri, String dbUrl) {
		try(BasicDataSource pool = new BasicDataSource()){
		if (dbUri.getUserInfo() != null) {
			pool.setUsername(dbUri.getUserInfo().split(":")[0]);
			pool.setPassword(dbUri.getUserInfo().split(":")[1]);
		}
		pool.setDriverClassName("org.postgresql.Driver");
		pool.setUrl(dbUrl);
		pool.setInitialSize(1);

		connectionPool = pool;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected final Connection getConnection() {
		try {
			return connectionPool.getConnection();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}