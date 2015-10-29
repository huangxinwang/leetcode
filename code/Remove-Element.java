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

//////////////////////////////////////////////////////////////////////////////
// 2015/10/29
public class Solution {
    public int removeElement(int[] nums, int val) {
        
        //use an index to keep track of current valid position in the array to write 
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==val) continue;
            else nums[idx] = nums[i];
            idx++;
        }
        return idx;
    }
}
