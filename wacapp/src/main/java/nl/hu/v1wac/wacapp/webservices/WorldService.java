package nl.hu.v1wac.wacapp.webservices;

//import java.util.ArrayList;
import nl.hu.v1wac.wacapp.persistence.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WorldService {
	private CountryDAO cdao = new CountryPostgresDAOImpl();
	
	public List<Country> getAllCountries() {
		return cdao.findAll();
	}
	
	public List<Country> get10LargestPopulations() {
		Collections.sort(cdao.findAll(), new Comparator<Country>() {
			public int compare(Country c1, Country c2) {
				return c2.getPopulation() - c1.getPopulation();
			};
		});
		
		return cdao.findAll().subList(0, 10);
	}
	

	public List<Country> get10LargestSurfaces() {
		Collections.sort(cdao.findAll(), new Comparator<Country>() {
			public int compare(Country c1, Country c2) {
				return (int)(c2.getSurface() - c1.getSurface());
			};
		});
		
		return cdao.findAll().subList(0, 10);
	} 
	
	public Country getCountryByCode(String code) {
		Country result = null;
		
		for (Country c : cdao.findAll()) {
			if (c.getCode().equals(code)) {
				result = c;
				break;
			}
		}
		
		return result;
	}
	
	public boolean deleteCountry(Country c) {
		cdao.delete(c);
		return true;
	}
}

