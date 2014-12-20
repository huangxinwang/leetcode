/**
 * Problem Statement: Word Search 
 * Link: https://oj.leetcode.com/problems/word-search/
 * Time: 512ms
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * 
 */

public class Solution {
    
    int[] dx;
    int[] dy;
    int[][] state;
    int row;
    int col;
    boolean found;
    
    public boolean exist(char[][] board, String word) {
        
        //intial variable
        row = board.length;
        col = board[0].length;
        int len = word.length();
        
        //adjacent matrix
        dx = new int[]{0,0,1,-1};
        dy = new int[]{1,-1,0,0};
        
        //state, used by dfs to keep record of visited point
        state = new int[row][col];
        
        found = false;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                //for each entry point, dfs find whether the word coud be constructured
                if (board[i][j]==word.charAt(0))
                    dfs(i,j,0,word,board);
                if (found) return true;
            }
        }
        
        return found;
    }
    
    
    //two layers of dfs to find 
    public void dfs(int x, int y, int depth, String word, char[][] board)
    {
        //terminate condition
        if(found) return;
        if(depth==word.length()-1) {found=true; return;}
        
        //visiting, change state
        state[x][y] = 1;
        
        //visit his 4 adjacents provided the conditions satisified   
        for(int i=0;i<4;i++)
        {
            int tx = x + dx[i];
            int ty = y + dy[i];
            
            //check whether condition satisfied
            if (canMove(tx, ty) && board[tx][ty]==word.charAt(depth+1))
            {
                dfs(tx, ty, depth+1, word, board);
            }
        }
        
        //finish visiting, change state
        state[x][y] = 0;
    }
    
    //check whether exceed border 
    public boolean canMove(int tx, int ty){
        if(tx<0 || tx>=row || ty<0 || ty>=col) return false;
        return state[tx][ty]==0;
    }
}


////////////////////////////////////////////////////////////////////////
//Round 2: 12/20/2014
public class Solution {
    
    int[] dx;
    int[] dy;
    boolean[][] state;
    boolean found;
    int row;
    int col;
    
    public boolean exist(char[][] board, String word) {
        
        row = board.length;
        col = board[0].length;
        dx = new int[]{0,0,-1,1};
        dy = new int[]{1,-1,0,0};
        int len = word.length();
        
        found = false;
        state = new boolean[row][col];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==word.charAt(0))
                    dfs(board, word, i, j, 0);
                if(found) return true;
            }
        }
        return found;
    }
    
    //dfs found possible move
    public void dfs(char[][] board, String word, int x, int y, int depth){
        
        if(depth==word.length()-1) {
            found = true;
            return;
        }
        
        state[x][y] = true;
        
        for(int i=0; i<dx.length; i++){
                if(canMove(x+dx[i], y+dy[i]) && board[x+dx[i]][y+dy[i]] == word.charAt(depth+1))
                    dfs(board, word, x+dx[i], y+dy[i], depth+1);
                if(found) return;
        }
        
        state[x][y] = false;
        

    }
    
    //decide whether a move is within the position of the board, or whether the position is traversed
    public boolean canMove(int x, int y){
        if(x<0 || x>=row || y<0 || y>=col) return false;
        return state[x][y]==false;
    }
}
