/**
 * Problem Statement: Largest Rectangle in Histogram 
 * Link: https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * Time: 436 ms
 * Ref: http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 * Hardness: *****
 * 
 * 
 */

public class Solution {
    public int largestRectangleArea(int[] height) {
        
        //special case
        if(height.length==0) return 0;
        
        //create a dummy end "0" at the end of the array, thus the calculation of all unpoped elements will be enabled
        int[] h = new int[height.length+1];
        h = Arrays.copyOf(height, height.length+1);
        
        Stack<Integer> stk = new Stack<Integer>();
        int area = 0;
        
        //traverse the array
        int i =0;
        while(i<h.length){
            //case 1: current elements is larger than the top elements in the stack, then push in the index
            if(stk.empty() || h[stk.peek()]<=h[i]) stk.push(i++);
            //case 2: pop out the top elements, and then calculate the area
            // note that this elements will be scanned again and again until the top elements in the stack is smaller than it
            // Thus, the elements in the stack maintains monotonically increasing property
            else{
                int tmp = stk.pop();
                area = Math.max(area, h[tmp]*(stk.empty()? i : i-stk.peek()-1));
            }
        }
        
        return area;
        
        
        
    }
}