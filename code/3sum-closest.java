/**
 * Problem Statement: 3Sum Closest 
 * link: https://oj.leetcode.com/problems/3sum-closest/
 * Time: 840ms
 * 
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */


public class Solution {
    
    public int threeSumClosest(int[] num, int target) {
        
        //keep two sets, oneSet for one element, twoSet for two elements
        Set<Integer> setOne = new HashSet<Integer>();
        Set<Integer> setTwo = new HashSet<Integer>();
        
        //keep optimal dist and solution
        int minDist = Integer.MAX_VALUE;
        int optValue = 0;
        
        //traverse tge arrays, and update the optimal dist and value
        for(int i=0; i<num.length; i++){
            
            for(Integer ele : setTwo){
                int sum = ele + num[i];
                int dist = Math.abs(sum-target);
                if(minDist>dist){
                    minDist = dist;
                    optValue = sum;
                }
            }
            
            for(Integer ele : setOne)
                setTwo.add(ele+num[i]);
                
            setOne.add(num[i]);
        }
        
        return optValue;
    }
}


/////////////////////////////////////////////////////////////////////////
//Round 2: 1/2/2015
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        
        //maintain two set
        //setOne used to hold value of single number
        //setTwp used to hold values of two numbers
        Set<Integer> setOne = new HashSet<Integer>();
        Set<Integer> setTwo = new HashSet<Integer>();
        int minDist = Integer.MAX_VALUE;
        int val = Integer.MAX_VALUE;
        
        for(int i=0; i<num.length; i++){
            for(Integer j: setTwo){
                int sum = num[i] + j;
                if(Math.abs(target-sum) < minDist){
                    minDist = Math.abs(target-sum);
                    val = sum;
                }
            }
            
            for(Integer k: setOne){
                setTwo.add(k+num[i]);
            }
            
            setOne.add(num[i]);
        }
        
        return val;
    }
}


/////////////////////////////////////////////////////
// 2015-10-15
// Highlight: naive approach, might be better to use set
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int max_error = Integer.MAX_VALUE;
        int rnt = 0;
        
        for(int i=0; i<nums.length-2; i++){
            //if(nums[i]>=target && Math.abs(nums[i]-target)>=max_error) break;
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<nums.length-1; j++){
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                int sum = nums[i] + nums[j]; 
                //if(sum>=target && Math.abs(sum-target)>=max_error) break;
                for(int k=j+1; k<nums.length; k++){
                    int three_sum = sum+nums[k];
                    if(three_sum>=target && Math.abs(three_sum-target)>=max_error) break;
                    else{
                        max_error = Math.abs(three_sum-target);
                        rnt = nums[i]+nums[j]+nums[k];
                        if(max_error==0) return rnt;
                    }
                }
            }
        }
        
        return rnt;
    }
}


//////////////////////////////////////////
// 2015-10-15
// Highlight: set solution
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Set<Integer> setOne = new HashSet<Integer>();
        Set<Integer> setTwo = new HashSet<Integer>();
        int rnt_sum = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        
        for(int i=0 ; i<nums.length; i++){
            for(Integer d: setTwo){
                int sum = d+nums[i];
                int curr_diff = Math.abs(sum-target);
                if(curr_diff<diff){
                    diff = curr_diff;
                    rnt_sum = sum;
                    if(diff==0) return sum;
                }
            }
            
            for(Integer d: setOne){
                setTwo.add(d+nums[i]);
            }
            
            setOne.add(nums[i]);
        }
        
        return rnt_sum;
    }
}


///////////////////////////////
// 2016/01/03
// Naive approach
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int rnt = 0;
        int diff = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length-2; i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<nums.length-1; j++){
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                int k = j+1;
                while(k<nums.length){
                    if(Math.abs(nums[i]+nums[j]+nums[k]-target)<diff){
                        diff = Math.abs(nums[i]+nums[j]+nums[k]-target);
                        rnt = nums[i]+nums[j]+nums[k];
                    }
                    k++;
                }
            }
        }
        
        return rnt;
    }
}
