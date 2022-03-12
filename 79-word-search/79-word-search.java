// class Solution {
//     public boolean helper(char[][] board, boolean[][] visited,int i, int j,int currentLetter, String word) {
        
//         if(currentLetter >= word.length()) {
//             return true;
//         }
//         if(i < 0 || i >= board.length || j <0 || j>= board[0].length) {
//             return false;
//         }
//         if(visited[i][j] == true) {
//             return false;
//         }
//         if(board[i][j] != word.charAt(currentLetter))
//             return false;
        
        
//         visited[i][j] = true;
        
//         boolean ret = 
//             helper(board, visited, i+1, j, currentLetter+1, word) ||
//             helper(board, visited, i-1, j, currentLetter+1, word) ||
//             helper(board, visited, i, j+1, currentLetter+1, word) ||
//             helper(board, visited, i, j-1, currentLetter+1, word);
        
//         visited[i][j] = false;
//         return ret;
//     }
//     public boolean exist(char[][] board, String word) {
//         boolean[][] visited = new boolean[board.length][board[0].length];
//             for(int i = 0; i< board.length; i++) {
//                 for(int j = 0; j< board[0].length; j++) {
//                     if(helper(board, visited, i ,j, 0, word)) {
//                         return true;
//                     }
//                 }
//             }
//         return false;
//     }
// }


class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                if(helper(board, word, i, j, 0)){return true;}
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, String word, int x, int y, int i){
        if(i >= word.length()){return true;}
        
        if(x >= board.length || x < 0 || y >= board[0].length || y < 0){
            return false;
        }
        
        if(board[x][y] != word.charAt(i)){return false;}
        
        board[x][y] ^= 256;
        boolean ret = 
            helper(board, word, x+1, y, i+1) || 
            helper(board, word, x-1, y, i+1) ||
            helper(board, word, x, y+1, i+1) || 
            helper(board, word, x, y-1, i+1);
        board[x][y] ^= 256;
        
        return ret;
    }
}
