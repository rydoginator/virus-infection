package infected;

/**
 * This class is for HotCountry data as infection rates vary with the countries climates. This is a subclass
 * of the Country class. The subclass has various getters and setters as well.
 * This subclass is created because the virus in hotter countries have higher infection rate but lower lethality rate.
 */

public class HotCountry extends Country {

    /**
     * creates an object with the params name, int, wealth
      * @param name
     * @param population
     * @param wealth
     */
    public HotCountry(String name, int population, int wealth) {
        super(name, population, wealth); // using polymorphism we call the superclass
    }

    /*
     * spread will handle an exponential equation in order to spread throughout the country
     */
    public void spread(Virus virus) {
        /*
         Eulers number, which is commonly used in growth problems, is used in this program to create
         the exponential equation.
         */
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

    /**
     * decay method takes a Virus object type param.
     * The method is used to add a death toll.
     * @param virus
     */
    public void decay(Virus virus) {
        int lethality = virus.getLethality();
        int rng;
        int decayed = 0;
        if (lethality > 0)
        {
            // roll a dice between 1 and the lethality rate, that will then "decease" a percent from the population
            rng = random(1, lethality);
            decayed = (super.getInfected() / 100) * rng;
            super.addDeceased(decayed);
        }

    }

    /**
     * Returns all the attributes of the object in a readable format
     * @return
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