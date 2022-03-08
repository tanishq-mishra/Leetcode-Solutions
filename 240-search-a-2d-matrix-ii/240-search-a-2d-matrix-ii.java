class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int c = n-1;
        while(r<m && c >=0) {
            if(matrix[r][c] == target) {
                return true;
            } else if(matrix[r][c] > target) {
                while(c >=0 && matrix[r][c] > target) {
                    c--;
                }
            } else if( matrix[r][c] < target)  {
                while(r<m && matrix[r][c] < target) {
                    r++;
                }
            }
        }
        
        
        return false;
    }
}