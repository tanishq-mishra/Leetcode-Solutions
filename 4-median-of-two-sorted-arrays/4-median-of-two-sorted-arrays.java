class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        
        int start = 0;
        int end = nums1.length-1;
        int mid = (start + end)/2;
        int totalLength = nums1.length + nums2.length;
        int halfLength = totalLength/2;
        
        while(true) {
            
            mid = (int)Math.floor((start + end)/2.0);
            int mid2 = halfLength - mid - 2;
            System.out.println(mid2);
            int nums1Left = mid<0 ? Integer.MIN_VALUE: nums1[mid];
            int nums1Right = mid+1>=nums1.length ? Integer.MAX_VALUE : nums1[mid+1];
            int nums2Left = mid2<0 ? Integer.MIN_VALUE: nums2[mid2];
            int nums2Right = mid2+1>=nums2.length ? Integer.MAX_VALUE : nums2[mid2+1];
            
            if(nums1Left <= nums2Right && nums2Left <= nums1Right){
                int leftMax = Math.max(nums1Left, nums2Left);
                int rightMin = Math.min(nums1Right, nums2Right);
                if(totalLength %2 == 0) {
                    return (leftMax + rightMin)/2.0d;
                    
                    
                } else {
                    return (double)rightMin;
                }
            }  else if(nums1Left > nums2Right) {
                end = mid-1;
                
            } else {
                start = mid+1;
            }
        }
        
    }
}