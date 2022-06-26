class Solution {
    // TOP DOWN DP with Memoisation
    public int[][] memo;
    public boolean helper(int sum, int[] nums, int index) { 
        if(memo[index][sum] != 0) {
            return memo[index][sum] == 1;
        }
        if(sum == 0) {
            return true;
        }
     
        if(index == nums.length-1) {
            return nums[index] == sum;
        }
        boolean noTake = helper(sum, nums, index+1);
        if(noTake) {
            return true;
        }
        boolean take = false;
        
        if(sum-nums[index] >=0) {
             take = helper(sum-nums[index], nums, index+1);
        }
        
        memo[index][sum] = noTake || take ? 1: -1;
        
        return noTake || take;
    }
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length;i++) {
            sum+=nums[i];
        }
        if(sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        memo = new int[nums.length][sum+1];
        
        return helper(sum, nums, 0);
    }
    
    // Converted Bottom Up DP
    
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for(int i = 0; i<nums.length;i++) {
//             sum+=nums[i];
//         }
//         if(sum % 2 != 0) {
//             return false;
//         }
//         sum /= 2; 
//         int[][] dp = new int[nums.length][sum+1];
        
//     }
}   