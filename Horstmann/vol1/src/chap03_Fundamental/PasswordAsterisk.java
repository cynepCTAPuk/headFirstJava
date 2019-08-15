package chap03_Fundamental;
/**
 http://www.cse.chalmers.se/edu/year/2018/course/TDA602/Eraserlab/pwdmasking.html
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordAsterisk {
    public static void main(String[] args) {
        String password = PasswordF.readPassword("Enter password: ");
        System.out.println("The password entered is: " + password);
    }
}

class PasswordF {
    /**
     * prompt The prompt to display to the user
     * The password as entered by the user
     */
    public static String readPassword(String prompt) {
        EraserThread et = new EraserThread(prompt);
        Thread mask = new Thread(et);
        mask.start();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String password = "";

        try {
            password = in.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        // stop masking
        et.stopMasking();
        // return the password entered by the user
        return password;
    }
}

class EraserThread implements Runnable {
    private boolean stop;

    /**
     * The prompt displayed to the user
     */
    public EraserThread(String prompt) {
        System.out.print(prompt);
    }

    /**
     * Begin masking...display asterisks (*)
     */
    public void run() {
        stop = true;
        while (stop) {
            System.out.print("\010*");
            try {
                Thread.currentThread().sleep(1);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    /**
     * Instruct the thread to stop masking
     */
    public void stopMasking() {
        this.stop = false;
    }
}