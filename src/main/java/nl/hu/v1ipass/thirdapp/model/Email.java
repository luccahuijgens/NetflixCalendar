package nl.hu.v1ipass.thirdapp.model;

public class Email {
	private int custid;
	private int seriesid;
	private String title;
	private String email;
	private String email_not;
	private String finished;
	private String enddate;
	public Email(int custid, int seriesid, String title, String email, String email_not, String finished, String enddate) {
		super();
		this.custid = custid;
		this.seriesid = seriesid;
		this.title=title;
		this.email = email;
		this.email_not = email_not;
		this.finished = finished;
		this.enddate = enddate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public int getSeriesid() {
		return seriesid;
	}
	public void setSeriesid(int seriesid) {
		this.seriesid = seriesid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_not() {
		return email_not;
	}
	public void setEmail_not(String email_not) {
		this.email_not = email_not;
	}
	public String getFinished() {
		return finished;
	}
	public void setFinished(String finished) {
		this.finished = finished;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
}
