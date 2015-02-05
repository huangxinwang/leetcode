/**
 * Ref: http://www.ninechapter.com/problem/55/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class Solution {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {
        // wirte your code here
        if(A.length==0) return A;
        
        offset = offset%(A.length);
        if(offset==0) return A;
        
        //reverse together
        reverse(A, 0, A.length-1);
        //reverse seperately
        reverse(A, 0, offset-1);
        reverse(A, offset, A.length-1);
        return A;
    }
    
    public void reverse(char[] A, int low, int high){
        for(int i=low; i<=(low+high)/2; i++){
            char tmp = A[i];
            A[i] = A[high+low-i];
            A[high+low-i] = tmp;
        }
    }
};
