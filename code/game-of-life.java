// Game of life

According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.


///////////////////////////////////////
// 2015/12/19
// Highlight: logic, maintain states, in-place update

//Ref: http://www.cnblogs.com/grandyang/p/4854466.html

//Use more states other than "0","1" to track the state of current position
//State 0: dead -> dead
//State 1: live -> live
//State 2: live -> dead
//State 3: dead -> live

//Then interpret the states as live/dead in the end

public class Solution {
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0) return;
        int[] xarr = new int[]{1,1,1,-1,-1,-1,0,0};
        int[] yarr = new int[]{1,0,-1,1,0,-1,1,-1};
        
        //track states
        int n = board.length;
        int m = board[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                //count number of lives
                int count = 0;
                for(int k=0; k<8; k++){
                        int x = i+xarr[k];
                        int y = j+yarr[k];
                        
                        if(x>=0 && x<n && y>=0 && y<m && (board[x][y]==1 || board[x][y]==2))
                            count++;
                }
                
                
                //set states
                //set from live -> dead
                if(count<2 || count>3){
                    if(board[i][j]==1) board[i][j] = 2;
                }
                //set from dead -> live
                else if(count==3 && board[i][j]==0) board[i][j] = 3;
            }
        }
        
        //reset states
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] %= 2;
            }
        }
        
    }
}
