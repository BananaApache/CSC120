
package project2;

// importing java libraries
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**

 * Project 2
 * ForestrySimulation
 * @author Daniel Li

 */
public class ForestrySimulation {


    // some constants
    private static final Scanner keyboard = new Scanner(System.in);
    private static final String LOCAL_PATH = "/Users/daniel/Documents/coding_stuff/CSC120_SPRING2024/src/project2/";

    // Main method
    public static void main(String[] args) {

        char option = 0;
        String input;
        int fileIndex;
        String forestName;
        int treeNumber = 0;
        int reapHeight = 0;
        boolean isInputValid;

        System.out.println("\nWelcome to the Forestry Simulation");
        System.out.println("----------------------------------");
        System.out.println();

        // loop through the argument that should be file names
        for (fileIndex = 0; fileIndex < args.length; fileIndex++) {

            System.out.println("Initializing from " + args[fileIndex]);
            System.out.println();
            Forest forest = new Forest(args[fileIndex], ReadFile(args[fileIndex]));

            // keep taking inputs until user enters 'N' (stands for next) or 'X'
            do {

                // if the forest is empty, break
                if (forest == null || forest.trees.isEmpty()) {
                    break;
                }

                System.out.print("(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : ");
                input = keyboard.next();
                option = input.charAt(0);

                //! IDIOT PROOFING: making sure input is only one character
                if (input.length() == 1) {
                    // switch statement for the list of menu options
                    switch (Character.toUpperCase(option)) {
                        case 'P':
                            // print the forest
                            forest.print(forest);
                            break;
                        case 'A':
                            // add a tree
                            forest = forest.addTree(forest);
                            System.out.println("\n");
                            break;
                        case 'C':
                            // cut down a tree
                            //! IDIOT PROOFING: making sure input is an integer
                            isInputValid = false;
                            do {
                                try {
                                    System.out.print("\nTree number to cut down: ");
                                    treeNumber = keyboard.nextInt();
                                    isInputValid = true;
                                }
                                catch (Exception e) {
                                    System.out.println("That is not an integer. Try again");
                                    keyboard.next();
                                }
                            } while (!isInputValid);
                            forest = forest.cutTree(forest, treeNumber);
                            System.out.println();
                            break;
                        case 'G':
                            // grow trees
                            System.out.println("\nGrowing trees!");
                            forest = forest.growTrees(forest);
                            System.out.println();
                            break;
                        case 'R':
                            // reap trees
                            //! IDIOT PROOFING: making sure input is an integer
                            isInputValid = false;
                            do {
                                try {
                                    System.out.print("\nHeight to reap from: ");
                                    reapHeight = keyboard.nextInt();
                                    isInputValid = true;
                                }
                                catch (Exception e) {
                                    System.out.println("That is not an integer. Try again");
                                    keyboard.next();
                                }
                            } while (!isInputValid);
                            System.out.println();
                            forest = forest.reapTrees(forest, reapHeight);
                            break;
                        case 'S':
                            // save the forest as a .db file
                            System.out.println("\nSaving file...");
                            SaveFile(forest, forest.name);
                            System.out.println();
                            break;
                        case 'L':
                            // load the forest from a .db file
                            System.out.print("Enter forest name: ");
                            forestName = keyboard.next();
                            System.out.println("\nLoading file...");
                            if (LoadFile(forestName) != null) {
                                forest = LoadFile(forestName);
                                System.out.println("File successfully loaded\n");
                            }
                            break;
                        case 'N':
                            // move on to the next forest
                            if (fileIndex != args.length - 1) {
                                System.out.println("\nMoving to the next forest");
                            } else {
                                System.out.println("\nNo more forests to process");
                            }
                            break;
                        case 'X':
                            // exit the program
                            System.out.println("\nExiting the Forestry Simulation");
                            break;
                        default:
                            // invalid option
                            System.out.println("\nInvalid menu option, try again\n");
                    }
                }
                else {
                    System.out.println("\nInvalid menu option, try again\n");
                }
            }
            while (Character.toUpperCase(option) != 'N' && Character.toUpperCase(option) != 'X');

            // stop the program if user enters 'X'
            if (Character.toUpperCase(option) == 'X') {
                break;
            }

        }

    } // End of main method


    /*
        * ReadFile method
        * reads from a csv file and returns an ArrayList of Tree objects
        * @param filename file to be read from
        * @return ArrayList<Tree> forest full of trees
     */
    public static ArrayList<Tree> ReadFile(String filename) {

        // initializing variables
        String[] treeData;
        ArrayList<Tree> trees = new ArrayList<>();

        // try opening the forest file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(LOCAL_PATH + filename + ".csv"))) {
            String line = bufferedReader.readLine();
            // read the file line by line
            while (line != null) {
                // add the line to the list
                // I don't think Geoff taught us this, but I already knew Python and knew about the split method for Strings
                treeData = line.split(",");

                // example tree
                // Maple,2012,80,10.3
                // public Tree(String species, int yearOfPlanting, double height, double growthRate)

                trees.add(new Tree(
                                treeData[0], // species
                                Integer.parseInt(treeData[1]), // yearOfPlanting
                                Double.parseDouble(treeData[2]), // height
                                Double.parseDouble(treeData[3]) // growthRate
                ));
                line = bufferedReader.readLine();
            }
            return trees;
        }
        // catch exceptions
        catch (Exception e) {
            System.out.println("Error opening/reading : " + filename + ".csv");
        }
        return new ArrayList<>();
    }


    /*
        * SaveFile method
        * saves the forest to a file
        * @param forest the forest to be saved
        * @param forestName name of the forest
     */
    public static void SaveFile(Forest forest, String forestName) {

        // try to write the file
        try (FileOutputStream fileOut = new FileOutputStream(LOCAL_PATH + forestName + ".db");
             // write the object to file
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(forest);
            System.out.println("File successfully saved!");
        } catch (IOException e) {
            System.out.println("Error writing file: " + forestName + ".db");
        }

    }


    /*
        * LoadFile method
        * loads the forest from a file
        * @param forestName name of the forest
        * @return Forest the forest loaded from the file
     */
    public static Forest LoadFile(String forestName) {

        ObjectInputStream fromStream = null;
        Forest forest;

        // try to read the file
        try {
            fromStream = new ObjectInputStream(new FileInputStream(LOCAL_PATH + forestName + ".db"));
            // reads the file into an object
            forest = (Forest) fromStream.readObject();
            System.out.println();
            return forest;
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading file: " + forestName + ".db");
            System.out.println("Old forest retained\n");
        }
        finally {
            // close the file
            try {
                if (fromStream != null) {
                    fromStream.close();
                }
            }
            catch (IOException e) {
                System.out.println("Error closing file: " + forestName + ".db");
            }
        }
        return null;

    }


} // End of ForestrySimulation class
