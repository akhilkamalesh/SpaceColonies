// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Akhil Kamalesh (akhilk24)

package spacecolonies;

import list.AList;

/**
 * ColonyCalculator class determines which planet is habitable for a person
 * based on their skill levels and if the planet is full or not
 * 
 * @author akhilkamalesh
 * @version 11/10/2020
 */
public class ColonyCalculator {

    /**
     * The number of planets
     */
    public static final int NUM_PLANETS = 3;
    /**
     * The minimum skill level
     */
    public static final int MIN_SKILL_LEVEL = 1;
    /**
     * The maximum skill level
     */
    public static final int MAX_SKILL_LEVEL = 5;

    /**
     * private variables used to create a ColonyCalculator object
     */
    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private static Planet[] planets = new Planet[NUM_PLANETS + 1];

    /**
     * Constructor for the ColonyCalculator Class
     * 
     * @param a
     *            ArrayQueue<Person> people in the arrayqueue
     * @param p
     *            Planet[] planets in the planet array
     */
    @SuppressWarnings("static-access")
    public ColonyCalculator(ArrayQueue<Person> a, Planet[] p) {
        if (a == null) {
            throw new IllegalArgumentException("ArrayQueue is null");
        }
        else {
            this.applicantQueue = a;
            this.planets = p;
            rejectBus = new AList<Person>();
        }
    }


    /**
     * getQueue method gets the applicantQueue of the ColonyCalculator class
     * 
     * @return applicantQueue ArrayQueue<Person>
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;
    }


    /**
     * getPlanets method gets the planets used in the ColonyCalculator class
     * 
     * @return planet Planet[]
     */
    public static Planet[] getPlanets() {
        return planets;
    }


    /**
     * getPlanetForPerson method gets the planet that is preferred or most
     * available for a person
     * 
     * @param nextPerson
     *            Person the next person to be added
     * @return pref Planet
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        if (nextPerson != null) {
            int index = getPlanetIndex(nextPerson.getPlanetName());
            if (index != 0) {
                return getPreferredPlanet(nextPerson, index);
            }
            else {
                return getMostAvailablePlanet(nextPerson);

            }
        }

        return null;

    }


    /**
     * getPreferredPlanet gets the preferred planet for a person; this is a
     * helper method for getPlanetForPerson
     * 
     * @param p
     *            Person
     * @return Planet
     */
    private Planet getPreferredPlanet(Person p, int index) {
        if (!planets[index].isFull() && planets[index].isQualified(p)) {
            return planets[index];

        }
        return null;

    }


    /**
     * getMostAvailiblePlanet the most available planet for a person; this is a
     * helper method for getPlanetForPerson
     * 
     * @param nextPerson
     *            Person
     * @return planet
     */
    private Planet getMostAvailablePlanet(Person nextPerson) {
        Planet hold = null;
        int avail = 0;
        for (int i = 1; i < planets.length; i++) {
            if (planets[i].isQualified(nextPerson) && planets[i]
                .getAvailability() >= avail && planets[i].getCapacity() > 0) {
                hold = planets[i];
                avail = planets[i].getAvailability();
            }
        }

        return hold;
    }


    /**
     * accept method accepts the person for their preferred planet
     * 
     * @return Boolean
     */
    public boolean accept() {
        if (!applicantQueue.isEmpty()) {
            Person person = applicantQueue.getFront();
            Planet selection = getPlanetForPerson(person);
            if (selection != null) {
                selection.addPerson(person);
                applicantQueue.dequeue();
                return true;
            }
        }
        return false;
    }


    /**
     * reject method rejects applicants and sends them into rejectBus
     */
    public void reject() {
        Person person = applicantQueue.dequeue();
        rejectBus.add(person);
    }


    /**
     * planetByNumber returns the planet object for the given numbers 1, 2, 3
     * 
     * @param planet
     *            int
     * @return Planet
     */
    public Planet planetByNumber(int planet) {
        if (planet == 1) {
            return planets[1];
        }
        else if (planet == 2) {
            return planets[2];
        }
        else if (planet == 3) {
            return planets[3];
        }
        return null;
    }


    /**
     * getPlanetIndex gets the planet index given a String of planet
     * 
     * @param planet
     *            String
     * @return int
     */
    public int getPlanetIndex(String planet) {
        for (int i = 1; i < planets.length; i++) {
            if (planets[i].getName().equals(planet)) {
                return i;
            }
        }

        return 0;
    }

}
