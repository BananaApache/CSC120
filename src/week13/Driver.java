
package week13;
import java.util.Scanner;


// Driver class
public class Driver {

    // initialize
    private static final Scanner keyboard = new Scanner(System.in);
    private static Girl girl;
    private static Diamond diamond;


    // main method
    public static void main(String[] args) {

        // variables
        String name;
        int carats;
        double dollarValue;

        // input
        System.out.print("\nEnter the name of the girl : ");
        name = keyboard.next();
        System.out.println("Marilyn has no best friend");

        // first input
        System.out.print("Enter carats and value     : ");
        carats = keyboard.nextInt();
        dollarValue = keyboard.nextDouble();
        diamond = new Diamond(carats, dollarValue);
        girl = new Girl(name, diamond);
        System.out.println("Woohoo, the girl took the diamond");
        System.out.println(girl);

        // loop
        while (carats != 0 && dollarValue != 0) {
            System.out.print("\nEnter carats and value     : ");
            carats = keyboard.nextInt();
            dollarValue = keyboard.nextDouble();
            diamond = new Diamond(carats, dollarValue);
            if (girl.isDiamondBetter(diamond)) {
                girl = new Girl(name, diamond);
                System.out.println("\nWoohoo, the girl took the diamond");
                System.out.println(girl);
            } else if (carats != 0 && dollarValue != 0) {
                System.out.println("\nAaargh, the diamond was rejected");
                System.out.println(girl);
            }
        }

        System.out.println(girl);
    }

} // end of Driver class
