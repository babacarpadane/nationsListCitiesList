package it.objectmethod.geographic.dates.dao;

import java.util.List;

import it.objectmethod.geographic.dates.models.City;

public interface CitiesDao {
	public List<City> findCitiesByNationName (String name);
}
