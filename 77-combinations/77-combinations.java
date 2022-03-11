class Solution {
    HashMap<List<Integer>, Set<List<Integer>>> memo = new HashMap<>();
    public Set<List<Integer>> helper(List<Integer> seed, int k) {
        if(memo.containsKey(seed))
            return memo.get(seed);
        if(seed.size() == k) {
            Set<List<Integer>> ans = new HashSet<>();
            ans.add(new ArrayList<>(seed));
            return ans;
        }
        Set<List<Integer>> ans = new HashSet<>();
        for(int i = 0; i<seed.size(); i++) {
            int temp = seed.get(i);
            seed.remove(i);
            ans.addAll(helper(seed, k)); 
            seed.add(i, temp);
        }
        memo.put(seed, ans);
        return ans;
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> seed = new ArrayList<>();
        
        for(int i = 1; i<=n; i++) {
            seed.add(i);
        }
       
        List<Integer> ans = new ArrayList<>();
        
        
        return new ArrayList<>(helper(seed, k))  ;
    }
}