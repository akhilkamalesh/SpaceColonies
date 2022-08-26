// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Akhil Kamalesh (akhilk24)

package spacecolonies;

/**
 * Skills class contains the grades for the skills that are specified for each
 * person
 * 
 * @author akhilkamalesh
 * @version 11/05/2020
 *
 */
public class Skills {

    /**
     * Scores of the skills that are used in the Skills class
     */
    private int agriculture;
    private int medicine;
    private int technology;

    /**
     * Constructor for the skills class
     * 
     * @param a
     *            score of the agriculture skill
     * @param m
     *            score of the medicine skill
     * @param t
     *            score of the technology skill
     */
    public Skills(int a, int m, int t) {
        this.agriculture = a;
        this.medicine = m;
        this.technology = t;
    }


    /**
     * Returns the agriculture score
     * 
     * @return agriculture int
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * Returns the medicine score
     * 
     * @return medicine int
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * Returns the technology score
     * 
     * @return technology int
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * Checks to see if these scores are lower than the other scores
     * returns true if they are, false if these scores are greater
     * 
     * @param other
     *            Skills
     * @return boolean
     */
    public boolean isBelow(Skills other) {
        return (this.agriculture <= other.agriculture
            && this.medicine <= other.medicine
            && this.technology <= other.technology);
    }


    /**
     * Checks to see if Two Skills object equal each other
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
            Skills otherSkills = (Skills)obj;
            if (this.getAgriculture() == otherSkills.getAgriculture() && this
                .getMedicine() == otherSkills.getMedicine() && this
                    .getTechnology() == otherSkills.getTechnology()) {
                return true;
            }

        }

        return false;
    }


    /**
     * toString method returns Skills as a String object
     * 
     * @return s String
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("A:" + this.getAgriculture() + " M:" + this.getMedicine()
            + " T:" + this.getTechnology());

        return s.toString();
    }

}
