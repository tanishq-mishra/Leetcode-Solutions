class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m*n) {
            return new int[][]{};
        }
        int[][] ans = new int[m][n];
        
        int count = 0;
        for(int i = 0; i<m;i++) {
            
            for(int j = 0; j<n && i+j+count < original.length; j++) {
                ans[i][j] = original[i+j+count];
            }
            
            count += n-1;
            
        }
        
        return ans;
    }
}