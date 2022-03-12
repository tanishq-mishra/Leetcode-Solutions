// class Solution {
//     HashSet<List<Integer>> ans;
//     List<Integer> current;
//     public void helper(boolean[] selected, int[] candidates,int sum, int target, int i) {
//         if(target == sum) {
//             ans.add(new ArrayList<>(current));
//             return;
//         }
//         if(target < 0) {
//             return;
//         }
//         if(i == candidates.length) {
//             return;
//         }
        
//         if(!selected[i]) {
//             selected[i] = true;
//             current.add(candidates[i]);
//             sum += candidates[i];
//             helper(selected, candidates, sum, target, i+1);
//             sum -= candidates[i];
//             selected[i] = false;
//             current.remove(current.size()-1);
//         } 
//         if( i < selected.length -1 && sum + candidates[i+1] <= target) {
//              helper(selected, candidates, sum, target, i+1);
//         }
        
       
        
        
//     }
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         Arrays.sort(candidates);
//         boolean selected[] = new boolean[candidates.length];
//         ans = new HashSet<>();
//         current= new ArrayList<>();
//         helper(selected, candidates,0, target,0);
//         return new ArrayList<>(ans);
//     }
// }



class Solution {
    public void helper(int indx, int[] arr, int sum , List<List<Integer>> res, ArrayList<Integer> ds )
    {
        if(sum == 0)
        {
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i = indx;i<arr.length;i++)
        {   
            // skiping duplicates
            if(i > indx && arr[i] == arr[i-1]) 
                continue;
            if(arr[indx] > sum) break;
            
            ds.add(arr[i]);
            helper(i+1, arr, sum - arr[i],res, ds );
            ds.remove(ds.size() -1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(0, candidates, target, res, new ArrayList<>());
        return res;
    }
}