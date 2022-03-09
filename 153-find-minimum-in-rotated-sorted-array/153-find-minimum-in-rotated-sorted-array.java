class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        int mid = start + (end - start)/2;
        int maxIndex = 0;
        while(start <= end) {
            if(nums[start] <= nums[mid]) {
                if(nums[maxIndex] < nums[mid]) {
                    maxIndex = mid;
                }
                start = mid+1;
                
            } else if(nums[start] > nums[mid]) {
                if(nums[end] > nums[mid]) {
                    end = mid-1;
                }
            }
            mid = start + (end - start)/2;
        }
        
        return nums[(maxIndex + 1)%nums.length];
    }
}