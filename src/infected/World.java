package infected;

import java.util.ArrayList;

interface OnWorldListener {
	void update();
}

public class World {

	private int day;
	private ArrayList<Country> countries;
	private Virus virus;
	public World(ArrayList<Country> countries, Virus virus) {
		this.countries = countries;
		this.virus = virus;
		this.day = 0;
	}
	
	public ArrayList<Country> getCountries() {
		return countries;
	}
	
	public Virus getVirus() {
		return virus;
	}
	
	public void setVirus(Virus virus) {
		this.virus = virus;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	/*
	 * incrementDay just sets the world day to a new day
	 * here, we can implement any spreading or killing that the virus might do
	 */
	public void incrementDay() {
		this.day++;
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
	
	public void spread() {
		int infectivity = virus.getInfectivity(); // use this to determine infectivity
		for (Country c: countries) {
			if (c.getSick() > 1)
			{
				// exponential function here to incorporate 
				// get the countries wealth. this will be a % of the people that will travel to another country for this day
				int travel = c.getWealth(); 
				int sickTravelers = travel * (c.getSick() / c.getHealthy()); // this will determine how many travelers will travel to another country
				// to make things simple, and less chaotic, a rng of 0 to 10 will determine whether they are sick enough to travel or not
				boolean willTravel = (random(1,10) == 1) ? true: false;
				// chose which country to infect based
				int id = random(0, countries.size());
				if (willTravel)
					countries.get(id).addSick(sickTravelers); // the sick travelers will only spread to 1 other person in the country
			}
						
		}
	}
}
