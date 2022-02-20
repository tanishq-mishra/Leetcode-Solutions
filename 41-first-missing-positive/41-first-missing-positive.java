class Solution {
    public static void swap(int[] nums, int first,int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int size = nums.length;
        int missingNumber = 1;
        while(i < size) {
            if(nums[i] <= size && nums[i] > 0 && nums[i] != i+1) {
                if(nums[i] != nums[nums[i]-1]) {
                    Solution.swap(nums, i, nums[i] -1);
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        i = 0;
        while(i <size) {
            if(nums[i] != i+1) {
                return i+1;
            }
            i++;
        }
        
       return size +1;
    }
    
}