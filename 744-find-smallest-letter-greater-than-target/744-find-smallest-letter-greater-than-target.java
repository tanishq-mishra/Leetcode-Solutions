class Solution {
    public char nextGreatestLetter(char[] nums, char target) {
        int start = 0;
        int end = nums.length-1;
        int mid= start + (end - start)/2;
        while(start <= end) {
            if(nums[mid] > target) {
                end = mid-1;
                
            } else {
                start = mid +1;
            }
            mid= start + (end - start)/2;
        }
        
        return nums[start % nums.length];
    }
}