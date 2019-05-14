package nl.hu.v1ipass.thirdapp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.hu.v1ipass.thirdapp.model.Series;

public class SeriesDAO extends BaseDAO {
	public SeriesDAO() {
	}

	public List<Series> getAll() {
		ArrayList<Series> seriesList = new ArrayList<>();
		// Leg de connectie met de database
		try (Connection conn = super.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SERIES")) {
			seriesList = getSeriesListFromStatement(stmt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seriesList;
	}

	private ArrayList<Series> getSeriesListFromStatement(PreparedStatement stmt) throws SQLException {
		ArrayList<Series> seriesList = new ArrayList<>();
		try (ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {

				seriesList.add(convertSeries(rs));
			}
			return seriesList;
		} catch (SQLException e) {
			throw new SQLException(e);
		}
	}

	public List<Series> getAiringSeries(String date) {
		ArrayList<Series> seriesList = new ArrayList<>();
		// Leg de connectie met de database
		try (Connection conn = super.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"SELECT * FROM Series s WHERE s.enddate is null or s.enddate>to_date(?,'dd/mm/yy')")) {
			stmt.setString(1, date);

			seriesList = getSeriesListFromStatement(stmt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seriesList;
	}

	public List<Series> getFinishedSeries(String date) {
		ArrayList<Series> seriesList = new ArrayList<>();
		// Leg de connectie met de database
		try (Connection conn = super.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("SELECT * FROM Series s WHERE s.enddate<to_date(?,'dd/mm/yy')")) {
			stmt.setString(1, date);
			seriesList = getSeriesListFromStatement(stmt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seriesList;
	}

	public Series getSeriesbyCode(int cd) {
		Series series = null;
		// Leg de connectie met de database
		try (Connection conn = super.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SERIES WHERE ID=?")) {
			stmt.setInt(1, cd);

			series = getSeriesListFromStatement(stmt).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return series;
	}

	public List<Series> getSeriesbyCustomerID(int cd, String date) {
		ArrayList<Series> seriesList = new ArrayList<>();
		try (Connection conn = super.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"SELECT * FROM Series s WHERE s.enddate>to_date(?,'dd/mm/yy') AND s.ID IN (SELECT cs.SeriesID FROM CustomerSeries cs WHERE cs.CustomerID =?)")) {
			stmt.setString(1, date);
			stmt.setInt(2, cd);

			seriesList = getSeriesListFromStatement(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seriesList;
	}

	public List<Series> getSeriesbyCustomerIDDate(int cd, String day, String date) {
		ArrayList<Series> seriesList = new ArrayList<>();
		try (Connection conn = super.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"select* from series s where (s.enddate is null OR s.enddate>to_date(?,'dd/mm/yy')) AND s.airday=? AND s.id IN(select seriesid from customerseries where customerid=?)")) {
			stmt.setString(1, date);
			stmt.setString(2, day);
			stmt.setInt(3, cd);

			seriesList = getSeriesListFromStatement(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seriesList;
	}

	public List<Series> getFinishedSeriesbyCustomerID(int cd, String date) {
		ArrayList<Series> seriesList = new ArrayList<>();
		try (Connection conn = super.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"SELECT * FROM Series s WHERE s.enddate<to_date(?,'dd/mm/yy') AND s.id IN (Select SeriesID from CustomerSeries Where CustomerID=?)")) {
stmt.setString(1, date);
stmt.setInt(2, cd);
			seriesList = getSeriesListFromStatement(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seriesList;
	}

	public List<Series> getSeriesbyStudio(String studio, String date) {
		ArrayList<Series> seriesList = new ArrayList<>();
		try (Connection conn = super.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"SELECT * FROM Series s WHERE s.enddate>to_date(?,'dd/mm/yy') AND s.studio=?")) {
			stmt.setString(1, date);
			stmt.setString(2, studio);

			seriesList = getSeriesListFromStatement(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seriesList;
	}

	private Series convertSeries(ResultSet rs) throws SQLException {
		int code = rs.getInt("ID");
		String title = rs.getString("title");
		String genre = rs.getString("genre");
		int episodes = rs.getInt("episodes");
		String startdate = rs.getString("startdate");
		String enddate = rs.getString("enddate");
		String airday = rs.getString("airday");
		int duration = rs.getInt("duration");
		double score = rs.getDouble("score");
		String productionstudio = rs.getString("studio");
		int rating = rs.getInt("rating");
		int viewers = rs.getInt("viewers");
		String synopsis = rs.getString("synopsis");
		return new Series(code, title, genre, episodes, startdate, enddate, airday, duration, score, productionstudio,
				rating, viewers, synopsis);
	}
}