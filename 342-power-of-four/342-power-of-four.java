class Solution {
    public boolean isPowerOfFour(int n) {
        int stepUp = 1;
        if(n == 1) {
            return true;
        }
        
        if(n == 0) {
            return false;
        }
        if(n%4 != 0) {
            return false;
        }
        boolean up = false;
        while(stepUp < n) {
            if(up)
                stepUp*=4;
            else {
                
                double check = (double)n/4.0;
                if(Math.floor(check) != check) {
                    return false;
                }
                n = (int)check;
            }
                
            up= !up;
        }
        
        if(stepUp == n) {
            return true;
        }
        
        return false;
        
        
        
    }
}