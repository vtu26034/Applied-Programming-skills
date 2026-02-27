 class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        int maxKadane = nums[0];
        int currentMax = nums[0];

        int minKadane = nums[0];
        int currentMin = nums[0];

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];

            if (i > 0) {
                currentMax = Math.max(nums[i], currentMax + nums[i]);
                maxKadane = Math.max(maxKadane, currentMax);

                currentMin = Math.min(nums[i], currentMin + nums[i]);
                minKadane = Math.min(minKadane, currentMin);
            }
        }

        // If all numbers are negative, return maxKadane
        if (maxKadane < 0) {
            return maxKadane;
        }

        return Math.max(maxKadane, totalSum - minKadane);
    }
}
