class Solution {
    public double myPow(double x, int n) {
        // binary Exponentiation TC : O(logn)
        long nn = n;
        double ans = 1.0;
        if(nn <0) {
            nn *= -1;
        }
        while(nn>0) {
            if(nn % 2 == 1) {
                ans = ans * x;
                nn-=1;
            } else {
                x = x*x;
                nn/=2;
            }
        }
        
        if(n <0) {
            ans = 1/ans;
        }
        
        return ans;
    }
}