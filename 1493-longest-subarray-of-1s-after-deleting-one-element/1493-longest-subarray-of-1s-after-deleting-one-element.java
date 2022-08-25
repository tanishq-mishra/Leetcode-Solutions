class Solution {
    
    //Sliding window
    public int longestSubarray(int[] nums) {
        int length = 0;
        int start = 0;
        int end = -1;
        boolean hasZero = false;
        while(end < nums.length-1) {
            end++;
            if(nums[end] == 0 && !hasZero) {
                hasZero =true;
            } else if(nums[end] == 0 && hasZero) {
                while(nums[start] != 0) {
                    start++;
                }
                start++;
                
            }
            
            length = Math.max(end-start, length);
        }
        
        
        return length;
    }
}