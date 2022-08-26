// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Akhil Kamalesh (akhilk24)
package spacecolonies;

import student.TestCase;

/**
 * PlanetTest extends TestCase and this class tests the methods in Planet to
 * make sure they work as intended
 * 
 * @author akhilkamalesh
 * @version 11/07/2020
 *
 */
public class PlanetTest extends TestCase {

    private Planet planet;
    private Planet planet1;

    /**
     * Creating a new planet object
     */
    public void setUp() {
        planet = new Planet("Asgard", 3, 3, 3, 10);
        planet1 = new Planet("Earth", 3, 3, 3, 1);

    }


    /**
     * tests the getName method
     */
    public void testGetName() {
        assertEquals("Asgard", planet.getName());
    }


    /**
     * tests the getSkills method
     */
    public void testGetSkills() {
        assertEquals("A:3 M:3 T:3", planet.getSkills().toString());
    }


    /**
     * tests the getPopulation methods
     */
    public void testGetPopulation() {
        Person person = new Person("Akhil", 4, 4, 4, "Earth");
        assertTrue(planet.addPerson(person));
        Person[] pop = { person };
        assertEquals(pop[0], planet.getPopulation()[0]);

    }


    /**
     * tests the getCapacity method
     */
    public void testGetCapacity() {
        assertEquals(10, planet.getCapacity());
    }


    /**
     * tests the getAvailibility method
     */
    public void testGetAvailability() {
        Person person = new Person("Akhil", 5, 5, 5, "Asgard");
        planet.addPerson(person);
        assertEquals(9, planet.getAvailability());
    }


    /**
     * tests the isFull method
     */
    public void testIsFull() {
        assertFalse(planet.isFull());
        Person person = new Person("Akhil", 5, 5, 5, "Asgard");
        planet1.addPerson(person);
        assertTrue(planet1.isFull());
    }


    /**
     * tests the addPerson method
     */
    public void testAddPerson() {
        Person person = new Person("Akhil", 5, 5, 5, "Asgard");
        Person person1 = new Person("Thor", 1, 1, 1, "Asgard");
        Person person2 = new Person("Thanos", 4, 4, 4, "Titan");
        assertTrue(planet.addPerson(person));
        assertFalse(planet1.addPerson(person1));
        assertTrue(planet1.addPerson(person));
        assertFalse(planet1.addPerson(person2));
        assertEquals(1, planet.getPopulationSize());
    }


    /**
     * tests the isQualified method
     */
    public void testIsQualified() {
        Person person = new Person("Akhil", 3, 3, 3, "Asgard");
        assertTrue(planet.isQualified(person));

    }


    /**
     * test the toString method
     */
    public void testToString() {
        assertEquals(
            "Asgard, population 0 (cap: 10), Requires: A >= 3, M >= 3, T >= 3",
            planet.toString());
    }


    /**
     * test the compareTo method
     */
    public void testCompareTo() {
        Planet planet2 = new Planet("Titan", 2, 2, 2, 10);
        assertEquals(0, planet.compareTo(planet2));
        assertEquals(1, planet.compareTo(planet1));
        Person person = new Person("Akhil", 5, 5, 5, "Asgard");
        planet.addPerson(person);
        assertEquals(-1, planet.compareTo(planet2));
    }


    /**
     * test the equals method
     */
    public void testEquals() {
        Planet nullPlanet = null;
        String str = "";
        Planet planet2 = new Planet("Titan", 2, 2, 2, 10);
        Planet equal = new Planet("Asgard", 3, 3, 3, 10);
        Planet varied1 = new Planet("Asgard", 2, 2, 4, 10);
        Planet varied2 = new Planet("Asgard", 2, 4, 2, 10);
        assertFalse(planet.equals(nullPlanet));
        assertFalse(planet.equals(str));
        assertTrue(planet.equals(planet));
        assertFalse(planet.equals(planet2));
        assertTrue(planet.equals(equal));
        assertFalse(planet.equals(varied1));
        assertFalse(planet.equals(varied2));
        assertFalse(planet.equals(varied2));

    }

}
