/**
 * Problem Statement: Dungeon Game
 * Hardness: ***
 * 
 */


public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
        
        int row = dungeon.length;
        int col = dungeon[0].length;
        
        //dynamic programming, go from end to start 
        int[][] cost = new int[row][col];
        
        //initialize table
        cost[row-1][col-1] = dungeon[row-1][col-1];
        for(int i=col-2; i>=0; i--){
            cost[row-1][i] = cost[row-1][i+1]+ dungeon[row-1][i];
            if(cost[row-1][i]>0) cost[row-1][i] = 0;
        }
        
        for(int i=row-2; i>=0; i--){
            cost[i][col-1] = cost[i+1][col-1] +dungeon[i][col-1];
            if(cost[i][col-1]>0) cost[i][col-1]=0;
        }
        
        //dynamic build the table
        for(int i=row-2; i>=0; i--){
            for(int j=col-2; j>=0; j--){
                cost[i][j] = Math.max(cost[i+1][j], cost[i][j+1]) + dungeon[i][j];
                if(cost[i][j]>0) cost[i][j] = 0;
            }
        }
        
        //return 
        if(cost[0][0]>=0){
            if(dungeon[0][0]<0) return -dungeon[0][0]+1;
            else return 1;
        }
        
        else return -cost[0][0]+1;
    }
}
