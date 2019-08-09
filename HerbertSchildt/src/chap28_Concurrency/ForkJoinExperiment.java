package chap28_Concurrency;

// A simple program that lets you experiment with the effects of
// changing the threshold and parallelism of a ForkJoinTask

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

// A ForkJoinTask (via RecursiveAction) that perform a
// transforms on the elements of an array of doubles
class Transform extends RecursiveAction {
    // Array to be accessed
    private double[] data;
    // Determines what part of data to process
    private int start, end;
    // Sequential threshold, which is set by the constructor
    private int threshold;

    Transform(double[] data, int start, int end, int threshold) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    // This is the method in which parallel computation will occur
    @Override
    protected void compute() {
        // if number of elements is below the sequential threshold, then process sequentially
        if ((end - start) < threshold) {
            // The following code assigns an element at an even index the square root of its
            // original value. An element at an odd index is assigned its cube root. This
            // code is designed to simply consume CPU time so that effects of concurrent
            // execution are more readily observable
            for (int i = start; i < end; i++) {
                if ((data[i] % 2) == 0) data[i] = Math.sqrt(data[i]);
                else data[i] = Math.cbrt(data[i]);
            }
        } else {
            // Otherwise, continue to break the data into smaller pieces
            // Find the midpoint
            int middle = (start + end) / 2;
            // Invoke new tasks, using the subdivided data
            invokeAll(
                    new Transform(data, start, middle, threshold),
                    new Transform(data, middle, end, threshold));
        }
    }
}

// Demonstrate parallel execution
class ForkJoinExperiment {
    public static void main(String[] args) {
        int pLevel;
        int threshold = 50; // qtyCalculations/(pLevel*10-1000)
/*
        if (args.length != 2) {
            System.out.println("Usage: ForkJoinDemoExperiment parallelism threshold");
            return;
        }
        pLevel = Integer.parseInt(args[0]);
        threshold = Integer.parseInt(args[1]);
*/
        long time = 0;
        int count = 20;

        pLevel = 1;
        for (int i = 0; i < count; i++) time += getTime(pLevel, threshold);
        System.out.printf(
                "Level of parallelism: %d Sequential threshold: %,d\n", pLevel, threshold);
        System.out.printf("Elapsed time: %,d ns\n", time /= count);

        pLevel = 2;
        for (int i = 0; i < count; i++) time += getTime(pLevel, threshold);
        System.out.printf(
                "Level of parallelism: %d Sequential threshold: %,d\n", pLevel, threshold);
        System.out.printf("Elapsed time: %,d ns\n", time /= count);
/*
        System.out.println();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Runtime.getRuntime().availableProcessors(): " + availableProcessors);
*/
    }

    private static long getTime(int pLevel, int threshold) {
        long time;// These variables are used to time the task
        long beginT, endT;
        // Create a task pool. Notice that the parallelism level is set

        ForkJoinPool forkJoinPool = new ForkJoinPool(pLevel);
        double[] nums = new double[100_000];
        // Give nums some values
        for (int i = 0; i < nums.length; i++) nums[i] = (double) i;

        Transform task = new Transform(nums, 0, nums.length, threshold);

        beginT = System.nanoTime();        // Starting timing
        forkJoinPool.invoke(task);         // Start the main ForkJoinTask
        endT = System.nanoTime();        // End timing

        return endT - beginT;
    }
}