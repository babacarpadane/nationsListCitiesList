package it.objectmethod.geographic.dates.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import it.objectmethod.geographic.dates.dao.NationsDao;
import it.objectmethod.geographic.dates.dao.impl.NationsDaoImpl;
import it.objectmethod.geographic.dates.models.Nation;

@RestController
public class NationController {
	
	@Autowired 
	private NationsDaoImpl dao;
	
	@GetMapping("/find-nations")
	public List<Nation> printNations(@RequestParam("continentName") String name) {
		//NationsDao dao = new NationsDaoImpl();
		//non serve più perchè ora c'è l'@Autowired qui, e il @Component nella classe NationsDaoImpl 
		List<Nation> finalList = dao.findNationsByContinentName(name);
		
		return finalList;
	}

}
