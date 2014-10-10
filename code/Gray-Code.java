/**
 * Problem Statement
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 
 * A gray code sequence must begin with 0.
 * 
 */
 
 
 /**
  * reference
  * http://www.2cto.com/kf/201401/270476.html
  */

public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        
        ArrayList rnt = new ArrayList<Integer>();
        rnt.add(0);
        
        for(int i=0; i<n; i++)
        {
            int h = rnt.size();
            for(int j=h-1; j>=0; j--)
            {
                //use h or rnt.get(j) to create the sequence
                //Note: we should put convert rnt.get(j) to int, because the type of rnt.get(j) is object
                //otherwise, we will get "bad operand types for binary operator '|'"
                rnt.add(h | (int)rnt.get(j));
            }
        }
        
        return rnt;
    }
}