class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        
        Arrays.fill(lis, 1);
        
        for(int i = nums.length -2; i>=0; i--) {
            for(int j = i+1 ; j< nums.length; j++) {
                
                if(nums[j] > nums[i]) {
                    lis[i] = Integer.max(lis[i], lis[j] +1);
                }
            }
        }
        
        int largest = lis[0];
        for(int l : lis) {
            largest = Integer.max(largest, l);
        }
        
        
        return largest;
    }
}