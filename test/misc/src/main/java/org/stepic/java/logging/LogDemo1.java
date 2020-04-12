package org.stepic.java.logging;


import java.util.Arrays;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * To use this config start JVM with parameter:
 * -Djava.util.logging.config.file=logging.properties
 * file logging.properties is the root
 */
public class LogDemo1 {
    private static final Logger LOGGER = Logger.getLogger(LogDemo1.class.getName());
    private static final Logger LOGGERA = Logger.getLogger("org.stepic.java.logging.ClassA");
    private static final Logger LOGGERB = Logger.getLogger("org.stepic.java.logging.ClassB");


    public static void main(String[] args) {
//        LOGGER.log(Level.INFO, "I'm logging");
        // SEVERE , WARNING , INFO , CONFIG , FINE , FINER , FINEST
//        LOGGER.warning("We have a problem!");
        configureLogging();
//        LOGGER.log(Level.INFO, "Started with arguments: {0}", Arrays.toString(args));
    }

    private static void configureLogging() {
        Logger A = Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger B = Logger.getLogger("org.stepic.java.logging.ClassB");
        A.setLevel(Level.ALL);
        B.setLevel(Level.WARNING);
        A.setUseParentHandlers(true);
        Handler[] handlers = A.getHandlers();
        System.out.println(Arrays.toString(handlers));
    }
}

class ClassA {
    private static final Logger LOGGER = Logger.getLogger(LogDemo1.class.getName());

}

class ClassB {
    private static final Logger LOGGER = Logger.getLogger(LogDemo1.class.getName());
}