package nl.hu.v1ipass.thirdapp.service;

import java.util.List;

import nl.hu.v1ipass.thirdapp.model.Studio;
import nl.hu.v1ipass.thirdapp.persistence.StudioDAO;

public class StudioService {		
	private static StudioService instance;
		private StudioDAO studioDAO= new StudioDAO();
		private StudioService() {}
		
		public static StudioService getInstance() {
			if (instance==null) {
				instance=new StudioService();
			}
			return instance;
		}

		public List<Studio> getStudios(){
			return studioDAO.getStudios();
		}
}