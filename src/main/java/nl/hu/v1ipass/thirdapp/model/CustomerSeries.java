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

public int getSeriesID() {
	return SeriesID;
}

public int getScore() {
	return Score;
}

public String getFinished() {
	return Finished;
}

public String getEmail() {
	return Email;
}
public String toString(){
	return CustID+" + "+SeriesID;
}
}
