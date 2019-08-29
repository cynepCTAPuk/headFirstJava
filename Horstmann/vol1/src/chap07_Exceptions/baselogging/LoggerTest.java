package chap07_Exceptions.baselogging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerTest {
    private static final Logger LOGGER = Logger.getLogger("com.example");
    

    public static void main(String[] args) {
/*
        Logger.getGlobal().info("File->Open menu item selected");
        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().info("File->Open menu item selected");
*/
//        LOGGER.setLevel(Level.ALL);
        LOGGER.setLevel(Level.ALL);
        LOGGER.setUseParentHandlers(false);
        var handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        LOGGER.addHandler(handler);

        LOGGER.severe("severe");
        LOGGER.warning("warning");
        LOGGER.info("инфо");
        LOGGER.config("config");
        LOGGER.fine("fine");
        LOGGER.finer("finer");
        LOGGER.finest("finest");

        System.out.println("-".repeat(50));
        LOGGER.log(Level.SEVERE, "severe log");
        LOGGER.log(Level.WARNING, "warning log");
        LOGGER.log(Level.INFO, "info log");
        LOGGER.log(Level.CONFIG, "config log");
        LOGGER.log(Level.FINE, "fine log");
        LOGGER.log(Level.FINER, "finer log");
        LOGGER.log(Level.FINEST, "finest log");


    }
}
