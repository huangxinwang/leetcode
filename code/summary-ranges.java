/*
* Problem Statement: Summary Ranges
*
*Given a sorted integer array without duplicates, return the summary of its ranges.
*
*For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

//////////////////////////////////////////////
// 2015/11/15
// Higlight: logic, keep start and end value, decide whether to continue or endup last range
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> rnt = new ArrayList<String>();
        if(nums==null || nums.length==0) return rnt;
        
        int start = nums[0];
        int end = nums[0];
        
        for(int i=1; i<nums.length; i++){
            //end last period
            if(nums[i]!=end+1){
                if(start==end){
                    rnt.add(start+"");
                }
                else rnt.add(start+"->"+end);
                start = nums[i];
                end = nums[i];
                startidx = i;
            }
            //continue last period
            else{
                end++;
            }
        }
        
        if(start==end){
            rnt.add(start+"");
        }
        else rnt.add(start+"->"+end);
        
        return rnt;
    }
}
