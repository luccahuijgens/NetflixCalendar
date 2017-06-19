package nl.hu.v1ipass.thirdapp.model;

import java.util.List;

import nl.hu.v1ipass.thirdapp.persistence.CustomerSeriesDAO;

public class CustomerSeriesService {
	private CustomerSeriesDAO CustomerSeriesdao= new CustomerSeriesDAO();
	
	public void addEntry(CustomerSeries cs) {
		CustomerSeriesdao.addEntry(cs);
	}
	public void deleteEntry(Customer c, Series s) {
		CustomerSeries cs=new CustomerSeries(c.getId(),s.getCode());
		CustomerSeriesdao.deleteEntry(cs);
	}
	public void updateScore(Customer c, Series s, int score) {
		CustomerSeries cs=new CustomerSeries(c.getId(),s.getCode());
		CustomerSeriesdao.updateScore(cs, score);
	}
	public void updateEmail(Customer c, Series s, String email) {
		CustomerSeries cs=new CustomerSeries(c.getId(),s.getCode());
		CustomerSeriesdao.updateEmail(cs, email);
	}
	public List<CustomerSeries> getAll() {
		return CustomerSeriesdao.getAll();
	}
	public List<Comb>getFinishedCustomerSeriesbyCustomerID(Customer c, String date){
		return CustomerSeriesdao.getFinishedCustomerSeriesbyCustomerID(c.getId(), date);
	}
	public List<Comb>getUnfinishedCustomerSeriesbyCustomerID(Customer c, String date){
		return CustomerSeriesdao.getUnfinishedCustomerSeriesbyCustomerID(c.getId(), date);
	}
}
