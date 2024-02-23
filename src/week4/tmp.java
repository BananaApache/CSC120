
package week4;
import java.util.Scanner;

public class tmp {

    private static final Scanner keyboard = new Scanner(System.in);
    private static final int FEET_PER_ATMOSPHERE = 33;

    public static void main(String[] args) {

        System.out.printf("%-40s: ", "Enter depth and percentage O2");
        int depth = keyboard.nextInt();
        int oxygen_percentage = keyboard.nextInt();

        float ambient_pressure = ( (float) depth / FEET_PER_ATMOSPHERE) + 1;
        float partial_pressure = ( (float) oxygen_percentage / 100) * ambient_pressure;

        compareOxygen(partial_pressure);

        char oxygen_group = computeOxygenGroup(partial_pressure);

        System.out.printf("%-40s: %s\n", "O2 group", oxygen_group);

        // Poem by Henry David Thoreau
        System.out.print("My life has been the poem ");  // A
        System.out.println("I would have writ");         // B
        System.out.println("But I could not ");            // C
        System.out.flush();
        System.out.print("both live and utter it.\n");


    } // end of main method

    private static void compareOxygen(float partial_pressure) {
        boolean exceeds_maximum_oxygen = partial_pressure > 1.4;
        boolean exceeds_maximum_contingency_oxygen = partial_pressure > 1.6;

        System.out.printf("%-40s: %s\n", "Exceeds maximal O2 pressure", exceeds_maximum_oxygen);
        System.out.printf("%-40s: %s\n", "Exceeds contingency O2 pressure", exceeds_maximum_contingency_oxygen);
    } // end of compareOxygen method

    private static char computeOxygenGroup(float partial_pressure) {
        char oxygen_group;
        oxygen_group = (char) (Math.floor(partial_pressure * 10) + (int) 'A');
        return oxygen_group;
    }

}
