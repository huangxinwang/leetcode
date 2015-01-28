/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
   
        for(int i=0;; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(curr.end < newInterval.start){
                result.add(curr);
            }
            else if(curr.start > newInterval.end){
                result.add(newInterval);
                //update current un-insert interval
                newInterval = curr;
            }else{
                newInterval.start = Math.min(newInterval.start, curr.start);
                newInterval.end = Math.max(newInterval.end, curr.end);
            }
        }
     
        result.add(newInterval);
        
        return result;
    }
}
