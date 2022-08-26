// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Akhil Kamalesh (akhilk24)

package spacecolonies;

/**
 * Person class is used to create a Person object that will be used in the space
 * colonies
 * 
 * @author akhilkamalesh
 * @version 11/10/2020
 *
 */
public class Person {

    /**
     * Used in person class for identification
     */
    private String name;
    private Skills skills;
    private String planetPreference;

    /**
     * Constructor for person class
     * 
     * @param n
     *            String name for the person object
     * @param a
     *            int Agriculture Skills for the person object
     * @param m
     *            int Medicine Skills for the person object
     * @param t
     *            int Technology Skills for the person object
     * @param p
     *            String planetPreference for the person object
     */
    public Person(String n, int a, int m, int t, String p) {
        this.name = n;
        skills = new Skills(a, m, t);
        this.planetPreference = p;
    }


    /**
     * Returns the name of the person
     * 
     * @return name String
     */
    public String getName() {
        return name;
    }


    /**
     * Returns the skills of the person
     * 
     * @return skills Skills
     */
    public Skills getSkills() {
        return skills;
    }


    /**
     * Returns the planet preference of the person
     * 
     * @return planetPreference String
     */
    public String getPlanetName() {
        return planetPreference;
    }


    /**
     * Used to display the Person object
     * 
     * @return s String
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(name + " " + skills.toString());
        if (planetPreference.length() > 0) {
            s.append(" Wants: " + planetPreference);
        }
        else {
            return "No-Planet " + name + " " + skills.toString();
        }

        return s.toString();
    }


    /**
     * Used to see if this person object equals another object
     * 
     * @param obj
     *            Object
     * @return boolean
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (this.getClass() == obj.getClass()) {
            Person otherPerson = (Person)obj;
            if (this.getName().equals(otherPerson.getName()) && (this.skills
                .getAgriculture() == otherPerson.skills.getAgriculture())
                && (this.skills.getMedicine() == otherPerson.skills
                    .getMedicine()) && (this.skills
                        .getTechnology() == otherPerson.skills.getTechnology())
                && this.getPlanetName().equals(otherPerson.getPlanetName())) {
                return true;
            }
        }

        return false;
    }

}
