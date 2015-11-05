/**
 * Problem Statement: First Missing Positive 
 * Link: https://oj.leetcode.com/problems/first-missing-positive/
 * Time: 356 ms
 * Ref: http://fisherlei.blogspot.com/2012/12/leetcode-first-missing-positive.html
 * Hardness: *****
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


/////////////////////////////////////////////////////////////////
//Round 2: 12/30/2014
public class Solution {
    public int firstMissingPositive(int[] A) {
        
    
        //do in place swap to put A[i] in index A[i]-1
        for(int i=0; i<A.length; i++){
            if(A[i]!=i+1){
                if(A[i]<=0 || A[i]>A.length-1 || A[i]==A[A[i]-1]) continue;
                else{
                    int tmp = A[i];
                    A[i] = A[tmp-1];
                    A[tmp-1] = tmp;
                    //need to check i again, since A[i] has been changed by swapping
                    i--;
                }
            }
        }
        
        //find the first element A[i]!=i+1
        for(int i=0; i<A.length; i++){
            if(A[i]!=i+1)
                return i+1;
        }
        
        return A.length+1;
    }
}

//////////////////////////////////////////////////////////////////
// 2015/11/04
// Highlight: in-place sorting 
public class Solution {
    public int firstMissingPositive(int[] nums) {
        
        //do implace sorting, swap nums[i] with nums[nums[i]-1] 
        for(int i=0; i<nums.length; i++){
            
            if(nums[i]<=0) continue;
            if(nums[i] >= nums.length) continue;
            if(nums[i]==nums[nums[i]-1]) continue;
           
            else{
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
                i--;
            }
        }
        
        int curr = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<=curr) continue;
            else if(nums[i]!=curr+1) return curr+1;
            else curr = nums[i];
        }
        
        return curr+1;
    }
}
