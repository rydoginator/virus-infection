package infected;

import java.util.ArrayList;

public class Virus {
	private String name;
	private ArrayList<Symptom> symptoms;
	
	public Virus(String name, Symptom symptom)
	{
		this.name = name;
		this.symptoms = new ArrayList<Symptom>();
		this.symptoms.add(symptom);
	}
	/*
	 * getName Getter for the name property
	 * @returns the name
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * getSymptoms will return an array list of symptoms
	 * @returns the symptom objects in an array
	 */
	public ArrayList<Symptom> getSymptoms() {
		return symptoms;
	}
	
	/*
	 * addSymptom will take a symptom object and add it to the end of the symptom arraylist
	 */
	public void addSymptom(Symptom symptom) {
		this.symptoms.add(symptom);
	}
	
	/*
	 * getInfectivity() will loop through the list of symptoms and accumulate what the infectivitiy is
	 * @returns infectivity, the points of infectivity that it has
	 */
	public int getInfectivity() {
		int infectivity = 0;
		for (Symptom s: symptoms)
		{
			infectivity += s.getInfectivity();
		}
		return infectivity;
	}
	/*
	 * getgetLethality() will loop through the list of symptoms and accumulate what the lethality is
	 * @returns lethality, the points of lethality that it has
	 */
	public int getLethality() {
		int lethality = 0;
		for (Symptom s: symptoms)
			lethality += s.getLethality();
		return lethality;
	}
}
