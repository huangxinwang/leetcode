//Brute force O(n^2), time out
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        // write your code
        
        int rnt = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.size()-1; i++){
            int diff1 = findMaxArray(nums, i+1, nums.size()-1) - findMinArray(nums, 0, i);
            int diff2 = findMaxArray(nums, 0, i) - findMinArray(nums, i+1, nums.size()-1);
            int diff = Math.max(diff1, diff2);
            if(diff > rnt)
                rnt = diff;
        }
        
        return rnt;
    }
    
    public int findMinArray(ArrayList<Integer> nums, int left, int right){
        int min = nums.get(left);
        int curr = 0;
        for(int i=left; i<=right; i++){
            curr += nums.get(i);
            if(curr < min){
                min = curr;
            }
            if(curr>0) curr = 0;
        }
        return min;
    }
    
    public int findMaxArray(ArrayList<Integer> nums, int left, int right){
        int max = nums.get(left);
        int curr = 0;
        for(int i=left; i<=right; i++){
            curr += nums.get(i);
            if(curr > max){
                max = curr;
            }
            if(curr<0) curr = 0;
        }
        return max;
    }
}
