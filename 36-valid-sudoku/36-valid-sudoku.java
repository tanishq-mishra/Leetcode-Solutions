class Solution {
    public boolean isSafe(char[][] board, int r, int c, char e) {
        // check box
        int sqRoot = (int)(Math.sqrt(board.length));
        int boxRow = r - (r % sqRoot);
        int boxColumn = c - (c % sqRoot);
        
        for(int i = boxRow; i<boxRow+sqRoot; i++) {
            for(int j = boxColumn; j < boxColumn+sqRoot; j++) {
                if(board[i][j] == e) {
                    return false;
                }
            }
        }
        
        
        // check row
        for (int i = 0; i< board.length; i++) {
            if(board[i][c] == e)
                return false;
        }
        
        // check column
        for (int i = 0; i< board.length; i++) {
            if(board[r][i] == e)
                return false;
        }
        return true;
    }
    
    public boolean helper(char[][] board, int r, int c){
        
        if(r >= board.length) {
            //printBoard(board);
            return true;
        }
        
        if(c >= board.length) {
            return helper(board, r+1, 0);
        }
        if(board[r][c] != '.') {
            char temp = board[r][c];
            board[r][c] = '.';
            if(!isSafe(board, r, c, temp)) {
                return false;
            } else{
                board[r][c] = temp;
                
            }
        } 
        return helper(board, r, c+1);
        
    }
    public boolean isValidSudoku(char[][] board) {
        return helper(board, 0,0);
    }
}