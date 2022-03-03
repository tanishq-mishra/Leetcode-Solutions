class Solution {
    public static HashMap<Integer, Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        if(n ==0) {
            return 1;
        } 
        if(n<0) {
            return 0;
        }
        int fromBelowCalls;
        
        fromBelowCalls = climbStairs(n-1) + climbStairs(n-2);
        memo.put(n, fromBelowCalls);
        
        return memo.get(n);
        
    }
}