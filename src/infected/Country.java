package infected;

public class Country {
	private String name;
	private boolean temp;
	private int population;
	private int infected;
	private int deceased;
	private int wealth;
	
	public Country(String name, int population, boolean temp, int wealth) {
		this.name = name;
		this.population = population;
		this.temp = temp;
		this.wealth = wealth;
		this.infected = 0;
		this.deceased = 0;
	}
	
	private String getName() {
		return name;
	}
	
	private int getPop() {
		return population;
	}
	
	private Boolean getTemp() {
		return temp;
	}
	
	private int getWealth() {
		return wealth;
	}
}
