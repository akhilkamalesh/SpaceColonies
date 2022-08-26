// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Akhil Kamalesh (akhilk24)

package spacecolonies;

/**
 * import statements
 */
import student.TestCase;

/**
 * ColonyCalculatorTest class extends TestCase and ColonyCalculatorTesttests the
 * method in ColonyCalculator to make sure they work as intended
 * 
 * @author akhilkamalesh
 * @version 11/09/2020
 *
 */
public class ColonyCalculatorTest extends TestCase {

    /**
     * private variables used to create a ColonyCalculator object
     */
    private ColonyCalculator cc;
    private Planet[] planets;
    private Planet first = new Planet("Titan", 4, 4, 4, 10);
    private Planet second = new Planet("Asgard", 3, 3, 3, 10);
    private Planet third = new Planet("Earth", 2, 2, 2, 10);
    private Person person;
    private Person dummy;
    private Person noSelection;

    /**
     * setUp() a ColonyCalculator object with three planets and one person in
     * the ArrayQueue<Person>
     */
    public void setUp() {
        planets = new Planet[4];
        planets[1] = first;
        planets[2] = second;
        planets[3] = third;

        ArrayQueue<Person> people = new ArrayQueue<Person>(1);
        person = new Person("Akhil", 4, 4, 4, "Asgard");
        dummy = new Person("dummy", 2, 2, 2, "Asgard");
        noSelection = new Person("Thanos", 4, 4, 4, "");
        people.enqueue(person);
        cc = new ColonyCalculator(people, planets);
        
        
        cc = new ColonyCalculator(people, planets);

    }


    /**
     * Test the getQueue method
     */
    public void testGetQueue() {
        assertEquals("[Akhil A:4 M:4 T:4 Wants: Asgard]", cc.getQueue()
            .toString());

        ArrayQueue<Person> nullPeople = null;
        Exception exception = null;
        try {
            ColonyCalculator cc1 = new ColonyCalculator(nullPeople, planets);
            cc1.getQueue();
        }
        catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
    }


    /**
     * Test the getPlanets method
     */
    public void testGetPlanets() {
        assertEquals(
            "Titan, population 0 (cap: 10), Requires: A >= 4, M >= 4, T >= 4",
            ColonyCalculator.getPlanets()[1].toString());
    }


    /**
     * Test the getPlanetForPerson method
     */
    public void testGetPlanetForPerson() {
        assertEquals(planets[2], cc.getPlanetForPerson(person));
        assertEquals(null, cc.getPlanetForPerson(dummy));
        assertEquals(planets[3], cc.getPlanetForPerson(noSelection));
        Person personNull = null;
        assertEquals(null, cc.getPlanetForPerson(personNull));
    }


    /**
     * Test the accept method
     */
    public void testAccept() {
        assertTrue(cc.accept());
        ArrayQueue<Person> empty = new ArrayQueue<Person>(0);
        ColonyCalculator cc1 = new ColonyCalculator(empty, planets);
        assertFalse(cc1.accept());

        ArrayQueue<Person> people3 = new ArrayQueue<Person>(1);
        Person person3 = new Person("Thor", 1, 1, 1, "");
        people3.enqueue(person3);
        ColonyCalculator cc2 = new ColonyCalculator(people3, planets);
        cc2.getPlanetForPerson(person3);
        assertFalse(cc2.accept());
    }


    /**
     * Test the reject method
     */
    public void testReject() {
        cc.reject();
        assertEquals(0, cc.getQueue().getSize());
    }


    /**
     * Test the planetByNumber method
     */
    public void testPlanetByNumber() {
        assertEquals(
            "Titan, population 0 (cap: 10), Requires: A >= 4, M >= 4, T >= 4",
            cc.planetByNumber(1).toString());
        assertEquals(
            "Asgard, population 0 (cap: 10), Requires: A >= 3, M >= 3, T >= 3",
            cc.planetByNumber(2).toString());
        assertEquals(
            "Earth, population 0 (cap: 10), Requires: A >= 2, M >= 2, T >= 2",
            cc.planetByNumber(3).toString());
        assertEquals(null, cc.planetByNumber(0));
    }


    /**
     * Test the getPlanetIndex method
     */
    public void testGetPlanetIndex() {
        assertEquals(1, cc.getPlanetIndex("Titan"));
        assertEquals(0, cc.getPlanetIndex("Knowwhere"));
    }


    /**
     * Test the ColonyReader class to test the SpaceColonyDataException
     */
    public void testColonyReader() {
        Exception exception = null;
        try {
            new ColonyReader("input.txt", "planetsEmpty.txt");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof SpaceColonyDataException);
        assertEquals(exception.getMessage(), "Not in skill range");
    }
}
