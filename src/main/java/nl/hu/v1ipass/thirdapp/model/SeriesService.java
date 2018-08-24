package nl.hu.v1ipass.thirdapp.model;


import java.util.ArrayList;

import nl.hu.v1ipass.thirdapp.persistence.SeriesDAO;

public class SeriesService {		
		private SeriesDAO Seriesdao= new SeriesDAO();
		
		public ArrayList<Series> getAllSeries() {
			return Seriesdao.getAll();
		}
		public ArrayList<Series> getAllAiringSeries(String date) {
			return Seriesdao.getAiringSeries(date);
		}
		public ArrayList<Series> getAllFinishedSeries(String date) {
			return Seriesdao.getFinishedSeries(date);
		}
		public ArrayList<Series> getFinishedSeriesbyCustomerID(int cd, String date){
			return Seriesdao.getFinishedSeriesbyCustomerID(cd, date);
		}
		public ArrayList<Series> getSeriesbyCustomerID(Customer c, String date){
			System.out.println(c.getName()+date);
			return Seriesdao.getSeriesbyCustomerID(c.getId(), date);
		}
		public ArrayList<Series> getSeriesbyCustomerIDDay(Customer c, String day, String date){
			return Seriesdao.getSeriesbyCustomerIDDate(c.getId(), day, date);
		}
		public Series getSeriesbyCode(int cd){
			return Seriesdao.getSeriesbyCode(cd);
		}
		}