package chap03_Fundamental.CompoundInterest;

/**
 * This program shows how to store tabular data in a 2D array.
 *
 * @author Cay Horstmann
 * @version 1.40 2004-02-10
 */
public class CompoundInterest {
    public static void main(String[] args) {
        final double START_RATE = 1; // %
        final int N_RATES = 9;
        final int N_YEARS = 9;
        final int INITIAL_BALANCE = 30_000;

        // set interest rates from START_RATE . . . %
        double[] interestRate = new double[N_RATES];
        for (int j = 0; j < interestRate.length; j++) interestRate[j] = (START_RATE + j) / 100.0;

        double[][] balances = new double[N_YEARS][N_RATES];
        // set initial balances to INITIAL_BALANCE
        for (int j = 0; j < balances[0].length; j++) balances[0][j] = INITIAL_BALANCE;

        // compute interest for future years
        for (int i = 1; i < balances.length; i++) {
            for (int j = 0; j < balances[i].length; j++) {
                double oldBalance = balances[i - 1][j]; // get last year's balances from previous row
                double interest = oldBalance * interestRate[j]; // compute interest
                balances[i][j] = oldBalance + interest; // compute this year's balances
            }
        }

        // print one row of interest rates
        for (int j = 0; j < interestRate.length; j++)
           System.out.printf("%10.0f%%", 100 * interestRate[j]);

        System.out.println();

        // print balance table
        int i = 0;
        for (double[] row : balances) {
            System.out.printf("%2d", i++); // print year
            for (double b : row) System.out.printf("%,11.2f", b); // print table row

            System.out.println();
        }
    }
}
