public class MaximumSubarraySum1 {
    public static int sequence(int[] arr) {
        int maxSubSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int subSum = 0;
            for (int j = i; j < arr.length; j++) {
                subSum += arr[j];
                if (subSum > maxSubSum) maxSubSum = subSum;
            }
        }
        return maxSubSum;
    }
}