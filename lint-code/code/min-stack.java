public class Solution {
    
    public Stack<Integer> stack;
    public Stack<Integer> minStack;
    
    public Solution() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if(minStack.empty())
            minStack.push(number);
        else{
            int min = minStack.peek();
            if(number <= min)
                minStack.push(number);
        }
    }

    public int pop() {
        // write your code here
        int rnt = stack.pop();
        if(rnt==minStack.peek())
            minStack.pop();
        return rnt;
    }

    public int min() {
        // write your code here
        if(minStack.empty())
            return -1;
        else return minStack.peek();
    }
}

