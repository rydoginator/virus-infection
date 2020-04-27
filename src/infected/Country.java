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
	void spread(Virus virus) {
		double EULER = 2.718f;
		// using Euler's number for exponential growth https://www.mathsisfun.com/algebra/exponential-growth.html
		infected = (int) (infected * Math.pow(EULER, virus.getInfectivity() * day));
		day++;		
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
    
    private Boolean range(int low, int high, int x) {
    	return ((x - low) <= (high - low));
    }
	
	
    /*
     * decay will generate a random number inside a loop to determine whether the person dies
     * @param Virus virus, the virus to get it's data
     */
	public void decay(Virus virus) {
		int lethality = virus.getLethality();
		int rng;
		int decayed = 0;
		if (lethality > 0)
		{
			for (int i = 0; i < infected; i++)
			{
				rng = random(1, 100); // roll a dice between 1,100, and if it is in range of lethality, then kill the person
				if (range(0, lethality, rng)) // check if the rng is in range, if so, the person decays
				{
					decayed++;
				}
			}
			addDeceased(decayed);
		}
		
	}
}
