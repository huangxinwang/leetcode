//Approach 1: dfs
//Time limit exceed, because I didn't make good use of the constraints that all input are positive integers
//Dynamic programming could be a good approach

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int  kSum(int[] A, int k, int target) {
        // write your code here
        if(k==0 && target!=0) return 0;
        
        int[] count = new int[1];
        dfs(A, k, 0, target, count);
        return count[0];
        
    }
    
    public void dfs(int[] A, int depth, int start, int target, int[] count){
        if(depth==0){
            if(target==0)
                count[0]++;
            return;
        }
        
        if(start == A.length) return;
        
        for(int i = start; i<A.length; i++){
            dfs(A, depth-1, i+1, target-A[i], count);
        }
    }
}

//////////////////////////////////////////////////////
//Approach 2: k sum
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int  kSum(int A[], int k, int target) {
        // write your code here
        int[][][] count = new int[A.length+1][k+1][target+1];
        
        //initialized  
        for(int i=1; i<=A.length; i++){
            if(A[i-1]<=target){
                for(int j=i; j<=A.length; j++){
                        count[j][1][A[i-1]] = 1;
                }
            }
        }
        
        for(int j=2; j<=k; j++){
                for(int i=j; i<=A.length; i++){
                    for(int m=1; m<=target; m++){
                    
                    //dynamic updat the table
                    int remain = m - A[i-1];
                    if(remain>=0){
                        //the j number contains A[i-1] or not
                        count[i][j][m] = count[i-1][j-1][remain] + count[i-1][j][m];
                    }
                    else count[i][j][m] = count[i-1][j][m];
                }
            }
        }
        
        return count[A.length][k][target];
    }
}
