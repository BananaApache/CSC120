
package week13;
import java.util.Scanner;

// Girl class
public class Girl {

    public String name;
    private Diamond diamond;


    public Girl(String name, Diamond diamond) {
        this.name = name;
        this.diamond = diamond;
    } // end constructor


    public void takeDiamond(Diamond diamond) {
        this.diamond = diamond;
    } // end method takeDiamond


    public boolean isDiamondBetter(Diamond newDiamond) {
        if (diamond == null) {
            return true;
        }
        return newDiamond.getCarats() > diamond.getCarats();
    } // end method isDiamondBetter


    public String toString() {
        return name + " has a diamond, " + diamond.getCarats() + " carats, worth $" + diamond.getDollarValue() + ".";
    }


} // end of Girl class
