/**
*Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
*For example:
*Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
*
*Follow up:
*Could you do it without any loop/recursion in O(1) runtime?
*
*/

////////////////////////////////////////////////////
// 2015/11/15
// Highlight: recursion
public class Solution {
    public int addDigits(int num) {
        //terminate case
        if(num>=0 && num<=9) return num;
        
        // recursion
        String str = String.valueOf(num);
        int rnt = 0;
        for(int i=0; i<str.length(); i++){
            int val = str.charAt(i)-'0';
            rnt += val;
        }
        return addDigits(rnt);
    }
}

/////////////////////////////////////
// 2015/11/15
// Highlight: list the input from 0 to 20, and find the rules
public class Solution {
    public int addDigits(int num) {
        if(num==0) return num;
        else return (num-1)%9 +1;
    }
}
