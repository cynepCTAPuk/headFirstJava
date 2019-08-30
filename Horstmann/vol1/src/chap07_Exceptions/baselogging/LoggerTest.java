package chap07_Exceptions.baselogging;

import java.io.IOException;
import java.util.logging.*;

public class LoggerTest {
    //    private static final Logger LOGGER = Logger.getLogger("com.example");
    public static void main(String[] args) throws IOException {
        Logger LOGGER = Logger.getLogger("com.example");
        LOGGER.setLevel(Level.ALL);
        LOGGER.setUseParentHandlers(false);

//        var handler = new ConsoleHandler();   // log to console
        var handler = new FileHandler();        // log to file %HOMEPATH%\java0.log
//        var handler = new SocketHandler(host, port); // log throw network

        handler.setLevel(Level.ALL);
        LOGGER.addHandler(handler);
/*
        Logger.getGlobal().info("File->Open menu item selected");
        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().info("File->Open menu item selected");
*/
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
