package it.objectmethod.geographic.dates.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.objectmethod.geographic.dates.dao.NationsDao;
import it.objectmethod.geographic.dates.models.Nation;
@Component
public class NationsDaoImpl implements NationsDao {
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:33060/", "omdev", "omdev");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	@Override
	public ArrayList<Nation> findNationsByContinentName(String continentName) {
		Connection conn = getConnection();
		List<Nation> listNations = new ArrayList<Nation>();
		String sql = "SELECT * FROM world.country WHERE Continent = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, continentName);
			ResultSet table = stmt.executeQuery();
			while (table.next()) {
				Nation nazioneAppoggio = new Nation();
				nazioneAppoggio.setCode(table.getString("Code"));
				nazioneAppoggio.setName(table.getString("Name"));
				nazioneAppoggio.setContinent(table.getString("Continent"));
				nazioneAppoggio.setPopulation(table.getLong("Population"));
				nazioneAppoggio.setSurfaceArea(table.getLong("SurfaceArea"));
				listNations.add(nazioneAppoggio);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (ArrayList<Nation>) listNations; 
	}

}
