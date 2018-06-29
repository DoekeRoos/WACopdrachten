package nl.hu.v1wac.wacapp.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import javax.ws.rs.DELETE;
import javax.json.Json;
import javax.json.*;
import javax.ws.rs.*;

@Path("/countries")
public class WorldResource {
	private WorldService service = ServiceProvider.getWorldService();
	
	@GET
	@Produces("application/json")
	public String getAllCountries(){
		WorldService service = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Country c : service.getAllCountries()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("code", c.getCode()).add("iso3", c.getIso3Code()).add("name", c.getName())
			.add("continent", c.getContinent()).add("capital", c.getCapital()).add("region", c.getRegion())
			.add("surface", c.getSurface()).add("population", c.getPopulation())
			.add("lat", c.getLatitude()).add("lon", c.getLongitude());
			
			jab.add(job);
		}
		
		JsonArray array = jab.build();
		return array.toString();
		//List<Country> listOfCountries = new ArrayList<Country>();
		//listOfCountries = createCountryList();
		//return listOfCountries;
	}
	
	@GET
	@Path("{code}")
	@Produces("application/json")
	public String getCountryByCode(@PathParam("code") String code) {
		WorldService service = ServiceProvider.getWorldService();
		Country country = service.getCountryByCode(code);
		
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("code", country.getCode()).add("iso3", country.getIso3Code()).add("name", country.getName())
		.add("continent", country.getContinent()).add("capital", country.getCapital()).add("region", country.getRegion())
		.add("surface", country.getSurface()).add("population", country.getPopulation())
		.add("lat", country.getLatitude()).add("lon", country.getLongitude());
		
		
		return job.build().toString();
	}
	
	@GET
	@Path("/largestpopulations")
	@Produces("application/json")
	public String getPopulations() {
		WorldService service = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Country c : service.get10LargestPopulations()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("code", c.getCode()).add("iso3", c.getIso3Code()).add("name", c.getName())
			.add("continent", c.getContinent()).add("capital", c.getCapital()).add("region", c.getRegion())
			.add("surface", c.getSurface()).add("population", c.getPopulation())
			.add("lat", c.getLatitude()).add("lon", c.getLongitude());
			
			jab.add(job);
		}
		
			JsonArray array = jab.build();
			return array.toString();
	}
	
	@GET
	@Path("/largestsurfaces")
	@Produces("application/json")
	public String getSurfaces() {
		WorldService service = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Country c : service.get10LargestSurfaces()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("code", c.getCode()).add("iso3", c.getIso3Code()).add("name", c.getName())
			.add("continent", c.getContinent()).add("capital", c.getCapital()).add("region", c.getRegion())
			.add("surface", c.getSurface()).add("population", c.getPopulation())
			.add("lat", c.getLatitude()).add("lon", c.getLongitude());
			
			jab.add(job);
		}
		
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@DELETE
	@Path("/delete/{name}")
	public Response deleteKamer(@PathParam("name") String name) {
		return Response.status(200).entity(service.deleteCountry(service.getCountryByCode(name))).build();
	}
}
	

	
