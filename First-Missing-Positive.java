/**
 * Problem Statement: First Missing Positive 
 * Link: https://oj.leetcode.com/problems/first-missing-positive/
 * Time: 356 ms
 * Ref: http://fisherlei.blogspot.com/2012/12/leetcode-first-missing-positive.html
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 */


public class Solution {
    public int firstMissingPositive(int[] A) {
        
        for(int i=0; i<A.length; i++){
            
            while(A[i]!=i+1){
                if(A[i]<=0 || A[i]>A.length || A[i] == A[A[i]-1]) break;
                //swap A[i] with A[A[i]-1]
                int temp = A[i];
                A[i] = A[temp-1];
                A[temp-1] = temp;
            }
        }
        
        for(int i=0; i<A.length; i++){
            if(A[i] != i+1)
                return i+1;
        }
        
        return A.length+1;
    }
}