package chap28_Concurrency;

// A simple example of the basic divide-and-conquer strategy
// In this case, RecursiveAction is used

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

// A ForkJoinTask (via RecursiveAction) that transforms
// the elements in an array of doubles into their square roots

class SqrtTransform extends RecursiveAction {
    // The threshold value is arbitrarily set at 1,000 in this example.
    // In real-world code, its optimal value can be determined by profiling and experimentation
    private final int seqThreshold = 1_000;
    // Array to be accessed
    private double[] data;
    // Determines what part of data to process
    private int start, end;

    SqrtTransform(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    // This is the method in which parallel computation will occur
    @Override
    protected void compute() {
        // if number of elements is below the sequential threshold, then process sequentially
        if ((end - start) < seqThreshold) {
            // Transform each element into its square root
            for (int i = start; i < end; i++) data[i] = Math.sqrt(data[i]);
        } else {
            // Otherwise, continue to break the data into smaller pieces
            // Find the midpoint
            int middle = (start + end) / 2;
            // Invoke new tasks, using the subdivided data
            invokeAll(new SqrtTransform(data,start,middle),new SqrtTransform(data,middle,end));
        }
    }
}

// Demonstrate parallel execution
class ForkJoinDemo {
    public static void main(String[] args) {
        // Create a task pool
        ForkJoinPool fjp = new ForkJoinPool();
        double[] nums = new double[100_000];
        // Give nums some values
        for (int i = 0; i < nums.length; i++) nums[i] = (double) i;
        System.out.println("A portion of the original sequence: ");
        for (int i = 10; i < 24; i++) System.out.printf("%6.0f ", nums[i]);
        System.out.println("\n");

        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);
        // Start the main ForkJoinTask
        fjp.invoke(task);
        System.out.println("A portion of the transformed sequence (to four decimal places): ");
        for (int i = 10; i < 24; i++) System.out.printf("%6.4f ", nums[i]);
        System.out.println();
    }
}