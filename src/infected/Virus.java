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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Symptom> getSymptoms() {
		return symptoms;
	}
	
	public void addSymptom(Symptom symptom) {
		this.symptoms.add(symptom);
	}
}
