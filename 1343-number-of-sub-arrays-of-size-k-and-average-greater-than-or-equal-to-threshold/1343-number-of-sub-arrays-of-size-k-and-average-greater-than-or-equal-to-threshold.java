class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int start = 0;
        int end = -1;
        int sum = 0;
        int count = 0;
        while(end<k-1) {
            sum+=arr[++end];
        }
        
        while(end < arr.length-1) {
            if(sum/k >= threshold) {
                count++;
            }
            sum-= arr[start++];
            sum+= arr[++end];
        }
        
        if(sum/k >= threshold) {
                count++;
            }
        return count;
    }
}