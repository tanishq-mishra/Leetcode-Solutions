class Solution {
    public HashMap<String, Integer> memo = new HashMap<>();
    public int helper(int m, int n) {
        if(m<1 || n<1) {
            return 0;
        }
        String id = m + "," + n;
        
        if(memo.containsKey(id)) {
            return memo.get(id);
        }
        
        if(m==1 && n == 1) {
            return 1;
        }
        
        
        
        int sum = 0;
        
        sum = helper(m-1, n) + helper( m, n-1);;
        memo.put(id, sum);
        
        return sum;
        
    }
    public int uniquePaths(int m, int n) {
        return helper(m, n);    
    }
}