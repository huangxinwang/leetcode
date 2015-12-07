/**
 * Problem Statement --- 3 Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Elements in a triplet (a,b,c) must be in non-decending order. (ie, a<=b <=c)
 * The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 */
 
 //////////////////////////////////////////////////
 // 2015/12/07
 // Time complexity: O(n^2)
 
 public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(nums);
        
        //first number
        for(int i=0; i<nums.length-2; i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int remain = 0 - nums[i];
            int start = i+1;
            int end = nums.length-1;
            
            //second and thrid number
            while(start<end){
                int sum = nums[start]+nums[end];
                if(sum<remain) start++;
                else if(sum>remain) end--;
                else{
                    ArrayList<Integer> curr = new ArrayList<Integer>();
                    curr.add(nums[i]);
                    curr.add(nums[start]);
                    curr.add(nums[end]);
                    rnt.add(curr);
                    while(start<end && nums[start]==nums[start+1]) start++;
                    while(start<end && nums[end-1] == nums[end]) end--;
                    start++;
                    end--;
                }
            }
        }
        return rnt;
        
        
    }
}
