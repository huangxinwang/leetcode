/**
 * Problem Statement: Remove Duplicates from Sorted Array II 
 * 
 * What if duplicates are allowed at most twice?
 */
 
 /**
  * Link: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
  */


///////////////////////////////////////////////////
// 2015/11/30
// Highlight: use idx to keep track of current position to write to
//            if count>=2 then skip, else write to array
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        
        int count = 1;
        int curr = nums[0];
        int idx = 1;
        
        //if count<=2, then write 
        //otherwise, skip
        for(int i=1; i<nums.length; i++){
            if(nums[i]==curr){
                if(count>=2) continue;
                nums[idx] = curr;
                count++;
                idx++;
            }else{
                nums[idx] = nums[i];
                count = 1;
                curr = nums[i];
                idx++;
            }
        }
        
        return idx;
    }
}
