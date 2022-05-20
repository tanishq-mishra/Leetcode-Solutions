class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i = 0; i<res.length;i++) {
            res[i] = (i%2)+res[i/2];
        }
        
        
        return res;
    }
}