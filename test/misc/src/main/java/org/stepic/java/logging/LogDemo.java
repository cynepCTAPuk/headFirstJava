package org.stepic.java.logging;


import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * To use this config start JVM with parameter:
 * -Djava.util.logging.config.file=logging.properties
 * file logging.properties is the root
 */
public class LogDemo {
    private static final Logger LOGGER = Logger.getLogger(LogDemo.class.getName());

    public static void main(String[] args) {
//        LOGGER.log(Level.INFO, "I'm logging");
        // SEVERE , WARNING , INFO , CONFIG , FINE , FINER , FINEST
//        LOGGER.warning("We have a problem!");
        LOGGER.log(Level.FINE, "Started with arguments: {0}", Arrays.toString(args));
        try {
            randomlyFailingAlgorithm();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception caught", e);
            System.exit(2);
        }
        LOGGER.fine(("Finished successfully"));
    }

    private static void randomlyFailingAlgorithm() {
        double randomNumber = Math.random();
        LOGGER.log(Level.FINE, "Generated random number: {0}", randomNumber);
        if (randomNumber < 0.5) {
            throw new IllegalStateException("Invalid phase of the Moon");
        }
    }
}
