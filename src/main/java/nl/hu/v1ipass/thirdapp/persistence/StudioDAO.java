package nl.hu.v1ipass.thirdapp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.hu.v1ipass.thirdapp.model.Studio;

public class StudioDAO extends BaseDAO {

	public StudioDAO() {
	}

	public List<Studio> getStudios() {
		ArrayList<Studio> studioList = new ArrayList<>();
		try (Connection conn = super.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT* FROM STUDIOS")) {

			studioList = getStudioListFromStatement(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studioList;
	}

	private ArrayList<Studio> getStudioListFromStatement(PreparedStatement stmt) throws SQLException {
		ArrayList<Studio> studioList = new ArrayList<>();
		try (ResultSet rs = stmt.executeQuery()) {

			String name;
			String ordate;

			Studio studio;

			while (rs.next()) {

				name = rs.getString("name");
				ordate = rs.getString("ordate");
				studio = new Studio(name, ordate);
				studioList.add(studio);
			}
			return studioList;
		} catch (SQLException e) {
			throw new SQLException(e);
		}
	}

	public Studio findStudiobyCode(String cd) {
		ArrayList<Studio> studioList = new ArrayList<>();
		try (Connection conn = super.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Studio WHERE name=?")) {
			stmt.setString(1, cd);

			studioList = getStudioListFromStatement(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studioList.get(0);
	}
}