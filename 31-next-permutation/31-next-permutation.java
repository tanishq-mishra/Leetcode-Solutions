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


// [1,2,3,4,5] 
// [1,2,3,5,4]
// [1,2,4,3,5]
// [1,2,4,5,3]
// [1,2,5,3,4]
// [1,2,5,4,3]
// [1,3,2,4,5]
// [1,3,2,5,4]
// [1,3,4,2,5]
// [1,3,4,5,2]
// [1,3,5,2,4]
// [1,3,5,4,2]
// [1,4,2,3,5]
// [1,4,2,5,3]
// [1,4,3,2,5]
// [1,4,3,5,2]
// [1,4,5,2,3]
// [1,4,5,3,2]