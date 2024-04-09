package project2;

// importing java libraries
import java.io.Serializable;

// Tree class
public class Tree implements Serializable {


    // some constants
    public enum Species {MAPLE, FIR, BIRCH};
    private Species species;
    private int yearOfPlanting;
    private double height;
    private double growthRate;


    // constructor method
    public Tree(String species, int yearOfPlanting, double height, double growthRate) {
        this.species = Species.valueOf(species.toUpperCase());
        this.yearOfPlanting = yearOfPlanting;
        this.height = height;
        this.growthRate = growthRate;
    }


    // get species
    public Species getSpecies() {
        return species;
    }


    // get yearOfPlanting
    public int getYearOfPlanting() {
        return yearOfPlanting;
    }


    // get height
    public double getHeight() {
        return height;
    }


    // get growthRate
    public double getGrowthRate() {
        return growthRate;
    }


    // grow method
    public void grow() {
        height += height * growthRate / 100;
    }


    // to string method
    public String toString() {
        return String.format("%-10s %-10d %-10.1f %s", species, yearOfPlanting, height, String.format("%.1f%%", growthRate));
    }


} // End of Tree class
