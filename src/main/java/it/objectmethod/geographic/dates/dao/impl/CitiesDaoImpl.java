package it.objectmethod.geographic.dates.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.geographic.dates.dao.CitiesDao;
import it.objectmethod.geographic.dates.models.City;

public class CitiesDaoImpl implements CitiesDao {

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
	public ArrayList<City> findCitiesByNationName(String name) {
		Connection conn = getConnection();
		List<City> listCities = new ArrayList<City>();
		String sql = "SELECT * FROM	world.city AS c INNER JOIN world.country AS g ON g.Name = ? AND g.Code = c.CountryCode ";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			ResultSet table = stmt.executeQuery();
			while (table.next()) {
				City cityAppoggio = new City();
				cityAppoggio.setId(table.getLong("ID"));
				cityAppoggio.setName(table.getString("Name"));
				cityAppoggio.setCountryCode(table.getString("CountryCode"));
				cityAppoggio.setDistrict(table.getString("District"));
				cityAppoggio.setPopulation(table.getLong("Population"));
				listCities.add(cityAppoggio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (ArrayList<City>) listCities;
	}

}
