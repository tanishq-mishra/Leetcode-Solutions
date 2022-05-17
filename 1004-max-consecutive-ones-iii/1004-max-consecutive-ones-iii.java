class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int max = 0;
        int flipped = 0;
        
        while(end < nums.length) {
            if(nums[end] == 1) {
                end++;
                
            } else if(nums[end] == 0) {
                if(flipped < k) {
                    end++;
                    flipped++;
                } else if(flipped == k) {
                    if(nums[start] == 0) {
                        start++;
                        flipped--;
                    } else {
                        start++;
                    }
                }
            }
                
            max = Math.max(end-start, max);
            
        }
        
        
        return max;
    }
}


/*
k = 3;
flipped = 3
size = 5
0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1


k = 2;
flipped = 0
start = 0
end = 4;
[1,1,1,0,0,0,1,1,1,1,0]

*/