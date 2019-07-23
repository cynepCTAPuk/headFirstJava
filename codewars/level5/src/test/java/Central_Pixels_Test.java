import org.junit.Test;

import static java.lang.reflect.Array.set;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class Central_Pixels_Test extends Central_Pixels_Finder {
    @Test
    public void Example_In_The_Picture() throws Exception {
        int[] image_data = {1, 1, 4, 4, 4, 4, 2, 2, 2, 2,
                1, 1, 1, 1, 2, 2, 2, 2, 2, 2,
                1, 1, 1, 1, 2, 2, 2, 2, 2, 2,
                1, 1, 1, 1, 1, 3, 2, 2, 2, 2,
                1, 1, 1, 1, 1, 3, 3, 3, 2, 2,
                1, 1, 1, 1, 1, 1, 3, 3, 3, 3};
        set(10, 6, image_data);

        // Only one red pixel has the maximum depth of 3:
        int[] red_ctr = {32};
        assertEquals(answer_matches(central_pixels(1), red_ctr), true);

        // Multiple blue pixels have the maximum depth of 2:
        int[] blue_ctr = {16, 17, 18, 26, 27, 28, 38};
        assertEquals(answer_matches(central_pixels(2), blue_ctr), true);

        // All the green pixels have depth 1, so they are all "central":
        int[] green_ctr = {35, 45, 46, 47, 56, 57, 58, 59};
        assertEquals(answer_matches(central_pixels(3), green_ctr), true);

        // Similarly, all the purple pixels have depth 1:
        int[] purple_ctr = {2, 3, 4, 5};
        assertEquals(answer_matches(central_pixels(4), purple_ctr), true);

        // There are no pixels with colour 5:
        int[] non_existent_ctr = {};
        assertEquals(answer_matches(central_pixels(5), non_existent_ctr), true);
    }

    /* ---------------------------------------------------------------------------------- */
// Check whether actual and expected arrays are equal, disregarding the order of elements.

    public static boolean answer_matches(int[] actual, int[] expected) {
        if (actual.length != expected.length)
            return false;

        Arrays.sort(actual);
        Arrays.sort(expected);

        for (int i = 0; i < actual.length; i++)
            if (actual[i] != expected[i])
                return false;

        return true;
    }
}
