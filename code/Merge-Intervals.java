/**
 * Problem Statement: Merge Intervals
 * Time:
 * Link: https://oj.leetcode.com/problems/merge-intervals/
 * Ref: http://www.programcreek.com/2012/12/leetcode-merge-intervals/
 * 
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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        
        //special case
        if(intervals==null || intervals.size() <= 1)
            return intervals;
        //sort interval list using comparator
        Collections.sort(intervals, new IntervalComparator());
        ArrayList<Interval> rnt = new ArrayList<Interval>();
        
        //traverse the sorted interval list to check merge condition
        Interval prev = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            //merge
            if(curr.start <= prev.end){
                Interval newInterval = new Interval(prev.start, Math.max(prev.end, curr.end));
                prev = newInterval;
            }
            //not merge, so prev can be added to result
            else{
                rnt.add(prev);
                prev = curr;
            }
        }
        
        //note this step is easy to forget
        rnt.add(prev);
        
        return rnt;
    }
    
    //comparator: sort intervals in increasing order of start time
    class IntervalComparator implements Comparator<Interval>{
        
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    }
}