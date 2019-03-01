package nl.hu.v1ipass.thirdapp.webservices;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import jersey.repackaged.com.google.common.collect.Lists;
import nl.hu.v1ipass.thirdapp.model.CustomerService;
import nl.hu.v1ipass.thirdapp.model.Series;
import nl.hu.v1ipass.thirdapp.model.SeriesService;
import nl.hu.v1ipass.thirdapp.model.ServiceProvider;

@Path("series")
public class SeriesResource {
	SeriesService service = ServiceProvider.getSeriesService();
	CustomerService service2=ServiceProvider.getCustomerService();

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
			JsonObjectBuilder job = ObjectToJsonMapper.convertSeries(c);
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
			JsonObjectBuilder job = ObjectToJsonMapper.convertSeries(c);
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
		Collections.sort(serieslist, new Comparator<Series>() {

	        public int compare(Series o1, Series o2) {
	            // compare two instance of `Score` and return `int` as result.
	        	    return o1.getStartdate().compareTo(o2.getStartdate());
	        }
	    });
		serieslist=Lists.reverse(serieslist);
		int batchend=batch+8;
		if (batchend>serieslist.size()) {
			batchend=serieslist.size();
		}if (batch<=serieslist.size()) {
		List<Series> result = new ArrayList<Series>(serieslist.subList(batch,batchend ));
		for (Series c : result) {
			JsonObjectBuilder job = ObjectToJsonMapper.convertSeries(c);
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
			JsonObjectBuilder job = ObjectToJsonMapper.convertSeries(c);
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
			JsonObjectBuilder job = ObjectToJsonMapper.convertSeries(c);
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
	JsonObjectBuilder job=ObjectToJsonMapper.convertSeries(series);
	return job.build().toString();
	}
		
}