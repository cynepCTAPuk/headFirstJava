package com.javacode.string;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringTestCase {
    @Test
    public void testSame() {
        String s = "\t abc \n";

        assertEquals("abc", s.trim());
        assertEquals("abc", s.strip());
    }

    @Test
    public void testDifferent() {
        Character c = '\u0020';
        String s = c + "abc" + c;

        assertTrue(Character.isWhitespace(c));
        assertEquals(s, s.trim());
        assertEquals("abc", s.strip());
    }
}