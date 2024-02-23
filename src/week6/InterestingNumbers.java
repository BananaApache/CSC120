
package week6;
import java.util.Scanner;

public class InterestingNumbers {

    private static final Scanner keyboard = new Scanner(System.in);
    private static final int MAX_VALUES = 10;
    private static final int STOP_VALUE = 0;

    // start of main method
    public static void main(String[] args) {

        System.out.println("WEEK 6 LAB");
//
        int[] candidates = new int[MAX_VALUES];

        // output statement
        System.out.print("Enter numbers (0 to stop): ");

        // declaring variables
        int index = 0;

        int inputValue;

        int count = 0;

        // do while loop for getting inputs
        do {
            inputValue = keyboard.nextInt();

            if( inputValue > 0){
                candidates[index] = inputValue;
                index++;
                count++;
            }


        } while (inputValue != 0);








//        for (int index = 0; index < candidates.length; index++) {
//
//            int value = keyboard.nextInt();
//            if (value != 0) {
//                candidates[index] = value;
//            }
//            else {
//                break;
//            }
//        }

        System.out.println("Array is of length " + getCandidates(candidates));

        // for loop for outputting
        for (index = 0; index < count; index++) {


            // comparing if fibonacci is true
            if ( isFibonacci(candidates[index]) ) {
                System.out.print(candidates[index] + " is Fibonacci");
            } else {
                System.out.print(candidates[index] + " is not Fibonacci");

            }

            // comparing if prime is true
            if ( isPrime(candidates[index]) ) {
                System.out.println(" and is Prime");
            } else {
                System.out.println(" and is not Prime");

            }






//            if ( isFibonacci(candidates[index]) && isPrime(candidates[index]) ) {
//                System.out.println(candidates[index] + " is Fibonacci and is prime");
//            }
//            else if ( !isFibonacci(candidates[index]) && !isPrime(candidates[index]) ) {
//                System.out.println(candidates[index] + " is not Fibonacci and is not prime");
//            }
//            else if ( isFibonacci(candidates[index]) && !isPrime(candidates[index]) ) {
//                System.out.println(candidates[index] + " is Fibonacci and is not prime");
//            }
//            else {
//                System.out.println(candidates[index] + " is not Fibonacci and is prime");
//            }

        }

//        System.out.println(IsFibonacci(13));

    } // end of main method

    // start of getCandidates method
    private static int getCandidates(int[] candidates) {
        int count = 0;

        // for loop that loops through candidate
        for (int index = 0; index < MAX_VALUES; index++) {

            if (candidates[index] == 0) {
                break;
            }
            else {
                count ++;
            }

        }
        return count;
    } // end of getCandidates method

    // start of IsFibonacci method
    private static boolean isFibonacci(int number) {

        // delcaring variables
        int previous = 0;
        int current = 1;

        // do while loop for getting values
        do {
            if (previous + current == number) {
                return true;
            }
            else {
                int temporary_number = current;
                current += previous;
                previous = temporary_number;
            }
        } while(number >= previous + current);

        return false;

    } // end of IsFibonacci method

    // start of IsPrime method
    private static boolean isPrime(int number) {
        long divisor = 2;

        while (divisor <= Math.sqrt(number)) {
            if (number % divisor == 0) {
                return(false);
            }
            divisor++;
        }

        return(true);

    } // end of IsPrime method



} // end of InterestingNumber class
