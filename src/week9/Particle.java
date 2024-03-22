package week9;

// start of class
public class Particle {

    // declaring global variables
    private double x;
    private double y;
    private int identification_tag = 0;

    // start of constructor
    public Particle(int particle_name) {

        // setting the x and y coordinates to 0.0
        x = 0.0;
        y = 0.0;
        // setting the identification tag to the particle name
        identification_tag = particle_name;

    } // end of constructor

    // start of toString method
    public String toString() {
        return "Particle " + identification_tag + " is at (" + x + ", " + y + ")\n";
    } // end of toString method

    // start of moveParticle method
    public void moveParticle(double movement_x, double movement_y) {

        // adding the movement to the x and y coordinates
        x += movement_x;
        y += movement_y;

    } // end of moveParticle method

} // end of class
