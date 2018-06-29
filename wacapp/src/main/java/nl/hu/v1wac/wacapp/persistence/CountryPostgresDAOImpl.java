package nl.hu.v1wac.wacapp.persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import nl.hu.v1wac.wacapp.webservices.Country;

public class CountryPostgresDAOImpl extends PostgresBaseDAO implements CountryDAO {
	public boolean save(Country country) {
		return true;
	}
	public List<Country> findAll(){
		List<Country> results = new ArrayList<Country>();
		Connection con = super.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT code, iso3, name, capital, continent, region, surfacearea, population, latitude, longitude FROM country");
			
			while (rs.next()) {
				String code = rs.getString("code");
				String iso3 = rs.getString("iso3");
				String name = rs.getString("name");
				String capital = rs.getString("capital");
				String continent = rs.getString("continent");
				String region = rs.getString("region");
				double surface = rs.getDouble("surfacearea");
				int population = rs.getInt("population");
				double latitude = rs.getDouble("latitude");
				double longitude = rs.getDouble("longitude");
				
				
				Country newCountry = new Country(code, iso3, name, capital, continent, region, surface, 
												population, latitude, longitude);
				results.add(newCountry);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return results;
	}
	
	public Country findByCode(String my_code) {
		Connection con = super.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM country WHERE code = '" + my_code + "'");
			
			while (rs.next()){
				String code = rs.getString("code");
				String iso3 = rs.getString("iso3");
				String name = rs.getString("name");
				String capital = rs.getString("capital");
				String continent = rs.getString("continent");
				String region = rs.getString("region");
				double surface = rs.getDouble("surface");
				int population = rs.getInt("population");
				double latitude = rs.getDouble("latitude");
				double longitude = rs.getDouble("longitude");
				
				Country newCountry = new Country(code, iso3, name, capital, continent, region, surface, 
						population, latitude, longitude);
				return newCountry;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}
	public List<Country> find10largestpopulations(){
		List<Country> results = new ArrayList<Country>();
		Connection con = super.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM country ORDER BY population DESC LIMIT(10)");
			
			while (rs.next()){
				String code = rs.getString("code");
				String iso3 = rs.getString("iso3");
				String name = rs.getString("name");
				String capital = rs.getString("capital");
				String continent = rs.getString("continent");
				String region = rs.getString("region");
				double surface = rs.getDouble("surface");
				int population = rs.getInt("population");
				double latitude = rs.getDouble("latitude");
				double longitude = rs.getDouble("longitude");
			
				Country newCountry = new Country(code, iso3, name, capital, continent, region, surface, 
						population, latitude, longitude);
				results.add(newCountry);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return results;
	}
	public List<Country> find10largestsurfaces(){
		List<Country> results = new ArrayList<Country>();
		Connection con = super.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM country ORDER BY surfacearea DESC LIMIT(10)");
			
			while (rs.next()){
				String code = rs.getString("code");
				String iso3 = rs.getString("iso3");
				String name = rs.getString("name");
				String capital = rs.getString("capital");
				String continent = rs.getString("continent");
				String region = rs.getString("region");
				double surface = rs.getDouble("surface");
				int population = rs.getInt("population");
				double latitude = rs.getDouble("latitude");
				double longitude = rs.getDouble("longitude");
			
				Country newCountry = new Country(code, iso3, name, capital, continent, region, surface, 
						population, latitude, longitude);
				results.add(newCountry);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return results;
	}

	public boolean update(Country country) {
		Connection con = super.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE country SET name = '" + country.getName() + "', capital = '" + country.getCapital()
			+ "', continent = '" + country.getContinent() + "', region = '" + country.getRegion() + "', surfacearea = "
			+ country.getSurface() + ", population = " + country.getPopulation() + "', latitude = " + country.getLatitude() + ", longitude = " + country.getLongitude()
			+ " WHERE code = '" + country.getIso3Code() + "'");
			
			ps.executeUpdate();
			return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return false;
	}
	public boolean delete(Country country) {
		Connection con = super.getConnection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM country WHERE name = '" + country.getName() + "'");
			return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return false;
	}
}
