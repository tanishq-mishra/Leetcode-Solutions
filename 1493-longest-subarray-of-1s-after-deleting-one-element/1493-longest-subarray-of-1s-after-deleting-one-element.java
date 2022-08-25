class Solution {
    
    //Sliding window
    public int longestSubarray(int[] nums) {
        int length = 0;
        int start = 0;
        int end = -1;
        int zeroIndex = -1;
        boolean hasZero = false;
        while(end < nums.length-1) {
            end++;
            if(nums[end] == 0 && !hasZero) {
                zeroIndex = end;
                hasZero =true;
            } else if(nums[end] == 0 && hasZero) {
                
                start = zeroIndex+1;
                zeroIndex = end;
                
            } 
            if(end-start > length) {
                length = end-start;
            }
            
            
        }
        
        
        return length;
    }
}