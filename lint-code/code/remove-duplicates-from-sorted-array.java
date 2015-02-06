public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        int idx = 0;
        for(int i=0; i<nums.length;){
            nums[idx] = nums[i];
            idx++;
           
            //skip duplicate
            int curr = nums[i];
            i++;
            while(i<nums.length && nums[i]==curr) i++;
        }
        
        return idx;
    }
}
