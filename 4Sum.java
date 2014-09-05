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



public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(num);
        
        //first number
        for(int i=0; i<num.length-3; i++){
            //skip same number
            if(i!=0 && num[i-1]==num[i]) continue;
            
            //second number 
            for(int j=i+1; j<num.length-2; j++){
                //skip same number
                if(j!=i+1 && num[j-1] == num[j]) continue;
                
                //third number
                int start = j+1;
                //forth number
                int end = num.length-1;
                //while loop to advance third, forth pointer accordind to the summing result
                while(start<end){
                    int currSum = num[i]+num[j]+num[start]+num[end];
                    if(currSum > target){
                        end--;
                    }
                    else if(currSum < target){
                        start++;
                    }
                    else{
                        //found
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[start]);
                        tmp.add(num[end]);
                        rnt.add(tmp);
                        start++;
                        end--;
                        //skip same number
                        while(start<end && num[start]==num[start-1])
                            start++;
                        while(start<end && num[end]==num[end+1])
                            end--;
                    }
                }
            }
        }
        
        return rnt;
        
   
    }
}