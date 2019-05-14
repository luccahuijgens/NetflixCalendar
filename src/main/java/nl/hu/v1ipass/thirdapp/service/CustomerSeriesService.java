package nl.hu.v1ipass.thirdapp.service;

import java.util.List;

import nl.hu.v1ipass.thirdapp.model.Customer;
import nl.hu.v1ipass.thirdapp.model.CustomerSeries;
import nl.hu.v1ipass.thirdapp.model.Series;
import nl.hu.v1ipass.thirdapp.persistence.CustomerSeriesDAO;

public class CustomerSeriesService {
	private static CustomerSeriesService instance;
	private CustomerSeriesDAO customerseriesDAO;
	
	private CustomerSeriesService() {
	customerseriesDAO= new CustomerSeriesDAO();
	}
	
	public static CustomerSeriesService getInstance() {
		if (instance==null) {
			instance=new CustomerSeriesService();
		}
		return instance;
	}
	
	public void addEntry(CustomerSeries cs) {
		customerseriesDAO.addEntry(cs);
	}
	public void deleteEntry(Customer c, Series s) {
		CustomerSeries cs=new CustomerSeries(c.getId(),s.getCode());
		customerseriesDAO.deleteEntry(cs);
	}
	public void updateScore(Customer c, Series s, int score) {
		CustomerSeries cs=new CustomerSeries(c.getId(),s.getCode());
		customerseriesDAO.updateScore(cs, score);
	}
	public void updateEmail(Customer c, Series s, String email) {
		CustomerSeries cs=new CustomerSeries(c.getId(),s.getCode());
		customerseriesDAO.updateEmail(cs, email);
	}
	public List<CustomerSeries> getAll() {
		return customerseriesDAO.getAll();
	}
	public List<CustomerSeries>getFinishedCustomerSeriesbyCustomerID(Customer c, String date){
		return customerseriesDAO.getFinishedCustomerSeriesbyCustomerID(c.getId(), date);
	}
	public List<CustomerSeries> getUnfinishedCustomerSeriesbyCustomerID(Customer c, String date){
		return customerseriesDAO.getUnfinishedCustomerSeriesbyCustomerID(c.getId(), date);
	}
	public List<CustomerSeries> getEmailbyCustomerID(Customer c, String date){
		return customerseriesDAO.getEmailbyCustomerID(c.getId(), date);
	}
	public void updateStatus(Customer found, Series found2, String status) {
		CustomerSeries cs=new CustomerSeries(found.getId(),found2.getCode());
		customerseriesDAO.updateStatus(cs, status);	
	}
}
