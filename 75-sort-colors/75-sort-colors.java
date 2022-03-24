class Solution {
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        // Put the 2s to the right
        while(i < j) {
            while(i<j && nums[i] !=2 ) {
                i++;
            }
            while(j > i && nums[j] == 2) {
                j--;
            }
            
            if(i < j && nums[i] == 2 && nums[j] != 2) {
                swap(nums, i,j);
                i++;
                j--;
            } 
        }
        
        
        while(j > 0 && nums[j] == 2) {
            j--;
        }
        
        i = 0;
        
        // Sort 0s and 1s;
        while(i<j) {
            while(i<j && nums[i] == 0) {
                i++;
            }
            while(i<j && nums[j] == 1) {
                j--;
            }
            
            if(i<j && nums[i] == 1 && nums[j] == 0) {
                swap(nums,i,j);
                i++;
                j--;
            } else {
                break;
            }
        }
        
        
    }
}