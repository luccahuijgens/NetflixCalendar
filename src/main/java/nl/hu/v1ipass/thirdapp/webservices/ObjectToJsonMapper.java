package nl.hu.v1ipass.thirdapp.webservices;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

import nl.hu.v1ipass.thirdapp.model.CustomerSeries;
import nl.hu.v1ipass.thirdapp.model.Series;

public class ObjectToJsonMapper {
	private ObjectToJsonMapper() {}

	public static JsonObjectBuilder convertSeries(Series c) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		try {
			Date date = new Date();
			String enddate = "-";
			Date modifiedDate = null;
			if (c.getEnddate() != null) {
				modifiedDate = new SimpleDateFormat("yyyy-MM-dd").parse(c.getEnddate().substring(0, 10));
				enddate = c.getEnddate().substring(0, 10);
			}
			job.add("id", c.getCode());
			job.add("title", c.getTitle());
			job.add("genre", c.getGenre());
			job.add("episodes", c.getEpisodes());
			job.add("duration", c.getDuration());
			job.add("airday", c.getAirday());
			if (modifiedDate != null) {
				if (modifiedDate.before(date)) {
					job.add("status", "Finished airing");
				} else {
					job.add("status", "Currently airing");
				}
			} else {
				job.add("status", "Currently airing");
			}
			job.add("start", c.getStartdate().substring(0, 10));
			job.add("end", enddate);
			job.add("score", c.getScore());
			job.add("viewers", c.getViewers());
			job.add("studio", c.getProductionstudio());
			job.add("synopsis", c.getSynopsis());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return job;
	}

	public static JsonObjectBuilder convertCustomerSeries(CustomerSeries c, Series series) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job = convertSeries(series);
		job.add("email", c.getEmail());
		job.add("personalstatus", c.getStatus());
		return job;

	}
}
