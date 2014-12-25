/**
 * Problem Statement: Count and Say 
 * Link: https://oj.leetcode.com/problems/count-and-say/
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 */

public class Solution {
    public String countAndSay(int n) {
        
        //initial sequence
        String seq = "1";
        String nextSeq = seq;
        
        //get the ith sequence
        for(int i=0; i<n-1; i++){
            nextSeq = read(seq);
            seq = nextSeq;
        }
        return nextSeq;
    }
    
    public String read(String seq){
        
           String rnt = new String();
           
           //the iterative will decide how to update i
           for(int i=0; i<seq.length(); ){
                char start = seq.charAt(i);
                //Case1: current char is the last char
                if(i==seq.length()-1) {
                    rnt+='1';
                    rnt+=start;
                    return rnt;
                }
                //Case2: current char is not the last char
                //compare with next element to see if they are same
                else{
                    int step = 1;
                    char next = seq.charAt(i+step);
                    while(start==next){
                        step++;
                        if(i+step<seq.length())
                            next = seq.charAt(i+step);
                        else break;
                    }
                    //finish read same element, update rnt
                    rnt+=(step);
                    rnt+=start;
                    i = i+step;
                }
            }
            return rnt;
    }
}


////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/24/2014
public class Solution {
    public String countAndSay(int n) {
        
        String laststr = "1";
         
        int i=0;
        //outer loop
        while(i<n-1){
            
            String nextstr = new String();
            int index =0;
            
            //innerloop
            while(index<laststr.length()){
                //count how many "curr" char
                int count = 0;
                char curr = laststr.charAt(index);
                
                while(index<laststr.length() && laststr.charAt(index)==curr){
                    count++;
                    index++;
                }
                //be careful of int to string!
                nextstr += ((count + "") + curr);
            }
            
            //update laststr
            laststr = nextstr;
            i++;
  
        }
        
        return laststr;
    }
}
