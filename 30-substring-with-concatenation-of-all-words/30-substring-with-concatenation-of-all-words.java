// class Solution {
//     HashSet<Integer> subs = new HashSet<>();
//     public void perm(String[] words, String processed, boolean[] visited, String s, int idx) {
//         if( idx == words.length) {
//             int index = s.indexOf(processed);
//             if(index != -1) {
//                 while(index != -1) {
//                     subs.add(index);
//                     index = s.indexOf(processed,index+1);
//                 }
                
//             }
//         }
//         for(int i = 0 ; i<words.length; i++) {
//             if(!visited[i]) {
//                 visited[i] = true;
//                 perm(words, processed+words[i], visited, s, idx+1);
//                 visited[i] = false;
//             }
//         }
        
        
//     } 
//     public List<Integer> findSubstring(String s, String[] words) {
//         perm(words, "", new boolean[words.length], s,0);
        
//         return new ArrayList<>(subs);
//     }
// }


class Solution {
    private HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
    private int wordLength;
    private int substringSize;
    private int k;
    
    private boolean check(int i, String s) {
        // Copy the original dictionary to use for this index
        HashMap<String, Integer> remaining = new HashMap<>(wordCount);
        int wordsUsed = 0;
        
        // Each iteration will check for a match in words
        for (int j = i; j < i + substringSize; j += wordLength) {
            String sub = s.substring(j, j + wordLength);
            if (remaining.getOrDefault(sub, 0) != 0) {
                remaining.put(sub, remaining.get(sub) - 1);
                wordsUsed++;
            } else {
                break;
            }
        }
        return wordsUsed == k;
    }
    
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        k = words.length;
        wordLength = words[0].length();
        substringSize = wordLength * k;
        
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n - substringSize + 1; i++) {
            if (check(i, s)) {
                answer.add(i);
            }
        }
        return answer;
    }
}