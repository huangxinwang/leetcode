public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        int min = Integer.MAX_VALUE;
        int curr = 0;
        for(int i=0; i<nums.size(); i++){
            curr += nums.get(i);
            if(curr < min)
                min = curr;
            if(curr>0) curr = 0;
        }
        
        return min;
    }
}

