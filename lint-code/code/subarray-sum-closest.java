public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    class Pair implements Comparable<Pair>{
        int key;
        int val;
        
        public Pair(int k, int v){
            this.key = k;
            this.val = v;
        }
        
        @Override
        public int compareTo(Pair other){
            if(this.key < other.key) return -1;
            else if(this.key == other.key) return 0;
            else return 1;
        }
    } 
    
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
       
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        if(nums.length==1){
            rnt.add(0);
            rnt.add(0);
            return rnt;
        }
       
       //put <sum, index> pair to list
       ArrayList<Pair> list = new ArrayList<Pair>();
      
       int curr = 0;
       for(int i=0; i<nums.length; i++){
           curr += nums[i];
           Pair p = new Pair(curr, i);
           list.add(p);
       }
       
       //sort sum list
       Collections.sort(list);
       int rnt1 = 0;
       int rnt2 = 0;
       
       
       //the min value will happen in successive sum
       int min = Integer.MAX_VALUE;
       for(int i=0; i<list.size()-1; i++){
           int diff = Math.abs(list.get(i+1).key - list.get(i).key);
           if(diff <= min){
               min = diff;
               rnt1 = list.get(i).val;
               rnt2 = list.get(i+1).val;
           }
       }
       
       //adjust the order of rnt1 and rnt2
       //note that the smaller one need to advance index by 1
       if(rnt1>rnt2){
           int tmp = rnt1;
           rnt1 = rnt2;
           rnt2 = tmp;
       }
       rnt1++;
       
    
       
      
       rnt.add(rnt1);
       rnt.add(rnt2);
       return rnt;
    }
}
