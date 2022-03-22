class Solution {
    boolean[][] visited;
    
    public void dfs(int i, int j, char[][] grid) {
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0) {
            return;
        }
        
        visited[i][j] = true;
        if(grid[i][j] == '1') {
            if(i+1 < grid.length && !visited[i+1][j])
                dfs(i+1, j, grid);
            
            if(j+1 < grid[0].length && !visited[i][j+1])
                dfs(i, j+1, grid );
            
            if(i-1 >=0 && !visited[i-1][j])
                dfs(i-1, j, grid);
            
            if(j-1 >= 0  && !visited[i][j-1])
                dfs(i, j-1, grid);
        }
    }
    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for(int i =0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i,j, grid);
                    islands++;
                }
            }
        }
        
        return islands;
    }
}