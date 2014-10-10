/**
 * Problem Statement: Add Binary
 * 
 * 
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */


public class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        
        int maxLen = Math.max(aLen, bLen);
        int aIndex = aLen-1;
        int bIndex = bLen-1;
        String rnt = new String();
        int carry = 0;
        
        //add from lowerst bit
        while(aIndex>=0 && bIndex>=0){
            int aNum = Character.getNumericValue(a.charAt(aIndex));
            int bNum = Character.getNumericValue(b.charAt(bIndex));
            int sum = aNum+bNum+carry;
            int result = sum%2;
            carry = sum/2;
            aIndex--;
            bIndex--;
            rnt += result;
        }
        
        while(aIndex>=0){
            int aNum = Character.getNumericValue(a.charAt(aIndex));
            int sum = aNum+carry;
            int result = sum%2;
            carry = sum/2;
            aIndex--;
            rnt += result;
        }
        
        while(bIndex>=0){
            int bNum = Character.getNumericValue(b.charAt(bIndex));
            int sum = bNum+carry;
            int result = sum%2;
            carry = sum/2;
            bIndex--;
            rnt += result;
        }
        
        if(carry!=0)
            rnt+=carry;
        
        //reverse string
        StringBuilder reverseRnt =  new StringBuilder(rnt);
        return reverseRnt.reverse().toString();
        
    }
}