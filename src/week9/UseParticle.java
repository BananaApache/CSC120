
package week9;
import java.util.Scanner;

// start of class
public class UseParticle {

    // declaring global variables
    private static final Scanner keyboard = new Scanner(System.in);

    // main method
    public static void main(String[] args) {

        // declaring local variables
        System.out.print("Enter the identification tag for the particle: ");
        int identification_tag = keyboard.nextInt();

        // creating a new particle object
        Particle particle = new Particle( identification_tag );
        System.out.println(particle);

        // declaring local variables
        double movement_x, movement_y;

        // do-while loop to keep asking for movement until the user enters 0.0 for both x and y
        do {

            System.out.print("Enter movement: ");
            movement_x = keyboard.nextDouble();
            movement_y = keyboard.nextDouble();

            particle.moveParticle(movement_x, movement_y);

            System.out.println(particle);

        } while ( movement_x != 0.0 && movement_y != 0.0 );


    } // end of main method

} // end of class
