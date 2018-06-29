package nl.hu.v1wac.wacapp.persistence;

import java.util.List;
import nl.hu.v1wac.wacapp.webservices.*;

public interface CountryDAO {
	public boolean save(Country country);
	public List<Country> findAll();
	public Country findByCode(String code);
	public List<Country> find10largestpopulations();
	public List<Country> find10largestsurfaces();
	public boolean update(Country country);
	public boolean delete(Country country);
}
