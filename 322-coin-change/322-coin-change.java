class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i = 0 ; i< dp.length; i++) {
            dp[i] = amount+1;
        }
        
        dp[0] = 0;
        int current = 0;
        
        while(++current <= amount) {
            for(int c : coins) {
                if(current-c >= 0) {
                    dp[current] = Math.min(dp[current], 1+ dp[current-c]);
                }
            }
        }
        
        return dp[amount] != amount +1 ? dp[amount] : -1;
    }
}