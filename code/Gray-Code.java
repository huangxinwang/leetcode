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


////////////////////////////////////////////////////////////////////
//Round 2: 12/18/2014

//Ref: http://fisherlei.blogspot.com/2012/12/leetcode-gray-code.html

public class Solution {
    public List<Integer> grayCode(int n) {
        
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        rnt.add(0);
        
        //when n =k
        //the gray code is those in n=k-1 plus 1<<n, in reverse order
        for(int i=0; i<n; i++){
            int highbit = 1<<i;
            for(int j=rnt.size()-1; j>=0; j--){
                rnt.add(highbit + (int)rnt.get(j));
            }
        }
        
        return rnt;
    }
}

//////////////////////////////////////////////////////
// 2015/11/19
// Highlight: new number is generated using base (1<<i) + existing number in the list
public class Solution {
    public List<Integer> grayCode(int n) {
        
        List<Integer> rnt = new ArrayList<Integer>();
        rnt.add(0);
        
        for(int i=0; i<n; i++){
            int base = 1<<i;
            //new number is generated using: base + number already in the return list
            for(int j=rnt.size()-1; j>=0; j--){
                rnt.add(base + rnt.get(j));
            }
        }
        
        return rnt;
    }
}
