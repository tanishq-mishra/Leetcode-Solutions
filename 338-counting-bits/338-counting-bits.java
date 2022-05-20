class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        int num;
        for(int i = 0; i<res.length;i++) {
            num = i;
            
            res[i] = (num%2)+res[num/2];
        }
        
        
        return res;
    }
}