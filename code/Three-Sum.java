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
 
 public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        
        //init
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        
        if(num.length < 3) return rnt;
        
        //sort array, could save time when enumerating
        Arrays.sort(num);
        
        //3 sum
        for(int i=0; i<num.length-2;i++){
            
            //avoid duplication
            if(i==0 || num[i]>num[i-1]){
                
                //find remain + num[i] == 0
                int remain = -num[i];
                
                int start = i+1;
                int end = num.length-1;
                
                while(start < end){
                    
                    //case 1
                    if(num[start]+num[end]==remain)
                    {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[start]);
                        tmp.add(num[end]);
                        rnt.add(tmp);
                        
                        start++;
                        end--;
                        //avoid duplication
                        while(start < end && num[end+1]==num[end]) end--;
                        while(start < end && num[start-1]==num[start]) start++;
                        
                        
                    }
                    //case 2
                    else if(num[start]+num[end] > remain)
                    {
                        end--;
                    }
                    //case 3
                    else if(num[start]+num[end] < remain)
                    {
                        start++;
                    }
                }
                
            }
        }
        
        return rnt;
        
        
    }
        
      
}


////////////////////////////////////////////////////////////////////////
//Round 2: 1/1/2015
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        if(num.length<3) return rnt;
        
        Arrays.sort(num);
        
        for(int i=0; i<num.length-2; i++){
            
            //avoid duplication
            if(i==0 || num[i]>num[i-1]){
                
            //sort array and find combinations that sums up to remain
            int remain = -num[i];
            int start = i+1;
            int end = num.length-1;
            while(start<end){
                int currSum = num[start]+num[end];
                if(currSum==remain){
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]);
                    tmp.add(num[start]);
                    tmp.add(num[end]);
                    rnt.add(tmp);
                    start++;
                    end--;
                    while(start<=end && num[start-1]==num[start]) start++;
                    while(start<=end && num[end] == num[end+1]) end--;
                }
                else if(currSum < remain)
                    start++;
                else end--;
            }
            }
        }
        
        return rnt;
    }
}
