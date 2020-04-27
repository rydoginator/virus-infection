package infected;

public class Country {
	private String name;
	private int population, infected, deceased, healthy;
	private int wealth;
	private int day; // days since the virus got in the country
	
	public Country(String name, int population, int wealth) {
		this.name = name;
		this.population = population;
		this.wealth = wealth;
		this.healthy = population;
		this.infected = 0;
		this.deceased = 0;
		this.day = 0;
	}
	
	public String getName() {
		return name;
	}
	
	/*
	 * addSick will subtract from the healthy population and will add it to the sick population
	 * @param sick the amount of people to infect
	 */
	public void addSick(int sick) {
		/* check to see if the sick population outweights the healthy population, if so, set sick to healthy
		 * in order to prevent the population from being skewed
		*/
		if (sick > healthy)
		{
			sick = healthy;
		}
		// add to the infected population
		infected += sick;
		// subtract from the healthy population
		healthy -= sick;
		// set the day timer, this will be used for the infection spread function
		if (day == 0)
			day = 1;
	}
	
	/*
	 * Getters and setters for the attributes
	 */
	
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
	
	
	public int getWealth() {
		return wealth;
	}
	
	public String toString() {
		return name;
	}
	
	/*
	 * spread will handle an exponential equation in order to 
	 */
	private void spread(Virus virus) {
		
	}
	
	
	/*
	 * Returns all the attributes of the object in a readable format
	 */
	public String getInfo() {
        String tmp = "";
        tmp = "Name: " + name + 
        		"\nPopulation: " + String.format("%,d", population) +
        		"\nWealth: " + wealth + "/5";
        return tmp;		
	}
}
