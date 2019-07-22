import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IntTrianglesTest {

    private static void testing(int i, int results) {
        assertEquals(results, i);
    }
    public static void tests(int[] list1, int[] results) {
        for (int i = 0; i < list1.length; i++)
            testing(IntTriangles.giveTriang(list1[i]), results[i]);
        return;
    }
    @Test
    public void test1() {
        System.out.println("Basic Tests");
        int[] list1 = new int[] {5, 15, 30, 50, 80, 90, 100, 150, 180, 190};
        int[] results = new int[] {0, 1, 3, 5, 11, 13, 14, 25, 32, 35};
        tests(list1, results);
    }
}
