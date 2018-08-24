package nl.hu.v1ipass.thirdapp.webservices;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.mail.internet.ParseException;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import jersey.repackaged.com.google.common.collect.Lists;
import nl.hu.v1ipass.thirdapp.model.Customer;
import nl.hu.v1ipass.thirdapp.model.CustomerService;
import nl.hu.v1ipass.thirdapp.model.CustomerServiceProvider;
import nl.hu.v1ipass.thirdapp.model.SerieServiceProvider;
import nl.hu.v1ipass.thirdapp.model.Series;
import nl.hu.v1ipass.thirdapp.model.SeriesService;

@Path("series")
public class SeriesResource {
	SeriesService service = SerieServiceProvider.getSeriesService();
	CustomerService service2=CustomerServiceProvider.getCustomerService();

	@GET
	@Produces("application/json")
	public String getAll(@QueryParam("batch")int batch) {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		Date date = new Date();
		List<Series>serieslist=service.getAllSeries();
		int batchend=batch+5;
		if (batchend>serieslist.size()) {
			batchend=serieslist.size();
		}if (batch<=serieslist.size()) {
		List<Series> result = new ArrayList<Series>(serieslist.subList(batch,batchend ));
		for (Series c : result) {
			JsonObjectBuilder job = createJson(c);
			jab.add(job);
		}
		JsonArray array = jab.build();
		return (array.toString());
		}else {
			return null;
		}
}
	@GET
	@Path("/airing")
	@Produces("application/json")
	public String getAllUnfinished(@QueryParam("batch")int batch) {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("dd/MM/YY").format(date);
		List<Series>serieslist=service.getAllAiringSeries(modifiedDate);
		int batchend=batch+5;
		if (batchend>serieslist.size()) {
			batchend=serieslist.size();
		}if (batch<=serieslist.size()) {
		List<Series> result = new ArrayList<Series>(serieslist.subList(batch,batchend ));
		for (Series c : result) {
			JsonObjectBuilder job = createJson(c);
			jab.add(job);
		}
		JsonArray array = jab.build();
		return (array.toString());
		}else {
			return null;
		}
}
	@GET
	@Path("/latest")
	@Produces("application/json")
	public String getLatest(@QueryParam("batch")int batch) {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		List<Series>serieslist=service.getAllSeries();
		int batchend=batch+8;
		if (batchend>serieslist.size()) {
			batchend=serieslist.size();
		}if (batch<=serieslist.size()) {
		List<Series> result = new ArrayList<Series>(serieslist.subList(batch,batchend ));
		for (Series c : result) {
			JsonObjectBuilder job = createJson(c);
			jab.add(job);
		}
		JsonArray array = jab.build();
		return (array.toString());
		}else {
			return null;
		}
}
	@GET
	@Path("/popular")
	@Produces("application/json")
	public String getPopular(@QueryParam("batch")int batch) {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		List<Series>serieslist=service.getAllSeries();
		Collections.sort(serieslist, new Comparator<Series>() {

	        public int compare(Series o1, Series o2) {
	            // compare two instance of `Score` and return `int` as result.
	            return Integer.compare(o1.getViewers(), o2.getViewers());
	        }
	    });
		serieslist=Lists.reverse(serieslist);
		int batchend=batch+8;
		if (batchend>serieslist.size()) {
			batchend=serieslist.size();
		}if (batch<=serieslist.size()) {
		List<Series> result = new ArrayList<Series>(serieslist.subList(batch,batchend ));
		for (Series c : result) {
			JsonObjectBuilder job = createJson(c);
			jab.add(job);
		}
		JsonArray array = jab.build();
		return (array.toString());
		}else {
			return null;
		}
}
	@GET
	@Path("/top")
	@Produces("application/json")
	public String getTop(@QueryParam("batch")int batch) {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		List<Series>serieslist=service.getAllSeries();
		Collections.sort(serieslist, new Comparator<Series>() {

	        public int compare(Series o1, Series o2) {
	            // compare two instance of `Score` and return `int` as result.
	            return Double.compare(o1.getScore(), o2.getScore());
	        }
	    });
		serieslist=Lists.reverse(serieslist);
		int batchend=batch+8;
		if (batchend>serieslist.size()) {
			batchend=serieslist.size();
		}if (batch<=serieslist.size()) {
		List<Series> result = new ArrayList<Series>(serieslist.subList(batch,batchend ));
		for (Series c : result) {
			JsonObjectBuilder job = createJson(c);
			jab.add(job);
		}
		JsonArray array = jab.build();
		return (array.toString());
		}else {
			return null;
		}
}
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public String getSeriesByID(@PathParam("id") int id) {
	Series series=service.getSeriesbyCode(id);
	JsonObjectBuilder job=createJson(series);
	return job.build().toString();
	}
	
	public JsonObjectBuilder createJson(Series c) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		try {
	Date date = new Date();
	Date modifiedDate= new SimpleDateFormat("yyyy-MM-dd").parse(c.getEnddate().substring(0,10));
	job.add("id", c.getCode());
	job.add("title", c.getTitle());
	job.add("genre", c.getGenre());
	job.add("episodes", c.getEpisodes());
	job.add("duration", c.getDuration());
	job.add("airday", c.getAirday());
	if (modifiedDate.before(date)) {
		job.add("status", "Finished airing");
	}else {
		job.add("status", "Currently airing");
	}
	job.add("start", c.getStartdate().substring(0,10));
	job.add("end", c.getEnddate().substring(0, 10));
	job.add("score",c.getScore());
	job.add("viewers", c.getViewers());
	job.add("studio", c.getProductionstudio());
	job.add("synopsis", c.getSynopsis());
	}
	catch(java.text.ParseException e) {
		e.printStackTrace();
	}
	return job;
		
}
}