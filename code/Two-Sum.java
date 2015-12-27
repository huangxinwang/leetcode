/**
 * Problem Statement: Two Sum
 * 
 * 
 */

//////////////////////////////////////
// 2015/11/30
// Highlight: hashmap, check if (target-curr) is in the map
// Time: O(n)
// Space: O(n)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //put each number and its index in hashmap
        //overwrite repeated numbers
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        
        //for each number, check whether (target-remain) is in the map 
        //make sure two indexes are different
        for(int i=0; i<nums.length; i++){
            int remain = target - nums[i];
            if(map.containsKey(remain) && map.get(remain)!=i){
                int[] rnt = new int[2];
                rnt[0] = i+1;
                rnt[1] = map.get(remain)+1;
                return rnt;
            }
        }
        
        return null;
    }
}
