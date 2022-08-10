class Solution {
    // brute force (O(n+m)^2)
//     public void shift(int[] nums, int start, int end) {
//         int i = end;
//         while(i > start) {
//             nums[i] = nums[i-1];
//             i--;
//         }
//     }
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int i = 0;
//         int j = 0;
//         for(int k = m; k<nums1.length;k++) {
//             nums1[k] = Integer.MAX_VALUE;
//         }
//         while(i<m+n && j < n) {
            
//             if(nums1[i] > nums2[j]) {
                
//                 //shift right;
//                 shift(nums1, i, nums1.length-1);
//                 nums1[i] = nums2[j];
//                 j++;
//             } else {
//                 i++;
//             }
//         }

//     }
    
    // Linear time (O(n+m))
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = nums1.length-1;
        
        while(i>=0 && j>=0) {
            if(nums2[j] > nums1[i]) {
                nums1[k--] = nums2[j--]; 
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        
        // if there are remaining elements in nums2 that have not been added yet.
        while(j>=0) {
            nums1[k--] = nums2[j--];
        }
    }
    
    
}