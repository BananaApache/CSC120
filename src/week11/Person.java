package week11;

// start of Person class
public class Person {

    // instance variables
    private final String name;
    private int age;

    // constructor that initializes the name and age
    public Person(String newName, int newAge) {
        name = newName;
        age = newAge;
    } // end of constructor

    // start of getName method
    public String getName() {
        return name;
    } // end of getName method

    // start of getAge method
    public int getAge() {
        return age;
    } // end of getAge method

    // start of increaseAge method
    public void increaseAge() {
        // Increment age by 1
        age += 1;
    } // end of increaseAge method

} // end of Person class
