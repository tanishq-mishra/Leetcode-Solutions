class Solution {
    public boolean canJump(int[] nums) {
        int currentIndex = 0;
        
        while(currentIndex < nums.length-1) {
            int jumpsAllowed = nums[currentIndex];
            if(jumpsAllowed == 0) {
                return false;
            }
            int maxDist = -1;
            int nextIndex = -1;
            if(currentIndex+ jumpsAllowed >= nums.length)
                return true;
            for(int i = currentIndex+1 ; i<= currentIndex + jumpsAllowed; i++) {
                if(maxDist < i+nums[i]) {
                    nextIndex = i;
                    maxDist = i+nums[i];
                }
                
            }
            if(nextIndex == -1) {
                return false;
            }
            currentIndex = nextIndex;
        }
        
        
        return true;
        
    }
}