
package playground;

import java.util.Scanner;

public class Species1 {

    private static String name;
    private static int population;
    private final Scanner keyboard = new Scanner(System.in);

    public Species1(String newName, int newPopulation) {
        name = newName;
        population = newPopulation;
    }

    public void readInput() {
        System.out.println("What is the species' name?");
        name = keyboard.next();
        System.out.println("What is the population of the species?");
        population = keyboard.nextInt();
    }

    public void writeOutput() {
        System.out.println("Name = " + name);
        System.out.println("Population = " + population);
    }

    public static void killAll() {
        name = "DEAD";
        population = 0;
    }

    public static void main(String[] args) {
        Species1 species1 = new Species1("bruh", 53);
        species1.readInput();
        species1.writeOutput();
    }

}
