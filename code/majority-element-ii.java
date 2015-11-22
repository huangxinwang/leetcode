/**
* Problem Statement: Majority Element II
* 
* Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and * in O(1) space.
*/

/////////////////////////////////////////////////
// 2015/11/22
// Highlight: logic
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0;
        int c2 = 0;
        int curr1 = 0;
        int curr2 = 0;
        
        //count the apperance of number, use majority count
        for(int i=0; i<nums.length; i++){
            if(c1!=0 && curr1 == nums[i]){
                c1++;
            }else if(c2!=0 && curr2 == nums[i]){
                c2++;
            }
            else if(c1==0){
                curr1 = nums[i];
                c1++;
            }else if(c2==0){
                curr2 = nums[i];
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        
        c1 = 0;
        c2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==curr1) c1++;
            if(nums[i]==curr2) c2++;
        }
        
        //calculate the count
        List<Integer> rnt = new ArrayList<Integer>();
        if(c1>nums.length/3) rnt.add(curr1);
        if(c2>nums.length/3 &&curr1!=curr2) rnt.add(curr2);
        
        return rnt;
    }
}
