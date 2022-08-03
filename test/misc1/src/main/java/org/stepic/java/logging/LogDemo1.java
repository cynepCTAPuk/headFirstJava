package org.stepic.java.logging;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * To use this config start JVM with parameter:
 * -Djava.util.logging.config.file=logging.properties
 * file logging.properties is the root
 */
public class LogDemo1 {
    private static final Logger LOGGER = Logger.getLogger(LogDemo1.class.getName());
    private static final Path pathPackage = Paths.get("./src/main/java/"
            + LogDemo1.class.getPackage().getName().replace('.', '/'));


    public static void main(String[] args) {
        configureLogging();
    }

    private static void configureLogging() {
        Logger A = Logger.getLogger(org.stepic.java.logging.ClassA.class.getName());
        Logger B = Logger.getLogger(org.stepic.java.logging.ClassB.class.getName());
        A.setLevel(Level.FINE);
        B.setLevel(Level.FINE);

        try {
            A.addHandler(new FileHandler(pathPackage + "/logClassA.txt"));
            B.addHandler(new FileHandler(pathPackage + "/logClassB.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        new ClassA();
        new ClassB();
        A.info("ClassA-1");
        A.info("ClassA-2");
        B.warning("ClassB");
    }
}

