package week14;

public class Incandescent extends Light {

    private final double FACTOR_OF_HEAT = 87.4;

    public Incandescent(int lumens) {
        super(lumens);
    }

    public String getName() {
        return "Incandescent";
    }

    public double heatOutput() {
        return getLumens() * FACTOR_OF_HEAT;
    }

    public boolean isFlourescent() {
        return false;
    }

}
