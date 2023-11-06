package Problem2;

public class MaximumAverageSubArray {

    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double maxAverage = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (j - i + 1 >= k) {
                    maxAverage = Math.max(maxAverage, (double) sum / (j - i + 1));
                }
            }
        }

        return maxAverage;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double result = findMaxAverage(nums, k);
        System.out.println(result); 
    }
}