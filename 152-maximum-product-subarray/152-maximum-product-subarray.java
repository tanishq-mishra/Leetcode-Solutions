class Solution {
    public int maxProduct(int[] nums) {
        int minVal = nums[0];
        int maxVal = nums[0];
        int maxSoFar = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < 0) {
                int temp = minVal;
                minVal = maxVal;
                maxVal = temp;
            }
            maxVal = Math.max(maxVal * nums[i], nums[i]);
            minVal = Math.min(minVal * nums[i], nums[i]);
            
            maxSoFar = Math.max(maxSoFar, maxVal);
        }
        
        return maxSoFar;
    }
}