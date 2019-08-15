package chap03_Fundamental;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Arrays;

public class PasswordMask {
    public static void main(String[] args) {
        char[] password = null;
        try {
            password = PasswordField.getPassword(System.in, "Enter your password: ");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        if (password == null)
            System.out.println("No password entered");
        else
            System.out.println("The password entered is: " + String.valueOf(password));
    }
}

/**
 * This class attempts to erase characters echoed to the console.
 */
class MaskingThread extends Thread {
    private volatile boolean stop;
    private char echoChar = '#';

    /**
     * @param prompt The prompt displayed to the user
     */
    public MaskingThread(String prompt) {
        System.out.print(prompt);
    }

    /**
     * Begin masking until asked to stop.
     */
    public void run() {
        int priority = Thread.currentThread().getPriority();
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        try {
            stop = true;
            while (stop) {
                System.out.print("\010" + echoChar);
                try {
                    // attempt masking at this rate
                    sleep(1);
                } catch (InterruptedException iex) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        } finally { // restore the original priority
            Thread.currentThread().setPriority(priority);
        }
    }

    /**
     * Instruct the thread to stop masking.
     */
    public void stopMasking() {
        this.stop = false;
    }
}

/**
 * This class prompts the user for a password and attempts to mask input with "*"
 */

class PasswordField {

    /**
     * @param in  stream to be used (e.g. System.in)
     * @param prompt The prompt to display to the user.
     * @return The password as entered by the user.
     */

    public static final char[] getPassword(InputStream in, String prompt) throws IOException {
        MaskingThread maskingthread = new MaskingThread(prompt);
        Thread thread = new Thread(maskingthread);
        thread.start();

        char[] lineBuffer;
        char[] buf;

        buf = lineBuffer = new char[128];

        int room = buf.length;
        int offset = 0;
        int c;

        loop:
        while (true) {
            switch (c = in.read()) {
                case -1:
                case '\n':
                    break loop;

                case '\r':
                    int c2 = in.read();
                    if ((c2 != '\n') && (c2 != -1)) {
                        if (!(in instanceof PushbackInputStream)) {
                            in = new PushbackInputStream(in);
                        }
                        ((PushbackInputStream) in).unread(c2);
                    } else {
                        break loop;
                    }

                default:
                    if (--room < 0) {
                        buf = new char[offset + 128];
                        room = buf.length - offset - 1;
                        System.arraycopy(lineBuffer, 0, buf, 0, offset);
                        Arrays.fill(lineBuffer, ' ');
                        lineBuffer = buf;
                    }
                    buf[offset++] = (char) c;
                    break;
            }
        }
        maskingthread.stopMasking();
        if (offset == 0) return null;
        char[] ret = new char[offset];
        System.arraycopy(buf, 0, ret, 0, offset);
        Arrays.fill(buf, ' ');
        return ret;
    }
}