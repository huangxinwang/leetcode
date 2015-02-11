public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        return findKth(nums, 0, nums.length-1, nums.length/2+ (nums.length&1));
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public int findKth(int[] nums, int start, int end, int k){
        
        int i = start+1;
        int j = end;
        while(i<=j){
            while(i<=j && nums[i]<nums[start])
                i++;
            while(i<=j && nums[j] >= nums[start])
                j--;
            if(i<j){
                swap(nums, i,j);
            }
        }
        swap(nums, start, j);
        
        if(j+1==k) return nums[j];
        if(j<k) return findKth(nums, j+1, end, k);
        else return findKth(nums, start, j, k);
    }
}

