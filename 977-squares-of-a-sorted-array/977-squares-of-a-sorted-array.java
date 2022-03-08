class Solution {
    public void reverse(int[] num) {
        for(int i=0; i< num.length/2; i++) {
                int temp = num[i];
                num[i] = num[num.length-i-1];
                num[num.length-i-1] = temp;
            }
    }
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        
        while( i < nums.length && nums[i] < 0) {
            i++;
        }
        int[] firstHalf =  Arrays.copyOfRange(nums, 0, i);
        if(i>0) {
            reverse(firstHalf);
            for(int j = 0 ; j<firstHalf.length; j++) {
                firstHalf[j] *= firstHalf[j];
            }            
        }
        
        
        
        for(int j = i; j<nums.length; j++) {
            nums[j] *= nums[j];
        }
        if(firstHalf.length == 0) {
            return nums;
        }
        
        
        
        int[] ans  = new int[nums.length];
        int a = 0;
        int b = i;
        int c = 0;
        while(a<firstHalf.length && b<nums.length) {
            if(firstHalf[a] < nums[b]) {
                ans[c++] = firstHalf[a++];
            } else {
                ans[c++] = nums[b++];
            }
        }
        
         while(a<firstHalf.length) {
                ans[c++] = firstHalf[a++];
        }
        
        while(b<nums.length) {
         
                ans[c++] = nums[b++];
        }
        
        
        
        return ans;
    }
}