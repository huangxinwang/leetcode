/**
* Rotate an array of n elements to the right by k steps.
* For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
* 
* Note:
* Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
* 
* [show hint]
* 
* Related problem: Reverse Words in a String II
* 
* Credits:
* Special thanks to @Freezen for adding this problem and creating all test cases.
* 
* Subscribe to see which companies asked this question
*
*/


public class Solution {
    public void rotate(int[] nums, int k) {
        
        if(k>=nums.length) k = k%nums.length;
        if(k==0) return;
        
        int[] rnt = new int[nums.length];
        
        //fill 0 to k
        for(int i=0; i<k; i++){
            rnt[i] = nums[nums.length-k+i];
        }
        
        //fill k to end
        for(int i=k; i<nums.length; i++){
            rnt [i] = nums[i-k];
        }
        
        for(int i=0; i<nums.length; i++){
            nums[i] = rnt[i];
        }
    }
}
