/**
 * Problem Statement: Majority Element
 * Hardness: **
 */

public class Solution {
    public int majorityElement(int[] num) {
        
        
        //let curr denote current candidate number
        //let count denote its count
        int curr = num[0];
        int count = 1;
        
        for(int i=1; i<num.length; i++){
            //when current traversed number is not equal to curr, count--
            //otherwise count++
            if(curr!=num[i]) count--;
            else count++;
            //if count reduced to 0, set current traversed number as candidate number
            if(count==0){
                curr = num[i];
                count++;
            } 
        }
        
        return curr;
    }
}


//////////////////////////////////////////////////////////////
// 2015/11/14
// Highlight: keep track of current value and its count; change current value when the count runs less than 1
public class Solution {
    public int majorityElement(int[] nums) {
        
        //keep track of current value and its count
        //change of current value if count runs less than 1
        int rnt = nums[0];
        int count = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=rnt){
                if(count>=1) count--;
                else{
                    rnt = nums[i];
                    count = 1;
                }
            }else count++;
        }
        
        return rnt;
    }
}
