
package week4;
import java.util.Scanner;

public class ScubaDiving {

    // assigning keyboard variable
    private static final Scanner keyboard = new Scanner(System.in);
    // constant variable
    private static final int FEET_PER_ATMOSPHERE = 33;

    // start of main method
    public static void main(String[] args) {

        System.out.println("WEEK 4 - LAB 3");

        // declaring variables
        int depth, oxygen_percentage;

        // getting input for 2 variables
        System.out.print("Enter depth and percentage O2: ");
        depth = keyboard.nextInt();
        oxygen_percentage = keyboard.nextInt();

        // declaring variables
        float ambient_pressure, partial_pressure;

        // compute partial pressure
        ambient_pressure = ((float) depth / FEET_PER_ATMOSPHERE) + 1;
        partial_pressure = ((float) oxygen_percentage / 100) * ambient_pressure;

        // get the char from method
        char oxygen_group = compute_oxygen_pressure_group(partial_pressure);
        System.out.println("O2 group: " + oxygen_group);

        // declaring variables
        boolean exceeds_max_oxygen, exceeds_max_contingency_oxygen;

        // comparing oxygen to the 2 maximums
        exceeds_max_oxygen = partial_pressure > 1.4;
        exceeds_max_contingency_oxygen = partial_pressure > 1.6;

        // printing output
        System.out.println("Ambient pressure: " + ambient_pressure);
        System.out.println("O2 pressure:  " + partial_pressure);
        System.out.println("Exceeds maximal O2 pressure: " + exceeds_max_oxygen);
        System.out.println("Exceeds contingency O2 pressure: " + exceeds_max_contingency_oxygen);


    } // end of main method

    // compute oxygen group method
    private static char compute_oxygen_pressure_group(float partial_pressure) {
        // assigning 65 to a variable
        int char_constant = (int) 'A';

        // returning character of the oxygen group
        return (char) ( ( (int) Math.floor(partial_pressure * 10) ) + 65);

    } // end of compute_oxygen_pressure_group method

} // end of ScubaDiving class
