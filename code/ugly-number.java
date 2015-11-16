/*
* Problem Statement: Ugly Number
* Write a program to check whether a given number is an ugly number.
*
* Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
*
* Note that 1 is typically treated as an ugly number.
*
*/

////////////////////////////////////
// 2015/11/15
// Highlight: recursive reduce the value of number to termination cases
public class Solution {
    
    public boolean isUgly(int num) {
        //terminate case
        if(num<=0) return false;
        
        //actually, I  don't think 1 is true
        if(num==1) return true;
        
        //recursively divide 2,3,5 if mod is 0
        if(num%2==0){
            num = num/2;
            return isUgly(num);
        }
        if(num%3==0){
            num = num/3;
            return isUgly(num);
        }
        if(num%5==0){
            num = num/5;
            return isUgly(num);
        }
        return false;
    }
}
