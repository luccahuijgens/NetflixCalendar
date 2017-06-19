package nl.hu.v1ipass.thirdapp.webservices;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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
	public String getAllUnfinished() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("dd/MM/YY").format(date);
		for (Series c : service.getAllAiringSeries(modifiedDate)) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("id", c.getCode());
			job.add("title", c.getTitle());
			job.add("genre", c.getGenre());
			job.add("episodes", c.getEpisodes());
			job.add("score",c.getScore());
			job.add("viewers", c.getViewers());
			job.add("studio", c.getProductionstudio());
			job.add("synopsis", c.getSynopsis());
			

			jab.add(job);
		}

		JsonArray array = jab.build();

		return (array.toString());
	}
}