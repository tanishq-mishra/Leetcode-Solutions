class Solution {
    
    public int helper(int[][] metrix, int i, int j, int[][] memo) {
        if(memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }
        if(i == metrix.length-1) {
            
            return metrix[i][j];
        }
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if(j > 0) {
            left = metrix[i][j] + helper(metrix, i+1, j-1,memo);
        }
        if(j < metrix[0].length-1) {
            right = metrix[i][j] + helper(metrix, i+1, j+1,memo);
        }
        
        down = metrix[i][j] + helper(metrix, i+1, j, memo);
        
        memo[i][j] = Math.min(left, Math.min(right, down));
    
        return memo[i][j];
    }
    public int minFallingPathSum(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        
        for(int[] m : memo) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<matrix[0].length; i++) {
            min = Math.min(min, helper(matrix, 0, i, memo));
        }
        
        return min;
    }
}