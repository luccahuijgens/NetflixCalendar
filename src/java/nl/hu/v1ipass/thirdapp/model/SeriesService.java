package nl.hu.v1ipass.thirdapp.model;


import java.util.List;

import nl.hu.v1ipass.thirdapp.persistence.SeriesDAO;

public class SeriesService {		
		private SeriesDAO Seriesdao= new SeriesDAO();
		
		public List<Series> getAllAiringSeries(String date) {
			return Seriesdao.getAiringSeries(date);
		}
		public List<Series> getAllFinishedSeries(String date) {
			return Seriesdao.getFinishedSeries(date);
		}
		public List<Series> getFinishedSeriesbyCustomerID(int cd, String date){
			return Seriesdao.getFinishedSeriesbyCustomerID(cd, date);
		}
		public List<Series> getSeriesbyCustomerID(Customer c, String date){
			return Seriesdao.getSeriesbyCustomerID(c.getId(), date);
		}
		public List<Series> getSeriesbyCustomerIDDay(Customer c, String day, String date){
			return Seriesdao.getSeriesbyCustomerIDDate(c.getId(), day, date);
		}
		}