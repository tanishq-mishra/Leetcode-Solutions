class Solution {
    public HashMap<Integer, HashMap<Integer, Boolean>> memo = new HashMap<>();
    public boolean helper(int sum, int[] nums, int index) { 
        if(memo.containsKey(index)) {
            if(memo.get(index).containsKey(sum)) {
                return memo.get(index).get(sum);
            }
        }
        if(sum == 0) {
            return true;
        }
     
        if(index == nums.length-1) {
            return nums[index] == sum;
        }
        boolean noTake = helper(sum, nums, index+1);
        if(noTake) {
            return true;
        }
        boolean take = false;
        
        if(sum-nums[index] >=0) {
             take = helper(sum-nums[index], nums, index+1);
        }
        
        HashMap<Integer, Boolean> temp = memo.getOrDefault(index, new HashMap<>());
        temp.put(sum, noTake || take);
        memo.put(index, temp);
        
        return noTake || take;
    }
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length;i++) {
            sum+=nums[i];
        }
        if(sum % 2 != 0) {
            return false;
        }
        
        sum /= 2;
        
        
        
        return helper(sum, nums, 0);
    }
}   