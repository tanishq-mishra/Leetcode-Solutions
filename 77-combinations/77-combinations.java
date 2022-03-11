class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> path = new LinkedList<>();
        
        dfs(n, k, 1, path);
        
        return res;
    }
    
    private void dfs(int n, int k, int start, LinkedList<Integer> path) {
        if(path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }
        
        for(int i = start; i <= n; i++) {
            path.add(i);
            
            dfs(n, k, i + 1, path);
            
            path.removeLast();
        }
    }
}