package it.objectmethod.geographic.dates.dao;

import java.util.List;

import it.objectmethod.geographic.dates.models.Nation;

public interface NationsDao {
	public List<Nation> findNationsByContinentName (String continentName);
}
