/**
*Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
*
*Example:
*Given nums = [-2, 0, 3, -5, 2, -1]
*
*sumRange(0, 2) -> 1
*sumRange(2, 5) -> -1
*sumRange(0, 5) -> -3
*Note:
*You may assume that the array does not change.
*There are many calls to sumRange function.
*
*/

////////////////////////////////////////////////////////
// 2015/11/19
// Highlight: one dimention array
public class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(i!=0) sum[i] = sum[i-1] + nums[i];
            else sum[i] = nums[0];
        }
    }

    public int sumRange(int i, int j) {
        if(i==0) return sum[j];
        else return sum[j] - sum[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
