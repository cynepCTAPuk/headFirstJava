package web.stepik.web2;

import org.junit.Test;

import java.util.regex.Matcher;

import static org.junit.Assert.*;

public class MathTest {

    @Test
    public void getSum() {
        Math math = new Math(3, 2);
        int result = math.getSum();
        assertEquals(5,result);
    }

    @Test
    public void testThreeAndTwo() {
        Math math = new Math(3, 2);
        int result = math.getDiv();
        assertEquals(5,result);
    }
}