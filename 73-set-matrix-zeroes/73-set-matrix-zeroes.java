class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> columns = new HashSet<>();
        
        
        for(int i = 0; i< matrix.length; i++) {
            for(int j = 0; j< matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                    
                }
            }
        }
        
        
        for(int r: rows) {
         
            for(int i = 0; i<matrix[0].length; i++) {
                matrix[r][i] = 0;
            }
        }
        for(int c: columns) {
            for(int i = 0; i<matrix.length; i++) {
                matrix[i][c] = 0;
            }
        }

    }
}