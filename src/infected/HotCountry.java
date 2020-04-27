package infected;

public class HotCountry extends Country {
	
	public HotCountry(String name, int population, int wealth) {
		super(name, population, wealth);
	}
	
	/*
	 * spread will handle an exponential equation in order to spread throughout the country
	 */
	public void spread(Virus virus) {
		double EULER = 2.718;
		int infected = super.getInfected();
		double rate = (double)((virus.getInfectivity() + 1) / 100); // hot countries will spread more
		// using Euler's number for exponential growth https://www.mathsisfun.com/algebra/exponential-growth.html
		infected = (int) (infected * Math.pow(EULER, rate * super.getDay())); 
		super.incrementDay();
		super.addSick(infected);
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
	
	public void decay(Virus virus) {
		int lethality = virus.getLethality();
		int rng;
		int decayed = 0;
		if (lethality > 0)
		{
			for (int i = 0; i < super.getInfected(); i++)
			{
				rng = random(1, 100); // roll a dice between 1,100, and if it is in range of lethality, then kill the person
				if (range(0, lethality, rng)) // check if the rng is in range, if so, the person decays
				{
					decayed++;
				}
			}
			super.addDeceased(decayed);
		}
		
	}
	
	/*
	 * Returns all the attributes of the object in a readable format
	 */
	public String getInfo() {
        String tmp = "";
        tmp = "Name: " + super.getName() + 
        		"\nPopulation: " + String.format("%,d", super.getPop()) +
        		"\nTemperature: " + "Hot" +
        		"\nWealth: " + super.getWealth() + "/5";
        return tmp;		
	}
			
}
