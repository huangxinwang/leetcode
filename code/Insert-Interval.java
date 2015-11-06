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

////////////////////////////////////////////////////////////
//Round 2； 12/29/2014
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
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        //special case
        if(intervals.size()==0){
            intervals.add(newInterval);
            return intervals;
        }
        
        //define return
        ArrayList<Interval> rnt = new ArrayList<Interval>();
        
        for(int i=0; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            //case 1: insert newInterval
            if(newInterval.end < curr.start){
                rnt.add(newInterval);
                newInterval = curr;
            }
            //case2: cancate 2 interval
            else if(newInterval.end == curr.start){
                newInterval.end = curr.end;
            }
            //case3:
            else{
                //insert curr
                 if(newInterval.start > curr.end){
                     rnt.add(curr);
                 }
                 //cancate 2 interval
                 else{
                     newInterval.start = Math.min(curr.start, newInterval.start);
                     newInterval.end = Math.max(curr.end, newInterval.end);
                 }
            }
        }
        
        //need to deal with last one
        rnt.add(newInterval);
        
        return rnt;
        
    }
}


////////////////////////////////////////////////
// 2015/11/05
// Comment: ugly
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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> rnt = new ArrayList<Interval>();
        Collections.sort(intervals, new IntervalComparator());
        
        if(intervals.size()==0){
            rnt.add(newInterval);
            return rnt;
        }
        
        int idx = 0;
        while(idx<intervals.size()){
            Interval v1 = intervals.get(idx);
            if(v1.end<newInterval.start){
                rnt.add(v1);
            }else break;
            idx++;
        }
        
        if(idx>=intervals.size()){
            rnt.add(newInterval);
            return rnt;
        }
        
        //5 conditions
        int i = 0;
        for(i = idx; i<intervals.size(); i++){
            Interval v1 = intervals.get(i);
            if(newInterval.end<v1.start){
                rnt.add(newInterval);
                break;
            }
            else if(newInterval.end<=v1.end){
               if(v1.start<=newInterval.start){
                   Interval v2 = new Interval(v1.start, v1.end);
                   rnt.add(v2);
                   i++;
                   break;
               }else{
                   Interval v2 = new Interval(newInterval.start, v1.end);
                   newInterval = v2;
                   
               }
            }else{
                if(v1.start<newInterval.start){
                    Interval v2 = new Interval(v1.start, newInterval.end);
                    newInterval = v2;
                }
            }
            
            if(i==intervals.size()-1){
                rnt.add(newInterval);
            }
        }
        
        //add the rest of intervals
        while(i<=intervals.size()-1){
            rnt.add(intervals.get(i));
            i++;
        }
        
        return rnt;
    }
    
    //interval comparator
    public class IntervalComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval v1, Interval v2){
            if(v1.start!=v2.start)
                return v1.start - v2.start;
            else return v1.end - v2.end;
        }
    }
}


///////////////////////////////////////////////
// 2015/11/05
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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> rnt = new ArrayList<Interval>();
        if(intervals.size()==0){
            rnt.add(newInterval);
            return rnt;
        }
        
        //compare v1 with newInterval
        for(int i=0; i<intervals.size(); i++){
            Interval v1 = intervals.get(i);
            
            if(newInterval.end<v1.start){
                rnt.add(newInterval);
                newInterval = v1;
            }else{
                if(v1.end<newInterval.start){
                    rnt.add(v1);
                }else {
                    int minstart = Math.min(v1.start, newInterval.start);
                    int maxend = Math.max(v1.end, newInterval.end);
                    newInterval = new Interval(minstart,maxend );
                }
            }
        }
        rnt.add(newInterval);
        return rnt;
    }
}
