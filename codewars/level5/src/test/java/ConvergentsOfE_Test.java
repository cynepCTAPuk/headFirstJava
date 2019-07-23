import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConvergentsOfE_Test {

    @Test
    public void test1() {
        assertEquals(17, ConvergentsOfE.convergentsOfE(10));
    }
    @Test
    public void test2() {
        assertEquals(272, ConvergentsOfE.convergentsOfE(100));
    }
}