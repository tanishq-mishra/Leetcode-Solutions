class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        HashMap<Integer, Integer> memo = new HashMap<>();
        for(int i = 0; i<res.length;i++) {
            int sum = 0;
            int num = i;
            
            while(num >0) {
                if(memo.containsKey(num)) {
                    sum+=memo.get(num);
                    break;
                }
                sum = sum + (num%2);
                num /=2;
            }
            memo.put(i, sum);
            res[i] = sum;
        }
        
        
        return res;
    }
}