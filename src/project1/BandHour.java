
package project1;

// importing my favorite class that takes in user input
import java.util.Scanner;

/**

    * Project 1
    * @author Daniel Li

 */

public class BandHour {

    // declaring global constant variables
    private static final Scanner keyboard = new Scanner(System.in);
    private static final double MAX_WEIGHT_PER_POSITION = 100.0;

    // start of main method
    public static void main(String[] args) {

        // printing out title
        System.out.print("\nPROJECT 1 - CSC 120 - DANIEL LI\n\n");
        System.out.println("Welcome to the Band of the Hour");
        System.out.println("-------------------------------");

        // declaring variables
        double[][] rows = createRows();
        char input_option;

        // do while loop to take in commands
        do {

            // prints out menu
            System.out.print("\n(A)dd, (R)emove, (P)rint, e(X)it: ");
            input_option = Character.toUpperCase(keyboard.next().charAt(0));

            //! IDIOT PROOFING: makes sure the option is available
            while ( input_option != 'A' && input_option != 'R' && input_option != 'P' && input_option != 'X') {
                System.out.print("ERROR: Invalid option, try again.\n(A)dd, (R)emove, (P)rint, e(X)it: ");
                input_option = Character.toUpperCase(keyboard.next().charAt(0));
            }

            // switch case
            switch (input_option) {
                case 'A':
                    addMusician(rows);
                    break;
                case 'R':
                    removeMusician(rows);
                    break;
                case 'P':
                    printRows(rows);
                    break;
            }

        } while (input_option != 'X');


    } // end of main method


    // start of createRows method
    /**
     * method that creates rows from user inputs
     * @return rows 2D array with
    */
    public static double[][] createRows() {

        // declaring all variables here
        int number_of_rows, index, number_of_positions, count;
        double[][] rows;

        // first declaration of row input
        System.out.print("Please enter number of rows: ");
        number_of_rows = keyboard.nextInt();

        //! IDIOT PROOFING: do while loop to check if number of rows is still less than 10
        do {

            // making sure number of rows is less than 10 and positive
            if (number_of_rows > 10 || number_of_rows < 0) {
                // will take in user input again
                System.out.print("ERROR: Out of range, try again: ");
                number_of_rows = keyboard.nextInt();
            }

        } while (number_of_rows > 10 || number_of_rows < 0);

        // setting 2d array to a user inputted rows
        rows = new double[number_of_rows][];

        // loop to add positions in row 'x' in an array
        count = 0;
        for (index = (int) 'A'; index < number_of_rows + (int) 'A'; index ++) {

            // takes in user input for row positions
            System.out.print("Please enter number of positions in row " + (char) index + ": ");

                number_of_positions = keyboard.nextInt();

                //! IDIOT PROOFING: making sure the number of position is less than 8 and also positive
                do {
                    if (number_of_positions < 0 || number_of_positions > 8) {
                        System.out.print("ERROR: Out of range, try again: ");
                        number_of_positions = keyboard.nextInt();
                    }
                } while (number_of_positions < 0 || number_of_positions > 8);

                // setting 2d array columns for each row
                rows[count] = new double[number_of_positions];
                count += 1;

        }

        // returning the 2d array filled with 0.0s
        return rows;

    } // end of createRows method


    // start of addMusician method
    /**
     * Method to add a musician based on user input
     * @param rows Takes in a 2d array of musicians
    */
    public static void addMusician(double[][] rows) {

        // declaring variables
        int row_position, input_position, input_weight, index;
        double sum;
        char row_letter;
        boolean isVacant;

        // takes in row letter
        System.out.print("Please enter row letter: ");
        row_letter = Character.toUpperCase(keyboard.next().charAt(0));

        //! IDIOT PROOFING: making sure row letter is in the array
        while ( (int) row_letter - (int) 'A' > rows.length - 1 || Character.isDigit(row_letter) ) {

            System.out.print("ERROR: Out of range, try again: ");
            row_letter = Character.toUpperCase(keyboard.next().charAt(0));

        }

        // converting row letter to integer
        row_position = (int) row_letter - (int) 'A';

        // takes in row position
        System.out.print("Please enter position number (1 to " + rows[row_position].length + "): ");
        input_position = keyboard.nextInt();

        //! IDIOT PROOFING: making sure row position is less than row length and is positive
        while ( input_position > rows[row_position].length || input_position <= 0) {

            System.out.print("ERROR: Out of range, try again: ");
            input_position = keyboard.nextInt();

        }

        // checking if there's already a musician in that position
        if ( rows[row_position][input_position - 1] != 0.0 ) {
            System.out.println("ERROR: There is already a musician there.");
            // sets isVacant to false
            isVacant = false;
        }
        else {
            isVacant = true;
        }

        // checks if the spot is vacant or not
        if (isVacant) {
            // takes in weight input
            System.out.print("Please enter weight (45.0 to 200.0): ");
            input_weight = keyboard.nextInt();

            //! IDIOT PROOFING: makes sure weight is between 45 and 200
            while (! (45 <= input_weight && input_weight <= 200) ) {
                System.out.print("ERROR: Out of range, try again: ");
                input_weight = keyboard.nextInt();
            }

            // for loop to calculate sum of musician weights
            sum = 0;
            for (index = 0; index < rows[row_position].length; index += 1) {
                sum += rows[row_position][index];
            }

            // makes sure that the input is not exceeding weight limit
            if ( sum + input_weight >= rows[row_position].length * MAX_WEIGHT_PER_POSITION) {
                System.out.println("ERROR: That would exceed the average weight limit.");
            }
            // adds musician to specified position
            else {
                rows[row_position][input_position - 1] = (float) input_weight;
                System.out.println("****** Musician added.");
            }
        }

    } // end of addMusician method


    // start of removeMusician method
    /**
     * Method to remove a musician's weight from a 2d array
     * @param rows Takes in a 2d array filled with musicians weights
    */
    public static void removeMusician(double[][] rows) {

        // declaring variables
        int row_position, input_position;
        char row_letter;

        // takes in row letter
        System.out.print("Please enter row letter: ");
        row_letter = Character.toUpperCase(keyboard.next().charAt(0));

        //! IDIOT PROOFING: makes sure the letter is in the array
        while ( (int) row_letter - (int) 'A' > rows.length ) {

            System.out.print("ERROR: Out of range, try again: ");
            row_letter = Character.toUpperCase(keyboard.next().charAt(0));

        }

        // converts the letter to an integer
        row_position = (int) row_letter - (int) 'A';

        // takes in row position
        System.out.print("Please enter position number (1 to " + rows[row_position].length + "): ");
        input_position = keyboard.nextInt();

        //! IDIOT PROOFING: makes sure row position is less than the length and also is positive
        while ( input_position > rows[row_position].length || input_position <= 0 ) {

            System.out.print("ERROR: Out of range, try again: ");
            input_position = keyboard.nextInt();

        }

        // does not allow removing of an empty space
        if ( rows[row_position][input_position - 1] == 0.0 ) {
            System.out.println("ERROR: That position is vacant.");
        }
        // removes musician from specified position
        else {
            rows[row_position][input_position - 1] = 0.0;
            System.out.println("****** Musician removed.");
        }

    } // end of removeMusician method


    // start of printRows method
    /**
     * @param rows Takes in a 2d array filled with musicians' weights
    */
    public static void printRows(double[][] rows) {

        // declaring variables
        int row, column;
        double sum;
        char row_letter;

        // loops through the rows
        for (row = 0; row < rows.length; row++) {
            sum = 0;

            // sets row letter to the integer version of a letter
            row_letter = (char) ( (int) 'A' + row );

            System.out.print( row_letter + ": " );

            // loops through the column
            for (column = 0; column < rows[row].length; column++) {
                // adds the weight at specified row and column and adds it to sum
                sum += rows[row][column];
                System.out.print(rows[row][column] + " ");
            }
            // prints out sum and average
            System.out.print(" SUM: " + sum + ", AVERAGE: ");
            System.out.printf("%.1f\n", ( sum / rows[row].length ));
        }

        System.out.println();

    } // end of printRows method


} // end of BandHour class

