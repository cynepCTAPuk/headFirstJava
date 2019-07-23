import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void test1() {
        assertEquals(17, E.convergentsOfE(10));
    }
    @Test
    public void test2() {
        assertEquals(272, E.convergentsOfE(100));
    }
}