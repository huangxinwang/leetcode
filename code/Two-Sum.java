/**
 * Problem Statement: Two Sum
 * 
 * 
 */

//////////////////////////////////////
// 2015/11/30
// Highlight: hashmap, check if (target-curr) is in the map
// Time: O(n)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],i+1);
        }
        
        for(int i=0; i<nums.length; i++){
            int remain = target - nums[i];
            if(map.containsKey(remain) && map.get(remain)!=i+1){
                int[] rnt = new int[2];
                rnt[0] = i+1;
                rnt[1] = map.get(remain);
                return rnt;
            }
        }
        
        return null;
    }
}
