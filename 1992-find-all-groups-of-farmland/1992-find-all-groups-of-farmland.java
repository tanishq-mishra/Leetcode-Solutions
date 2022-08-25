class Solution {
    int x1, y1, x2, y2;
    
    public void helper(int[][] land, boolean[][] visited, int i, int j) {
        if(i <0 || j < 0 || i>=land.length || j >= land[0].length || visited[i][j] || land[i][j] == 0) {
            return;
        }
        
        visited[i][j] = true;
        x1 = Math.min(x1,i);
        y1 = Math.min(y1, j);
        x2 = Math.max(x2, i);
        y2 = Math.max(y2, j);
        
        
        helper(land, visited, i+1, j);
        helper(land, visited, i, j+1);
        helper(land, visited, i-1, j);
        helper(land, visited, i, j-1);

    }
    
    
    public int[][] findFarmland(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i<land.length; i++) {
            for(int j = 0; j<land[0].length; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    x1 = i;
                    y1 = j;
                    x2 = i;
                    y2 = j;
                    helper(land, visited, i, j);
                    res.add(new int[]{x1,y1,x2,y2});
                }
            }
        }

        return res.toArray(new int[0][]);
    }
}


// /* 0 1
//    1 0
   
   