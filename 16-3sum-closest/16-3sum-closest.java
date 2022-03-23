class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int currentClosest = nums[0] + nums[1] + nums[2];
        for(int i = 0; i< nums.length -2; i++) {
            int difference = target - nums[i];
            int j = i+1;
            int k = nums.length-1;
            while(j<k) {
                if(Math.abs(target - currentClosest) > Math.abs(target - (nums[i] + nums[j] + nums[k]))) {
                    currentClosest = nums[i] + nums[j] + nums[k];
                } 
                if( target > nums[i] + nums[j] + nums[k]) {
                    j++;
                } else {
                    k--;
                }
            }
            
            
        }
        return currentClosest;
    }
}