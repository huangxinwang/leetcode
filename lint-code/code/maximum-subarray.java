public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        // write your code
        int max = nums.get(0);
        int curr = 0;
        for(int i=0; i<nums.size(); i++){
            curr += nums.get(i);
            if(curr > max)
                max = curr;
            if(curr<0) curr = 0;
        }
        
        return max;
    }
}
