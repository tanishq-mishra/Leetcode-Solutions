class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 0) {
            return false;
        }
        if(n == 1) {
            return true;
        }
        double logExp = Math.log(n)/Math.log(4);
        if(Math.floor(logExp) == logExp) {
            return true;
        }
        
        return false;
    }
}