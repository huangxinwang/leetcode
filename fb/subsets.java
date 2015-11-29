/**
* Problem Statement: Subsets
* Ref: http://www.mitbbs.com/article_t/JobHunting/33101531.html
*
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        rnt.add(new ArrayList<Integer>());
        
        //for each number, either add it or not
        //thus, there are in total 2^n approaches
        int i = 0;
        while(i<nums.length){
            List<List<Integer>> curr = new ArrayList<List<Integer>>(rnt);
            for(List<Integer> a : curr){
                List<Integer> tmp = new ArrayList<Integer>(a);
                tmp.add(nums[i]);
                rnt.add(tmp);
            }
            i++;
        }
        return rnt;
    }
}
