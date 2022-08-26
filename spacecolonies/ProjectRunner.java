// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Akhil Kamalesh (akhilk24)

package spacecolonies;

import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * Project Runner class runs the colonyReader class that creates a GUI from the
 * SpaceWindow class
 * 
 * @author akhilkamalesh
 * @version 11/10/2020
 */
public class ProjectRunner {

    /**
     * 
     * @param args
     *            String[] arguments used to be passed in ColonyReader
     * @throws FileNotFoundException
     * @throws ParseException
     * @throws SpaceCsolonyDataException
     */
    public static void main(String[] args)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {

        // System.out.println("Hi");
        if (args.length == 2) {
            ColonyReader colonyReader = new ColonyReader(args[0], args[1]);
        }
        else {
            ColonyReader colonyReader = new ColonyReader("input.txt",
                "planets.txt");
        }
    }

}
