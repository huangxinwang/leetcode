/**
 * Problem: A+B Problem
 * Ref: http://bubuko.com/infodetail-553698.html
 * 
 */
class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // Click submit, you will get Accepted!
        //return a + b;
        int carry = 0;
        while(b!=0){
            carry = a&b;
            a = a^b;
            b = carry << 1;
        }
        
        return a;
    }
};
