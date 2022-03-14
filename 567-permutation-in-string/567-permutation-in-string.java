class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        
        for (int i = 0;i<s1.length();i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        
        int start = 0, end = s1.length() - 1;
        
        while (end < s2.length()) {
            if (checkIfSame(count1, count2))
                return true;
            
            count2[s2.charAt(start) - 'a']--;
            start++;
            end++;
            if (end < s2.length()) count2[s2.charAt(end) - 'a']++;
        }
        
        return false;
        
    }
    
    public boolean checkIfSame(int[] count1, int[] count2) {
        int p1 = 0, p2 = 0;
        
        while (p1 < 26 && p2 < 26) {
            if (count1[p1] != count2[p2])
                return false;
            p1++;p2++;
        }
        
        return true;
    }
}