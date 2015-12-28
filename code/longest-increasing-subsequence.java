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
        int[] valid = new int[nums.length];
        int idx = 1;
        valid[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            //Case 1: larger than the tail, append
            if(nums[i]>valid[idx-1]){
                valid[idx++] = nums[i];
            //Case 2: smaller than head, repace head
            }else if(nums[i]<valid[0]){
                valid[0] = nums[i];
            }
            //Case 3: otherwise, repace the first number that equal or larger than x
            else{
                int replaceidx = findIdx(valid, nums[i], 0, idx);
                valid[replaceidx] = nums[i];
            }
        }
        return idx;
    }
    
    //binary search to find the idx of the first number that is equal or larger than target
    public int findIdx(int[] valid, int target, int left, int right){
        if(right-left<1) return left;
        int mid = left + (right-left)/2;
        if(valid[mid]<target)
            return findIdx(valid, target, mid+1, right);
        else return findIdx(valid, target, left, mid);
    }
}
