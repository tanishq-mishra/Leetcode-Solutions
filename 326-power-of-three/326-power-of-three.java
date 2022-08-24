class Solution {
    // log(n);
//     public boolean isPowerOfThree(int n) {
        
//         if(n <= 0) {
//             return false;
//         }
//         if(n == 1) {
//             return true;
//         }
//         while(n>1) {
//             double d = (double)n/3;
            
//             if(Math.floor(d) != d) {
//                 return false;
//             }
//             n = (int)d;
//         }
        
//         return true;
        
//     }
    
    // constant time;
    public boolean isPowerOfThree(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int  
        return ( n>0 &&  1162261467%n==0);
    }
}