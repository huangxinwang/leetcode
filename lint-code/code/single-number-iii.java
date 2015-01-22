/**
 * Ref: http://okckd.github.io/blog/2014/06/28/Single-Number-III/
 * 
 */


public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public ArrayList<Integer> singleNumberIII(int[] A) {
        // write your code here
        int xor = A[0];
        for(int i=1; i<A.length; i++)
            xor ^= A[i];
        
        //get the right-most number
        int x = 0;
        int y = 0;
        int sign = xor & ~(xor-1);
        for(int i=0; i<A.length; i++){
            if( (A[i] & sign) != 0)
                x ^= A[i];
            else y ^= A[i];
        }
        
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        rnt.add(x);
        rnt.add(y);
        return rnt;
        
    }
}
