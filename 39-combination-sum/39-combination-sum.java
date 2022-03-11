class Solution {
    public void helper(List<Integer> selected, int[] candidates, int target,List<List<Integer>> ans) {
        if(target == 0) {
            List<Integer> newList = new ArrayList<>(selected);
            Collections.sort(newList);
            if(!ans.contains(newList))
                ans.add(newList);
            return;
        }
        if(target < 0) {
            return;
        }
        
        for(int i = 0; i< candidates.length; i++) {
            if(candidates[i] <= target) {
                selected.add(candidates[i]);
                helper(selected, candidates, target-candidates[i], ans);
                selected.remove(selected.size()-1);
            }
            
            
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        
        helper(new ArrayList<>(),candidates, target, ans);
        return ans;
    }
}