class Solution {
    public int countGoodSubstrings(String s) {
        int counter = 0;
        for(int i = 0; i<= s.length()-3; i++) {
            if(s.charAt(i) == s.charAt(i+1))
                continue;
            if(s.charAt(i+1) == s.charAt(i+2))
                continue;
            if(s.charAt(i) == s.charAt(i+2))
                continue;
            counter++;
        }
        
        
        return counter;
        
    }
}