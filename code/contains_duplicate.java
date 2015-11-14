/**
* Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears *at least twice in the array, and it should return false if every element is distinct.
**/


///////////////////////////////////////
// 2015/11/13
// Highlight: hashset 
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length==0) return false;
        
        HashSet<Integer> set =  new HashSet<Integer>();
        
        for(Integer i : nums){
            if(set.contains(i)) return true;
            else set.add(i);
        }
        
        return false;
    }
}
