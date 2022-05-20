class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        
        for(int i = 0; i<res.length;i++) {
            int sum = 0;
            int num = i;
            
            while(num >0) {
                sum = sum + (num%2);
                num /=2;
            }
            res[i] = sum;
        }
        
        
        return res;
    }
}