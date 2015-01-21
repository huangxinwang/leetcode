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


///////////////////////////////////////////
//Approach 2: O(log n)

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        return help(A, 0, A.length-1);
    }
    
    public int help(int[] A, int l, int r){
        int mid = (l+r)/2;
        
        //have peak
        if( (mid==0 || A[mid-1] < A[mid]) && (mid==A.length-1 || A[mid] > A[mid+1]))
            return mid;
        
        //if A[mid-1] > A[mid], then there must be a peak in the left part 
        //Because: at first, it was increasing
        if( mid>0 && A[mid-1] > A[mid])
            return help(A, l, mid-1);
        else return help(A, mid+1, r);
    }
}

