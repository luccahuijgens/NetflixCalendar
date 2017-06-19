package nl.hu.v1ipass.thirdapp.model;

import java.util.List;

import nl.hu.v1ipass.thirdapp.persistence.StudioDAO;

public class StudioService {		
		private StudioDAO Studiodao= new StudioDAO();

		public List<Series> getSeriesbyStudio(String studio, String date){
			return Studiodao.getSeriesbyStudio(studio, date);
		}
}