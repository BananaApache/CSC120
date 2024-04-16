
package project2;

// importing java libraries
import java.io.Serializable;

// Tree class
public class Tree implements Serializable {


    // some constants
    public enum Species {MAPLE, FIR, BIRCH}
    private final Species species;
    private final int yearOfPlanting;
    private double height;
    private final double growthRate;


    // constructor method
    public Tree(String species, int yearOfPlanting, double height, double growthRate) {
        // get value from enum
        this.species = Species.valueOf(species.toUpperCase());
        this.yearOfPlanting = yearOfPlanting;
        this.height = height;
        this.growthRate = growthRate;
    }


    // get height
    public double getHeight() {
        return height;
    }


    // grow method
    public void grow() {
        height += height * growthRate / 100;
    }


    // to string method
    public String toString() {
        // prints it like:
        // MAPLE   2012   80.00'  10.3%
        return String.format("%-10s %-10d %-10.1f %s", species, yearOfPlanting, height, String.format("%.1f%%", growthRate));
    }


} // End of Tree class
