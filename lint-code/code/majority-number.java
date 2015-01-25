public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int max = nums.get(0);
        int count = 1;
        for(int i=1; i<nums.size(); i++){
            if(nums.get(i)!=max)
                count--;
            else count++;
            if(count==0){
                max = nums.get(i);
                count = 1;
            }
        }
        
        return max;
    }
}
