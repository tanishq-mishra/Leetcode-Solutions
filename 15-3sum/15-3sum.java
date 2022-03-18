class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        
        for(int i = 0 ; i<nums.length -2 ; i++) {
            int sum = nums[i] * -1;
            
            int left = i+1;
            int right = nums.length -1;    
            
            if(i == 0 || (i>0 && nums[i] != nums[i-1])) {
                while(left < right) {
                    if(nums[left] + nums[right] == sum) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < nums.length-1 && nums[left] == nums[left+1])
                            left++;
                        while(right > i && nums[right] == nums[right-1])
                            right--;
                        left++;
                        right--;
                        
                    } else if(nums[left] + nums[right] > sum) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
               
    }
}