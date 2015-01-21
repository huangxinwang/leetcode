//1D dynamic programming

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int len = nums.length;
        
        //ith maxlen up to i
        int[] maxlen = new int[len];
        for(int i=0; i<len; i++)
            maxlen[i] = 1;
            
        for(int i=0; i<len; i++){
            for(int j=0; j<i; j++){
               if(nums[j] <= nums[i]){
                   maxlen[i] = Math.max(maxlen[i], maxlen[j]+1);
               } 
            }
        }
        
        int max = 0;
        for(int i=0; i<len; i++){
            if(max < maxlen[i])
                max = maxlen[i];
        }
        
        return max;
    }
}
