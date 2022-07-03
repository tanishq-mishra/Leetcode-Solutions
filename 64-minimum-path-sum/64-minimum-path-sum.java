class Solution {
    // Top Down DP with memo
//     public int helper(int[][] grid , int i, int j, int[][] memo) {
//         if(memo[i][j] != -1) {
//             return memo[i][j];
//         }
//         if(i == 0 && j == 0) {
//             return grid[i][j];
//         }
        
//         int left = Integer.MAX_VALUE;
//         int up = Integer.MAX_VALUE;
        
//         if(j > 0) {
//             left = Math.min(helper(grid, i, j-1, memo)+grid[i][j], left);
//         }
        
//         if(i > 0) {
//             up = Math.min(helper(grid, i-1, j, memo)+grid[i][j], up);
//         }
//         memo[i][j] = Math.min(left, up);
//         return memo[i][j];
//     }
    
//     public int minPathSum(int[][] grid) {
//         int[][] memo = new int[grid.length][grid[0].length];
        
//         for(int[] m : memo) {
//             Arrays.fill(m, -1);
//         }
//         return helper(grid, grid.length-1, grid[0].length-1, memo);
//     }
    
    // Bottom-up DP conversion
    // create dp of same size as memo
    // fill the dp with the base cases
    // create loops corresponding to the parameters 
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        
        for(int[] d :dp) {
            Arrays.fill(d, 1000000);
        }
        
        // base case
        dp[0][0] = grid[0][0];
        
        
        // loops corresponding to the states in reverse order
        // i : 0 -> grid.length , j : 0 ->grid[0].length
        for(int i = 0 ; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                // copy the recurrance 
                
                if(i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                    
                } else {
                    int left = Integer.MAX_VALUE;
                    int up = Integer.MAX_VALUE;
                
                    if(j > 0) {
                        left = Math.min(dp[i][j-1]+grid[i][j], left);
                    }
                    if(i > 0) {
                        up = Math.min(dp[i-1][j] + grid[i][j], up);
                    }
                    dp[i][j] = Math.min(left, up);
                }
                
                
            }
        }
        
        return dp[grid.length-1][grid[0].length-1];
        
    }
}