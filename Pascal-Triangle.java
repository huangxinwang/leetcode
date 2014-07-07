/**
 * Problem Statement: Pascal's Triangle 
 *
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */


public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        
        //TODO: explain why when I change return type from List<List<>> to ArrayList<ArrayList<>>
        //the incompatible problem solved
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        if(numRows==0) return rnt;
        
        //create first layer
        int index = 1;
        List<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        rnt.add(new ArrayList<Integer>(prev));
        
        //using the relation between each two neighbour layer to build the subsequent layers
        while(index<numRows){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int i=0; i<prev.size()+1; i++){
                if(i==0 || (i==prev.size())) tmp.add(1);
                else tmp.add(prev.get(i-1)+prev.get(i));
            }
            rnt.add(new ArrayList<Integer>(tmp));
            prev = new ArrayList<Integer>(tmp);
            index ++;
            
        }
        
        return rnt;
    }
}