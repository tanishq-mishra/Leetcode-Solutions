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
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int[] nums1 = new int[nums.length-1];
        int[] nums2 = new int[nums.length-1];
        int x = 0;
        int y = 0;
        for(int i = 0; i<nums.length; i++) {
            if(i == 0) {
                nums1[x++] = nums[i];
            } else if(i == nums.length-1) {
                nums2[y++] = nums[i];
            } else {
                nums1[x++] = nums[i];
                nums2[y++] = nums[i];
            }
        }
        //System.out.println(helper(nums2, 0));
        
        int max = 0;
            
        max = Math.max(helper(nums1,0),max);
        memo.clear();
        max = Math.max(helper(nums2, 0), max);
        return max;
    }
}