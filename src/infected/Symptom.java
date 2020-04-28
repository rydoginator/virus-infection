package infected;
/*
 * Symptom is a object that holds information about lethality and infectivity
 * This will be held by the virus object, which will then be used by the World/Country Objects in order to spread/Kill other people
 */
public class Symptom {

	private String name;
	private int infectivity, lethality;
	// Create the object
	public Symptom(String name, int infectivity, int lethality) {
		this.setName(name);
		this.setInfectivity(infectivity);
		this.setLethality(lethality);
	}
	/*
	 * getInfectivity() will return the infectivity of the symptom object
	 * @returns infectivity
	 */
	public int getInfectivity() {
		return infectivity;
	}
	/*
	 * setInfectivity will modify the infectivity attribute
	 * it's unused for now, but could be useful in the future in order to upgrade symptoms
	 * @param infectivity the infectivity that the user wants to set
	 */
	public void setInfectivity(int infectivity) {
		this.infectivity = infectivity;
	}
	/*
	 * getLethality() will return the lethality of the symptom object
	 * @returns lethality
	 */
	public int getLethality() {
		return lethality;
	}
	/*
	 * setLethality will modify the Lethality attribute
	 * it's unused for now, but could be useful in the future in order to upgrade symptoms
	 * @param lethality the lethality that the user wants to set
	 */
	public void setLethality(int lethality) {
		this.lethality = lethality;
	}
	/*
	 * getName is a getter to get the name of the Symptom object
	 * @returns name
	 */
	public String getName() {
		return name;
	}
	/*
	 * setName is a setter for the name objects
	 * @param name the new name that you want to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/*
	 * toString() converts the object to a string so that it can be used in text fields
	 * @returns the name
	 */
	public String toString() {
		return name;
	}
}
