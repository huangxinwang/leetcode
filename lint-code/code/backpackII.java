public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        
        //v(I, m) = max
        //v(I_(i-1), m-(w_i)) + v_i
        //v(I_(i-1), m)
        int[][] rnt = new int[A.length][m+1];
        
        for(int i=0; i<A.length; i++){
            for(int j=1; j<=m; j++){
                if(i==0){
                    rnt[0][j] = (j>=A[i]) ? V[0] : 0;
                }
                else{
                    if(j >= A[i])
                        rnt[i][j] = Math.max(rnt[i-1][j-A[i]] + V[i], rnt[i-1][j]);
                    else
                        rnt[i][j] = rnt[i-1][j];
                }
            }
        }
        
        return rnt[A.length-1][m];
    }
}
