public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        
        //use maxjump to keep track of the maximum distance you can jump
        
        int maxjump = A[0];
        for(int i=0; i<A.length && i<=maxjump; i++){
            if(A[i]+i>maxjump){
                maxjump = A[i]+i;
                if(maxjump>=A.length-1)
                    return true;
            }
        }
        
        return false;
    }
}

