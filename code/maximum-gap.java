// maximum gap

//////////////////////////////////
// 2015/12/15
// Highlight: bucket sort
// Time: O(n)

// Ref: http://blog.csdn.net/u012162613/article/details/41936569
// Highlight: bukcet-sort

public class Solution {
    public int maximumGap(int[] nums) {
        if(nums==null || nums.length<=1) return 0;
        
        int min = nums[0];
        int max = nums[0];
        for(int a: nums){
            if(min>a) min = a;
            if(max<a) max = a;
        }
        
        //design length of buckets
        //deisgn number of buckets
        int len = (max-min)/nums.length + 1;
        int bucketnum = (max-min)/len+1;
        
        int[][] buckets = new int[bucketnum][2];
        for(int i=0; i<buckets.length; i++){
            buckets[i][0] = -1;
            buckets[i][1] = -1;
        }
        
        //put number in buckets
        for(int a: nums){
            int i = (a-min)/len;
            if(buckets[i][0]==-1){
                buckets[i][0] = a;
                buckets[i][1] = a;
            }else{
                if(buckets[i][0]>a) buckets[i][0] = a;
                if(buckets[i][1]<a) buckets[i][1] = a;
            }
        }
        
        //calculate the gap between two successive buckets ( min of bucket1 - max of bucket 0)
        int gap = 0;
        int prev = 0;
        for(int i=1; i<buckets.length; i++){
            if(buckets[i][0]==-1) continue;
            int diff = buckets[i][0] - buckets[prev][1];
            if(gap<diff) gap = diff;
            prev = i;
        }
        
        return gap;
    }
}
