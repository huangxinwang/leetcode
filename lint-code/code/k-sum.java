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
