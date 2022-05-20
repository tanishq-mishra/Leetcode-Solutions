class Solution {
    
    public String longestPalindrome(String s) {
        int resultSum = 0;
        String res = "";
        
        
        for(int i = 0; i<s.length(); i++) {
            int left = i;
            int right = i;
            // odd;
            while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if(right-left +1 > resultSum) {
                    resultSum = right-left +1;
                    res = s.substring(left, right+1);
                }
                left--;
                right++;
            }
            // even 
            
            left = i;
            right = i+1;
            while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if(right-left +1 > resultSum) {
                    resultSum = right-left +1;
                    res = s.substring(left, right+1);
                }
                left--;
                right++;
            }
        }
        
        return res;
    }
    
    
//     public boolean isPal(String s, int i, int j) {
//         while(i<j) {
//             if(s.charAt(i) != s.charAt(j)) {
//                 return false;
//             }
//             i++;
//             j--;
//         }
        
//         return true;
//     }
//     public String longestPalindrome(String s) {
//         // brute force
//         int sum = 0;
//         String res = "";
//         for(int i = 0; i<s.length(); i++) {
//             for(int j = i; j<s.length(); j++) {
//                 if(isPal(s, i, j)) {
//                     if(sum< j-i+1) {
//                         sum = j-i+1;
//                         res = s.substring(i, j+1);
//                     }
//                 } 
//             }
//         }
        
        
//         return res;
//     }
}