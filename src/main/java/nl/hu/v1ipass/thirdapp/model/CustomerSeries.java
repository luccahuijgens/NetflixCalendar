package nl.hu.v1ipass.thirdapp.model;

public class CustomerSeries {
private int CustID;
private int SeriesID;
private int Score;
private String Finished;
private String Email;

public CustomerSeries(int custID, int seriesID, int score, String finished, String email) {
	CustID = custID;
	SeriesID = seriesID;
	Score = score;
	Finished = finished;
	Email = email;
}

public CustomerSeries(int custID, int seriesID) {
	CustID = custID;
	SeriesID = seriesID;
	Score = 0;
	Finished = "No";
	Email = "No";
}

public int getCustID() {
	return CustID;
}

public void setCustID(int custID) {
	CustID = custID;
}

public int getSeriesID() {
	return SeriesID;
}

public void setSeriesID(int seriesID) {
	SeriesID = seriesID;
}

public int getScore() {
	return Score;
}

public void setScore(int score) {
	Score = score;
}

public String getFinished() {
	return Finished;
}

public void setFinished(String finished) {
	Finished = finished;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

}
