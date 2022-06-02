class Solution {
    
    public static class TrieNode {
        char value;
        HashMap<Character, TrieNode> children;
        String word;
        public TrieNode(char value) {
            this.value = value;
            children = new HashMap<>();
            word = null;
        }
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode('*');
        for(String word: words) {
            TrieNode current = root;
            for(int i = 0; i< word.length(); i++) {
                char c = word.charAt(i);
                if(!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode(c));
                }
                 current = current.children.get(c);
                
                if(i == word.length()-1) {
                    current.word = word;
                    break;
                }
                
               
            }
        }
        return root;
    }
    
    public void printTrie(TrieNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.value + "    ");
        System.out.print("[");
        for(Map.Entry<Character, TrieNode> e : root.children.entrySet()) {
            System.out.print(e.getKey()+",");
        }
        System.out.print("]");
        if(root.word != null) {
            System.out.println(root.word);
        }
        System.out.println();
        System.out.println();
        for(Map.Entry<Character, TrieNode> e : root.children.entrySet()) {
            printTrie(e.getValue());
        }
        
    }
    
    public List<String> result = new ArrayList<>();
    
    public void helper(char[][] board, TrieNode current, int i, int j, boolean[][] visited) {
        if(i >=board.length || i<0 || j>= board[0].length || j<0) {
            return;
        }
        if(visited[i][j]) {
            return;
        }
       
       
        if(current.children.containsKey(board[i][j])) {
             String s = current.children.get(board[i][j]).word;
             if(s != null) {
                result.add(s);
                 current.children.get(board[i][j]).word = null;
                 
             }
            visited[i][j] = true;
            helper(board, current.children.get(board[i][j]), i, j+1,visited);
            helper(board, current.children.get(board[i][j]), i+1, j,visited);
            helper(board, current.children.get(board[i][j]), i-1, j,visited);
            helper(board, current.children.get(board[i][j]), i, j-1,visited);
            visited[i][j] = false;
        }
        
        
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        //printTrie(root);
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j< board[0].length; j++) {
                helper(board, root, i, j, visited);
            }
        }
        
        
        return new ArrayList<>(result);
    }
}