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
