/**
 * Problem Statement: Remove Duplicates from Sorted Array II 
 * 
 * What if duplicates are allowed at most twice?
 */
 
 /**
  * Link: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
  */


public class Solution {
    public int removeDuplicates(int[] A) {
        
        if(A.length==0) return 0;
        
        int lastVal = A[0];
        //indicate first appearance, if false
        boolean flag = false;
        //keep writing index, update A in place
        int index = 1;
        //keep delete account
        int count = 0;
        
        for(int i=1; i<A.length; i++){
            
            //Case 1: appear more than twice
            if(A[i]==lastVal && flag){
                count++;
                continue;
            }
            
            //Case 2:appear twice
            if(A[i]==lastVal && !flag){
                flag = true;
                A[index] = A[i];
                index++;
            }
            //Case 3: first appear
            else if(A[i]!=lastVal){
                lastVal = A[i];
                flag = false;
                A[index] = A[i];
                index++;
            }
        }
        
        
        
        return A.length-count;
            
        }
    }


/////////////////////////////////////////////////////////////////
//Round 2: 12/19/2014
public class Solution {
    public int removeDuplicates(int[] A) {
        
        //the right place to put A[i]
        int index = 0;
        
        int i =0;
        
        while(i<=A.length-1){
            if(i==A.length-1){
                A[index] = A[i];
                index++;
                break;
            }
            //at most allow 2
            if(A[i]==A[i+1]){
                int val = A[i];
                A[index] = A[i];
                index++;
                A[index] = A[i];
                index++;
                while(i<=A.length-1 && A[i]==val)
                    i++;
            }
            //no duplicate
            else{
                A[index] = A[i];
                index++;
                i++;
            }
        }

        return index;
    }
}


////////////////////////////////////////////////////////
//2015/11/07
// Highlight: keep track of duplicate numbers, and when meet new numbers, deal with old numbers
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        
        int curr = nums[0];
        int count = 1;
        int i =0;
        int idx = 0;
        
        //keep track of the count of duplicate number
        //when meet new number, deal with the set of nums meet last
        for(i=1; i<nums.length; i++){
            if(nums[i]==curr){ 
                count++;
                continue;
            }
            else{
                nums[idx] = curr;
                idx++;
                if(count>1){
                    nums[idx] = curr;
                    idx++;
                }
                curr = nums[i];
                count  = 1;
            }
        }
        nums[idx] = curr;
        if(count>1){
            idx++;
            nums[idx] = curr;
        }
        
        return idx+1;
    }
}
