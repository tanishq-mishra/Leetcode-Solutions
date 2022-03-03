class Solution {
    public int maxSubArray(int[] nums) {
        int currentMax = 0;
        int globalMax = Integer.MIN_VALUE;
        
        for(int i = 0; i< nums.length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            globalMax = Math.max(globalMax, currentMax);
        }
        
        return globalMax;
    }
}