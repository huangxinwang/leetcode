/**
* Ref: http://www.1point3acres.com/bbs/thread-154552-1-1.html
* Similar
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int max = Integer.MAX_VALUE;
        if(nums==null || nums.length==0) return 0;
        
        int curr = 0;
        int start = 0;
        int end = 0;
        
        //keep two pointer, one for start, one for end
        while(start<=end && end<nums.length){
            curr += nums[end];
            while(curr>=s && start<=end){
                int len = end-start+1;
                if(max>len) max = len;
                curr -= nums[start];
                start++;
            }
            end++;
        }
        
        if(max==Integer.MAX_VALUE) return 0;
        return max;
    }
}
