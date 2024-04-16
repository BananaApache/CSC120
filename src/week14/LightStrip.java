
package week14;
import java.util.ArrayList;

public class LightStrip {

    private double lumens;
    private ArrayList<Light> lights = new ArrayList<Light>();

    public void addLight(Light light) {
        lights.add(light);
    }

    public void removeLight(int index) {
        try {
            lights.remove(index);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds");
        }
    }

    public void display() {

        int index;
        double total_lumens = 0;
        int total_flourescent = 0;
        double total_heat_output = 0;

        for (index = 0; index < lights.size(); index++) {
            System.out.println(index + ": " + lights.get(index));

            if (lights.get(index).isFlourescent()) {
                total_lumens += lights.get(index).getLumens();
                total_flourescent++;
            }
            else {
                total_lumens += lights.get(index).getLumens();
                total_heat_output += lights.get(index).heatOutput();
            }
        }

        System.out.println("Total lumens = " + total_lumens);
        System.out.println("Flourescent  = " + total_flourescent);
        System.out.println("Heat output  = " + total_heat_output);

    }

}
