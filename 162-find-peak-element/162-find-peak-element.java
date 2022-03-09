class Solution {
    public int findPeakElement(int[] arr) {
      int start = 0;
      int end = arr.length -1; 
      int mid = start + (end - start)/2;
      int peak = 0;
      while(start < end) {
        if(arr[mid] > arr[mid + 1]) {
          end = mid;
        } else if(arr[mid] < arr[mid +1]) {

          start = mid + 1;

        }
        mid = start + (end - start)/2;
      }

      return end;
        
    }
}