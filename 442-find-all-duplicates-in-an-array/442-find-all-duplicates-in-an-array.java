class Solution {
    public static void swap(int[] nums,int first,int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while(i<nums.length) {
            if(nums[i] != i +1) {
                if(nums[i] != nums[nums[i] -1]) {
                    swap(nums, i,  nums[i] -1);
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        
        for(i = 0; i< nums.length; i++) {
            if(nums[i] != i+1) {
                ans.add(nums[i]);
            }
        }
        
        return ans;
    }
}