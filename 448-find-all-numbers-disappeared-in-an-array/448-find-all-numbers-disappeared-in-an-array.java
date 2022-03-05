class Solution {
    
    
    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int i = 0;
        while(i<nums.length) {
            if(nums[i] <= nums.length && nums[i]-1 != i && nums[i] != nums[nums[i]-1]) {
                System.out.println(nums[i] +", "+ i);
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }
        
        List<Integer> output = new ArrayList<Integer>();
        
        
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1) {
                output.add(j+1);
            }
        }
        
        return output;
    }
}