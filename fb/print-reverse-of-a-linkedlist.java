/**
* Ref: http://www.geeksforgeeks.org/write-a-recursive-function-to-print-reverse-of-a-linked-list/
*
*/

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  Node head;
  
  class Node{
    int data;
    Node next;
    Node(int d){
      data = d;
      next = null;
    }
  }
  
  //recursively print the linkedlist
  public void printReverse(Node head){
    if(head == null) return;
    printReverse(head.next);
    
    System.out.println(head.data+" ");
  }
  
  //utility function for creating node
  public void insertNode(int newdata){
    Node newnode = new Node(newdata);
    newnode.next = head;
    head = newnode;
  }
  public static void main(String[] args) {
    //create list 1->2->3->4
    Solution list = new Solution();
    list.insertNode(4);
    list.insertNode(3);
    list.insertNode(2);
    list.insertNode(1);
    list.printReverse(list.head);
  }
}
