class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        
        //use zeroidx, oneidx, and twoidx to represent the index to put next zero, one and two respectively
        
        //in particularly, one will point to the number that currently is not traversed!
        
        int zeroidx = 0;
        int oneidx = 0;
        int twoidx = nums.length-1;
        
        while(oneidx <= twoidx){
            switch(nums[oneidx]){
                case 0:
                    swap(nums, zeroidx++, oneidx++);
                    break;
                case 1:
                    oneidx++;
                    break;
                case 2:
                    swap(nums, oneidx, twoidx--);
                    break;
            }
        }
        
    }
    
    public void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
