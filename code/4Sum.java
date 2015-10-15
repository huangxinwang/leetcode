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

/////////////////////////////////////////////////////////////////////////
//Round 2: 1/8/2015
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        
        //first num
        for(int i=0; i<num.length-3; i++){
            //skip duplicate
            if(i!=0 && num[i]==num[i-1]) continue;
            
            //second num
            for(int j=i+1; j<num.length-2; j++){
                if(j!=i+1 && num[j]==num[j-1]) continue; //skip duplicate
                
                //third and forth
                int start = j+1;
                int end = num.length-1;
                
                while(start<end){
                    int curr = num[i] + num[j] + num[start] + num[end];
                    if(curr<target)
                        start++;
                    else if(curr>target)
                        end--;
                    else{
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]); tmp.add(num[j]); tmp.add(num[start]); tmp.add(num[end]);
                        rnt.add(new ArrayList<Integer>(tmp));
                        start++;
                        end--;
                        while(start<end && num[start]==num[start-1]) start++;
                        while(start<end && num[end] == num[end+1]) end--;
                    }
                    
            }
        }
    }
    
    return rnt;
    }
}


//////////////////////////////////////////
// 2015-10-15
// Highlight: 4sum + hashmap
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<List<Integer>> rnt = new ArrayList<List<Integer>>();
        
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        
        //O(n^3) + hashmap
        for(int i=0; i<nums.length-3; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            //if(nums[i]>target) break;
            for(int j=i+1; j<nums.length-2; j++){
                if(j!=i+1 && nums[j] == nums[j-1]) continue;
                int twoSum = nums[i]+nums[j];
                //if(twoSum>target) break;
                for(int k=j+1; k<nums.length-1; k++){
                    if(k!=j+1 && nums[k]==nums[k-1]) continue;
                    int threeSum = nums[k]+twoSum;
                    //if(threeSum>target) break;
                    int remain = target - threeSum;
                    if(remain<nums[k]) break;
                    if(map.containsKey(remain)){
                        if(remain==nums[k] && map.get(remain)<2) continue;
                        if(remain==nums[k] && remain==nums[j] && map.get(remain)<3) continue;
                        if(remain==nums[k] && remain ==nums[j] && remain==nums[i] && map.get(remain)<4) continue;
                        ArrayList<Integer> currList = new ArrayList<Integer>();
                        currList.add(nums[i]);
                        currList.add(nums[j]);
                        currList.add(nums[k]);
                        currList.add(remain);
                        rnt.add(currList);
                    }
                }
            }
        }
        
        return rnt;
    }
}
