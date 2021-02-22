package it.objectmethod.geographic.dates.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.geographic.dates.dao.CitiesDao;
import it.objectmethod.geographic.dates.dao.NationsDao;
import it.objectmethod.geographic.dates.dao.impl.CitiesDaoImpl;
import it.objectmethod.geographic.dates.dao.impl.NationsDaoImpl;
import it.objectmethod.geographic.dates.models.City;
import it.objectmethod.geographic.dates.models.Nation;

@RestController
public class ListController {
	
	@GetMapping("/find-cities")
	public List<City> printCities(@RequestParam("nationName") String name) {
		CitiesDao dao = new CitiesDaoImpl();
		List<City> finalList = dao.findCitiesByNationName(name);
		
		return finalList;	
	}
	
	@GetMapping("/find-nations")
	public List<Nation> printNations(@RequestParam("continentName") String name) {
		NationsDao dao = new NationsDaoImpl();
		List<Nation> finalList = dao.findNationsByContinentName(name);
		
		return finalList;
	}

}
