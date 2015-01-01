/**
 * Problem Statement: Remove Element 
 * 
 * 
 */

public class Solution {
    public int removeElement(int[] A, int elem) {
        
        //use an index to keep track of places to put a valid number
        int index = 0;
        for(int i=0; i<A.length; i++){
            if(A[i]!=elem){
                A[index] = A[i];
                index++;
            }
        }
        return index;
    }
}
