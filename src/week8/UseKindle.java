
package week8;
import java.util.Scanner;

// start of UseKindle class
public class UseKindle {

    // create a Scanner object
    private static final Scanner keyboard = new Scanner(System.in);

    // start of main method
    public static void main(String[] args) {

        // declare a KindleClass object and an int variable
        KindleClass aBook;
        int numberOfPages;

        // Get person information
        System.out.print("How many pages in the book : ");
        numberOfPages = keyboard.nextInt();

        // Create object
        aBook = new KindleClass(numberOfPages);
        System.out.print("Initially                  : ");
        System.out.println(aBook);

        // Do some reading
        aBook.turnPages();
        aBook.turnPages();
        aBook.turnPages();
        aBook.turnPages();
        System.out.print("A bit later                : ");
        System.out.println(aBook);

        // Skip ahead
        aBook.turnPages(27);
        System.out.print("After skipping 27 pages    : ");
        System.out.println(aBook);

        // Try skip past the end of the book
        aBook.turnPages(8);
    } // end of main method

} // end of UseKindle class
