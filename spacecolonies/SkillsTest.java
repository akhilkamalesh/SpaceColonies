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
 * SkillsTest extends TestCase and SkillsTest tests the method in Skills class
 * to make sure they work as intended
 * 
 * @author akhilkamalesh
 * @version 11/09/2020
 */
public class SkillsTest extends TestCase {

    /**
     * private variable used to create a Skills object
     */
    private Skills skills;

    /**
     * setUp() method with one Skills object
     */
    public void setUp() {
        skills = new Skills(5, 4, 5);
    }


    /**
     * Test the getAgriculture method
     */
    public void testGetAgriculture() {
        assertEquals(5, skills.getAgriculture());
    }


    /**
     * Test the getMedicine method
     */
    public void testGetMedicine() {
        assertEquals(4, skills.getMedicine());
    }


    /**
     * Test the getTechnology method
     */
    public void testGetTechnology() {
        assertEquals(5, skills.getTechnology());
    }


    /**
     * Test the isBelow method
     */
    public void testIsBelow() {
        Skills skillTest = new Skills(2, 2, 2);
        assertFalse(skills.isBelow(skillTest));
        assertTrue(skillTest.isBelow(skills));
    }


    /**
     * Test the toString method
     */
    public void testToString() {
        assertEquals("A:5 M:4 T:5", skills.toString());
    }


    /**
     * Test the equals method
     */
    public void testEquals() {
        Skills skillNull = null;
        String str = "";
        Skills skillTest = new Skills(2, 2, 2);
        Skills equal = new Skills(5, 4, 5);
        Skills varied = new Skills(9, 2, 3);
        Skills varied1 = new Skills(2, 9, 3);
        Skills varied2 = new Skills(2, 3, 9);
        assertFalse(skills.equals(skillNull));
        assertFalse(skills.equals(str));
        assertTrue(skills.equals(skills));
        assertFalse(skills.equals(skillTest));
        assertTrue(skills.equals(equal));
        assertTrue(equal.equals(skills));
        assertFalse(skills.equals(varied));
        assertFalse(skills.equals(varied1));
        assertFalse(skills.equals(varied2));

    }

}
