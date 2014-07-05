/**
 * Proble Statement: Triangle
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * [
 *      [2],
 *      [3,4],
 *      [6,5,7],
 *      [4,1,8,3]
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        if (triangle.size()==0) return 0;
        
		//rnt keep record of current layer of nodes
        List<Integer> curr = triangle.get(0);
        List<Integer> rnt = new ArrayList<Integer>();
        
		//dynamic programming update rnt
        for(int i=1; i<triangle.size(); i++){
            List<Integer> next = triangle.get(i);
            for(int j=0; j<next.size(); j++){
                if(j==0) rnt.add(next.get(j) + curr.get(j));
                else if(j==curr.size()) rnt.add(next.get(j) + curr.get(j-1));
                else rnt.add(next.get(j) + Math.min(curr.get(j-1) , curr.get(j)));
            }
            curr = new ArrayList<Integer>(rnt);
            rnt = new ArrayList<Integer>();
        }
        
        int min = curr.get(0);
        for(int i=0; i<curr.size(); i++){
            min = min > curr.get(i) ? curr.get(i) : min;
        }
        return min;
    }
}