class Solution {
    int currentArea = 0;
    public void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if(i <0 || j<0 || i>=grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        
        visited[i][j] = true;
        currentArea++;
        
        dfs(grid, visited, i+1, j);
        dfs(grid, visited, i, j+1);
        dfs(grid, visited, i-1, j);
        dfs(grid, visited, i, j-1);
                    
        
        
    }
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        
        for(int i = 0 ; i< grid.length; i++) {
            
            for(int j = 0; j< grid[0].length; j++) {
                
                if(grid[i][j] == 1 && !visited[i][j]) {
                    currentArea = 0;
                    dfs(grid, visited, i, j);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        
        
        return maxArea;
    }
}