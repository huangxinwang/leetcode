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