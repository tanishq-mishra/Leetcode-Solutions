class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        int start = 0;
        int end = 0;
        int maxLength = 0; 
        char[] c = s.toCharArray();
        
        while(end < c.length-1) {
            end++;
            int i = end;
            while( i > start && i > 0 && c[i-1] != c[end]) {
                i--;
            }
            start = i;
            maxLength = Math.max(maxLength, end-start +1);
        }
        
        
        return maxLength;
    }
}