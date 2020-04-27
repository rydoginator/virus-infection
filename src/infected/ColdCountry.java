package infected;

public class ColdCountry extends Country {
	public ColdCountry(String name, int population, int wealth) {
		super(name, population, wealth);
	}
	
	
	/*
	 * spread will handle an exponential equation in order to spread throughout the country
	 */
	public void spread(Virus virus) {
		double EULER = 2.718;
		int infected = super.getInfected();
		double rate = (double)(virus.getInfectivity() - 1) / 100; // cold countries will spread less
		// using Euler's number for exponential growth https://www.mathsisfun.com/algebra/exponential-growth.html
		infected = (int) (infected * Math.pow(EULER, (rate * super.getDay()))); 
		super.setSick(infected);
		super.incrementDay();		
	}
	
	/*
	 * Returns all the attributes of the object in a readable format
	 */
	public String getInfo() {
        String tmp = "";
        tmp = "Name: " + super.getName() + 
        		"\nPopulation: " + String.format("%,d", super.getPop()) +
        		"\nTemperature: " + "Cold" +
        		"\nWealth: " + super.getWealth() + "/5";
        return tmp;		
	}
}
