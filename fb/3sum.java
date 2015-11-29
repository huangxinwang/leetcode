/**
* Ref: http://www.mitbbs.com/article_t/JobHunting/33101531.html
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int start = i+1;
            int end = nums.length-1;
            int remain = 0 - nums[i];
            while(start<end){
                if(nums[start]+nums[end]==remain){
                    List<Integer> curr = new ArrayList<Integer>();
                    curr.add(nums[i]);
                    curr.add(nums[start]);
                    curr.add(nums[end]);
                    rnt.add(curr);
                    start++;
                    end--;
                    while(start<end && nums[start-1]==nums[start]) start++;
                    while(start<end && nums[end+1]==nums[end]) end--;
                }else if(nums[start]+nums[end]<remain) start++;
                else end--;
            }
        }
        
        return rnt;
    }
}
