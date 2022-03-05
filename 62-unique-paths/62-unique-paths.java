class Solution {
    public HashMap<String, Integer> memo = new HashMap<>();
    public int helper(int x, int y, int m, int n) {
        String id = x + "," + y;
        if(memo.containsKey(id)) {
            return memo.get(id);
        }
        
        if(x == m && y == n) {
            return 1;
        }
        if(x>m) {
            return 0;
        }
        if(y>n) {
            return 0;
        }
        
        int sum = 0;
        
        sum += helper(x+1, y, m, n);
        sum += helper(x, y+1, m, n);
        
        memo.put(id, sum);
        
        return sum;
        
    }
    public int uniquePaths(int m, int n) {
        return helper(1,1, m, n);    
    }
}