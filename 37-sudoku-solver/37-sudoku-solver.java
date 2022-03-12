class Solution {
    
    public static void printBoard(char[][] board) {
        for(char[] row: board) {
            for(char element: row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
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
        if(board[r][c] == '.') {
            
            for(char i = '1'; i<='9'; i++) {
                if(isSafe(board, r, c, i)) {
                    //printBoard(board);
                    board[r][c] = i;
                    
                    if(helper(board, r, c+1)) {
                        return true;
                    } else {
                        board[r][c] = '.';
                    }
                    
                }
                
            }
            return false;
        } 
        if(c == board.length -1)
            return helper(board, r+1, 0);
        else 
            return helper(board, r, c+1);
        
    }
    public void solveSudoku(char[][] board) {
        
        helper(board, 0,0);
        //helper(board, 0,0);
        
        
        
    }
}