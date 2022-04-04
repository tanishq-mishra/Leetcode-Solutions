class WordDictionary {
    Node root;
    class Node {
        public char val;
        public boolean isWord;
        public Map<Character, Node> children;
        
        Node(char val) {
            this.val = val;
            isWord = false;
            children = new HashMap<>();
        }
    }

    public WordDictionary() {
        root = new Node('\0');
    }
    
    public void addWord(String word) {
        
        Node current = root;
        for(int i = 0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!current.children.containsKey(c)) {
                current.children.put(c, new Node(c));
            }
            
            current = current.children.get(c);
        }
        
        current.isWord = true;
        
    }
    
    public boolean searchFrom(int index, String sub, Node current) {
        for(int i=index; i< sub.length(); i++) {
            char c = sub.charAt(i);
            if(c == '.') {
                for(Map.Entry<Character, Node> e : current.children.entrySet()) {
                    if(searchFrom(i+1, sub,e.getValue())) {
                        return true;
                    } 
                }
                return false;
            } else if(!current.children.containsKey(c)) {
                return false;
            } else {
                current = current.children.get(c);
            }
            
        }
        return current.isWord;
    }
    
    public boolean search(String word) {
        Node current = root;
        for(int i = 0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(Map.Entry<Character, Node> e : current.children.entrySet()) {
                    if(searchFrom(i+1, word,e.getValue())) {
                        return true;
                    } 
                }
                return false;
            } else if(!current.children.containsKey(c)) {
                return false;
            } else {
                current = current.children.get(c);
            }
            
           
        }
        return current.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */