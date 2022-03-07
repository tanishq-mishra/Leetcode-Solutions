class Solution {
    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;

    }
    public int findDuplicate(int[] nums) {
        //cyclic sort;
        int i = 0;
        while(i<nums.length) {
            if(nums[i] != i +1) {
                if(nums[i] != nums[nums[i] -1]) {
                    swap(nums, i,  nums[i] -1);
                }
                else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        // for(i = 0; i< nums.length; i++) {
        //     if(nums[i] != i +1) {
        //         return nums[i];
        //     }
        // }
        
        return -1;
    }
}