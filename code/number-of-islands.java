// Number of islands

///////////////////////////////////////////////////
// 2015/12/15
// Highlight: dfs
// Time: O(row * col)

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null ||grid.length==0) return 0;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }
    
    //dfs traverse
    //mark node '1' as visited
    public void dfs(char[][] grid, boolean[][] visited, int i, int j){
        int[] xArr = new int[]{0,0,1,-1};
        int[] yArr = new int[]{1,-1,0,0};
        
        for(int k=0; k<4; k++){
            int x = i+xArr[k];
            int y = j+yArr[k];
            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && visited[x][y]==false && grid[x][y]=='1'){
                visited[x][y] = true;
                dfs(grid, visited, x, y);
            }
        }
    }
}
