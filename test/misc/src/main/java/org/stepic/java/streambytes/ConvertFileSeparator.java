package org.stepic.java.streambytes;

import java.io.IOException;

public class ConvertFileSeparator {
    public static final byte CARRIAGE_RETURN = 13;
    public static final byte LINE_FEED = 10;

    public static void main(String[] args) throws IOException {
        int current, next;
        current = System.in.read();
        while (current >= 0) {
            next = System.in.read();
            if (current != CARRIAGE_RETURN || next != LINE_FEED)
                System.out.write(current);
            current = next;
        }
        System.out.flush();
    }
}
