import static org.junit.Assert.*;

import org.junit.Test;

public class FindCubePiramideTest {

    @Test
    public void test1() {
        assertEquals(2022, FindCubePiramide.findNb(4183059834009L));
    }
    @Test
    public void test2() {
        assertEquals(-1, FindCubePiramide.findNb(24723578342962L));
    }
    @Test
    public void test3() {
        assertEquals(4824, FindCubePiramide.findNb(135440716410000L));
    }
    @Test
    public void test4() {
        assertEquals(3568, FindCubePiramide.findNb(40539911473216L));
    }
}
