public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
        for(int i=0; i<nums.length; i++){
            
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(map.containsKey(nums[i]))
               list=  map.get(nums[i]);
       
            list.add(i);
            map.put(nums[i], list);
       
        }
        
        Arrays.sort(nums);
       
        int left = 0;
        int right = nums.length-1;
       
        
        int sum = nums[left] + nums[right];
        int rnt1 = nums[left];
        int rnt2 = nums[right];
        int dist = Math.abs(sum-0);
        
        //get cloest sum
        while(left<right){
            if(sum<0 && left<right-1)
                left++;
            if(sum>0 && left<right-1)
                right--;
            if(left<right){
                int curr = nums[left] + nums[right];
                if(Math.abs(curr) <= dist){
                   
                    sum = curr;
                    if(Math.abs(curr) < dist){
                        dist = Math.abs(curr);
                        rnt1 = nums[left];
                        rnt2 = nums[right];
                    }
                   
                }
            }
            if(sum==0) break;
            if(left==right-1) break;
        }
        
        //get index from hashMap
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        rnt.add(map.get(rnt1).get(0));
        if(rnt1==rnt2)
        rnt.add(map.get(rnt2).get(1));
        else rnt.add(map.get(rnt2).get(0));
        
        return rnt;
        
    }
}
