/**
 * Problem Statement: Find a Peak
 * 
 * 
 */


class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
     
    //O(n) time complexity
    public int findPeak(int[] A) {
        // write your code here
        
        //special case
        if(A.length>=2 && A[0]>A[1]) return 0;
        if(A.length>=2 && A[A.length-2] < A[A.length-1]) return A.length-1;
        
        for(int i=1; i<A.length-1; i++){
            if(A[i] > A[i-1] && A[i] >A[i+1])
                return i;
        }
        
        return -1;
    }
}
