class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void helper(int k, boolean[] used, int n, List<Integer> combi ) {
        if(n == 0) {
            if(combi.size() == k) {
                res.add(new ArrayList<>(combi));
            }
            return;
        }
        
        if(n<0) {
            return;
        }
        int start = combi.size() == 0 ? 1: combi.get(combi.size()-1)+1;
        
        for(int i =start ; i<=9 && i<=n; i++) {
            if(!used[i]) {
                used[i] = true;
                combi.add(i);
                helper(k, used, n-i, combi);
                combi.remove(combi.size()-1);
                used[i]=false;
            }
        }
    }
    
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k, new boolean[10], n, new ArrayList<>());
        
        return res;
        
    }
}