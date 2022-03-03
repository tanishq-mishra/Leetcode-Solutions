class Solution {
    HashMap<String,Integer> memo = new HashMap<>();
    public int helper(int[] nums, int target, int index, int sum) {
        String memoKey = sum + "," + index;
        
        if(memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }
        
        if(index == nums.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        
        int fromBelowCalls = 0;
        fromBelowCalls +=helper(nums, target, index+1 , sum + nums[index]);
        fromBelowCalls += helper(nums, target, index+1, sum - nums[index]);
        memo.put(memoKey, fromBelowCalls);
        return fromBelowCalls;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }
}