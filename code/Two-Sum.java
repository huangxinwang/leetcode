/**
 * Problem Statement: Two Sum
 * 
 * 
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++){
            map.put(numbers[i],i);
        }
        
        int[] rnt = new int[2];
        
        //if target - numbers[i] is in hashmap, then found
        //note number[i] could equal to remain
        for(int i=0; i<numbers.length; i++){
            int remain = target - numbers[i];
            if(map.containsKey(remain) && map.get(remain)!=i){
                rnt[0] = i+1;
                rnt[1] = map.get(remain)+1;
                return rnt;
            }
        }
        
        return rnt;
    }
}


//Naive approach 2015-10-03
//Time complexity O(n^2)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] rnt = new int[2];
        for(int i=0; i<nums.length; i++){
            int remain = target - nums[i];
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]==remain){
                    rnt[0] = i+1;
                    rnt[1] = j+1;
                    return rnt;
                }
            }
        }
        return rnt;
        
    }
}
