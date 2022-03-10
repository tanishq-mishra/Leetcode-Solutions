class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int helper(int[] nums, int current) {
        if(memo.containsKey(current)) {
            return memo.get(current);
        }
        if(current == nums.length) {
            return 0;
        }
        if(current == nums.length-1 ) {
            return nums[current];
        }
        
        int max = Math.max( nums[current] + helper(nums, current+2), helper(nums, current+1));
        memo.put(current, max);
        return max;
        
        
    }
    public int rob(int[] nums) {
        // if(nums.length == 2) {
        //     return Math.max(nums[0], nums[1]);
        // }
        return helper(nums, 0);
    }
}