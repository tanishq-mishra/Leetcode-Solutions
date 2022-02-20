/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public static int peakIndexInMountainArray(MountainArray arr) {
        int start = 0;
        int end = arr.length() -1; 
        int mid = start + (end - start)/2;
        int peak = 0;
        
        while(start < end) {
            if(arr.get(mid) > arr.get(mid +1)) {
                end = mid;
            } else if(arr.get(mid)< arr.get(mid + 1)) {
                start = mid + 1;
            }
            mid = start + (end - start)/2;
        }

        return end;
    }
    
    public static int binarySearch(int start, int end, MountainArray arr,int target, boolean desc) {
        int mid = start + (end - start)/2;
        
        while(start <= end) {
            if(arr.get(mid) == target) {
                return mid;
            } else if(arr.get(mid) > target) {
                if(!desc) {
                    end = mid - 1;
                } else  {
                    start = mid + 1;
                }
            } else {
                if(!desc) {
                    start = mid + 1;
                } else  {
                    end = mid - 1;
                }
            }
            mid = start + (end - start)/2;
        }
        
        return -1;
    }
    public int findInMountainArray(int target, MountainArray arr) {
        
        int peak = Solution.peakIndexInMountainArray(arr);
        int index = Solution.binarySearch(0,peak,arr, target, false);
        if(index == -1) {
            index = Solution.binarySearch(peak,arr.length()-1,arr, target, true);
        }
        
        return index;
        
    }
}