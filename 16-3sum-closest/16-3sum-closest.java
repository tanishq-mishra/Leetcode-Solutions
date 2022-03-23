class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int currentClosest = nums[0] + nums[1] + nums[2];
        for(int i = 0; i< nums.length -2; i++) {
            int j = i+1;
            int k = nums.length-1;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) {
                    return sum;
                }
                if(Math.abs(target - currentClosest) > Math.abs(target - sum)){
                    currentClosest = sum;
                } 
                if( target > sum) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return currentClosest;
    }
}