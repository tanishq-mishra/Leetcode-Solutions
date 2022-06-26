class Solution {
    // TOP DOWN DP with Memoisation
//     public int[][] memo;
//     public boolean helper(int sum, int[] nums, int index) { 
//         if(memo[index][sum] != 0) {
//             return memo[index][sum] == 1;
//         }
//         if(sum == 0) {
//             return true;
//         }
     
//         if(index == nums.length-1) {
//             return nums[index] == sum;
//         }
//         boolean noTake = helper(sum, nums, index+1);
//         if(noTake) {
//             return true;
//         }
//         boolean take = false;
        
//         if(sum-nums[index] >=0) {
//              take = helper(sum-nums[index], nums, index+1);
//         }
        
//         memo[index][sum] = noTake || take ? 1: -1;
        
//         return noTake || take;
//     }
    
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for(int i = 0; i<nums.length;i++) {
//             sum+=nums[i];
//         }
//         if(sum % 2 != 0) {
//             return false;
//         }
//         sum /= 2;
//         memo = new int[nums.length][sum+1];
        
//         return helper(sum, nums, 0);
//     }
    
    
    
    // Converted Bottom Up DP
    /*
        1. Take the DP Array of same dimension and size.
        2. check the base cases (for every index if sum == 0 , return true. or if the sum == nums[index] return true)
        3. Determine the number of nested loops based on the changing parameters (2 changing parameters, therefore 2 nested loops) in reverse direction
    */
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length;i++) {
            sum+=nums[i];
        }
        if(sum % 2 != 0) {
            return false;
        }
        sum /= 2; 
        boolean[][] dp = new boolean[nums.length][sum+1];
        for(int i = 0 ; i<nums.length; i++) {
            dp[i][0] = true;
            
        }
        for(int i = nums.length-2; i>=0; i--) {
             for(int target = 1; target <=sum; target++) {
                 
                boolean noTake = dp[i+1][target];
                boolean take = false;
                if(target-nums[i] >=0) {
                     take = dp[i+1][target-nums[i]];
                }
                
                dp[i][target] = noTake || take;
             }
        }
        
        return dp[0][sum];
    }
}   