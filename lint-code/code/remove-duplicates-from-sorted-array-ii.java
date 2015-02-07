public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        int idx = 0;
        for(int i=0; i<nums.length; ){
            nums[idx] = nums[i];
            idx++;
            
            int curr = nums[i];
            int count = 1;
            i++;
            
            //skip duplication
            while(i<nums.length && nums[i]==curr){
                if(count==1){
                    nums[idx] = nums[i];
                    idx++;
                    count++;
                }
                i++;
            }
        }
        
        return idx;
    }
}
