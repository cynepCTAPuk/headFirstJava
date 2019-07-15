public class MaximumSubarraySum {
    public static int sequence(int[] arr) {
        int max_ending_here = 0, max_so_far = 0;
        for (int v : arr) {
            max_ending_here = Math.max(0, max_ending_here + v);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int[] arr = {1, -10, 2, -10, 3, 4, -1, 9};
        System.out.println(sequence(arr));
    }
}