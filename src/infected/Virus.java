package infected;

import java.util.ArrayList;

/**
 * The Virus class creates a Virus object as well various accessors and mutators. This class is used to create the
 * virus as a whole, giving it a name and a list of symptoms.
 */
public class Virus {
    private String name;
    private ArrayList<Symptom> symptoms;

    /**
     * This object will be used to hold the virus that the player chooses and names.
     * The symptoms array will be used to hold the various symptoms the player can choose throughout the application
     * @param name
     * @param symptom
     */
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
        /*
        This loop goes through the symptoms array and gets the infectivity, using .getInfectivity() method from the Symptom class,
        from there it returns the infectivity.
         */
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
        /*
        Similar to getInfectivity in this class (above getInfectivity method) this method scrolls through the symptoms
        array and takes the lethality and returns it.
         */
        for (Symptom s: symptoms)
            lethality += s.getLethality();
        return lethality;
    }
}