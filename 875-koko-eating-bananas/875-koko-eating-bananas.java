class Solution {
    public int max(int[] piles) {
        int max = piles[0];
        
        for(int p : piles) {
            if(max < p) {
                max = p;
            }
        }
        return max;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end  = 1000000000;
        int mid = start + (end - start)/2;
        int result = 0;
        
        long time = 0;
        
        while(start <= end) {
            mid = start + (end - start)/2;
            time = 0;
            for(int p: piles) {
                
                time += (p + mid - 1) / mid;
            }
            if(time > h) {
                start = mid+1;
            } else {
                result = mid;
                end = mid-1;
            }

            
        }
        
        return result;
    }
}