class Solution {
    public boolean isPowerOfThree(int n) {
        
        if(n <= 0) {
            return false;
        }
        if(n == 1) {
            return true;
        }
        while(n>1) {
            double d = (double)n/3;
            
            if(Math.floor(d) != d) {
                return false;
            }
            n = (int)d;
        }
        
        return true;
        
    }
}