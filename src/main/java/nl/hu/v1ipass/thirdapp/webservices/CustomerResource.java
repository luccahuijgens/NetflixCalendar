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

import nl.hu.v1ipass.thirdapp.model.Customer;
import nl.hu.v1ipass.thirdapp.model.CustomerService;
import nl.hu.v1ipass.thirdapp.model.CustomerServiceProvider;
import nl.hu.v1ipass.thirdapp.model.Series;

@Path("customer")
public class CustomerResource {
	CustomerService service = CustomerServiceProvider.getCustomerService();

	@GET
	@Produces("application/json")
	public String CountryList() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Customer c : service.getAllCustomers()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("name", c.getName());
			job.add("surname", c.getSurname());
			job.add("email", c.getEmail());

			jab.add(job);
		}

		JsonArray array = jab.build();

		return (array.toString());
	}
	@Path("{email}+{pass}")
	@GET
	@Produces("application/json")
	public String SeriesByCustID(@PathParam("email") String email, @PathParam("pass") String pass) {
		Customer c = service.getCustbyLogin(email, pass);

		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("id", c.getId());
		job.add("password", c.getPassword());
		

		return (job.build().toString());
	}
	
}

