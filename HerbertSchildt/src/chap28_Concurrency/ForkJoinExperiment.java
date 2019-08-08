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
        int threshold;
        if (args.length != 2) {
            System.out.println("Usage: ForkJoinDemoExperiment parallelism threshold");
            return;
        }
        pLevel = Integer.parseInt(args[0]);
        threshold = Integer.parseInt(args[1]);
        // These variables are used to time the task
        long beginT, endT;
        // Create a task pool. Notice that the parallelism level is set

        ForkJoinPool forkJoinPool = new ForkJoinPool(pLevel);
        double[] nums = new double[100_000];
        // Give nums some values
        for (int i = 0; i < nums.length; i++) nums[i] = (double) i;

        Transform task = new Transform(nums, 0, nums.length, threshold);

        // Starting timing
        beginT = System.nanoTime();
        // Start the main ForkJoinTask
        forkJoinPool.invoke(task);
        // End timing
        endT = System.nanoTime();

        System.out.println("Level of parallelism: " + pLevel);
        System.out.printf("Sequential threshold: %,d\n", threshold);
        System.out.printf("Elapsed time: %,d ns", endT - beginT);
        System.out.println();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Runtime.getRuntime().availableProcessors(): " + availableProcessors);

    }
}