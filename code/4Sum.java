/**
 * Problem Statement: 4Sum 
 * Time: 536 ms
 * Link: https://oj.leetcode.com/problems/4sum/
 * Ref: http://answer.ninechapter.com/solutions/4sum/
 * Hardness: ****
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 */


///////////////////////////////////////////////
// 2015/12/7
// Time: O(n^3)

public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        /* your code */
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(nums);
        
        //first number
        for(int i=0; i<nums.length-3; i++){
            if(i!=0 && nums[i-1]==nums[i]) continue;
            //second number
            for(int j=i+1; j<nums.length-2; j++){
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                int remain = target - nums[i] - nums[j];
                int start = j+1; 
                int end = nums.length-1;
                
                //third and fourth number
                while(start<end){
                    int sum = nums[start] + nums[end];
                    if(sum<remain) start++;
                    else if(sum>remain) end--;
                    else{
                        ArrayList<Integer> curr = new ArrayList<Integer>();
                        curr.add(nums[i]);
                        curr.add(nums[j]);
                        curr.add(nums[start]);
                        curr.add(nums[end]);
                        rnt.add(curr);
                        while(start<end && nums[start]==nums[start+1]) start++;
                        while(start<end && nums[end] == nums[end-1]) end--;
                        start++;
                        end--;
                    }
                }
            }
        }
        
        return rnt;
    }
}
