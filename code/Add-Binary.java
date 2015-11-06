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


//////////////////////////////////////////////////////
//2015/11/06
// Highlight: note to add from right side
public class Solution {
    public String addBinary(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        String rnt = new String();
        
        //Add from right side
        int i=0;
        int j =0;
        int carry = 0;
        while(i<alen && j<blen){
            int val1 = a.charAt(alen-1-i)-'0';
            int val2 = b.charAt(blen-1-j)-'0';
            int sum = val1+val2+carry;
            int prod = sum%2;
            carry = sum/2;
            rnt = prod+""+rnt;
            i++;
            j++;
        }
        
        String str = i<alen? a: b;
        int limit = i<alen? alen: blen;
        int k = i<alen? i: j;
        while(k<limit){
            int val1 = str.charAt(limit-1-k)-'0';
            int sum = val1+carry;
            int prod = sum%2;
            carry = sum/2;
            rnt = prod +""+ rnt;
            k++;
        }
        
        if(carry!=0) rnt = carry+rnt;
        
        return rnt;
    }
}
