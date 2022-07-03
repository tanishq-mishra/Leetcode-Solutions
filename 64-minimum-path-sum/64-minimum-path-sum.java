class Solution {
    
    public int helper(int[][] grid , int i, int j, int[][] memo) {
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        if(i == 0 && j == 0) {
            return grid[i][j];
        }
        
        int left = Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE;
        
        if(j > 0) {
            left = Math.min(helper(grid, i, j-1, memo)+grid[i][j], left);
        }
        
        if(i > 0) {
            up = Math.min(helper(grid, i-1, j, memo)+grid[i][j], up);
        }
        memo[i][j] = Math.min(left, up);
        return memo[i][j];
    }
    
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        
        for(int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return helper(grid, grid.length-1, grid[0].length-1, memo);
    }
}