class NumArray {
    int[] nums;
    int total = 0;
    Map<int[], Integer> sums = new HashMap<>();

    public NumArray(int[] nums) {
        this.nums = nums;
        for(int i = 0; i<nums.length; i++) {
            total+= nums[i];
        }
        sums.put(new int[]{0,(nums.length-1)}, total);
    }
    
    public int sumRange(int left, int right) {
        if(sums.containsKey(new int[]{left,right})) {
            return sums.get(new int[]{left,right});
        }
        
        
        int sum = total ;
        
        for(int i = 0; i<left; i++) {
            sum-= nums[i];
        }
        for(int i = right+1; i<nums.length; i++) {
            sum-= nums[i];
        }
        sums.put(new int[]{left,right}, sum);
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */