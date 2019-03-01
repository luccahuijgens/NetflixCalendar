package nl.hu.v1ipass.thirdapp.webservices;

import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import nl.hu.v1ipass.thirdapp.model.CustomerService;
import nl.hu.v1ipass.thirdapp.model.Review;
import nl.hu.v1ipass.thirdapp.model.ReviewService;
import nl.hu.v1ipass.thirdapp.model.SeriesService;
import nl.hu.v1ipass.thirdapp.model.ServiceProvider;

@Path("/reviews")
public class ReviewResource {
CustomerService cs= ServiceProvider.getCustomerService();
SeriesService ss=ServiceProvider.getSeriesService();
ReviewService rs=ServiceProvider.getReviewService();

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public String getAllByID(@PathParam("id") int id) {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		ArrayList<Review>reviews=rs.getReviewsBySeries(id);
		for (Review r : reviews) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("customerid", r.getCustomer().getId());
			job.add("customer",r.getCustomer().getName()+" "+r.getCustomer().getSurname());
			job.add("content", r.getContent());
			job.add("score", r.getScore());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return (array.toString());
	}
}

