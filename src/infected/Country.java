package infected;

public class Country {
	private String name;
	// temperature will be a boolean on whether it's hot or not
	private boolean temp;
	private int population, infected, deceased, healthy;
	private int wealth;
	
	public Country(String name, int population, boolean temp, int wealth) {
		this.name = name;
		this.population = population;
		this.temp = temp;
		this.wealth = wealth;
		this.healthy = population;
		this.infected = 0;
		this.deceased = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealthy() {
		return healthy;
	}
	
	public int getDeceased() {
		return deceased;
	}
	
	public int getInfected() {
		return infected;
	}
	
	public int getSick() {
		return infected;
	}
	
	public int getPop() {
		return population;
	}
	
	public Boolean getTemp() {
		return temp;
	}
	
	public int getWealth() {
		return wealth;
	}
	
	public String toString() {
		return name;
	}
	
	
	
	public String getInfo() {
        String tmp = "";
        tmp = "Name: " + name + 
        		"\nPopulation: " + String.format("%,d", population) +
        		"\nTemperature: " + ((temp) ? "Hot" : "Cold") +
        		"\nWealth: " + wealth + "/5";
        return tmp;		
	}
}
