class NumArray {
    int[] nums;
    int total = 0;

    public NumArray(int[] nums) {
        this.nums = nums;
        for(int i = 0; i<nums.length; i++) {
            total+= nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        int sum = total;
        
        for(int i = 0; i<left; i++) {
            sum-= nums[i];
        }
        for(int i = right+1; i<nums.length; i++) {
            sum-= nums[i];
        }
        
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */