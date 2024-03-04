
package week8;

// start of KindleClass
public class KindleClass {

    // instance variables
    private int numberOfPages;
    private int currentPage;

    // constructor that sets the number of pages
    public KindleClass(int newNumberOfPages) {
        numberOfPages = newNumberOfPages;
        currentPage = 1;
    } // end of constructor

    // start of turnPages method
    public void turnPages() {
        // adds one to the current page
        currentPage++;
    } // end of turnPages method

    // start of turnPages method
    public void turnPages(int pagesToTurn) {
        // if the current page plus the number of pages to turn is greater than the number of pages
        if (currentPage + pagesToTurn > numberOfPages) {
            System.out.println("You were on " + currentPage + " of " + numberOfPages + " pages.");
            System.out.println("Turning " + pagesToTurn + " pages would take you past the last page.");
            System.out.println("You are now on " + numberOfPages + " of " + numberOfPages + " pages.");
        } else {
            // adds the number of pages to turn to the current page
            currentPage += pagesToTurn;
        }
    } // end of turnPages method

    // start of toString method
    public String toString() {
        // returns the current page and the number of pages
        return "Page " + currentPage + " of " + numberOfPages;
    } // end of toString method

} // end of KindleClass
