package nl.hu.v1ipass.thirdapp.model;

import java.util.ArrayList;
import java.util.List;

import nl.hu.v1ipass.thirdapp.persistence.EmailDAO;

public class EmailService {
private EmailDAO customerdao = new EmailDAO();
	
	public ArrayList<Email>  getEmailbyCustomerID(int custid, String date){
		return customerdao.getEmailByCustomerID(custid, date);
	}
}
