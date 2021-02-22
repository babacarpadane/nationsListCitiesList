package it.objectmethod.geographic.dates.models;

public class Nation {
	private String code;
	private String name;
	private String continent;
	private long population;
	private long surfaceArea;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public long getSurfaceAea() {
		return surfaceArea;
	}

	public void setSurfaceArea(long surfaceAea) {
		this.surfaceArea = surfaceAea;
	}

	@Override
	public String toString() {
		return "code=" + code + ", name=" + name + ", continent=" + continent + ", population=" + population
				+ ", surfaceAea=" + surfaceArea;
	}

}

