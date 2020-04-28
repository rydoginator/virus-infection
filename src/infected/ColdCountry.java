package infected;

/**
 * Similar to the HotCountry subclass, this as well is a subclass. Countries with cold climates have lower infectivity
 * but a higher lethality.
 */
public class ColdCountry extends Country {
    public ColdCountry(String name, int population, int wealth) {
        super(name, population, wealth);
    }

    /**
     * creates an object with the params name, int, wealth
     * spread will handle an exponential equation in order to spread throughout the country
     * @param virus
     */
    public void spread(Virus virus) {
        /*
         Eulers number, which is commonly used in growth problems, is used in this program to create
         the exponential equation.
         */
        double EULER = 2.718;
        int infected = super.getInfected();
        double rate = (double)(virus.getInfectivity() - 1) / 100; // cold countries will spread less
        // using Euler's number for exponential growth https://www.mathsisfun.com/algebra/exponential-growth.html
        infected = (int) (infected * Math.pow(EULER, (rate * super.getDay())));
        super.setSick(infected);
        super.incrementDay();
    }


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
                "\nTemperature: " + "Cold" +
                "\nWealth: " + super.getWealth() + "/5";
        return tmp;
    }
}