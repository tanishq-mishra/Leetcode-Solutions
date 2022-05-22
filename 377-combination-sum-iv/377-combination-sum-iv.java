class Solution {
    
    public HashMap<Integer, Integer> memo = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        if(memo.containsKey(target)) {
            return memo.get(target);
        }
        if(target == 0) {
            return 1;
        }
        if(target <0) {
            return 0;
        }
        
        int res = 0;
        
        for(int i = 0; i< nums.length; i++) {
            
            res += combinationSum4(nums, target-nums[i]);
        }
        memo.put(target, res);
        
        return res;
        
    }
}