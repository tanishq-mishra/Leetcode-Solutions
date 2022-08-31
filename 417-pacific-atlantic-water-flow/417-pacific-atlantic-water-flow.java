class Solution {
    public boolean pacific = false;
    public boolean atlantic = false;
    
    public void helper(int[][] heights, boolean[][] visited, int i, int j) {
        if(pacific && atlantic) {
            return;
        }
        if(i < 0 || j<0 ) {
            pacific = true;
            return;
        }
        
        if( i == heights.length || j == heights[0].length) {
            atlantic = true;
            return;
        }
        
        if(visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
        
        if(i+1 == heights.length || heights[i+1][j] <= heights[i][j])
            helper(heights, visited, i+1,j);
        
        if(i-1 < 0 || heights[i-1][j] <= heights[i][j])
            helper(heights, visited, i-1,j);
        
        if(j+1 == heights[0].length || heights[i][j+1] <= heights[i][j])
            helper(heights, visited, i,j+1);
        
        if(j-1 < 0 || heights[i][j-1] <= heights[i][j])
            helper(heights, visited, i,j-1);
        
        visited[i][j] = false;
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        for(int i = 0; i< heights.length; i++) {
            for(int j = 0 ; j< heights[0].length; j++) {
                pacific = false;
                atlantic = false;
                
                helper(heights, visited, i, j);
                
                if(pacific && atlantic) {
                    List<Integer> coord = new ArrayList<>();
                    coord.add(i);
                    coord.add(j);
                    res.add(coord);
                }
            }
        }
        
        
        
        return res;
        
    }
}