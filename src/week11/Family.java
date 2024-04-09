
package week11;

// start of Family class
public class Family {

    // instance variables
    private Person[] family;
    private int numberOfMembers;

    // constructor that initializes the family array and members
    public Family() {
        // initialize family array to 10
        family = new Person[10];
        numberOfMembers = 0;
    }

    // start of addPerson method
    public boolean addPerson(String name, int age) {

        // check if the family array is full
        try {
            family[numberOfMembers] = new Person(name, age);
            numberOfMembers += 1;
            return true;
        }
        catch (Exception e) {
            return false;
        }

    } // end of addPerson method

    // start of getNumberOfPeople method
    public int getNumberOfPeople() {

        // initialize people to 0
        int people = 0;
        int index;

        // loop through the family array
        for (index = 0; index < numberOfMembers; index++) {
            people += 1;
        }

        return people;
    } // end of getNumberOfPeople method

    // start of getTotalAge method
    public int getTotalAge() {

        // initialize sum to 0
        int sum = 0;
        int index;

        // loop through the family array
        for (index = 0; index < numberOfMembers; index++) {
            sum += family[index].getAge();
        }

        return sum;

    } // end of getTotalAge method

    // start of birthday method
    public void birthday(String name) {

        int index;

        // loop through the family array
        for (index = 0; index < family.length; index++) {
            if (family[index] != null) {
                if (family[index].getName().equalsIgnoreCase(name)) {
                    family[index].increaseAge();
                }
            }
        }

    } // end of birthday method

    // start of display method
    public void display() {

        int index;

        // loop through the family array
        for (index = 0; index < family.length; index++) {
            if (family[index] != null) {
                System.out.println(family[index].getName() + " is " + family[index].getAge() + " years old.");
            }
        }

    } // end of display method

} // end of Family class
