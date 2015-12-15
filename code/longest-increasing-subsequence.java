// Longest increasing subsequence

///////////////////////////////////////////
// 2015/12/15
// Highlight: 1D dynamic programming
// Time: O(n^2)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        
        //count[i]: the maximum increasing sequence when end at i
        int[] count = new int[nums.length];
        for(int i=0; i<count.length; i++){
            count[i] = 1;
        }
        int max = 1;
        
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    if(count[j]+1 > count[i]){
                        count[i] = count[j]+1;
                    } 
                }
            }
            if(count[i]>max) max = count[i];
        }
        
        return max;
    }
}
