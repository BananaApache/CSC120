
package week5;
import java.util.Scanner;

public class TaxTime {

    // declaring constant variables
    private static final Scanner keyboard = new Scanner(System.in);
    private static final int STINKING_RICH = 500000;
    private static final int QUITE_RICH = 200000;
    private static final int MIAMI_POOR = 100000;
    private static final int AVERAGE = 50000;
    private static final int REALISTIC = 20000;
    private static final double HIGH_RATE = 0.25;
    private static final double MEDIUM_RATE = 0.1;
    private static final double LOW_RATE = 0.03;
    private static final String FORMAT_SPACES = "%-20s: ";

    // start of Main method
    public static void main(String[] args) {

        System.out.println("WEEK5 - LAB 4");

        // declaring variables
        int user_amount, income, deductions, taxable_incomes;
        float tax_owed;
        char tax_group;

        // initializing 2 variables to 0
        income = deductions = 0;

        // do while loop for getting user input
        do {
            System.out.printf(FORMAT_SPACES, "Enter next amount");
            user_amount = keyboard.nextInt();
            // adding to income
            if (user_amount > 0) {
                income += user_amount;
            }
            // adding to deduction
            else if (user_amount < 0) {
                deductions += user_amount;
            }
        } while (user_amount != 0);

        // outputting
        System.out.printf("%-20s: $%s\n", "Income", (float) income);
        System.out.printf("%-20s: $%s\n", "Deductions", (float) Math.abs(deductions));
        taxable_incomes = computeTaxableIncome(income, deductions);
        System.out.printf("%-20s: $%s\n", "Taxable income",  (float) taxable_incomes);
        tax_group = computeTaxGroup(taxable_incomes);
        System.out.printf("%-20s: %s\n", "Tax Group", tax_group);
        System.out.printf("%-20s: $%s\n", "Tax Owed", computeTaxOwed(taxable_incomes, tax_group));

    } // end of Main method

    // start of computeTaxableIncome Method
    private static int computeTaxableIncome(int income, int deductions) {
        // return sum if income is greater than deduction
        if (income > deductions) {
            return income + deductions;
        }
        // return 0 if income less than deduction
        else {
            return 0;
        }
    } // end of computeTaxableIncome Method

    // start of computeTaxGroup Method
    private static char computeTaxGroup(int taxable_income) {

        // comparing taxable income to ranges and returning tax group
        if (taxable_income >= STINKING_RICH) {
            return 'S';
        }
        else if (QUITE_RICH <= taxable_income) {
            return 'Q';
        }
        else if (MIAMI_POOR <= taxable_income) {
            return 'M';
        }
        else if (AVERAGE <= taxable_income) {
            return 'A';
        }
        else if (REALISTIC <= taxable_income) {
            return 'R';
        }
        else {
            return 'P';
        }

    } // end of computeTaxGroup Method

    // start of computeTaxOwed Method
    private static float computeTaxOwed(int taxable_income, char tax_group) {
        // comparing tax groups and returning tax amount owed
        if (tax_group == 'S' || tax_group == 'Q') {
            return (float) (taxable_income * HIGH_RATE);
        }
        else if (tax_group == 'M') {
            return (float) (taxable_income * MEDIUM_RATE);
        }
        else if (tax_group == 'A' || tax_group == 'R') {
            return (float) (taxable_income * LOW_RATE);
        }
        else {
            return 0.0F;
        }

    }

} // end of TaxTime class
