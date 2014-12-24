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


//////////////////////////////////////////////////////////////////////
//Round 2: 12/24/2014
public class Solution {
    public String addBinary(String a, String b) {
        
        //use an array to keep up the sum
        char[] rnt = new char[Math.max(a.length(),b.length())];
        
        int carry = 0;
        
        int i =a.length()-1;
        int j = b.length()-1;
        int index = rnt.length-1;
        
        //sum up a and b
        while(i>=0 && j>=0){
            int num1 = Character.getNumericValue(a.charAt(i));
            int num2 = Character.getNumericValue(b.charAt(j));
            int sum = num1 + num2 + carry;
            carry = sum/2;
            sum = sum%2;
            rnt[index] = (char)(sum+'0');
            index--;
            i--;
            j--;
        }
        
        //remain parts
        while(i>=0){
            int num1 = Character.getNumericValue(a.charAt(i));
            int sum = num1 + carry;
            carry = sum/2;
            sum = sum%2;
            rnt[index] = (char)(sum+'0');
            index--;
            i--;
        }
        
        while(j>=0){
            int num1 = Character.getNumericValue(b.charAt(j));
            int sum = num1 + carry;
            carry = sum/2;
            sum = sum%2;
            rnt[index] = (char)(sum+'0');
            index--;
            j--;
        }
        
        //return
        String curr = new String(rnt);
        if(carry==0) return curr;
        else return "1"+curr;
    }
}
