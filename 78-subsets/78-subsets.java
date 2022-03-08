class Solution {
    public List<List<Integer>> helper(List<Integer> p, int[] up) {
        if(up.length == 0) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(helper(new ArrayList<>(p), Arrays.copyOfRange(up, 1, up.length)));
        p.add(up[0]);
        ans.addAll(helper(new ArrayList<>(p), Arrays.copyOfRange(up,1, up.length)));
        return ans;
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        return helper(new ArrayList<Integer>(), nums);
    }
}