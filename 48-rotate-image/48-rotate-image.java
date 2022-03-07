class Solution {
    public void rotate(int[][] matrix) {
        int i = 0;
        int size = matrix.length;
        while(i<=matrix.length/2) {
            int j = i;
            
            while(j<matrix.length-i-1) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[size-j-1][i];
                matrix[size-j-1][i] = matrix[size-i-1][size-j-1];
                matrix[size-i-1][size-j-1] = matrix[j][size-i-1];
                matrix[j][size-i-1] = temp;
                j++;
            }
            
            i++;
        }
    }
}