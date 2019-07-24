import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class SamePrimeFactorsTest {

    private static void testing(String act, String exp) {
        assertEquals(exp, act);
    }

    public static void tests(int[] list1, int[][] results) {
        for (int i = 0; i < list1.length; i++)
            testing(Arrays.toString(SamePrimeFactors.sameFactRev(list1[i])),
                    Arrays.toString(results[i]));
        return;
    }

    @Test
    public void test1() {
        System.out.println("Basic Tests");
        int[] l = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
        int[][] r = {{}, {1089}, {1089, 2178}, {1089, 2178}, {1089, 2178, 4356},
                {1089, 2178, 4356}, {1089, 2178, 4356, 6534}, {1089, 2178, 4356, 6534},
                {1089, 2178, 4356, 6534, 8712}, {1089, 2178, 4356, 6534, 8712, 9801}};
        tests(l, r);
        return;
    }
}
