package com.javacode.lambdas;

@FunctionalInterface
interface Operation {
    void process();

    static void measure(Operation function) {
        long start = System.currentTimeMillis();
        function.process();
        long end = System.currentTimeMillis();
        System.out.println("Time spent " + (end - start));
    }

    default Operation combineOperation(Operation that) {
        return () -> {
            process();
            that.process();
        };
    }
}
