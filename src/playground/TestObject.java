package playground;

import java.io.Serializable;

public class TestObject implements Serializable {

    private String name;
    private int age;

    public TestObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void increaseAge() {
        age += 1;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

}
