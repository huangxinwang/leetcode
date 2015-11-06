/**
 * Problem Statement: Plus One 
 * Link:https://oj.leetcode.com/problems/plus-one/
 * Time:360ms
 * 
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 */

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        //do calculation
        for(int i=digits.length-1; i>=0; i--){
            int sum = digits[i] + carry;
            digits[i] = sum%10;
            carry = sum/10;
        }
        
        //decide whether to expand array
        if(carry==0) return digits;
        else{
            int[] rnt = new int[digits.length+1];
            arrayCopy(rnt,digits);
            rnt[0] = 1;
            return rnt;
        }
    }
    
    //copy oldArr to newArr, from highest to lowest
    public void arrayCopy(int[] newArr, int[] oldArr){
        for(int i=oldArr.length; i>=1; i--){
            newArr[i] = oldArr[i-1];
        }
    }
}


///////////////////////////////////////////////////////////////////////////////
//Round 2: 12/22/2014
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        
        //add one, traverse the digits
        for(int i=digits.length-1; i>=0; i--){
            int sum = digits[i]+carry;
            digits[i] = sum%10;
            carry = sum/10;
        }
        
        if(carry==0) return digits;
        //need add one bit to the head of the array
        int[] rnt = new int[digits.length+1];
        System.arraycopy( digits, 0, rnt, 1, digits.length );
        rnt[0] = 1;
        return rnt;
    }
}


///////////////////////////////////////////////////////////////////
// 2015/11/06
// Highlight: logic
public class Solution {
    public int[] plusOne(int[] digits) {
        int[] rnt = new int[digits.length+1];
        
        //sum from the right hand side
        int carry = 1;
        for(int i=0; i<digits.length; i++){
            int sum = digits[digits.length-1-i] + carry;
            rnt[rnt.length-1-i] = sum%10;
            carry = sum/10;
        }
        
        if(carry!=0) rnt[0] = carry;
        
        int len = rnt[0]==0? rnt.length-1: rnt.length;
        if(len==rnt.length) return rnt;
        else{
            int[] adjustrnt = new int[len];
            for(int i=1; i<rnt.length; i++){
                adjustrnt[i-1] = rnt[i];
            }
            return adjustrnt;
        }
    }
}
