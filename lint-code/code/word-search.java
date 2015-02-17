public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    boolean result = dfs(board, visited, word, 1, i, j);
                    if(result) return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, boolean[][] visited, String word, int start, int i, int j){
        if(start>=word.length()) return true;
        
        int[] offSetX = {0, 0, 1, -1};
        int[] offSetY = {1, -1, 0, 0};
        
        //travere each possible next step
        for(int k=0; k<offSetX.length; k++){
            int curri = i+offSetX[k];
            int currj = j+offSetY[k];
            if(validPos(board, visited, curri, currj)){
                if(board[curri][currj] == word.charAt(start)){
                    visited[curri][currj] = true;
                    boolean result = dfs(board, visited, word, start+1, curri, currj);
                    visited[curri][currj] = false;
                    if(result) return true;
                }
            }
        }
        
        return false;
        
    }
    
    //judge whether a next position is valid or not
    public boolean validPos(char[][] board, boolean[][] visited, int i, int j){
        int row = board.length;
        int col = board[0].length;
        if(i<0 || i>=row) return false;
        if(j<0 || j>=col) return false;
        if(visited[i][j]) return false;
        return true;
    }
    
}
