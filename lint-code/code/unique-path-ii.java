public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(row==1 && col==1) return 1;
        
        
        int[][] ways = new int[row][col];
        ways[0][0] = 1;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(obstacleGrid[i][j]==1)
                    ways[i][j] = 0;
                else{
                    if(i!=0 && j!=0) ways[i][j] = ways[i-1][j] +ways[i][j-1];
                    else if(i==0 && j!=0)  ways[i][j] = ways[i][j-1];
                    else if(j==0 && i!=0) ways[i][j] = ways[i-1][j];
                }
            }
        }
        
        return ways[row-1][col-1];
    }
}
