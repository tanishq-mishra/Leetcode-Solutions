// class Solution {
//     public int reversePairs(int[] nums) {
//         // brute force
//         int counter = 0;
//         for(int i = 0; i< nums.length-1; i++) {
//             for(int j = i+1; j<nums.length; j++) {
//                 if(nums[i] - nums[j] > nums[j])
//                         counter++;
//             }
//         }
//         return counter;
//     }
// }

// using merge sort (nlogn)
class Solution {
    int reverseCounter = 0;
    public void  merge(int[] nums, int start, int mid, int end)  {
        int[] res = new int[end-start+1];
        
        int i = start;
        int j = mid+1;
        int k = 0;
        // checking inversions
        // the left half and the right half are sorted. 
        // if(nums[k] > 2* nums[j]) then nums[i] > 2*nums[j], where i>=k;
        // that's why we can directly add all the elements that are left of nums[j] in the 2nd half directly without recounting.
        for(i = start; i<=mid;i++) {
            while(j<=end && nums[i] > (2 * (long) nums[j])) {
                j++;
            }
            reverseCounter += (j-(mid+1));
        }
        
        
        i = start;
        j = mid+1;
        k = 0;
        
        // sorting
        while(i<= mid && j <=end) {
            if(nums[i] < nums[j]) {
                res[k++] = nums[i++];
            } else {
                res[k++] = nums[j++];
            }
        }
        
        while(i<= mid) {
            res[k++] = nums[i++];
        }
        
        while(j<=end) {
            res[k++] = nums[j++];
        }
        
        i = start;
        k = 0;
        while(i<=end) {
            nums[i++] =res[k++]; 
        }
        
    }
    public void mergeSort(int[] nums, int start, int end)  {
        if(start < end) {
            int mid  = (start +end)/2;
            //System.out.println("Start: " + start + "   End: " + end);
            mergeSort(nums, start, mid);
            mergeSort(nums, mid+1, end);
            merge(nums, start, mid, end);
        }
    }
    
    public int reversePairs(int[] nums) {
        mergeSort(nums,0, nums.length-1);
        return reverseCounter;
    }
}