class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashMap<Character, String> morseCode = new HashMap<>();
        String[] alphabet = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", 
                                         "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", 
                                         ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        
        for(int i = 0; i< alphabet.length;i++) {
            char current = 'a';
            current+=i;
            morseCode.put(current, alphabet[i]);
        }
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i< words.length;i++) {
            StringBuilder sb = new StringBuilder("");
            for(int j = 0; j< words[i].length(); j++) {
                sb.append(morseCode.get(words[i].charAt(j)));
            }
            set.add(sb.toString());
            
        }
        
        return set.size();
    };
    
}