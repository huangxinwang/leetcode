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
