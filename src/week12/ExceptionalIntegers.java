
package week12;
import java.util.ArrayList;

// ExceptionalIntegers class
public class ExceptionalIntegers {

    // Main method
    public static void main(String[] args) {
        // Declare variables
        int index;
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        // Process the command line arguments
        for (index = 0; index < args.length; index++) {
            // Convert the argument to an integer
            try {
                // Add the integer to the vector
                numbers.add(convertToInteger(args[index]));
                System.out.println("Converter method says integer OK - " + args[index]);
            }
            // Catch the exception if the argument is not an integer
            catch (NumberFormatException e) {
                System.out.println("Catch block says the argument \"" + args[index] + "\" is ignored because " + e.getMessage());
            }
        } // end of for loop

        // Display the contents of the vector
        System.out.println("\nVector contents are:");
        for (index = 0; index < numbers.size(); index++) {
            System.out.println("Item " + index + " is " + numbers.get(index));
        } // end of for loop

    } // end of main

    // Convert a string to an integer
    private static int convertToInteger(String arg) {
        return Integer.parseInt(arg);
    } // end of convertToInteger

} // end of ExceptionalIntegers class
