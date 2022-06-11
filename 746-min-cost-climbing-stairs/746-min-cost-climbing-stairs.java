class Solution {
    public int helper(int[] cost, int current, int[] memo) {
        if(current == cost.length-1) {
            return cost[current];
        }
        if(current >= cost.length) {
            return 0;
        }
        if(memo[current] != 0) {
            return memo[current];
        }
        
        int left = helper(cost, current+1, memo)+ cost[current];
        int right = helper(cost, current+2, memo)+ cost[current];
        
        memo[current] = Math.min(left, right);
        
        return memo[current];       
    }
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(helper(cost, 0, new int[cost.length]), helper(cost, 1, new int[cost.length]));
    }
}