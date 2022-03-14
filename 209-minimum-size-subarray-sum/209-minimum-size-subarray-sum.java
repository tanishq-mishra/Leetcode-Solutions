class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // define pointers for sliding window
        int p1 = 0; int p2 = 0;
        // define min & sum
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int n = nums.length;
        // min sub array length
        while(p2 < n) {
            // first add the current element
            sum = sum + nums[p2];
            // contraction of window
            while(sum >= s) {
                min = Math.min(min,p2 - p1 + 1);
                sum = sum - nums[p1];
                p1++;
            }
            // Increment the p2
            p2++;
        }
        // return res
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}