
package playground;
import java.lang.reflect.*;


public class Tests {

    public static void main(String[] args) {

        // Testing char to int conversion
//        System.out.println((int) 'C' - (int) 'A');

        // Testing String object methods
        Class<?> cls = String.class;
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        // Can a string be in single quote?
//        String s = 'fadsfsa';
        //! NO




    }

}


