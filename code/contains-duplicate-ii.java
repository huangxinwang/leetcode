/*
* Problem Statement: Contains Duplicate II
* 
* Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that *nums[i] = nums[j] and the difference between i and j is at most k.
*/

////////////////////////////////////////////////////
// 2015/11/15
// Highlight: hashmap, keep track of latest idx of nums[i]
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int idx = map.get(nums[i]);
                if(i-idx<=k) return true;
            }
            //maintain the latest idx of num[i]
            map.put(nums[i], i);
        }
        
        return false;
    }
}
