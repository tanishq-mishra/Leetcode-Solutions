class Solution {
    
    // Top-Down DP with Memo
    public int helper(List<List<Integer>> triangle, int i, int j, int[][] memo) {
        if(memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }
        if(i == triangle.size()-1) {
            return triangle.get(i).get(j);
        }
        
        int down = triangle.get(i).get(j) + helper(triangle, i+1, j, memo);
        int diagonal  = triangle.get(i).get(j) + helper(triangle, i+1, j+1, memo);
        memo[i][j] = Math.min(down, diagonal);
        return memo[i][j];
        
        
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        
        for(int[] m : memo) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }
        
        return helper(triangle, 0, 0, memo);
    }
    
    // Bottom-Up Conversion
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
         
//         int m = triangle.size();
//         int n = triangle.get(triangle.size()-1).size();
        
       
        
//         for(int i = m-1; i>=0; i--) {
//             for(int j = triangle.get(i).size()-1; j>=0; j--) {
//                 if(i == m-1) {
//                     dp[i][j] = triangle.get(i).get(j);
//                 } else {
//                     int down = triangle.get(i).get(j) + dp[i+1][j];
//                     int diagonal  = triangle.get(i).get(j) + dp[i+1][j+1];
//                     dp[i][j] = Math.min(down, diagonal);
//                 }
//             }
//         }
//         return dp[0][0];
//     }
    
    
    
}