
package playground;

import java.io.*;

public class FileTests {

    public static void main(String[] args) {

        TestObject obj = new TestObject("John", 25);

        // output testobject to a file
        try {
            ObjectOutputStream output_file = new ObjectOutputStream(new FileOutputStream("/Users/daniel/Desktop/TestFile"));
            output_file.writeObject(obj);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
