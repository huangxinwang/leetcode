/**
 * Problem Statement: http://answer.ninechapter.com/solutions/multiply-strings/
 * Link: https://oj.leetcode.com/problems/multiply-strings/
 * Time:
 * Hardness: *** 
 * Ref: 
 * 
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * 
 */

public class Solution {
    public String multiply(String num1, String num2) {
        
        //intial array to store products
        int len1 = num1.length();
        int len2 = num2.length();
        int len3 = len1 + len2;
        int[] num3 = new int[len3];
        
        //inital varaible used in produce products
        int carry = 0;
        int product = 0;
        int i, j;
        
        //produce products
        for( i=len1-1; i>=0; i--){
            carry = 0;
            for( j=len2-1; j>=0; j--){
                product = carry + num3[i+j+1] + Character.getNumericValue(num1.charAt(i))
                    *Character.getNumericValue(num2.charAt(j));
                num3[i+j+1] = product%10;
                carry = product/10;
            }
            //note j-- has been done here
            num3[i+j+1] = carry;
        }
        
        //skip 0 at head of the array
        i=0; 
        while(i<len3 && num3[i]==0){
            i++;
        }
        
        //construct returning string
        StringBuilder sb = new StringBuilder();
        
        //special case, all elements are 0
        if(i==len3) return "0";
        
        while(i<len3){
            sb.append(num3[i]);
            i++;
        }

        return sb.toString();
    }
    
   
}

////////////////////////////////////////////////////////////
// 2015/11/04
// Highlight: multiple each two character, put num1[i]*nums[j] in rnt[i+j+1], take care of product and carry
public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int len3 = len1 + len2;
        int[] rnt = new int[len3];
        
        //multiple each char in two strings correspondingly, 
        int i,j;
        int carry = 0;
        for( i=len1-1; i>=0; i--){
            carry = 0;
            for( j=len2-1; j>=0; j--){
                int val1 = Character.getNumericValue(num1.charAt(i));
                int val2 = Character.getNumericValue(num2.charAt(j));
                int product = val1*val2+carry+rnt[i+j+1];
                int val = product%10;
                rnt[i+j+1] = val;
                carry = val/10;
               
            }
            
            rnt[i+j+1] = carry;
        }
        

        
        i = 0;
        while(i<rnt.length && rnt[i]==0){
            i++;
        }
        
        if(i==rnt.length) return "0";
        
        StringBuilder sb = new StringBuilder();
        while(i<rnt.length){
            sb.append(rnt[i]);
            i++;
        }
        
        return sb.toString();
    }
}
