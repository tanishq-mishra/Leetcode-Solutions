class Solution {
    
    public boolean helper(String s1, String s2, String s3, int i, int j, int k, int[][] cache)  {
        
        
        if(i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        if(i < s1.length() && j < s2.length() && cache[i][j] != 0) {
            return cache[i][j] == -1? false: true;
        }
        boolean left = false;
        boolean right = false;
        if( i != s1.length() && s1.charAt(i) == s3.charAt(k)) {
            left = helper(s1, s2, s3, i+1, j, k+1,cache);
        }
        
        
        if(j!= s2.length() && s2.charAt(j) == s3.charAt(k)) {
            right = helper(s1,s2, s3, i, j+1, k+1,cache);
        }
        
        cache[i][j] = left || right? 1: -1;
        
        return cache[i][j] == 1? true: false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] cache = new int[s1.length()+1][s2.length()+1];
        
        if(s1.length() +s2.length() != s3.length()) {
            return false;
        }
        return helper(s1, s2, s3, 0, 0, 0, cache);   
    }
}