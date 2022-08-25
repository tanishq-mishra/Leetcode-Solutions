class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] ransomFreq = new int[26];
        
        int[] magaFreq = new int[26];
        int ransomTotal = 0;
        for(int i = 0; i< ransomNote.length(); i++) {
            char currentCharacter = ransomNote.charAt(i);
            ransomFreq[currentCharacter-'a']++; 
            if(ransomFreq[currentCharacter-'a'] == 1) {
                ransomTotal++;
            }
            //ransomFreq.put(currentCharacter, ransomFreq.getOrDefault(currentCharacter, 0)+1);
        }
        int matchedFrequency = 0;
        for(int i = 0; i< magazine.length(); i++) {
            char currentCharacter = magazine.charAt(i);
            if(ransomFreq[currentCharacter-'a'] != 0) {
                magaFreq[currentCharacter-'a']++;
                
                if(magaFreq[currentCharacter-'a'] == ransomFreq[currentCharacter-'a']) {
                    matchedFrequency++;
                }
            }
            
            if(matchedFrequency == ransomTotal) {
                return true;
            }
        }
        return false;
        
    }
}