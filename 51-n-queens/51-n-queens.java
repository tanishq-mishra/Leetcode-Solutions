class Solution {
    public boolean isValid(List<String> board, int x, int y) {
        
        for(int i = 0; i< board.size(); i++) {
            if(i != y && board.get(x).charAt(i) == 'Q') {
                return false;
            }
            
        }
        for(int i = 0; i< board.size(); i++) {
            if(i !=x && board.get(i).charAt(y) == 'Q') {
                return false;
            }
        }
        
        int i = x;
        int j = y;
        
        while(i<board.size() && j < board.size()) {
            if(i !=x && j != y) {
                if(board.get(i).charAt(j) == 'Q')
                    return false;
            }
            i++;
            j++;
        }
        i = x;
        j = y;
        while(i>=0 && j < board.size()) {
            if(i !=x && j != y) {
                if(board.get(i).charAt(j) == 'Q')
                    return false;
            }
            i--;
            j++;
        }
        
        i = x;
        j = y;
        while(j>=0 && i< board.size()) {
            if(i !=x && j != y) {
                if(board.get(i).charAt(j) == 'Q')
                    return false;
            }
            i++;
            j--;
        }
        
        
        i = x;
        j = y;
        
        while(j>=0 && i>=0) {
            if(i !=x && j != y) {
                if(board.get(i).charAt(j) == 'Q')
                    return false;
            }
            i--;
            j--;
        }
        
        
        return true;
        
            
        
    }
    
    public void backtrack(int i, List<String> board, List<List<String>> boards) {
        if(i == board.size()) {
            List<String> ans = new ArrayList<>(board);
            boards.add(ans);
            return;
        }
        StringBuilder s = new StringBuilder(board.size());
        for(int a = 0; a<board.size(); a++) {
            s.append(".");
        }
        
        for(int j = 0; j<board.size(); j++) {
            s.setCharAt(j, 'Q');
            //System.out.println(s);
            board.set(i, s.toString());
           
            if(isValid(board, i, j)) {
                backtrack(i+1, board, boards);
            }
            s.setCharAt(j, '.');
            board.set(i, s.toString());
            
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> boards = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String row = "";
        for(int i = 0; i< n; i++) {
            row += ".";
        }
        
        for(int i = 0 ; i< n;i ++) {
            board.add(row);
        }
        
        backtrack(0,board, boards);
        
        return boards;
    }
}