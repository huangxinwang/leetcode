/**
 * Problem Statement: Insert Interval 
 * Link:https://oj.leetcode.com/problems/insert-interval/
 * Time:528 ms
 * Ref:http://blog.csdn.net/worldwindjp/article/details/21612731
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 */



/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
      
      //special case
      if(intervals==null || newInterval==null) return intervals;
      if(intervals.size()==0){
          intervals.add(newInterval);
          return intervals;
      }
      
      //interae over the list to find the right position to insert the newInterval
      ListIterator<Interval> it = intervals.listIterator();
      
      while(it.hasNext()){
          Interval tmp = it.next();
          //Case1: insert newInterval in previous position
          if(tmp.start > newInterval.end){
              //Adjust pointer position of the interator
              it.previous();
              it.add(newInterval);
              return intervals;
          }
          //Case2: keep finding the position
          else if(tmp.end < newInterval.start)
            continue;
          //Case3: merge with current scanned interval, make the merged interval as newInterval
          //       and remove current scanned interval
          else{
              newInterval = new Interval(Math.min(tmp.start, newInterval.start), Math.max(tmp.end, newInterval.end));
              it.remove();
          }
      }
      
      //if newInterval has been added to intevals, then it will return in the while loop
      intervals.add(newInterval);
      
      return intervals;
      
    }
}