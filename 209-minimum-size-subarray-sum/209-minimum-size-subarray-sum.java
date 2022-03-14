class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 1;
        int currentSum = nums[0];
        int minSize = Integer.MAX_VALUE;
        while(start < end && end <= nums.length) {
            //System.out.println(start+", "+ end + " Sum = " + currentSum);
            if(currentSum >= target) {
                //System.out.println(end-start);
                minSize = Math.min(minSize, end-start);
            } 
            if(currentSum < target && end != nums.length) {
                    currentSum +=nums[end];
                    end++;
            
            } else if(currentSum > target) {
                currentSum -=nums[start];
                start++;
            } 
            else if(end <nums.length) {
                currentSum +=nums[end];
                end++;
            } 
            
            else if (end == nums.length){
                break;
            } 
            
            
            
        }
        
        if(minSize == Integer.MAX_VALUE) {
            return 0;
        }
        
        return minSize;
    }
}