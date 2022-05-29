class Solution {
    public String minWindow(String s, String t) {
        if(t.length() == 0) {
            return "";
        }
        
        
        HashMap<Character, Integer> sCount = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tCount = new HashMap<Character, Integer>();
        
        for(int i = 0; i< t.length(); i++) {
            // add all character frequencies of t string in a hashMap
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) +1);
        }
        
        
        int left = 0;
        int right = 0;
        int present = 0;
        
        int resLeft = 0;
        int resRight = 0;
        int reSize = Integer.MAX_VALUE;
       
        for(right = 0; right < s.length(); right++) {
            
            char current = s.charAt(right);
            
            if(tCount.containsKey(current)) {
                // if the newly added character is present in t then add it to the freq map of s string. 
                sCount.put(current, sCount.getOrDefault(current, 0)+1);
                
                
                if(sCount.get(current).equals(tCount.get(current))) {
                    // if the newly added character frequency equals the freq in the t frequecy map, the increment present counter
                    // present counter keeps track of all the required frequecy of characters in the window. 
                    present++;
                }
            }
            
            
            // present is equal to t freq map size when all the character freq requirements are met i.e, >= freq of characters.
            // we are incrementing the left pointer to get the smallest possible window which is valid. 
            while(present == tCount.size()) {
                
                if(reSize > right-left+1) {
                    reSize = right-left+1;
                    resLeft = left;
                    resRight = right;
                }
                char currentLeft = s.charAt(left);
                left++;
                if(sCount.containsKey(currentLeft)) {
                    sCount.put(currentLeft, sCount.get(currentLeft)-1);
                    if(sCount.get(currentLeft) < tCount.get(currentLeft)) {
                        present--;
                    }
                }
                
            }
            
           
            
        }
        return reSize != Integer.MAX_VALUE  ? s.substring(resLeft, resRight+1): "";
    }
}