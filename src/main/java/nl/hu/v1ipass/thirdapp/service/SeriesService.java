package nl.hu.v1ipass.thirdapp.service;


import java.util.List;

import nl.hu.v1ipass.thirdapp.model.Customer;
import nl.hu.v1ipass.thirdapp.model.Series;
import nl.hu.v1ipass.thirdapp.persistence.SeriesDAO;

public class SeriesService {
	private static SeriesService instance;
		private SeriesDAO seriesDAO= new SeriesDAO();
		
		private SeriesService() {}
		
		public static SeriesService getInstance() {
			if(instance==null) {
				instance=new SeriesService();
			}
			return instance;
		}
		
		public List<Series> getAllSeries() {
			return seriesDAO.getAll();
		}
		public List<Series> getAllAiringSeries(String date) {
			return seriesDAO.getAiringSeries(date);
		}
		public List<Series> getAllFinishedSeries(String date) {
			return seriesDAO.getFinishedSeries(date);
		}
		public List<Series> getFinishedSeriesbyCustomerID(int cd, String date){
			return seriesDAO.getFinishedSeriesbyCustomerID(cd, date);
		}
		public List<Series> getSeriesbyCustomerID(Customer c, String date){
			return seriesDAO.getSeriesbyCustomerID(c.getId(), date);
		}
		public List<Series> getSeriesbyCustomerIDDay(Customer c, String day, String date){
			return seriesDAO.getSeriesbyCustomerIDDate(c.getId(), day, date);
		}
		public Series getSeriesbyCode(int cd){
			return seriesDAO.getSeriesbyCode(cd);
		}
		}