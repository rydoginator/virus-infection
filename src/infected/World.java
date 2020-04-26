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
	
	
	public void incrementDay() {
		this.day++;
		for (Country c: countries) {
			c.addSick(1);
		}
	}

}
