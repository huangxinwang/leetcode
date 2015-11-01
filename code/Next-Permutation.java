/**
 * 
 * Problem Statement: Next Permutation
 * Link: https://oj.leetcode.com/problems/next-permutation/
 * Ref: http://fisherlei.blogspot.com/2012/12/leetcode-next-permutation.html
 * Hardness: ****
 * Time: 480 ms
 * 
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 ? 1,3,2
 * 3,2,1 ? 1,2,3
 * 1,1,5 ? 1,5,1
 */

public class Solution {
    
    public void nextPermutation(int[] num) {
        
        
        //scan from right to left, and find partition index
        //define partition index, the first elements disobey increasing sequence
        int parIndex = -1;
        int len = num.length;
        for(int i=len-1; i>0; i--){
            if(num[i] > num[i-1]){
                parIndex = i-1;
                break;
            }
        }
        
        //scan from right to left, find the first elemtns that is larget than that at partition index
        // and swap
        if(parIndex != -1){
            for(int i=len-1; i>0; i--){
                if(num[i] > num[parIndex]){
                    int tmp = num[i];
                    num[i] = num[parIndex];
                    num[parIndex] = tmp;
                    break;
                }
            }
        }
        
        //reverse the array from [partitionIndex+1...end]
        int startIndex = parIndex+1;
        int endIndex = len-1;
        for(int i=startIndex; i<=(startIndex+endIndex)/2; i++){
            int tmp = num[i];
            num[i] = num[startIndex+endIndex-i];
             num[startIndex+endIndex-i] = tmp;
        }
        
    }
}

///////////////////////////////////////////////////////////////
//Round 2: 12/31/2014
/**
 * Ref: http://fisherlei.blogspot.com/2012/12/leetcode-next-permutation.html
 * 
 */

public class Solution {
    public void nextPermutation(int[] num) {
        
        //from right to left, find first index that break the increasing rule
        //call this index as paritionIndex
        int partitionIndex = num.length-1;
        while(true & partitionIndex>=0){
            if(partitionIndex>0 && num[partitionIndex] > num[partitionIndex-1]){
                partitionIndex--;
                break;
            }
            else partitionIndex--;
        }
        
        //from right to left, find the first element to swap with the partition element
        if(partitionIndex>=0){
            for(int i=num.length-1; i>=0; i--){
                if(num[i]>num[partitionIndex]){
                    int tmp = num[i];
                    num[i] = num[partitionIndex];
                    num[partitionIndex] = tmp;
                    break;
                }
            }
        }
        
        //reverse the string in the righthand-side of the partition number
        for(int i=partitionIndex+1; i<=(partitionIndex+num.length)/2; i++){
            int tmp = num[i];
            num[i] = num[partitionIndex+num.length-i];
            num[partitionIndex+num.length-i] = tmp;
        }
        
    }
}


////////////////////////////////////////////////////////////////////////////////////////////
// 2015/10/31
// Highlight: logic
public class Solution {
    public void nextPermutation(int[] nums) {
        boolean found = false;
        
        int currmax = nums[nums.length-1];
        
        //from right to left, find the first element that is less than max value seen, denoted the index as i
        int i=nums.length-1;
        for(; i>=0; i--){
            int val = nums[i];
            if(val >= currmax){
                currmax = val;
            }else{
                found = true;
                break;
            }
        }
        
        //from right to left, find the first element that is larger than the value found in last step, denoted the index as k
        int k = nums.length-1;
        
        //if such value exit, exchange i and k value
        if(i>=0){
            for(; k>i; k--){
                if(nums[k]>nums[i])
                    break;
            }
            
            int tmp = nums[i];
            nums[i] = nums[k];
            nums[k] = tmp;
        }
        
        
        // reverse the values in the right of i, since all the numbers in the right of i is in decreasing order, reverse the list make it in increasing order so as to satisfy the property of next permutation
        for(int m=nums.length-1; m>(i+nums.length-1)/2; m--){
            int tmp = nums[m];
            nums[m] = nums[i+nums.length-m];
            nums[i+nums.length-m] = tmp;
        }
    }
}
