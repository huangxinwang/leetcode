////////////////////////////////////////////// Memory Limit Exceed
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
     
    //W(I_i, w) = W(I_(i-1), w-w_i) + w_i
    //  = W(I_(i-1), w)
    public int backPack(int m, int[] A) {
        // write your code here
        Arrays.sort(A);
        
        int[][] size = new int[A.length][m+1];
        for(int i=0; i<A.length; i++){
            for(int j=1; j<=m; j++){
                if(i==0) {
                    size[i][j] = j>=A[0] ? A[0]:0;
                    continue;
                }
                if(j-A[i]>0){
                    size[i][j] = Math.max(size[i-1][j-A[i]] + A[i], size[i-1][j]);
                }
                else
                size[i][j] = size[i-1][j];
            }
        }
        
        return size[A.length-1][m];
            
        
    }
    
////////////////////////////////////////// 
    
    
   
}
