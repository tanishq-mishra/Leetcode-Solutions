class Solution {
    public void shift (int[] nums, int start, int end) {
         for(int i = start; i<end-1; i++) {
             nums[i] = nums[i+1];
         }
        
        
    }
    public int removeDuplicates(int[] nums) {
        int dups = 0;
        int i = 0;
        while(i<nums.length-dups-1) {
            if(nums[i] == nums[i+1]) {
                shift(nums, i, nums.length-dups);
                dups++;
            } else {
                i++;
            }
        }
        
        
        return nums.length-dups;
    }
}