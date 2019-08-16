package chap03_Fundamental.CompoundInterest;

/**
 * This program shows how to store tabular data in a 2D array.
 *
 * @author Cay Horstmann
 * @version 1.40 2004-02-10
 */
public class CompoundInterest {
    public static void main(String[] args) {
        final double STARTRATE = 1;
        final int NRATES = 9;
        final int NYEARS = 9;
        final int INITIAL_SUM = 30_000;

        // set interest rates to 10 . . . 15%
        double[] interestRate = new double[NRATES];
        for (int j = 0; j < interestRate.length; j++) interestRate[j] = (STARTRATE + j) / 100.0;

        double[][] balances = new double[NYEARS][NRATES];
        // set initial balances to 10000
        for (int j = 0; j < balances[0].length; j++) balances[0][j] = INITIAL_SUM;

        // compute interest for future years
        for (int i = 1; i < balances.length; i++) {
            for (int j = 0; j < balances[i].length; j++) {
                // get last year's balances from previous row
                double oldBalance = balances[i - 1][j];
                // compute interest
                double interest = oldBalance * interestRate[j];
                // compute this year's balances
                balances[i][j] = oldBalance + interest;
            }
        }

        // print one row of interest rates
        for (int j = 0; j < interestRate.length; j++)
            System.out.printf("%10.0f%%", 100 * interestRate[j]);

        System.out.println();

        // print balance table
        int i = 0;
        for (double[] row : balances) {
            System.out.printf("%2d", i++);
            // print table row
            for (double b : row) System.out.printf("%,11.2f", b);

            System.out.println();
        }
    }
}
