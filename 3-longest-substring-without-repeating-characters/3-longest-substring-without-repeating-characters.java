class Solution {
    public int lengthOfLongestSubstring(String c) {
        if(c.length() == 0 || c.length() == 1) {
            return c.length();
        }
        int start = 0;
        int end = 0;
        int maxLength = 0; 
        
        
        while(end < c.length()-1) {
            end++;
            int i = end;
            while( i > start && i > 0 && c.charAt(i-1) != c.charAt(end)) {
                i--;
            }
            start = i;
            maxLength = Math.max(maxLength, end-start +1);
        }
        
        
        return maxLength;
    }
}



// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if(s.length() == 0 || s.length() == 1) {
//             return s.length();
//         }
//         int start = 0;
//         int end = 0;
//         int maxLength = 0; 
//         char[] c = s.toCharArray();
//         HashMap<Character, Integer> set = new HashMap<>();
//         while(end < c.length-1) {
//             end++;
//             if(set.containsKey(c[end])) {
//                 start = set.get(c[end]) +1;
                
//                 set.put(c[end], end);
                
//             } else 
//             start = i;
//             maxLength = Math.max(maxLength, end-start +1);
//         }
        
        
//         return maxLength;
//     }
// }