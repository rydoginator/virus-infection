package infected;

public class Symptom {
	private String name;
	private int infectivity, lethality;
	public Symptom(String name, int infectivity, int lethality) {
		this.setName(name);
		this.setInfectivity(infectivity);
		this.setLethality(lethality);
	}
	public int getInfectivity() {
		return infectivity;
	}
	public void setInfectivity(int infectivity) {
		this.infectivity = infectivity;
	}
	public int getLethality() {
		return lethality;
	}
	public void setLethality(int lethality) {
		this.lethality = lethality;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
