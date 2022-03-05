class Solution {
    public int helper(int m, int n, int[][] memo) {
        if(memo[m][n] != -1) {
            return memo[m][n];
        }
        
        if(m<1 || n<1) {
            return 0;
        }
        
        if(m==1 && n == 1) {
            return 1;
        }
        
        int sum = 0;
        
        sum = helper(m-1, n,memo) + helper( m, n-1,memo);;
        memo[m][n] = sum;
        
        return sum;
        
    }
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m+1][n+1];
        for(int[] me : memo) {
            Arrays.fill(me, -1);
        }
        
        return helper(m, n, memo );    
    }
}