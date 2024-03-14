package playground;

public class tmp {

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static final int QUARTER_WAY = 2;
    private static final int HALF_WAY = 4;
    private static final int ALL_THE_WAY = 8;
    private static final int MAX_MARK = 10;

    public static void q1() {

    }

    public static void q2() {
        int numberOfValues = 0;
        int total = 0;
        boolean madeIt;
        do {
            numberOfValues++;
            while (numberOfValues < HALF_WAY) {
                total += numberOfValues;
                numberOfValues++;
            }
                madeIt = (total - numberOfValues) % 2 == 0;
                numberOfValues -= QUARTER_WAY;
                System.out.println(total + " " + numberOfValues + " " + madeIt);
            } while (total < ALL_THE_WAY) ;
        }public static void main(String[] args) {
        int question;
        boolean pass;
        double fear;
        question = 3;
        fear = 7.3;
        pass = (question / MAX_MARK > 0 || (fear + MAX_MARK) < question + MAX_MARK % question);
        fear = question++ * fear;
        question += 13 / 3;
        System.out.println(pass + " " + fear + " " + question);
    }
    }

