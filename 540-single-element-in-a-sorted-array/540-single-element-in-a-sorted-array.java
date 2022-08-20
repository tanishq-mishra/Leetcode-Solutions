class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int mid = (start + end)/2;
        
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums[0] != nums[1]) {
            return nums[0];
        }
        
        if(nums[end] != nums[end-1]) {
            return nums[end];
        }
        
        
        
        while(start < end) {
            
            if(nums[mid -1] != nums[mid] && nums[mid+1] != nums[mid]) {
                return nums[mid];
            }    
            
            // odd index 
            if(mid % 2 == 1) {
                if(nums[mid] != nums[mid+1]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                if(nums[mid] != nums[mid+1]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            
            mid = (start + end)/2;
        }
        
        
        return nums[start];
    }
}