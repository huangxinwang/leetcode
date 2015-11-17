/**
* Problem Statement: Implement Queue using Stacks
*
* Implement the following operations of a queue using stacks.
*
*push(x) -- Push element x to the back of queue.
*pop() -- Removes the element from in front of queue.
*peek() -- Get the front element.
*empty() -- Return whether the queue is empty.
*
*/


//////////////////////////////////////////
// 2015/11/16
// Highlight: use two stacks
class MyQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!empty()) s2.pop();
    }

    // Get the front element.
    public int peek() {
        if(!empty()) return s2.peek();
        else return -1;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                int val = s1.pop();
                s2.push(val);
            }
        }
        if(!s2.isEmpty()) return false;
        else return true;
    }
}
