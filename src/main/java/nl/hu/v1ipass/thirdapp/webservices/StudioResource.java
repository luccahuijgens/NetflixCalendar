package nl.hu.v1ipass.thirdapp.webservices;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import nl.hu.v1ipass.thirdapp.model.Series;
import nl.hu.v1ipass.thirdapp.model.ServiceProvider;
import nl.hu.v1ipass.thirdapp.model.StudioService;
@Path("studio")
public class StudioResource {
	StudioService service = ServiceProvider.getStudioService();
	
	@Path("{name}")
	@GET
	@Produces("application/json")
	public String SeriesbyCustIDDate(@PathParam("name") String studio) {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("dd/MM/YY").format(date);
		System.out.println(modifiedDate);
		for (Series c : service.getSeriesbyStudio(studio, modifiedDate)) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("id", c.getCode());
			job.add("title", c.getTitle());
			job.add("genre", c.getGenre());
			job.add("episodes", c.getEpisodes());
			job.add("score",c.getScore());
			job.add("viewers", c.getViewers());
			job.add("synopsis", c.getSynopsis());
			

			jab.add(job);
		}

		JsonArray array = jab.build();

		return (array.toString());
	}
}
