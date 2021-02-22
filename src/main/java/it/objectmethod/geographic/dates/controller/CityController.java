package it.objectmethod.geographic.dates.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import it.objectmethod.geographic.dates.dao.CitiesDao;
import it.objectmethod.geographic.dates.dao.impl.CitiesDaoImpl;
import it.objectmethod.geographic.dates.models.City;

@RestController
public class CityController {
	
	@Autowired 
	private CitiesDaoImpl dao;
	
	@GetMapping("/find-cities")
	public List<City> printCities(@RequestParam("nationName") String name) {
		//CitiesDao dao = new CitiesDaoImpl(); 
		//non serve più perchè ora c'è l'@Autowired qui, e il @Component nella classe CitiesDaoImpl 
		List<City> finalList = dao.findCitiesByNationName(name);
		
		return finalList;	
	}
	

}
