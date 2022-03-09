class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // find the closest element and expand the range
        int closestIdx = 0;
        int i = 0;
        int j = arr.length - 1;
        while(i < j - 1){
            int mid = i + (j - i)/2;
            if(arr[mid] > x) j = mid;
            else i = mid;
        }
        // post-processing
        closestIdx = Math.abs(arr[i] - x) <= Math.abs(arr[j] - x) ? i : j;

        List<Integer> list = new ArrayList<>();
        int count = 1;
        i = closestIdx - 1;
        j = closestIdx + 1;
        while(count < k){
            if(i < 0) j++;
            else if(j >= arr.length) i--;
            else if(Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) i--;
            else j++;
            count++;
        }
                    
        for(int m = i + 1; m <= j - 1; m++) list.add(arr[m]);
        return list;
    }
}