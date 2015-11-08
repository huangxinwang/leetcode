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

////////////////////////////////////////////////////////////////////////
//Round 2: 12/19/2014
/**
 * http://fisherlei.blogspot.com/2012/12/leetcode-largest-rectangle-in-histogram.html
 * 
 */


public class Solution {
    public int largestRectangleArea(int[] height) {
        
        //append 0 to the end of the array
        int[] h = Arrays.copyOf(height, height.length+1);
        int maxArea = 0;
        Stack<Integer> stk = new Stack<Integer>();
        
        for(int i=0; i<h.length; i++){
            //if h[i] is larger than current largest number, then push in
            if(stk.isEmpty() || h[i] >h[stk.peek()])
                stk.push(i);
            //otherwise, calculate the max before h[i]
            else{
                int index = stk.pop();
                maxArea = Math.max(maxArea,stk.isEmpty()==true ? h[index]*i : (i-stk.peek()-1)*h[index]);
                //re examing the i-th element
                i--;
            }
        }
        
        return maxArea;
        
    }
}


////////////////////////////////////////////////////
// 2015/11/08
// Highlight: logic
// Hardness: ****
public class Solution {
    public int largestRectangleArea(int[] height) {
        
        //append 0 at the end of array, so that with stack, we can evaluate the last part
        height = Arrays.copyOf(height, height.length+1);
        
        Stack<Integer> stack = new Stack<Integer>();
        
        int max = 0;
        
        for(int i=0; i<height.length; i++){
            if(stack.isEmpty() || height[i] > height[stack.peek()]){
                stack.push(i);
            }else{
                int idx = stack.pop();
                max = Math.max(max, stack.isEmpty()? height[idx]*i: height[idx]*(i-stack.peek()-1));
                i--;
            }
        }
        
        return max;
    }
}
