//////////
//Approach 1: O(n) space, O(n) time
public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] rnt = new int[2];
        
        for(int i=0; i<numbers.length; i++){
            int remain = target - numbers[i];
            if(map.containsKey(remain)){
                rnt[0] = map.get(remain);
                rnt[1] = i+1;
                return rnt;
            }else{
                map.put(numbers[i], i+1);
            }
        }
        
        return rnt;
    }
}
