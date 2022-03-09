class Solution {
    public int findPeakElement(int[] arr) {
      int start = 0;
      int end = arr.length -1; 
      int mid = start + (end - start)/2;
      int peak = 0;
      while(start < end) {
        if(arr[mid] > arr[mid + 1]) {

          //peak = arr[mid] > arr[peak] ? mid : peak;
          end = mid;

        } else if(arr[mid] < arr[mid +1]) {

          //peak = arr[mid+1] > arr[peak] ? mid+1 : peak;
          start = mid + 1;

        }
        mid = start + (end - start)/2;
      }

      return end;
        
    }
}