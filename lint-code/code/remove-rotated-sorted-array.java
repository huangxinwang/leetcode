public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        int i =0;
        for(; i<nums.size()-1; i++){
            if(nums.get(i)>nums.get(i+1))
                break;
        }
        
        if(i==nums.size()-1) return;
        
        while(i>=0){
            int item =nums.remove(0);
            nums.add(item);
            i--;
        }
        
    }
}
