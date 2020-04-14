package org.stepic.java.logging;

import java.util.logging.Logger;

class ClassB {
    private static final Logger LOGGER = Logger.getLogger(ClassB.class.getName());

    public ClassB() {
        LOGGER.config("ConstructorB");
    }
}
