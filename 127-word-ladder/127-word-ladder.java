class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> graph = new HashMap<>();
        int wordLength = beginWord.length();
        String word = beginWord;
        wordList.add(beginWord);
        if(!wordList.contains(endWord))
            return 0;
        
        for(int i = 0; i<wordList.size(); i++) {
            word = wordList.get(i);
            for(int j = 0; j<word.length(); j++) {
                String perm = "";
                if(j == 0) {
                    perm = "*"+ word.substring(1);
                } else if(j<word.length()-1){
                    perm = word.substring(0, j) + "*" + word.substring(j+1);
                } else {
                    perm = word.substring(0, j) + "*";
                }
               
                
                if(graph.containsKey(perm)) {
                    graph.get(perm).add(word);
                    
                } else {
                    List<String> newList = new ArrayList<>();
                    newList.add(word);
                    graph.put(perm, newList);
                    
                }
                
            }
           
        }
        
        List<String> bfs = new ArrayList<>();
        bfs.add(beginWord);
        Set<String> visited = new HashSet<>();
        int pathLength = 0;
        while(!bfs.isEmpty()) {
            int queueLen = bfs.size();
            for(int k = 0; k<queueLen; k++) {
                String current = bfs.get(0);
                bfs.remove(0);
                if(visited.contains(current)) {
                    continue;
                }
                if(current.equals(endWord)) {
                    return pathLength+1;
                }
                visited.add(current);
                for(int j = 0; j<current.length(); j++) {
                    String perm = "";
                    if(j == 0) {
                        perm = "*"+ current.substring(1);
                    } else if(j<current.length()-1){
                        perm = current.substring(0, j) + "*" + current.substring(j+1);
                    } else {
                        perm = current.substring(0, j) + "*";
                    }

                    List<String> neighbor = graph.get(perm);
                    for(int i = 0; i<neighbor.size(); i++) {
                        if(!visited.contains(neighbor.get(i))) {
                            bfs.add(neighbor.get(i));
                        }
                    }

                }
            }
            pathLength++;
            
        }
        
        
        return 0;
        
    }
}