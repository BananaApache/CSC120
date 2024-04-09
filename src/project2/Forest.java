package project2;

// importing java libraries
import java.io.*;
import java.util.ArrayList;

// Forest class
public class Forest implements Serializable {


    // some constants
    public enum Species {MAPLE, FIR, BIRCH};

    public String name;
    public ArrayList<Tree> trees;

    private final int MAX_YEAR = 2024;

    private final int MIN_YEAR = 2000;
    private final double MIN_HEIGHT = 10.0;
    private final double MAX_HEIGHT = 20.0;
    private final double MIN_GROWTH_RATE = 10.0;
    private final double MAX_GROWTH_RATE = 20.0;


    // constructor method
    public Forest(String forestName, ArrayList<Tree> trees) {
        this.name = forestName;
        this.trees = trees;
    }


    // get average of trees
    public double getAverage() {
        double sum = 0;
        for (Tree tree : trees) {
            sum += tree.getHeight();
        }
        return sum / trees.size();
    }


    // print forest
    public void print(Forest forest) {
        int index;

        System.out.println("\nForest name: " + forest.name);
        for (index = 0; index < forest.trees.size(); index++) {
            System.out.println(index + " " + forest.trees.get(index));
        }
        System.out.printf("There are %d trees, with an average height of %.2f%n", forest.trees.size(), forest.getAverage());
        System.out.println();
    }


    // add randomly generated tree
    public Forest addTree(Forest forest) {
        // generate random parameters
        Species species = Species.values()[(int) (Math.random() * Species.values().length)];
        int yearOfPlanting = (int) (Math.random() * (MAX_YEAR - MIN_YEAR + 1) + MIN_YEAR);
        double height = (Math.random() * (MAX_HEIGHT - MIN_HEIGHT + 1) + MIN_HEIGHT);
        double growthRate = (Math.random() * (MAX_GROWTH_RATE - MIN_GROWTH_RATE + 1) + MIN_GROWTH_RATE);
        System.out.printf("\nAdded: %-10s %-5d %-10.1f %-10.1f", species, yearOfPlanting, height, growthRate);

        // adds tree to forest
        forest.trees.add(new Tree(species.toString(), yearOfPlanting, height, growthRate));
        return forest;

    }


    // cut tree at index
    public Forest cutTree(Forest forest, int treeNumber) {
        // check if tree exists
        if (treeNumber > forest.trees.size() - 1) {
            System.out.println("Tree number " + treeNumber + " does not exist");
        }
        // cut tree
        else {
            System.out.println("Cut down: " + forest.trees.get(treeNumber));
            forest.trees.remove(treeNumber);
        }
        return forest;
    }


    // grow trees
    public Forest growTrees(Forest forest) {
        // grow each tree
        for (Tree tree : forest.trees) {
            tree.grow();
        }
        return forest;
    }


    // reap trees
    public Forest reapTrees(Forest forest, int reapHeight) {
        int index;

        for (index = 0; index < forest.trees.size(); index++) {
            double treeHeight = forest.trees.get(index).getHeight();

            // reap only if tree is tall enough
            if (treeHeight >= reapHeight) {
                System.out.println("Reaping the tall tree:  " + forest.trees.get(index));

                Species species = Species.values()[(int) (Math.random() * Species.values().length)];
                int yearOfPlanting = (int) (Math.random() * (MAX_YEAR - MIN_YEAR + 1) + MIN_YEAR);
                double height = (Math.random() * (MAX_HEIGHT - MIN_HEIGHT + 1) + MIN_HEIGHT);
                double growthRate = (Math.random() * (MAX_GROWTH_RATE - MIN_GROWTH_RATE + 1) + MIN_GROWTH_RATE);

                forest.trees.set(index, new Tree(species.toString(), yearOfPlanting, height, growthRate));

                System.out.println("Replaced with new tree:  " + forest.trees.get(index) + "\n");
            }
        }
        return forest;
    }


} // end of Forest class
