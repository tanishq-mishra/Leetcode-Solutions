class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = start + (end - start)/2; 
        
        while(start <= end) {
            mid = start + (end - start)/2; 
            //System.out.println(start + ","+ mid+ ","+ end);
            if(nums[mid] == target) {
                return mid;
            } else if(nums[start] == target) {
                return start;
            } else if(nums[end] == target) {
                return end;
            }
            else {
                if(nums[start] <= nums[mid]) {
                    
                    if(nums[start] < target && nums[mid] > target) {
                        end = mid-1;
                    } else {
                        start = mid+1;
                    }
                } else {
                    
                    if(nums[start] > target && nums[mid] < target) {
                        start = mid+1;
                    } else if (nums[start] > target && nums[mid] > target) {
                        end = mid-1;
                    }else {
                        end = mid-1;
                    }
                    
                }
            }
        }
        
        return -1;
    }
}