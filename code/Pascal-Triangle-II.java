/**
 * Problem Statement: Pascal's Triangle II 
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 */
 
 /**
  * Link: https://oj.leetcode.com/problems/pascals-triangle-ii/
  */


public class Solution {
    
    public ArrayList<Integer> getRow(int rowIndex) {
        
        //initial first layer
        ArrayList<Integer> curr = new ArrayList<Integer>();
        curr.add(1);
        
        for(int i=0; i<rowIndex; i++){

            //get next layer from current layer
            ArrayList<Integer> next = new ArrayList<Integer>();
            
            for(int j=0; j<=curr.size();j++){
                if(j==0 || j==curr.size())
                    next.add(1);
                //dynamic programming
                else next.add(curr.get(j-1)+curr.get(j));
            }
            curr = new ArrayList<Integer>(next);
        }
        
        return curr;
    }
}