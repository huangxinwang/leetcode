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
