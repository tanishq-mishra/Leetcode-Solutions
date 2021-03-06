class Solution { 
    
    public int helper(int[][] obstacleGrid, int i, int j, int[][] memo) {
        if(i<0 || j<0 || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        if(i == 0  && j == 0) {
            return 1;
        }
        int left = helper(obstacleGrid, i-1, j,memo);
        int up = helper(obstacleGrid, i, j-1,memo);
        memo[i][j] = left+up;
        return memo[i][j];
    }
    
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return helper(obstacleGrid, obstacleGrid.length-1,obstacleGrid[0].length-1, memo);
    }
}