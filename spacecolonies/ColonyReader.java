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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import bsh.ParseException;

/**
 * ColonyReader class reads the input of the text files passed to it and begins
 * the SpaceWindow
 * 
 * @author akhilkamalesh
 * @version 11/09/2020
 *
 */
public class ColonyReader {

    /**
     * Private variables used to create the ColonyReader object
     */
    private Planet[] planets;
    private ArrayQueue<Person> queue;

    /**
     * Constructor for the ColonyReader class
     * 
     * @param applicantFileName
     *            String file of applicants
     * @param planetFileName
     *            String file of plants
     * @throws SpaceColonyDataException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public ColonyReader(String applicantFileName, String planetFileName)
        throws FileNotFoundException,
        SpaceColonyDataException,
        ParseException {

        queue = readQueueFile(applicantFileName);
        planets = readPlanetFile(planetFileName);
        ColonyCalculator cc = new ColonyCalculator(queue, planets);
        SpaceWindow spaceWindow = new SpaceWindow(cc);
    }


    /**
     * readPlanetFile reads the planet file and grabs the first three planets
     * from the text file passed
     * 
     * @param fileName
     *            String text file passed into readPlanetFile
     * @return local Planet[]
     * @throws FileNotFoundException
     * @throws ParseException
     * @throws SpaceColonyDataException
     */
    private Planet[] readPlanetFile(String fileName)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {
        Planet[] local = new Planet[4];
        Scanner scanner = new Scanner(new File(fileName));
        int iter = 1;
        while (scanner.hasNextLine() && iter < 4) {
            String fileLine = scanner.nextLine();
            String[] chop = fileLine.split(", *");
            if (chop.length != 5) {
                throw new ParseException();
            }
            else if (isInSkillRange(Integer.parseInt(chop[1]), Integer.parseInt(
                chop[2]), Integer.parseInt(chop[3]))) {
                local[iter] = new Planet(chop[0], Integer.parseInt(chop[1]),
                    Integer.parseInt(chop[2]), Integer.parseInt(chop[3]),
                    Integer.parseInt(chop[4]));
                iter++;
            }
            else {
                throw new SpaceColonyDataException("Not in skill range");
            }

        }

        scanner.close();
        if (iter < 3)

        {
            throw new SpaceColonyDataException("Less than 3 planets");
        }

        return local;

    }


    /**
     * readQueueFile reads the applicant queue file
     * 
     * @param fileName
     *            String text file passed into readQueueFile
     * @return local ArrayQueue<Person>
     * @throws FileNotFoundException
     * @throws SpaceColonyDataException
     */
    private ArrayQueue<Person> readQueueFile(String fileName)
        throws FileNotFoundException,
        SpaceColonyDataException,
        ParseException {

        Scanner scanner = new Scanner(new File(fileName));
        ArrayQueue<Person> peopleQueue = new ArrayQueue<Person>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] chop = line.split(", *");

            String end = "";

            if (chop.length > 4) {
                end = chop[4];

            }
            if (!isInSkillRange(Integer.parseInt(chop[1]), Integer.parseInt(
                chop[2]), Integer.parseInt(chop[3]))) {

                throw new SpaceColonyDataException("Not in skill range");

            }
            else {
                peopleQueue.enqueue(new Person(chop[0], Integer.parseInt(
                    chop[1]), Integer.parseInt(chop[2]), Integer.parseInt(
                        chop[3]), end));

            }

        }

        return peopleQueue;
    }


    /**
     * Checks to see if the skill values are in between the minimum and maximum
     * skill levels
     * 
     * @param num1
     *            int Agriculture skill
     * @param num2
     *            int Medicine skill
     * @param num3
     *            int Technology skill
     * @return boolean
     */
    private boolean isInSkillRange(int num1, int num2, int num3) {
        if (num1 <= ColonyCalculator.MAX_SKILL_LEVEL
            && num1 >= ColonyCalculator.MIN_SKILL_LEVEL) {
            if (num2 <= ColonyCalculator.MAX_SKILL_LEVEL
                && num2 >= ColonyCalculator.MIN_SKILL_LEVEL) {
                if (num3 <= ColonyCalculator.MAX_SKILL_LEVEL
                    && num3 >= ColonyCalculator.MIN_SKILL_LEVEL) {
                    return true;

                }
            }
        }

        return false;
    }

}
