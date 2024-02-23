
//@ src/week3/LabTask3.java
//. Daniel Li
//. 01/29/2024

package week3;

//~ length of the side
//~ length of roads
//~ number of kangaroos

//~ kangaroo density = kangaroos per square kilometer
//~ road surface = 

// import java Scanner class
import java.util.Scanner;

public class LabTask3 {
    private static final Scanner keyboard = new Scanner(System.in);
    private static final double ROADKILL_PROBABILITY_CONSTANT = 1.47;
    private static final double AVERAGE_AUSTRALIAN_ROAD_WIDTH = 0.01;

    public static void main(String[] args) {

        // initializing 3 variables
        double lengthLand, lengthRoad;
        int numKangaroos;
        
        // get user input for length of the side, length of roads, number of kangaroos
        System.out.print("\nLength of a side (km): ");
        lengthLand = keyboard.nextDouble();
        System.out.print("Length of road (km): ");
        lengthRoad = keyboard.nextDouble();
        System.out.print("Number of kangaroos: ");
        numKangaroos = keyboard.nextInt();

        // initializing 2 variables
        double kangarooDensity, roadSurface;

        // declaring the 2 variables with the formulas
        kangarooDensity = numKangaroos / Math.pow(lengthLand, 2);
        roadSurface = AVERAGE_AUSTRALIAN_ROAD_WIDTH * lengthRoad;

        // initializing 2 variables
        int expectedKills, expectedInjuries;

        // declaring 2 variables
        expectedKills = (int) (kangarooDensity * roadSurface * ROADKILL_PROBABILITY_CONSTANT);
        expectedInjuries = (int) Math.ceil((kangarooDensity * roadSurface * ROADKILL_PROBABILITY_CONSTANT) % 1);

        System.out.println("\nExpected number of kills " + expectedKills);
        System.out.println("Expected number of injuries " + expectedInjuries);

    }

} // end of class KangarooKills class
