class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        
        for(int i = 0 ; i<lis.length; i++) {
            lis[i] = 1;
        }
        
        for(int i = nums.length -2; i>=0; i--) {
            int largest = 1;
            for(int j = i+1 ; j< nums.length; j++) {
                
                if(nums[j] > nums[i]) {
                    int current = 1+lis[j];
                    
                    largest = Integer.max(current, largest);
                }
                
            }
            lis[i] = largest;
        }
        
        int largest = lis[0];
        for(int l : lis) {
            largest = Integer.max(largest, l);
        }
        
        
        return largest;
    }
}