class Solution {
    // Memoization
//     public int helper(int[] nums, int idx, int[] memo) {
//         if(idx == nums.length-1) {
//             return 0;
//         }
//         if(memo[idx] != -1) {
//             return memo[idx];
//         }
//         if(nums[idx] == 0) {
//             return 1000000;
//         }
        
//         int min = Integer.MAX_VALUE;
//         for(int i = 1; i<=nums[idx] && i+idx< nums.length;i++) {
            
//             min = Math.min(helper(nums, idx+i, memo)+1, min);
//         }
//         memo[idx] = min;
//         return min;
//     }
//     public int jump(int[] nums) {
//         int[] memo = new int[nums.length];
//         Arrays.fill(memo, -1);
//         return helper(nums, 0, memo);
//     }
    
    // converted tabulation
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        
        
        for ( int i = nums.length-2; i>=0; i--) {
            
            int min = 1000000;
            for(int j = 1; j<=nums[i] && j+i< nums.length;j++) {

                min = Math.min(dp[j+i]+1, min);
            }
            dp[i] = min;
            
        }
        return dp[0];
    }
}