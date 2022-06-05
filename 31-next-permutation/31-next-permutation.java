class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        
        while( i>0 && nums[i-1] >= nums[i]) {
            i--;
        }
        
        Arrays.sort(nums, i, nums.length);
        
        
        int swap = i-1;
        if(swap  == -1 ) 
            return;
        
        
        while(i < nums.length && nums[swap] >= nums[i]) {
            i++;
        }
        
        // if(i == nums.length) {
        //     return;
        // }
        int temp = nums[swap];
        nums[swap] = nums[i];
        nums[i] = temp;
        
    }
}