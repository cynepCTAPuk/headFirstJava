package chap07_Exceptions.baselogging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerTest {
    public static void main(String[] args) {
        Logger.getGlobal().info("File->Open menu item selected");
        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().info("File->Open menu item selected");
    }
}
