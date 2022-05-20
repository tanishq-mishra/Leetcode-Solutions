class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void helper(int k,  int n, List<Integer> combi ) {
        if(n == 0) {
            if(combi.size() == k) {
                res.add(new ArrayList<>(combi));
            }
            return;
        }
        if(combi.size()>=k) {
            return;
        }
        int start = combi.size() == 0 ? 1: combi.get(combi.size()-1)+1;
        for(int i =start ; i<=9 && i<=n; i++) {
                combi.add(i);
                helper(k, n-i, combi);
                combi.remove(combi.size()-1);
        }
    }
    
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k,  n, new ArrayList<>());
        
        return res;
        
    }
}