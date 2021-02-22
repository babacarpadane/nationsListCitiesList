package it.objectmethod.geographic.dates.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.geographic.dates.dao.CitiesDao;
import it.objectmethod.geographic.dates.dao.impl.CitiesDaoImpl;
import it.objectmethod.geographic.dates.models.City;

@RestController
public class CityController {
	
	@GetMapping("/find-cities")
	public List<City> printCities(@RequestParam("nationName") String name) {
		CitiesDao dao = new CitiesDaoImpl();
		List<City> finalList = dao.findCitiesByNationName(name);
		
		return finalList;	
	}
	

}
