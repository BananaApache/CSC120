
package week8;
// importing Scanner class from java.util package
import java.util.Scanner;

// start of StringReader class
public class StringReader {

    // start of main method
    public static void main(String[] args) {

        // declaring finalString and inputString variables
        StringBuilder finalString;
        String inputString;
        finalString = new StringBuilder();

        // creating a Scanner object
        Scanner keyboard = new Scanner(System.in);

        // printing first input statement
        System.out.println("Please enter sentences, . to end.");

        // prompting the user to enter a string while the input string is not "."
        do {
            // reading the input string
            inputString = keyboard.nextLine();
            // if the input string starts with "I am"
            if (inputString.startsWith("I am")) {
                // append the input string to finalString with a comma
                finalString.append( inputString.substring(5) ).append( ", " );
            }
        } while ( !inputString.equals(".") );

        // printing the final string and replacing the last comma with period
        System.out.println("The qualities of everyone are " + finalString.substring(0, finalString.length() - 2) + ".");

    } // end of main method

} // end of StringReader class
