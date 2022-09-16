package org.stepic.java.logging;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Formatter;
import java.util.logging.*;

/**
 * To use this config start JVM with parameter:
 * -Djava.util.logging.config.file=logging.properties
 * file logging.properties is the root
 */
public class LogDemo2 {
    public static void main(String[] args) {
        configureLogging();
    }

    private static void configureLogging() {
        Logger parent = Logger.getLogger("org.stepic.java");
        Logger A = Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger B = Logger.getLogger("org.stepic.java.logging.ClassB");

        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new XMLFormatter());

        parent.setUseParentHandlers(false);
        parent.addHandler(handler);

        A.setLevel(Level.ALL);
        B.setLevel(Level.WARNING);
    }
}

