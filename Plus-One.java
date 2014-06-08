/**
 * Problem Statement: Plus One
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
 
 public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        if(digits.length==0) return digits;
        
        int[] remain = new int[digits.length];
        for(int i=digits.length-1; i>=0; i--){
            if(i==digits.length-1) carry+=1;
            int sum = digits[i] + carry;
            carry = sum/10;
            remain[i] = sum%10;
        }
        
        
        
        if(carry==0) return remain;
        else{
            int[] rnt = new int[digits.length+1];
            digits[0] = carry;
            for(int i=1; i<digits.length+1; i++){
                rnt[i] = remain[i-1];
            }
            return rnt;
        }
        
    }
}