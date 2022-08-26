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
 * PersonTest extends TestCase and PersonTest tests the method in Person class
 * to make sure they work as intended
 * 
 * @author akhilkamalesh
 * @version 11/09/2020
 */
public class PersonTest extends TestCase {

    /**
     * private variable that are used to set up a Person object
     */
    private Person person;
    private Person person1;
    private Skills skills;

    /**
     * setUp() method with one person and one set of skills
     */
    public void setUp() {
        person = new Person("Akhil", 5, 4, 5, "Mars");
        person1 = new Person("Thor", 4, 4, 4, "");
        skills = new Skills(5, 4, 5);
    }


    /**
     * Test the getName method
     */
    public void testGetName() {
        assertEquals("Akhil", person.getName());
    }


    /**
     * Test the getSkills method
     */
    public void testGetSkills() {
        assertEquals(skills, person.getSkills());
    }


    /**
     * Test the getPlanetName method
     */
    public void testGetPlanetName() {
        assertEquals("Mars", person.getPlanetName());
    }


    /**
     * Test the toString method
     */
    public void testToString() {
        assertEquals("Akhil A:5 M:4 T:5 Wants: Mars", person.toString());
        assertEquals("No-Planet Thor A:4 M:4 T:4", person1.toString());
    }


    /**
     * Test the equals method
     */
    public void testEquals() {
        Person personNull = null;
        String str = "";
        Person equal = new Person("Akhil", 5, 4, 5, "Mars");
        assertFalse(person.equals(personNull));
        assertTrue(person.equals(person));
        assertFalse(person.equals(person1));
        assertFalse(person.equals(str));
        assertTrue(person.equals(equal));
    }

}
