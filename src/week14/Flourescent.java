package week14;

public class Flourescent extends Light {


    public Flourescent(int lumens) {
        super(lumens);
    }

    public String getName() {
        return "Flourescent";
    }

    public double heatOutput() {
        return 0;
    }

    public boolean isFlourescent() {
        return true;
    }
}
