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


////////////////////////////////////////////////////
// 2015/12/15
// Highlight: unlike dynamic programming, in the inner loop of j, use binary search
// The main idea is to find a position to insert current value
// Ref: http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int len = 1;
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        
        for(int i=1; i<nums.length; i++){
            //Case 1: replace minimum with current value
            if(nums[i]<tails[0]) tails[0] = nums[i];
            //Case 2: append current value
            else if(nums[i]>tails[len-1]){
                tails[len++] = nums[i];
            }
            //Case 3: find idx to insert current value
            else tails[findIdx(tails, 0,len, nums[i])] = nums[i];
        }
        return len;
    }
    
    //find idx to insert value target
    public int findIdx(int[] nums, int left, int right, int target){
        if(right-left<1) return left;
        int mid = left + (right-left)/2;
        if(nums[mid]<target){
            return findIdx(nums, mid+1, right, target);
        }else return findIdx(nums, left, mid, target);
    }
}
