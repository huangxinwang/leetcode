// Kth largest element in an array

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return help(nums, 0, nums.length-1, nums.length-k+1);
    }
    
    public int help(int[] nums, int l, int r, int k){
        if(k>0 && k<=r-l+1){
            
            //parittion the array around the last element
            //return pivot position
            int pos = partition(nums, l, r);
            if(pos-l+1 == k) return nums[pos];
            
            //note pos-1, pos+1
            if(pos-l+1 >k) return help(nums, l, pos-1, k);
            else return help(nums, pos+1, r,k-(pos-l+1));
        }
        //no solution
        else return Integer.MAX_VALUE;
    }
    
    //quick sort, put elements that is smaller than pivot to the left
    public int partition(int[] nums, int l, int r){
        int pivot = nums[r];
        int i = l;
        for(int j=l; j<=r-1; j++){
            if(nums[j]<=pivot){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }
        nums[r] = nums[i];
        nums[i] = pivot;
        return i;
    }
}
