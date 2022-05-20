class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        //HashMap<Integer, Integer> memo = new HashMap<>();
        for(int i = 0; i<res.length;i++) {
            int sum = 0;
            int num = i;
            
            sum = (num%2);
            num /=2;
            sum+=res[num];
            
            res[i] = sum;
        }
        
        
        return res;
    }
}