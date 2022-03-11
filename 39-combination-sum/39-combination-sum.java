// class Solution {
//     public void helper(List<Integer> selected, int[] candidates, int target,List<List<Integer>> ans) {
//         if(target == 0) {
//             List<Integer> newList = new ArrayList<>(selected);
//             Collections.sort(newList);
//             if(!ans.contains(newList))
//                 ans.add(newList);
//             return;
//         }
//         if(target < 0) {
//             return;
//         }
        
//         for(int i = 0; i< candidates.length; i++) {
//             if(candidates[i] <= target) {
//                 selected.add(candidates[i]);
//                 helper(selected, candidates, target-candidates[i], ans);
//                 selected.remove(selected.size()-1);
//             }
            
            
//         }
//     }
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         Arrays.sort(candidates);
//         List<List<Integer>> ans = new ArrayList<>();
        
//         helper(new ArrayList<>(),candidates, target, ans);
//         return ans;
//     }
// }


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        CSUtil(0,candidates, target,result, new ArrayList<>());
        
        return result;
    }
    
    public void CSUtil(int index, int[] candidates, int target, List<List<Integer>> result, ArrayList<Integer> temp){
        if(index == candidates.length){
            if(target == 0){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        
        if(candidates[index] <= target){
        // Pick
        temp.add(candidates[index]);
        CSUtil(index, candidates, target-candidates[index], result, temp);
        
        temp.remove(temp.size()-1);
        }
        
        // Non pick
        CSUtil(index+1, candidates, target, result, temp);
        
    }
}