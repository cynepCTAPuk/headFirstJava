package org.stepic.java.logging;

import java.util.logging.Logger;

class ClassA {
    private static final Logger LOGGER = Logger.getLogger(ClassA.class.getName());

    public ClassA() {
        LOGGER.fine("ConstructorA");
    }
}
