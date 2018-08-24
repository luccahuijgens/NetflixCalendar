package nl.hu.v1ipass.thirdapp.model;

public class Review {
private Customer customer;
private Series series;
private String content;
private int score;
public Review(Customer customer, Series series, String content, int score) {
	super();
	this.customer = customer;
	this.series = series;
	this.content = content;
	this.score=score;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public Series getSeries() {
	return series;
}
public void setSeries(Series series) {
	this.series = series;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}

}
