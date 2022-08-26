// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Akhil Kamalesh (akhilk24)

package spacecolonies;

/**
 * Planet class implements the Comparable<T> interface. This class creates a
 * planet object
 * that is used in the spacecolonies project
 * 
 * @author akhilkamalesh
 * @version 11/07/2020
 *
 */
public class Planet implements Comparable<Planet> {

    /**
     * private variables used in the planet class
     */
    private String name;
    private Skills minSkills;
    private Person[] population;
    private int populationSize;
    private final int capacity;

    /**
     * Constructor for the planet class
     * 
     * @param planetName
     *            name of the planet
     * @param planetAgri
     *            agriculture skill requirement for planet
     * @param planetMedi
     *            medical skill requirement for planet
     * @param planetTech
     *            technical skill requirement for planet
     * @param planetCap
     *            capacity for the planet
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {

        this.name = planetName;
        this.minSkills = new Skills(planetAgri, planetMedi, planetTech);
        this.capacity = planetCap;
        this.populationSize = 0;
        this.population = new Person[planetCap];

    }


    /**
     * Sets the name for the planet
     * 
     * @param n
     *            String
     */
    public void setName(String n) {
        name = n;
    }


    /**
     * Gets the name of the planet
     * 
     * @return name String
     */
    public String getName() {
        return name;
    }


    /**
     * Gets the minimum skills of the planet
     * 
     * @return minSkills Skills
     */
    public Skills getSkills() {
        return minSkills;
    }


    /**
     * Gets the population of the planet
     * 
     * @return population Person[]
     */
    public Person[] getPopulation() {
        return population;
    }


    /**
     * Gets the population size of the planet
     * 
     * @return populationSize int
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * Gets the capacity of the planet
     * 
     * @return capacity int
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * Gets the available spaces for the planet
     * 
     * @return int
     */
    public int getAvailability() {
        return capacity - populationSize;
    }


    /**
     * Checks to see if the planet isFull
     * 
     * @return boolean
     */
    public boolean isFull() {
        return capacity == populationSize;
    }


    /**
     * Method used to add people to the planet
     * 
     * @param newPerson
     *            Person
     * @return boolean
     */
    public boolean addPerson(Person newPerson) {
        if ((!isFull()) && isQualified(newPerson)) {
            population[populationSize] = newPerson;
            populationSize++;
            return true;
        }

        return false;
    }


    /**
     * Checks to see if the person isQualified to live on the planet
     * 
     * @param qualPerson
     *            Person
     * @return boolean
     */
    public boolean isQualified(Person qualPerson) {
        return minSkills.isBelow(qualPerson.getSkills());
    }


    /**
     * Used to display the Planet object
     * 
     * @return s String
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(name + ", population " + populationSize + " (cap: " + capacity
            + "), " + "Requires: A >= " + minSkills.getAgriculture() + ", M >= "
            + minSkills.getMedicine() + ", T >= " + minSkills.getTechnology());
        return s.toString();
    }


    @Override
    public int compareTo(Planet otherPlanet) {
        if (this.getAvailability() > otherPlanet.getAvailability()) {
            return 1;
        }
        else if (this.getAvailability() == otherPlanet.getAvailability()) {
            return 0;
        }
        else {
            return -1;
        }

    }


    /**
     * Checks to see if this planet is equal to another planet
     * 
     * @param other
     *            Object
     * @return boolean
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass() == other.getClass()) {
            Planet otherPlanet = (Planet)other;
            if (this.getName().equals(otherPlanet.getName()) && (this
                .getSkills().getAgriculture() == otherPlanet.getSkills()
                    .getAgriculture()) && (this.getSkills()
                        .getMedicine() == otherPlanet.getSkills().getMedicine())
                && (this.getSkills().getTechnology() == otherPlanet.getSkills()
                    .getTechnology()) && this.getCapacity() == otherPlanet
                        .getCapacity() && this
                            .getPopulationSize() == otherPlanet
                                .getPopulationSize()) {
                return true;
            }
        }

        return false;
    }

}
