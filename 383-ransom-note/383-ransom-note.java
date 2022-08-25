class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()) {
            return false;
        }
        HashMap<Character, Integer> ransomFreq = new HashMap<>();
        
        HashMap<Character, Integer> magaFreq = new HashMap<>();
        
        for(int i = 0; i< ransomNote.length(); i++) {
            char currentCharacter = ransomNote.charAt(i);
            ransomFreq.put(currentCharacter, ransomFreq.getOrDefault(currentCharacter, 0)+1);
        }
        int matchedFrequency = 0;
        for(int i = 0; i< magazine.length(); i++) {
            char currentCharacter = magazine.charAt(i);
            if(ransomFreq.containsKey(currentCharacter)) {
                magaFreq.put(currentCharacter, magaFreq.getOrDefault(currentCharacter, 0)+1);
                if(magaFreq.get(currentCharacter).equals(ransomFreq.get(currentCharacter)) ) {
                    matchedFrequency++;
                }
            }
            
            if(matchedFrequency == ransomFreq.size()) {
                return true;
            }
        }
        return false;
        
    }
}