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

/**
 * SpaceColonyDataException extends Exception and it is a class that is used in
 * Colony Reader to throw and Exception
 * 
 * @author akhilkamalesh
 * @version 11/09/2020
 */
public class SpaceColonyDataException extends Exception {

    /**
     * Constructor for SpaceColonyDataException
     * 
     * @param s
     *            String String returned whenever the exception is thrown
     * 
     */
    public SpaceColonyDataException(String s) {
        super(s);
    }

}
