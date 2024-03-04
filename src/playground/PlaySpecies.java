package playground;

public class PlaySpecies {

    public static void main(String[] args) {
        Species1 species1 = new Species1("a", 1);
//        species1.readInput();
        species1.writeOutput();

        Species1 species2 = new Species1("b", 2);
//        species2.readInput();
        species2.writeOutput();

        Species1.killAll();

        species1.writeOutput();
        species2.writeOutput();

        //! Note: The following line will work because the main method is static
//        Species1.main(new String[0]);


    }

}
