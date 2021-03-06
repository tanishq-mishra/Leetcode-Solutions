class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int currentProduct = 1;
        int result = 0;
        int i = 0;
        int j = 0;
        
        while(j < nums.length) {
            if(currentProduct*nums[j] < k) {
                currentProduct*=nums[j];
                result += (j-i)+1;
                j++;
            } else {
                currentProduct /= nums[i];
                if(i<j) {
                    i++;
                }else {
                    currentProduct = 1;
                    i++;
                    j = i;
                }
            }
        }
        return result;
    }
}