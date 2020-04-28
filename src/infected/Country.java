package infected;

/*
 * Country is the super class for the hot country and cold country objects
 * this just implements all the methods if a regular country object were to be created
 */

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
	/*
	 * getName will return the name of the country
	 * @returns name
	 */
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
	 * setSick will check if the amount you want to set sick is greather than the current amount of sick people and 
	 * call addSick. this was created because of the exponetnial function keeps returning 1 when time is low (since its a double casted to int)
	 * and when addSick was called, it would just keep doubling the sick population
	 * @param sick the amount of people to set sick
	 */
	public void setSick(int sick) {
		if (sick > infected)
		{
			addSick(sick - infected);
		}
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
	
	public int getDay() {
		return day;
	}
	
	
	public int getWealth() {
		return wealth;
	}
	
	public String toString() {
		return name;
	}
	
	public void incrementDay() {
		this.day++;
	}
	/*
	 * addDeceased will take a paramater deceased and will subtract from the sick population to kill them
	 * @param deceased the deceased population to 
	 */
	public void addDeceased(int deceased) {
		if (deceased > population)
		{
			// prevent integer underflow
			deceased = population;
		}
		else
		{
			population -= deceased;
			infected -= deceased;
			this.deceased += deceased;
		}
	}
	
	/*
	 * spread will handle an exponential equation in order to spread throughout the country
	 */
	public void spread(Virus virus) {
		double EULER = 2.718f;
		// using Euler's number for exponential growth https://www.mathsisfun.com/algebra/exponential-growth.html
		infected = (int) (infected * Math.pow(EULER, virus.getInfectivity() * day));
		day++;		
	}
	
	
	/*
	 * getInfo returns all the attributes of the object in a readable format
	 * @returns tmp, a formatted string to be used in textfields/labels
	 */
	public String getInfo() {
        String tmp = "";
        tmp = "Name: " + name + 
        		"\nPopulation: " + String.format("%,d", population) +
        		"\nWealth: " + wealth + "/5";
        return tmp;		
	}
	
	// geneerate a random number for min and max
	/*
	 * random generates a random number and casts to a int since Math.random() returns a double
	 * @param min the minimum number that you want returned
	 * @param max the maximum number that you want returned
	 * @returns the random number that was generated
	 */
    private int random(int min, int max) {
        return (int) (Math.random()*(max-min))+min;
    }
    	
    /*
     * decay will generate a random number inside a loop to determine whether the person dies
     * @param Virus virus, the virus to get it's data from
     */
	public void decay(Virus virus) {
		int lethality = virus.getLethality();
		int rng;
		int decayed = 0;
		if (lethality > 0)
		{
			// roll a dice between 1 and the lethality rate, that will then "decease" a percent from the population 
			rng = random(1, lethality); 
			decayed = (infected / 100) * rng;
			addDeceased(decayed);
		}
	}
}
