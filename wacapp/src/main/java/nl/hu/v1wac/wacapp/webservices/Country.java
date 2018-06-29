package nl.hu.v1wac.wacapp.webservices;

public class Country {
	private String code;
	private String iso3;
	private String name;
	private String capital;
	private String continent;
	private String region;
	private double surfacearea;
	private int population;
	private double latitude;
	private double longitude;
	
	
	public Country(String c, String iso, String nm, String cap, String ct, String reg, double sur, int pop, double lat, double lng) {
		code = c;
		iso3 = iso;
		name = nm;
		capital = cap;
		continent = ct;
		region = reg;
		surfacearea = sur;
		population = pop;
		latitude = lat;
		longitude = lng;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public String getRegion() {
		return region;
	}
	
	public String getContinent() {
		return continent;
	}
	
	public String getCapital() {
		return capital;
	}
	
	public double getSurface(){
		return surfacearea;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getIso3Code() {
		return iso3;
	}
	
	public String getName() {
		return name;
	}
}