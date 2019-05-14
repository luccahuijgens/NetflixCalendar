package nl.hu.v1ipass.thirdapp.model;

public class CustomerSeries {
private int customerID;
private int seriesID;
private int score;
private String finished;
private String email;
private String status;

public CustomerSeries(int customerID, int seriesID, int score, String finished, String email, String status) {
	super();
	this.customerID = customerID;
	this.seriesID = seriesID;
	this.score = score;
	this.finished = finished;
	this.email = email;
	this.status = status;
}

public CustomerSeries (int customerID,int seriesID) {
	this.customerID=customerID;
	this.seriesID=seriesID;
}

public int getCustomerID() {
	return customerID;
}

public int getSeriesID() {
	return seriesID;
}

public int getScore() {
	return score;
}

public String getFinished() {
	return finished;
}

public String getEmail() {
	return email;
}

public String getStatus() {
	return status;
}

}

