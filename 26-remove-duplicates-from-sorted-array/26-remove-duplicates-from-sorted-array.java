class Solution {
    public int removeDuplicates(int[] nums) {
        int dups = 0;
        int i = 0;
        for(i = 1; i<nums.length; i++) {
            if(nums[i-1] == nums[i]) {
                dups++;
            }
            
            nums[i-dups] = nums[i];
        }
        
        
        return nums.length-dups;
    }
}